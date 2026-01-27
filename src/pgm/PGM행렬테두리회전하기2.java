package pgm;

import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        int[][] arr = initArr(rows, columns);

        for(int i = 0; i < queries.length; i++){
            answer[i] = rotate(arr, queries[i]);
        }

        return answer;
    }

    // 로테이션하고 최솟값 반환
    private int rotate(int[][] arr, int[] query){
        int x1 = query[0] - 1;
        int y1 = query[1] - 1;
        int x2 = query[2] - 1;
        int y2 = query[3] - 1;

        int min = Integer.MAX_VALUE;

        List<Integer> list = new ArrayList<>();
        List<int[]> order = getOrder(x1, y1, x2, y2);

        // 최솟값 찾기
        for(int[] o: order){
            int temp = arr[o[0]][o[1]];
            list.add(temp);
            min = Math.min(min, temp);
        }

        for(int i = 0; i < order.size(); i++){
            int x = order.get(i)[0];
            int y = order.get(i)[1];

            if(i == 0){
                arr[x][y] = list.get(list.size() - 1);
            }else{
                arr[x][y] = list.get(i - 1);
            }
        }

        return min;
    }

    // 시계방향 좌표 리스트 반환
    private List<int[]> getOrder(int x1, int y1, int x2, int y2){
        List<int[]> result = new ArrayList<>();

        // 오른쪽 아래 왼쪽 위쪽
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int x = x1;
        int y = y1;

        for(int i = 0; i < 4; i++){
            boolean flag = true;

            while(flag){
                if(x1 <= x && x <= x2 && y1 <= y && y <= y2){
                    result.add(new int[]{x, y});
                }
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(x1 <= nx && nx <= x2 && y1 <= ny && ny <= y2){
                    x += dx[i];
                    y += dy[i];
                }else {
                    result.remove(result.size() -1);
                    flag = false;
                }

            }
        }

        return result;
    }

    private int[][] initArr(int rows, int columns){
        int[][] arr = new int[rows][columns];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                arr[i][j] = ((i) * (columns) + j + 1);
            }
        }

        return arr;
    }
}
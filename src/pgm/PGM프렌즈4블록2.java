package pgm;

import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;

        boolean[][] map = new boolean[m][n];
        char[][] boards = new char[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                boards[i][j] = board[i].charAt(j);
            }
        }

        while(true){
            removeFunc(map,boards, m, n);
            int cnt = getCount(map);
            resetMap(map);
            rebuild(boards, m, n);
            answer += cnt;

            if(cnt == 0) break;

        }

        return answer;
    }

    private void rebuild(char[][] boards, int m, int n){
        for(int j = 0; j < n; j++){
            while(true){
                boolean flag = true;

                for(int i = 0; i < m; i++){
                    if((i != (m - 1)) && boards[i][j] != ' ' && boards[i+1][j] == ' '){
                        flag = false;
                        char temp = boards[i][j];
                        boards[i][j] = ' ';
                        boards[i+1][j] = temp;
                    }
                }
                if(flag) break;
            }
        }
    }


    private void resetMap(boolean[][] map){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                map[i][j] = false;
            }
        }
    }

    private int getCount(boolean[][] map){
        int sum = 0;

        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if(map[i][j]) sum++;
            }
        }

        return sum;
    }

    private void removeFunc(boolean[][] map, char[][] boards, int m, int n){
        int[] di = {1,0,1};
        int[] dj = {0,1,1};

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                boolean flag = true;
                char now = boards[i][j];

                if(now == ' '){
                    flag = false;
                    continue;
                }

                for(int k = 0; k < di.length; k++){
                    int ni = i + di[k];
                    int nj = j + dj[k];

                    if(0 <= ni && ni < m && 0 <= nj && nj < n){
                        if(boards[ni][nj] != now){
                            flag = false;
                            break;
                        }
                    }else{
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    map[i][j] = true;
                    for(int k = 0; k < di.length; k++){
                        int ni = i + di[k];
                        int nj = j + dj[k];

                        map[ni][nj] = true;
                    }
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j]) boards[i][j] = ' ';
            }
        }
    }
}

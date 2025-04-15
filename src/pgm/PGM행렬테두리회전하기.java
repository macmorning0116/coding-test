package pgm;

import java.util.*;

class PGM행렬테두리회전하기 {
    int[][] arr;
    public int[] solution(int rows, int columns, int[][] queries) {
        List<Integer> answer = new ArrayList<>();

        int num = 1;
        arr = new int[rows + 1][columns + 1];

        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= columns; j++){
                arr[i][j] = num++;
            }
        }

        for(int[] q : queries){
            Robin temp = getRobin(q);
            answer.add(temp.min);
            rotate(temp.list);
        }


        return answer.stream().mapToInt(i -> i).toArray();
    }

    private void rotate(List<Node> list){
        Node last = list.get(list.size() - 1);
        int next = arr[last.i][last.j];
        int temp = 0;

        for(int i = 0; i < list.size(); i++){
            Node now = list.get(i);
            temp = arr[now.i][now.j];
            arr[now.i][now.j] = next;
            next = temp;
        }
    }

    private Robin getRobin(int[] query){
        List<Node> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int[] di = {1,0,-1,0};  // 우 하 좌 상
        int[] dj = {0,1,0,-1};

        int x1 = query[0], y1 = query[1], x2 = query[2], y2 = query[3];
        int ni = x1;
        int nj = y1;

        for(int i = 0; i < 4; i++){
            while(true){
                ni += di[i];
                nj += dj[i];

                list.add(new Node(ni,nj));
                if(arr[ni][nj] < min) min = arr[ni][nj];

                if(
                        (ni == x2 && nj == y1) ||
                                (ni == x2 && nj == y2) ||
                                (ni == x1 && nj == y2) ||
                                (ni == x1 && nj == y1)
                ) break;
            }
        }

        Collections.reverse(list);

        return new Robin(list,min);

    }




    class Robin{
        List<Node> list;
        int min;

        public Robin(List<Node> list, int min){
            this.list = list;
            this.min = min;
        }
    }

    class Node{
        int i;
        int j;

        public Node(int i, int j){
            this.i = i;
            this.j = j;
        }

        public String toString(){
            return "[" + i + "," + j + "]";
        }
    }
}

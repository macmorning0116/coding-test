package pgm;

import java.util.*;

class PGM미로탈출 {
    public int solution(String[] maps) {
        char[][] arr = new char[maps.length][maps[0].length()];

        int si = 0, sj = 0, li = 0, lj = 0;

        for(int i = 0; i < maps.length; i++){
            arr[i] = maps[i].toCharArray();
        }

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == 'S'){
                    si = i;
                    sj = j;
                } else if(arr[i][j] == 'L'){
                    li = i;
                    lj = j;
                }
            }
        }

        int routeToL = bfs(arr, si, sj, 'L');
        int routeToE = bfs(arr, li, lj, 'E');

        if(routeToL != -1 && routeToE != -1){
            return routeToL + routeToE;
        }else return -1;

    }

    private int bfs(char[][] arr, int i , int j, char target){
        Queue<Node> q = new LinkedList<>();
        int[][] visited = new int[arr.length][arr[0].length];
        int[] di = {1,0,-1,0};
        int[] dj = {0,1,0,-1};

        q.add(new Node(i,j));

        while(!q.isEmpty()){
            Node now = q.poll();

            int ci = now.i;
            int cj = now.j;

            if(arr[ci][cj] == target){
                return visited[ci][cj];
            }

            for(int k = 0; k < 4; k++){
                int ni = ci + di[k];
                int nj = cj + dj[k];

                if(0 <= ni && ni < arr.length && 0 <= nj && nj < arr[0].length && arr[ni][nj] != 'X' && visited[ni][nj] == 0){
                    visited[ni][nj] = visited[ci][cj] + 1;
                    q.add(new Node(ni,nj));
                }
            }


        }

        return -1;

    }

    class Node{
        int i;
        int j;

        public Node(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

}

package pgm;

import java.util.*;

class PGM리코쳇로봇 {
    int[][] d;
    char[][] arr;
    public int solution(String[] board) {
        arr = new char[board.length][board[0].length()];
        d = new int[arr.length][arr[0].length];
        int si = 0, sj = 0, ei = 0, ej = 0;


        for(int i = 0; i < board.length; i++){
            arr[i] = board[i].toCharArray();
        }

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == 'R'){
                    si = i;
                    sj = j;
                }else if(arr[i][j] == 'G'){
                    ei = i;
                    ej = j;
                }
            }
        }

        for(int i = 0; i < d.length; i++){
            for(int j = 0; j < d[0].length; j++){
                if(i == si && j == sj) continue;
                d[i][j] = Integer.MAX_VALUE;
            }
        }

        // for(int i = 0; i < arr.length; i++){
        //     System.out.println(Arrays.toString(arr[i]));
        // }

        bfs(si,sj);

        // for(int i = 0; i < arr.length; i++){
        //     System.out.println(Arrays.toString(d[i]));
        // }


        if(d[ei][ej] != Integer.MAX_VALUE) return d[ei][ej];
        else return -1;
    }

    private void bfs(int si, int sj){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(si,sj));

        while(!q.isEmpty()){
            Node now = q.poll();

            for(Node next: checkDir(now)){
                if(d[next.i][next.j] > d[now.i][now.j] + 1){
                    d[next.i][next.j] = d[now.i][now.j] + 1;
                    q.add(next);
                }
            }
        }
    }

    private List<Node> checkDir(Node now){
        List<Node> result = new ArrayList<>();
        int ci = now.i;
        int cj = now.j;
        int n = arr.length;
        int m = arr[0].length;

        int[] di = {1,0,-1,0};
        int[] dj = {0,1,0,-1};

        // 상하좌우에서 갈 수 있는 곳 검사 후 result에 담음
        for(int i = 0; i < 4; i++){
            int ni = ci;
            int nj = cj;
            while(true){
                ni += di[i];
                nj += dj[i];

                if(((0 > ni || ni >= n) || (0 > nj || nj >= m)) || (0 <= ni && ni < n && 0 <= nj && nj < m) && arr[ni][nj] == 'D'){
                    ni -= di[i];
                    nj -= dj[i];

                    if(ni != ci || nj != cj) result.add(new Node(ni,nj));
                    break;
                }
            }
        }

        return result;
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

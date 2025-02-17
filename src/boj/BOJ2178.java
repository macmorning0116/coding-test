package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {
    static int N;
    static int M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for(int i = 0; i < N; i++){
            String[] str =  br.readLine().split("");
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }


        int answer = bfs(new Node(0,0,1), arr);
        System.out.println(answer);

    }

    static int bfs(Node s, int[][] arr){
        boolean[][] visited = new boolean[N][M];
        Queue<Node> q = new LinkedList<>();
        int[] di = {1,0,-1,0};
        int[] dj = {0,1,0,-1};
        int count = 0;

        q.add(s);
        visited[s.x][s.y] = true;

        while(!q.isEmpty()){
            Node now = q.poll();
            int ci = now.x;
            int cj = now.y;

            if(ci == N-1 && cj == M-1){
                count = now.cnt;
                break;
            }

            for(int i = 0; i < di.length; i++){
                int ni = ci + di[i];
                int nj = cj + dj[i];

                if(0 <= ni && ni < N && 0 <= nj && nj < M && !visited[ni][nj] && arr[ni][nj] == 1){
                    visited[ni][nj] = true;
                    q.add(new Node(ni,nj, now.cnt + 1));
                }
            }


        }

       return count;
    }

    static class Node{
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}

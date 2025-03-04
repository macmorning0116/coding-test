package boj;

import java.util.*;
import java.io.*;

public class BOJ2251 {
    static int[] sender = {0,0,1,1,2,2};
    static int[] receiver = {1,2,0,2,0,1};
    static boolean[] answer = new boolean[201];
    static boolean[][] visited = new boolean[201][201];
    static int[] comp = new int[3];
    public static void main(String[] args) throws Exception {;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 3; i++){
            comp[i] = Integer.parseInt(st.nextToken());
        }

        bfs();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < answer.length; i++){
            if(answer[i]) sb.append(i).append(" ");
        }

        System.out.println(sb);

    }

    static void bfs(){
        Deque<AB> q = new ArrayDeque<>();
        AB s = new AB(0,0);
        visited[0][0] = true;
        answer[comp[2]] = true;
        q.addLast(s);

        while(!q.isEmpty()){
            AB now = q.pollFirst();
            int A = now.a;
            int B = now.b;
            int C = comp[2] - A - B;

            for(int i = 0; i < 6; i++){
                int[] next = {A,B,C};

                next[receiver[i]] += next[sender[i]];
                next[sender[i]] = 0;
                if(next[receiver[i]] > comp[receiver[i]]){
                    next[sender[i]] = next[receiver[i]] - comp[receiver[i]];
                    next[receiver[i]] = comp[receiver[i]];
                }
                if(!visited[next[0]][next[1]]){
                    visited[next[0]][next[1]] = true;
                    q.addLast(new AB(next[0], next[1]));
                    if(next[0] == 0) answer[next[2]] = true;
                }
            }
        }




    }

    static class AB{
        int a;
        int b;

        public AB(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
}

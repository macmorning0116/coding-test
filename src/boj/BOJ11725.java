package boj;

import java.util.*;
import java.io.*;

public class BOJ11725 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> list = new ArrayList<>();
        boolean[] visited = new boolean[N+1];
        visited[1] = true;
        int[] parents = new int[N+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(u).add(v);
            list.get(v).add(u);
        }

        while(!q.isEmpty()){
            int now = q.poll();
            for(int next: list.get(now)){
                if(!visited[next]){
                    visited[next] = true;
                    parents[next] = now;
                    q.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i < parents.length; i++){
            sb.append(parents[i]).append("\n");
        }

        System.out.println(sb);
    }
}

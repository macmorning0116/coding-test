package boj;

import java.util.*;
import java.io.*;

public class BOJ11724_2 {
    static boolean[] visited;
    static int count = 0;
    static List<List<Integer>> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(u).add(v);
            list.get(v).add(u);
        }

        visited = new boolean[N+1];

        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                count++;
                visited[i] = true;
                dfs(i);
            }
        }

        System.out.println(count);

    }
    static void dfs(int num){
        for(int next: list.get(num)){
            if(!visited[next]){
                visited[next] = true;
                dfs(next);
            }
        }
    }
}

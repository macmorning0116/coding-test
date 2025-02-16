package boj;

import java.util.*;
import java.io.*;

public class BOJ11724 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[N+1];
        int count = 0;

        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                count++;
                dfs(i, visited, graph);
            }
        }

        System.out.println(count);

    }

    static void dfs(int num, boolean[] visited, List<List<Integer>> graph){
        if(visited[num]) return;
        visited[num] = true;
        List<Integer> list = graph.get(num);
        for(int i = 0; i < list.size(); i++){
            dfs(list.get(i), visited, graph);
        }
    }
}

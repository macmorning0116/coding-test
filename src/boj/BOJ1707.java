package boj;

import java.util.*;
import java.io.*;


public class BOJ1707 {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] check;
    static boolean even;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();

            for(int j = 0; j <= V; j++){
                graph.add(new ArrayList<>());
            }

            visited = new boolean[V+1];
            even = true;
            check = new int[V+1];

            for(int j = 0; j < E; j++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                graph.get(s).add(e);
                graph.get(e).add(s);
            }

            for(int j = 1; j <= V; j++){
                if(even){
                    dfs(j);
                }else{
                    break;
                }
            }

            if(even){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }
    }

    static void dfs(int start){
        visited[start] = true;

        for(int i: graph.get(start)){
            if(!visited[i]){
                check[i] = ((check[start] + 1) % 2);
                dfs(i);
            }else if(check[start] == check[i]){
                even = false;
            }
        }
    }
}

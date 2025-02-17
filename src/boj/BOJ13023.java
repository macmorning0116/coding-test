package boj;

import java.util.*;
import java.io.*;


public class BOJ13023 {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean check = false;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++){
            graph.add(new ArrayList<>());
        }

        visited = new boolean[N];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(int i = 0; i < N; i++){
            if(check) break;
            dfs(i,1);
        }

        System.out.println(check ? "1" : "0");

    }

    static void dfs(int now, int depth){
        if(depth == 5 || check){
            check = true;
            return;
        }

        visited[now] = true;
        for(int num: graph.get(now)){
            if(!visited[num]){
                dfs(num,depth+1);
            }
        }
        visited[now] = false;
    }
}

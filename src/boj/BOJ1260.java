package boj;

import java.util.*;
import java.io.*;

public class BOJ1260 {

    static int N;
    static int nodeCnt;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static List<Integer> dfsAnswer = new ArrayList<>();
    static List<Integer> bfsAnswer = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N+1; i++){
            graph.add(new ArrayList<>());
        }

        visited = new boolean[N+1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(int i = 0; i < graph.size(); i++){
            if(!graph.get(i).isEmpty()) nodeCnt++;
        }

        for(int i = 0; i < graph.size(); i++){
            Collections.sort(graph.get(i));
        }

        visited[V] = true;
        dfsAnswer.add(V);
        dfs(V,1);
        bfs(V);

        StringBuilder dfsSb = new StringBuilder();
        StringBuilder bfsSb = new StringBuilder();

        for(int i = 0; i < dfsAnswer.size(); i++){
            dfsSb.append(dfsAnswer.get(i) + " ");
            bfsSb.append(bfsAnswer.get(i) + " ");
        }

        System.out.println(dfsSb);
        System.out.println(bfsSb);

    }
    static void dfs(int node, int sum){
        if(sum == nodeCnt){
            return;
        }

        for(int num: graph.get(node)){
            if(!visited[num]){
                dfsAnswer.add(num);
                visited[num] = true;
                dfs(num, sum+1);
            }

        }
    }

    static void bfs(int s){
        boolean[] visited = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        q.add(s);
        visited[s] = true;
        list.add(s);

        while(!q.isEmpty()){
            List<Integer> tempList = graph.get(q.poll());

            for(int num: tempList){
                if(!visited[num]){
                    q.add(num);
                    visited[num] = true;
                    list.add(num);
                }
            }
        }

        bfsAnswer = list;

    }

}

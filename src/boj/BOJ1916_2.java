package boj;

import java.util.*;
import java.io.*;

public class BOJ1916_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<List<Node>> graph = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> o1.cost - o2.cost);
        boolean[] visited = new boolean[N+1];
        int[] d = new int[N+1];

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v,w));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        for(int i = 1; i < d.length; i++){
            if(i != s) d[i] = Integer.MAX_VALUE;
        }

        pq.add(new Node(s,0));


        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(visited[now.vertex]) continue;
            visited[now.vertex] = true;

            for(Node next: graph.get(now.vertex)){
                int nextVertex = next.vertex;
                int newCost = d[now.vertex] + next.cost;

                if(d[nextVertex] > newCost){
                    d[nextVertex] = newCost;
                    pq.add(new Node(nextVertex, newCost));
                }
            }
        }

        System.out.println(d[e]);



    }
    static class Node{
        int vertex;
        int cost;

        public Node(int vertex, int cost){
            this.vertex = vertex;
            this.cost = cost;
        }
    }
}

package boj;

import java.util.*;
import java.io.*;

public class BOJ1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 정점 개수
        int E = Integer.parseInt(st.nextToken()); // 간선 개수
        int K = Integer.parseInt(br.readLine()); // 시작 정점
        int[] dist = new int[V+1]; // 정점까지의 거리
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> o1.cost - o2.cost);
        int MAX = Integer.MAX_VALUE;
        for(int i = 0; i < dist.length; i++){
            dist[i] = MAX;
        }
        dist[K] = 0;

        List<List<Node>> list = new ArrayList<>();
        for(int i = 0; i < V+1; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(u).add(new Node(v, w));
        }

        pq.add(new Node(K,0));

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(dist[now.vertex] < now.cost) continue;

            for(Node next: list.get(now.vertex)){
                int newCost = dist[now.vertex] + next.cost;

                if(dist[next.vertex] > newCost){
                    dist[next.vertex] = newCost;
                    pq.add(new Node(next.vertex, newCost));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < dist.length; i++){
            sb.append(dist[i] == MAX ? "INF" : dist[i]).append("\n");
        }

        System.out.println(sb);


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

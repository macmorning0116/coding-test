package boj;

import java.util.*;
import java.io.*;

public class BOJ1916 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<List<Node>> list = new ArrayList<>(); // 인접 리스트
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> (int)(o1.cost - o2.cost));
        long[] dist = new long[N+1]; // 정점까지의 거리
        long MAX = Long.MAX_VALUE;

        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(u).add(new Node(v, w));
        }

        for(int i = 0; i < dist.length; i++){
            dist[i] = MAX;
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(dist[now.node] < now.cost) continue;

            for(Node next: list.get(now.node)){
                long newCost = dist[now.node] + next.cost;
                if(dist[next.node] > newCost){
                    dist[next.node] = newCost;
                    pq.add(new Node(next.node, newCost));
                }
            }
        }
        System.out.println(dist[end]);

    }
    static class Node{
        int node;
        long cost;

        public Node(int node, long cost){
            this.node = node;
            this.cost = cost;
        }
    }
}

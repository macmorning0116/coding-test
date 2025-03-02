package boj;

import java.util.*;
import java.io.*;

public class BOJ1854 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<PriorityQueue<Integer>> dist = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> o1.cost - o2.cost);

        int[][] arr = new int[n+1][n+1];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[u][v] = w;
        }

        for(int i = 0; i < n+1; i++){
            dist.add(new PriorityQueue<>((o1,o2) -> o2 - o1));
        }

        pq.add(new Node(1, 0));
        dist.get(1).add(0);

        while(!pq.isEmpty()){
            Node now = pq.poll();

            for(int i = 1; i <= n; i++){
                if(arr[now.node][i] > 0){
                    if(dist.get(i).size() < k){
                        dist.get(i).add(now.cost + arr[now.node][i]);
                        pq.add(new Node(i, now.cost + arr[now.node][i]));
                    }else if(dist.get(i).peek() > now.cost + arr[now.node][i]){
                        dist.get(i).poll();
                        dist.get(i).add(now.cost + arr[now.node][i]);
                        pq.add(new Node(i, now.cost + arr[now.node][i]));
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < dist.size(); i++){
            if(dist.get(i).size() < k) sb.append(-1).append("\n");
            else sb.append(dist.get(i).peek()).append("\n");
        }

        System.out.println(sb);
    }
    static class Node{
        int node;
        int cost;

        public Node(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }
}

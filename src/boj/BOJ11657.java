package boj;

import java.util.*;
import java.io.*;

public class BOJ11657 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Node[] edges = new Node[m];
        long[] dist = new long[n+1];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[i] = new Node(u,v,w);
        }

        for(int i = 1; i < dist.length; i++){
            dist[i] = Long.MAX_VALUE;
        }

        dist[1] = 0;

        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < m; j++){
                if(dist[edges[j].start] != Long.MAX_VALUE && dist[edges[j].end] > dist[edges[j].start] + edges[j].cost){
                    dist[edges[j].end] = dist[edges[j].start] + edges[j].cost;
                }
            }
        }

        boolean flag = false;

        for(int i = 0; i < m; i++){
            if(dist[edges[i].start] != Long.MAX_VALUE && dist[edges[i].end] > dist[edges[i].start] + edges[i].cost){
                flag = true;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();

        if(flag) System.out.println(-1);
        else{
            for(int i = 2; i < dist.length; i++){
                if(dist[i] != Long.MAX_VALUE) sb.append(dist[i]).append("\n");
                else sb.append(-1).append("\n");
            }

            System.out.println(sb);
        }




    }
    static class Node {
        int start;
        int end;
        int cost;

        public Node(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}

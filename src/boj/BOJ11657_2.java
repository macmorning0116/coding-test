package boj;

import java.util.*;
import java.io.*;

public class BOJ11657_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());

        long MAX = Long.MAX_VALUE;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();
        long[] d = new long[N+1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(s,e,w));
        }

        for(int i = 2; i <= N; i++){
            d[i] = MAX;
        }

        for(int i = 1; i < N; i++){
            for(int j = 0; j < M; j++){
                Edge now = edges.get(j);
                if(d[now.start] != MAX && d[now.end] > d[now.start] + now.cost){
                    d[now.end] = d[now.start] + now.cost;
                }
            }
        }

        boolean flag = false;
        for(int j = 0; j < M; j++){
            Edge now = edges.get(j);
            if(d[now.start] != MAX && d[now.end] > d[now.start] + now.cost){
                flag = true;
                break;
            }
        }

        if(flag) System.out.println(-1);
        else{
            StringBuilder sb = new StringBuilder();
            for(int i = 2; i < d.length; i++){
                if(d[i] == MAX) sb.append(-1).append("\n");
                else sb.append(d[i]).append("\n");
            }
            System.out.println(sb);
        }


    }
    static class Edge{
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}

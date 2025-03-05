package boj;

import java.util.*;
import java.io.*;

public class BOJ1197 {
    static int[] heads;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<Edge> list = new ArrayList<>();  // 간선 저장
        heads = new int[V+1]; // 유니온 파인드 대표 노드 저장
        int answer = 0;
        int count = 0;

        for(int i = 1; i <= V; i++){
            heads[i] = i;
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.add(new Edge(s,e,c));
        }
        list.sort((o1,o2) -> o1.cost - o2.cost);

        for(int i = 0; i < list.size(); i++){
            if(count == V-1) break;

            Edge now = list.get(i);
            if(find(now.start) != find(now.end)){
                count++;
                answer += now.cost;
                union(now.start, now.end);
            }
        }

        System.out.println(answer);
    }
    static void union(int a, int b){
        int aHead = find(a);
        int bHead = find(b);

        if(aHead != bHead) heads[bHead] = aHead;
    }


    static int find(int num){
        if(num == heads[num]) return num;
        return heads[num] = find(heads[num]);
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

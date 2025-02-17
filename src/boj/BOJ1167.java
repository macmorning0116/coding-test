package boj;

import java.util.*;
import java.io.*;

public class BOJ1167 {
    static int V;
    static List<List<Node>> graph = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        V = Integer.parseInt(br.readLine());
        for(int i = 0; i <= V; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < V; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());

            while(true){
                int next = Integer.parseInt(st.nextToken());
                if(next == -1) break;
                int d = Integer.parseInt(st.nextToken());

                graph.get(start).add(new Node(next, d));
            }
        }

        int[] checkSum = new int[V+1];
        int[] answerSum = new int[V+1];

        bfs(1,checkSum);
        int maxCheck = 0;
        int maxCheckIdx = 0;

        for(int i = 0; i < checkSum.length; i++){
            if(maxCheck < checkSum[i]){
                maxCheck = checkSum[i];
                maxCheckIdx = i;
            }
        }

        bfs(maxCheckIdx, answerSum);

        System.out.println(Arrays.stream(answerSum).max().getAsInt());

    }

    static void bfs(int s, int[] sum){
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[V+1];
        visited[s] = true;
        q.add(new Node(s,0));

        while(!q.isEmpty()){
            Node now = q.poll();

            for(Node node: graph.get(now.end)){
                if(!visited[node.end]){
                    visited[node.end] = true;
                    sum[node.end] = sum[now.end] + node.dis;
                    q.add(node);
                }
            }
        }

    }

    static class Node{
        int end;
        int dis;

        public Node(int end, int dis){
            this.end = end;
            this.dis = dis;
        }
    }

}

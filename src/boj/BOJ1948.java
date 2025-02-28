package boj;

import java.util.*;
import java.io.*;

public class BOJ1948 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] sums = new int[n+1]; // 임계값 저장
        List<List<Node>> list = new ArrayList<>(); // 정방향 인접 리스트 저장
        List<List<Node>> reverse = new ArrayList<>(); // 역방향 인접 리스트 저장
        int[] d = new int[n+1]; // 정방향 진입 차수 저장
        int[] rD = new int[n+1]; // 역방향 진입 차수 저장
        Queue<Integer> q = new LinkedList<>(); // 정방향 큐
        Queue<Integer> rQ = new LinkedList<>(); // 역방향 큐
        int count = 0; // 쉬지않고 달려야 하는 도로의 개수
        boolean[] visited = new boolean[n+1]; // 역방향 방문 노드 확인


        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());

            d[e]++;  // 정방향 진입 차수 ++
            rD[s]++; // 역방향 진입 차수 ++
            list.get(s).add(new Node(e,dis)); // 정방향 인접 리스트
            reverse.get(e).add(new Node(s,dis)); // 역방향 인접 리스트
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 최대 길이 구하기
        for(int i = 1; i < d.length; i++){
            if(d[i] == 0) q.add(i);
        }

        while(!q.isEmpty()){
            int now = q.poll();

            for(Node next: list.get(now)){
                d[next.end]--;
                sums[next.end] = Math.max(sums[next.end] , sums[now] + next.dis);
                if(d[next.end] == 0) q.add(next.end);
            }
        }

        // 역방향으로 돌면서 쉬지않고 달려야 하는 도로 개수 구하기
        rQ.add(end);

        while(!rQ.isEmpty()){
            int now = rQ.poll();

            for(Node next: reverse.get(now)){
                if(sums[now] == (sums[next.end] + next.dis)){
                    count++;
                    if(!visited[next.end]){
                        visited[next.end] = true;
                        rQ.add(next.end);
                    }
                }

            }
        }

        System.out.println(sums[end]);
        System.out.println(count);

    }
    static class Node {
        int end;
        int dis;

        public Node(int end, int dis){
            this.end = end;
            this.dis = dis;
        }
    }
}

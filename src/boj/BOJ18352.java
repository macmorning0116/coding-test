package boj;

import java.util.*;
import java.io.*;

public class BOJ18352 {
    static int K;
    static int N;
    static ArrayList<Integer>[] arr;
    static int[] dis;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N+1];
        for(int i = 0; i < arr.length; i++){
            arr[i] = new ArrayList<>();
        }


        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
        }

        dis = new int[N+1];
        bfs(X);

        List<Integer> answer = new ArrayList<>();

        for(int i = 1; i < dis.length; i++){
            if(dis[i] == K) answer.add(i);
        }

        StringBuilder sb = new StringBuilder();

        if(answer.isEmpty()){
            System.out.println(-1);
        }else{
            for(int num: answer){
                sb.append(num);
                sb.append("\n");
            }
            System.out.println(sb);
        }

    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        visited[start] = true;

        q.add(start);

        out:
        while(!q.isEmpty()){
            int now = q.poll();
            List<Integer> next = arr[now];

            for(int num: next){
                if(!visited[num]){
                    dis[num] = dis[now] + 1;
                    if(dis[num] > K){
                        break out;
                    }
                    visited[num] = true;
                    q.add(num);
                }
            }


        }
    }
}

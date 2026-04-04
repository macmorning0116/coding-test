package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1325_1 {
    static int[] arr;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];

        for(int i = 0; i < N + 1; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int e = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            list.get(e).add(s);
        }

        for(int i = 1; i <= N; i++){
            visited = new boolean[N + 1];
            bfs(i);
        }

        int max = 0;
        for(int n: arr){
            if(n > max) max = n;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == max) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb.toString());
    }

    private static void bfs(int s){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);

        while(!q.isEmpty()){
            int c = q.poll();
            visited[c] = true;

            for(int n: list.get(c)){
                if(!visited[n]){
                    visited[n] = true;
                    arr[n]++;
                    q.add(n);
                }

            }
        }

    }
}

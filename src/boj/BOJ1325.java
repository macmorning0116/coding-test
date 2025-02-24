package boj;


import java.util.*;
import java.io.*;


public class BOJ1325 {
    static ArrayList<Integer>[] arr;
    static int[] sums;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N+1];
        sums = new int[N+1];

        for(int i = 0; i < arr.length; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr[s].add(e);
        }

        boolean[] visited = new boolean[N+1];
        ArrayDeque<Integer> q = new ArrayDeque<>();

        for(int i = 1; i <= N; i++){
            q.clear();
            Arrays.fill(visited, false);

            q.addLast(i);
            visited[i] = true;

            while(!q.isEmpty()){
                int now = q.pollFirst();

                for(int num: arr[now]){
                    if(!visited[num]){
                        visited[num] = true;
                        sums[num]++;
                        q.addLast(num);
                    }
                }
            }
        }

        int max = Arrays.stream(sums).max().getAsInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < sums.length; i++){
            if(sums[i] == max) sb.append(i).append(" ");
        }

        System.out.println(sb);

    }
}

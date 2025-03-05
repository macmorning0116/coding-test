package boj;

import java.util.*;
import java.io.*;

public class BOJ1389 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][N+1];

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <=N; j++){
                if(i != j) arr[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u][v] = 1;
            arr[v][u] = 1;
        }

        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    arr[i][j] = (int) Math.min((long) arr[i][j], ((long) arr[i][k] + arr[k][j]));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int idx = 0;

        for(int i = 1; i < arr.length; i++){
            int sum = Arrays.stream(arr[i]).sum();
            if(min > sum){
                min = sum;
                idx = i;
            }
        }

        System.out.println(idx);

    }
}

package boj;

import java.util.*;
import java.io.*;

public class BOJ11403 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][N+1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k = 1; k <= N; k++){
            for(int s = 1; s <= N; s++){
                for(int e = 1; e <= N; e++){
                    if(arr[s][k] > 0 && arr[k][e] > 0) arr[s][e] = 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                sb.append(arr[i][j]).append(" ");
            }
            if(i != N){
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}

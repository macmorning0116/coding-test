package boj;

import java.util.*;
import java.io.*;

public class BOJ11404 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] arr = new int[n+1][n+1];

        for(int i = 1; i < arr.length; i++){
            for(int j = 1; j < arr.length; j++){
                if(i == j) continue;
                arr[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if(arr[u][v] > w){
                arr[u][v] = w;
            }
        }

        for(int k = 1; k <= n; k++){          // 경유 정점
            for(int s = 1; s <= n; s++){       // 출발 정점
                for(int e = 1; e <=n; e++){     // 도착 정점
                    arr[s][e] = (int) Math.min((long)arr[s][e], ((long)arr[s][k] + arr[k][e]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(arr[i][j] == Integer.MAX_VALUE) sb.append(0).append(" ");
                else sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

package boj;

import java.util.*;
import java.io.*;

public class BOJ11660 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][N+1];
        long[][] sumArr = new long[N+1][N+1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                sumArr[i][j] = sumArr[i][j-1] + arr[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            long sum = 0;
            for(int s = x1; s <= x2; s++){
                sum += (sumArr[s][y2] - sumArr[s][y1-1]);
            }

            sb.append(sum);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}


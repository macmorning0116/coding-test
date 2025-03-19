package boj;

import java.util.*;
import java.io.*;

public class BOJ11050_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        int[][] dp = new int[N+1][N+1];

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp.length; j++){
                if(j == 0 || i == j) dp[i][j] = 1;
                else if(j == 1) dp[i][j] = i;
            }
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp.length; j++){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

//        for(int i = 0; i < dp.length; i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }

        System.out.println(dp[N][K]);
    }
}

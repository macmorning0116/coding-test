package boj;

import java.util.*;
import java.io.*;

public class BOJ11051 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[][] dp = new long[N+1][N+1];

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0 || i == j) dp[i][j] = 1;
                else if(j == 1) dp[i][j] = i;
            }
        }

        for(int i = 0; i < dp.length; i++){
            for(int j = 2; j <= i; j++){
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 10007;
            }
        }

//        for(int i = 0; i < dp.length; i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }

        System.out.println(dp[N][K]);


    }
}

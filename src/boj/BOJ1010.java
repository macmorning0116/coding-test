package boj;

import java.util.*;
import java.io.*;

public class BOJ1010 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            long[][] dp = new long[M+1][M+1];
            for(int i = 0; i < dp.length; i++){
                for(int j = 0; j <= i; j++){
                    if(i == j || j == 0) dp[i][j] = 1;
                    else if(j == 1) dp[i][j] = i;
                }
            }

            for(int i = 0; i < dp.length; i++){
                for(int j = 2; j <= i; j++){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                }
            }

            System.out.println(dp[M][N]);
        }
    }
}

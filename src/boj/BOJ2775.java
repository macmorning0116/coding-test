package boj;

import java.io.*;

public class BOJ2775 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[][] dp = new int[15][15];
            for(int i = 0; i < dp.length; i++){
                dp[0][i] = i;
                dp[i][1] = 1;
            }

            for(int i = 1; i < dp.length; i++){
                for(int j = 1; j < dp.length; j++){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }

            System.out.println(dp[k][n]);
        }
    }
}

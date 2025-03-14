package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ13398 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n][3];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            dp[i][0] = Integer.parseInt(st.nextToken());
        }
        dp[0][1] = Math.max(0, dp[0][0]);
        dp[0][2] = dp[0][0];

        int max = dp[0][0];

        for (int i = 1; i < dp.length; i++) {
            dp[i][1] = Math.max(dp[i-1][1] + dp[i][0], dp[i-1][2]);

            dp[i][2] = Math.max(dp[i-1][2] + dp[i][0], dp[i][0]);

            max = Math.max(max, Math.max(dp[i][1], dp[i][2]));
        }

//        for(int j = 0; j < dp[0].length; j++){
//            for(int i = 0; i < dp.length; i++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println(" ");
//        }

        System.out.println(max);
    }
}


package boj;

import java.util.*;

public class BOJ1463 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] dp = new int[N+1];

        for(int i = 1; i < dp.length; i++){
            if(i+1 < dp.length && (dp[i+1] == 0 || dp[i+1] > dp[i] + 1)) dp[i+1] = dp[i] + 1;
            if(i*2 < dp.length && (dp[i*2] == 0 || dp[i*2] > dp[i] + 1)) dp[i*2] = dp[i] + 1;
            if(i*3 < dp.length && (dp[i*3] == 0 || dp[i*3] > dp[i] + 1)) dp[i*3] = dp[i] + 1;
        }

        System.out.println(dp[N]);
    }
}

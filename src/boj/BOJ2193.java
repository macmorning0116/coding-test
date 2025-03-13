package boj;

import java.util.*;

public class BOJ2193 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[] dp = new long[N+2];
        dp[1] = 1;
        dp[2] = 1;

        if(N == 1 || N == 2){
            System.out.println(1);
            return;
        }

        for(int i = 3; i <= N; i++){
            dp[i] = dp[i-2] + dp[i-1];
        }

        System.out.println(dp[N]);
    }
}

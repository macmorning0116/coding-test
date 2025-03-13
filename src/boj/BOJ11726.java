package boj;

import java.util.*;

public class BOJ11726 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] dp = new long[N+2];

        dp[1] = 1;
        dp[2] = 2;

        if(N == 1){
            System.out.println(1);
        }else if(N == 2){
            System.out.println(2);
        }else{
            for(int i = 3; i <= N; i++){
                dp[i] = (dp[i-2] + dp[i-1]) % 10007;
            }
            System.out.println(dp[N]);
        }
    }
}

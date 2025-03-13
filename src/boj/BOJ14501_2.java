package boj;

import java.util.*;
import java.io.*;

public class BOJ14501_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] t = new int[N+1];
        int[] p = new int[N+1];
        int[] dp = new int[200];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int tt = Integer.parseInt(st.nextToken());
            int pp = Integer.parseInt(st.nextToken());

            t[i] = tt;
            p[i] = pp;
        }

        for(int i = N; i >= 1; i--){
            if(i + t[i] - 1 <= N){
                dp[i] = Math.max(p[i] +  dp[i + t[i]], dp[i+1]);
            }else{
                dp[i] = dp[i+1];
            }
        }

        System.out.println(dp[1]);
    }
}

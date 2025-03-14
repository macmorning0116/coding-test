package boj;

import java.io.*;

public class BOJ9252 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] aArr = br.readLine().toCharArray();
        char[] bArr = br.readLine().toCharArray();

        int[][] dp = new int[bArr.length + 1][aArr.length + 1];

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[i].length; j++){
                if(aArr[j-1] == bArr[i-1]) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }

//
//        for(int i = 0; i < dp.length; i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }

        StringBuilder sb = new StringBuilder();
        int i = dp.length - 1;
        int j = dp[0].length - 1;

        while(sb.length() < dp[bArr.length][aArr.length]){
            if(bArr[i-1] == aArr[j-1]){
                sb.append(bArr[i-1]);
                i--;
                j--;
            }
            else {
                if(dp[i][j-1] >= dp[i-1][j]){
                    j--;
                }else{
                    i--;
                }
            }
        }

        System.out.println(dp[bArr.length][aArr.length]);
        System.out.println(sb.reverse());

    }
}

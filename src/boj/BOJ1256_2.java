package boj;

import java.util.*;
import java.io.*;


public class BOJ1256_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[][] sums = new long[N+M+1][N+M+1];
        for(int i = 0; i < sums.length; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0 || i == j) sums[i][j] = 1;
                else if(j == 1) sums[i][j] = i;
            }
        }

        for(int i = 1; i < sums.length; i++){
            for(int j = 2; j <= i; j++){
                sums[i][j] = sums[i-1][j-1] + sums[i-1][j];
                if(sums[i][j] > 1000000000) sums[i][j] = 1000000001;
            }
        }

        if(K > sums[N+M][N]) System.out.println(-1);
        else{
            StringBuilder sb = new StringBuilder();

            while(N > 0 && M > 0){
                if(K <= sums[N+M-1][N-1]){
                    sb.append("a");
                    N--;
                }else{
                    sb.append("z");
//                    System.out.println("sums[N+M-1][N-1] " +sums[N+M-1][N-1]);
                    K = (int) (K - sums[N+M-1][N-1]);
                    M--;
                }

//                System.out.println("sb의 값 " + sb);
//                System.out.println("현재 K 값 " + K);
//                System.out.println("");


            }

            while(N > 0){
                sb.append("a");
                N--;
            }
            while(M > 0){
                sb.append("z");
                M--;
            }

            System.out.println(sb);
        }
    }
}

package boj;

import java.util.*;
import java.io.*;

public class BOJ1256 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] D = new int[201][201];

        for(int i = 0; i <= N + M; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i) D[i][j] = 1;
                else{
                    D[i][j] = D[i-1][j-1] + D[i-1][j];
                    if(D[i][j] > 1000000000) D[i][j] = 1000000001;
                }
            }
        }

        if(D[M+N][N] < K){
            System.out.println(-1);
            return;
        }else{
            StringBuilder sb = new StringBuilder();
            while(!(N == 0 && M == 0)){
                if(D[N+M-1][M] >= K){
                    sb.append("a");
                    N--;
                }else{
                    sb.append("z");
                    K = K - D[N+M-1][M];
                    M--;
                }
            }

            System.out.println(sb);
        }


    }
}

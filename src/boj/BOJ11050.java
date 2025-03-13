package boj;

import java.util.*;
import java.io.*;

public class BOJ11050 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][N+1];

        for(int i = 0; i <= N; i++){
            arr[i][1] = i;
            arr[i][i] = 1;
            arr[i][0] = 1;
        }

        for(int i = 1; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(arr[i][j] == 0) arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
            }
        }

        System.out.println(arr[N][K]);
    }
}

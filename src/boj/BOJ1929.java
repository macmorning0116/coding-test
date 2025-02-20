package boj;

import java.util.*;
import java.io.*;


public class BOJ1929 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];

        for(int i = 2; i <= N; i++){
            arr[i] = i;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 2; i <= Math.sqrt(N); i++){
            if(arr[i] == 0) continue;
            for(int j = i + i; j <= N; j = j + i){
                arr[j] = 0;
            }
        }

        for(int i = M; i <= N; i++){
            if(arr[i] != 0){
                sb.append(i);
                sb.append("\n");
            }
        }

        System.out.println(sb);

    }
}

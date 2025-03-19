package boj;

import java.util.*;
import java.io.*;

public class BOJ13251 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[M];
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int temp = Integer.parseInt(st.nextToken());

            sum += temp;
            arr[i] = temp;
        }

        int K = Integer.parseInt(br.readLine());

        double answer = 0;

        for(int i = 0; i < M; i++){
            double temp = 1;
            for(int j = 0; j < K; j++){
                temp *= (double) (arr[i] - j) / (sum - j);
            }
            answer += temp;
        }

        System.out.println(answer);


    }
}

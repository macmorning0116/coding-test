package boj;

import java.util.*;
import java.io.*;

public class BOJ2042 {
    static long[] arr;
    static long k;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long temp = 1; // 세그먼트 트리 사용을 위한 k값 찾기
        k = 0;
        while(temp < N){
            temp*= 2;
            k++;
        }

        arr = new long[(int)Math.pow(2,k) * 2];
        int start = (int) Math.pow(2,k);
        for(int i = start; i < start + N; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        // 구간합 초기화
        for(int i = start - 1; i >= 1; i--){
            arr[i] = arr[i*2] + arr[i*2+1];
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M + K; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());

            if(u == 1) change(v,w);
            else{
                sb.append(sum(v,(int)w)).append("\n");
            }
        }

        System.out.println(sb);


    }
    // 수 업데이트
    static void change(int idx, long num){
        int start = (int) (Math.pow(2,k)) + (idx - 1);
        arr[start] = num;

        while(start > 0){
            start /= 2;
            arr[start] = arr[start*2] + arr[start * 2 + 1];
        }
    }

    // 구간합 구하기
    static long sum(int s, int e){
        long sum = 0;
        int start = (int) (Math.pow(2,k)) + (s - 1);
        int end = (int) (Math.pow(2,k)) + (e - 1);

        while(start <= end){
            if(start % 2 == 1) sum += arr[start];
            if(end % 2 == 0) sum += arr[end];

            start = (start + 1) / 2;
            end = (end - 1) / 2;
        }

        return sum;
    }

}

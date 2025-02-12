package boj;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10986 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[] sum = new long[N];
        sum[0] = arr[0];

        for(int i = 1; i < sum.length; i++){
            sum[i] = sum[i-1] + arr[i];
        }

        int[] newSum = new int[N];
        for(int i = 0; i < sum.length; i++){
            int temp = (int) (sum[i] % M);
            if(temp == 0) answer++;
            newSum[i] = temp;
        }

        long[] counts = new long[M];

        for(int i = 0; i < newSum.length; i++){
            counts[(int) newSum[i]]++;
        }

        for(int i = 0; i < counts.length; i++){
            if(counts[i] >=2){
                answer += (((long) counts[i] * ( counts[i] - 1))/2);
            }
        }

        System.out.println(answer);
    }
}

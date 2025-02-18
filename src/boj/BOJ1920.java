package boj;

import java.util.*;
import java.io.*;

public class BOJ1920 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] targets = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0;  i < M; i++){
            targets[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();

        for(int num: targets){
            int idx = Arrays.binarySearch(arr, num);
            if(idx >= 0) sb.append("1\n");
            else sb.append("0\n");
        }

        System.out.println(sb);
    }
}

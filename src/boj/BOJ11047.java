package boj;

import java.util.*;
import java.io.*;

public class BOJ11047 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 0;

        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = arr.length - 1; i >= 0; i--){
            if(K == 0) break;
            if(K - arr[i] >= 0){
                while(true){
                    if(K - arr[i] >= 0){
                        K -= arr[i];
                        count++;
                    }else{
                        break;
                    }
                }
            }
        }

        System.out.println(count);
    }
}

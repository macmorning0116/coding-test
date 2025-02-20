package boj;

import java.util.*;
import java.io.*;

public class BOJ1456 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int[] arr = new int[10000001];

        for(int i = 2; i < arr.length; i++){
            arr[i] = i;
        }

        for(int i = 2; i < arr.length; i++){
            if(arr[i] == 0) continue;
            for(int j = i + i; j < arr.length; j = j + i){
                arr[j] = 0;
            }
        }

        int answer = 0;
        for(int i = 2; i <= Math.sqrt(B) ; i++){
            if(arr[i] != 0){
                long temp =  (long)i * i;
                while(temp <= B){
                    if(temp >= A){
                        answer++;
                    }
                    if (temp > B / i) break;
                    temp *= i;
                }
            }
        }


        System.out.println(answer);
    }
}

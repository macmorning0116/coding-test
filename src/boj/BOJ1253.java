package boj;

import java.util.*;
import java.io.*;

public class BOJ1253 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long answer = 0;

        int N = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arr.length; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i = 0; i < arr.length; i++){
            int s = 0;
            int e = arr.length - 1;
            while(s < e){
                if(s != i && e != i){
                    if(arr[s] + arr[e] == arr[i]){
                        answer++;
                        break;
                    }else if(arr[s] + arr[e] > arr[i]){
                        e--;
                    }else{
                        s++;
                    }
                }else if(s == i){
                    s++;
                }else{
                    e--;
                }
            }
        }

        System.out.println(answer);

    }
}

package boj;

import java.util.*;
import java.io.*;

public class BOJ2750 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for(int i = 0; i < arr.length; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N-1; i++){
            for(int j = 0; j < N-1-i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int num: arr){
            sb.append(num);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

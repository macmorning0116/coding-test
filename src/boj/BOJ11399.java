package boj;

import java.util.*;
import java.io.*;

public class BOJ11399 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        long sum = 0;
        long temp = 0;

        for(int i = 0; i < arr.length; i++){
            temp += arr[i];
            sum += temp;
        }

        System.out.println(sum);
    }
}

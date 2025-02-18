package boj;

import java.util.*;
import java.io.*;

public class BOJ2343 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        int max = 0;
        int sum = 0;

        for(int i = 0; i < arr.length; i++){
            int temp = Integer.parseInt(st.nextToken());
            if(max < temp) max = temp;
            sum += temp;
            arr[i] = temp;
        }

        int start = max;
        int end = sum;

        while(start <= end){
            int mid = (start + end) / 2;
            int tempSum = 0;
            int count = 0;

            for(int i = 0; i < arr.length; i++){
                if(tempSum + arr[i] <= mid){
                    tempSum += arr[i];
                }else{
                    count++;
                    tempSum = arr[i];
                }
                if(i == arr.length - 1){
                    count++;
                }
            }

            if(count <= M) end = mid - 1;
            else start = mid + 1;
        }

        System.out.println(start);
    }
}

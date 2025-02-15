package boj;

import java.util.*;
import java.io.*;

public class BOJ1427 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int[] arr = Arrays.stream(str.split("")).mapToInt(Integer::parseInt).toArray();

        for(int i = 0; i < arr.length; i++){
            int max = -1;
            int maxIdx = 0;
            for(int j = i; j < arr.length; j++){
                if(max < arr[j]){
                    max = arr[j];
                    maxIdx = j;
                }
            }
            int temp = arr[i];
            arr[i] = max;
            arr[maxIdx] = temp;
        }

        StringBuilder sb = new StringBuilder();
        for(int num: arr){
            sb.append(num);
        }

        System.out.println(sb);
    }
}

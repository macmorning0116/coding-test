package boj;

import java.util.*;
import java.io.*;

public class BOJ1920_2 {
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            if(find(Integer.parseInt(st.nextToken()))){
                sb.append(1).append("\n");
            }else{
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb);

    }

    static boolean find(int num){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = (start + end) / 2;
            if(num == arr[mid]) return true;
            else if(num > arr[mid]) start = mid + 1;
            else end = mid - 1;
        }

        return false;
    }
}

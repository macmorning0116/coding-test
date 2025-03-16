package boj;

import java.util.*;
import java.io.*;

public class BOJ1915 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++){
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] == 1 && i > 0 && j > 0){
                    int min = Math.min(arr[i-1][j-1], Math.min(arr[i-1][j], arr[i][j-1]));
                    arr[i][j] = min + 1;
                }
                if(max < arr[i][j]) max = arr[i][j];
            }
        }

//        for(int i = 0; i < arr.length; i++){
//            System.out.println(Arrays.toString(arr[i]));
//        }

        System.out.println(max * max);
    }
}


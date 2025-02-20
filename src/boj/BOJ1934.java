package boj;

import java.util.*;
import java.io.*;

public class BOJ1934 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int msn = gcd(A,B);
            long answer = (long) msn * (A/msn) * (B/msn);
            sb.append(answer);
            sb.append("\n");
        }

        System.out.println(sb);

    }
    static int gcd(int a, int b){
        int max = 0;
        int min = 0;

        if(a >= b){
            max = a;
            min = b;
        }else{
            max = b;
            min = a;
        }

        while(true){
            int temp = max % min;
            if(temp == 0){
                return min;
            }else{
                max = min;
                min = temp;
            }
        }
    }
}

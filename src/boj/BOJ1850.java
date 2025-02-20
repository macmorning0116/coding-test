package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1850 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long count = gcd(a,b);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < count; i++){
            sb.append("1");
        }

        System.out.println(sb);

    }
    static long gcd(long a, long b){
        long max = 0;
        long min = 0;
        if(a >= b) {
            max = a;
            min = b;
        }else{
            max = b;
            min = a;
        }

        while(true){
            long temp = max % min;
            if(temp == 0) return min;
            else{
                max = min;
                min = temp;
            }
        }


    }
}

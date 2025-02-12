package boj;

import java.util.*;
import java.io.*;

public class BOJ1940 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long answer = 0;

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            int temp = Integer.parseInt(st.nextToken());
            if(map.containsKey(M - temp)){
                answer++;
            }
            map.put(temp, 1);
        }

        System.out.println(answer);
    }
}

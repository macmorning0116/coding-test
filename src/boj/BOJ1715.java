package boj;

import java.util.*;
import java.io.*;

public class BOJ1715 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Long[] arr = new Long[N];

        for(int i = 0; i < N; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i = 0; i < arr.length; i++){
            pq.add(arr[i]);
        }

        long answer = 0;

        while(pq.size() >= 2){
            long temp = pq.poll() + pq.poll();
            answer += temp;
            pq.add(temp);
        }

        System.out.println(answer);
    }
}

package boj;

import java.util.*;
import java.io.*;

public class BOJ11286 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> {
            int o1Conv = Math.abs(o1);
            int o2Conv = Math.abs(o2);

            if(o1Conv == o2Conv){
                return o1 > o2 ? 1 : -1;
            }else{
                return o1Conv - o2Conv;
            }
        });

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());

            if(now == 0){
                if(pq.isEmpty()) sb.append("0\n");
                else{
                    sb.append(pq.poll());
                    sb.append("\n");
                }
            }else{
                pq.add(now);
            }
        }

        System.out.println(sb);

    }
}

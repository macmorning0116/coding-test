package boj;

import java.util.*;
import java.io.*;

public class BOJ2252 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        int[] d = new int[N+1];
        for(int i = 0; i < N+1; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            d[e]++;
            list.get(s).add(e);
        }

        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 1; i < d.length; i++){
            if(d[i] == 0) q.addLast(i);
        }
        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()){
            int num = q.pollFirst();

            sb.append(num).append(" ");
            for(int i: list.get(num)){
                d[i]--;
                if (d[i] == 0) q.addLast(i);
            }
        }

        System.out.println(sb);

    }
}

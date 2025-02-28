package boj;

import java.util.*;
import java.io.*;

public class BOJ1516 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] sums = new int[N+1];  // 해당 건물을 짓는데 들어가는 총 시간
        int[] time = new int[N+1];  // 각 건물 짓는 시간
        int[] d = new int[N+1];     // 진입 차수
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());

            while(st.hasMoreTokens()){
                int num = Integer.parseInt(st.nextToken());
                if(num == -1) break;

                d[i]++;
                list.get(num).add(i);
            }
        }

        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 1; i < d.length; i++){
            if(d[i] == 0){
                q.addLast(i);
                sums[i] = time[i];
            }
        }

        while(!q.isEmpty()){
            int now = q.pollFirst();

            for(int num: list.get(now)){
                sums[num] = Math.max(sums[now] + time[num], sums[num]);
                d[num]--;
                if(d[num] == 0) q.addLast(num);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < sums.length; i++){
            sb.append(sums[i]).append("\n");
        }

        System.out.println(sb);


    }
}

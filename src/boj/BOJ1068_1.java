package boj;

import java.util.*;
import java.io.*;

public class BOJ1068_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> list = new ArrayList<>();
        int sum = 0; // 전체 리프노드 개수
        Queue<Integer> q = new LinkedList<>();
        int[] counts = new int[N];  // 자식 노드 개수
        int[] parents = new int[N];  // 부모 노드

        for(int i = 0; i < N; i++){
            list.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num != -1){
                list.get(num).add(i);
                counts[num]++;
            }
            parents[i] = num;
        }

        int K = Integer.parseInt(br.readLine());
        q.add(K);
        if(parents[K] == -1){
            System.out.println(0);
            return;
        }
        counts[parents[K]]--;
        counts[K] = -1;

        while(!q.isEmpty()){
            int now = q.poll();

            for(int next: list.get(now)){
                counts[next] = -1;
                q.add(next);
            }
        }

        for(int i = 0; i < counts.length; i++){
            if(counts[i] == 0) sum++;
        }

        System.out.println(sum);

    }
}

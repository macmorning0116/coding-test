package boj;

import java.util.*;
import java.io.*;

public class BOJ14501_1 {
    static int max = 0;
    static List<Node> list;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            list.add(new Node(t, p));
        }

        dfs(0,0);

        System.out.println(max);


    }

    static void dfs(int n, int sm){
        if(n > N) return;
        if(n == N){
            if(sm > max) max = sm;
            return;
        }

        // 고르기
        dfs(n + list.get(n).t , sm + list.get(n).p);
        // 고르지 않기
        dfs(n + 1, sm);
    }

    static class Node{
        int t;
        int p;

        public Node(int t, int p){
            this.t = t;
            this.p = p;
        }
    }
}

package boj;

import java.util.*;
import java.io.*;

public class BOJ1717 {
    static int[] heads;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        heads = new int[n+1];

        for(int i = 0; i < heads.length; i++){
            heads[i] = i;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int uf = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(uf == 0){
                union(a,b);
            }else{
                int aHead = find(a);
                int bHead = find(b);

                if(aHead == bHead) sb.append("YES\n");
                else sb.append("NO\n");
            }
        }

        System.out.println(sb);
    }
    static void union(int a, int b){
        int aHead = find(a);
        int bHead = find(b);

        if(aHead != bHead){
            heads[bHead] = aHead;
        }
    }

    static int find(int n){
        if(n == heads[n]) return n;
        return heads[n] = find(heads[n]);
    }
}

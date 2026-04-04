package boj;

import java.util.*;
import java.io.*;

public class BOJ1717_2 {

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
            int c = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(c == 1){
                if(find(a) == find(b)) sb.append("YES").append("\n");
                else sb.append("NO").append("\n");
            }else{
                union(a, b);
            }
        }

        System.out.println(sb.toString());
    }

    static void union(int a, int b){
        int aHead = find(a);
        int bHead = find(b);

        if(aHead != bHead) {
            heads[bHead] = aHead;
        }
    }

    static int find(int n){
        if(n == heads[n]) return n;
        return heads[n] = find(heads[n]);
    }
}

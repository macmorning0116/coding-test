package boj;

import java.util.*;
import java.io.*;

public class BOJ11404_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long MAX = Long.MAX_VALUE;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        long[][] d = new long[n+1][n+1];

        for(int i = 0; i < d.length; i++){
            for(int j = 0; j < d.length; j++){
                if(i != j) d[i][j] = MAX;
            }
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(d[s][e] > c) d[s][e] = c;
        }

        for(int k = 1; k <= n; k++){
            for(int s = 1; s <= n; s++){
                for(int e = 1; e <= n; e++){
                    if(d[s][k] != MAX && d[k][e] != MAX && d[s][e] > d[s][k] + d[k][e])
                        d[s][e] = d[s][k] + d[k][e];
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < d.length; i++){
            for(int j = 1; j < d.length; j++){
                if(d[i][j] != MAX) sb.append(d[i][j]);
                else sb.append(0);
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

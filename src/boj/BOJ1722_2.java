package boj;

import java.util.*;
import java.io.*;

public class BOJ1722_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[N+1];
        long[] F = new long[21];
        int[] S = new int[21];
        F[0] = 1;
        for(int i = 1; i <= N; i++){
            F[i] = F[i-1] * i;
        }


        st = new StringTokenizer(br.readLine());
        int Q = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        if(Q == 1){
            long K = Long.parseLong(st.nextToken());
            for(int i = 1; i <= N; i++){
                int cnt = 1;
                for(int j = 1; j <= N; j++){
                    if(visited[j]) continue;
                    if(K <= cnt * F[N-i]){
                        K -= ((cnt - 1) * F[N - i]);
                        S[i] = j;
                        visited[j] = true;
                        break;
                    }
                    cnt++;
                }
            }

            for(int i = 1; i <= N; i++){
                sb.append(S[i]).append(" ");
            }

            System.out.println(sb);

        }else{
            long K = 1;
            for(int i = 1; i <= N; i++){
                S[i] = Integer.parseInt(st.nextToken());
                long cnt = 0;
                for(int j = 1; j < S[i]; j++){
                    if(!visited[j]) cnt++;
                }
                K += cnt * F[N - i];
                visited[S[i]] = true;
            }
            System.out.println(K);
        }


    }
}

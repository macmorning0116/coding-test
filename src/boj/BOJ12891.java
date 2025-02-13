package boj;

import java.util.*;
import java.io.*;

public class BOJ12891 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long answer = 0;

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String str = st.nextToken();

        char[] arr = str.toCharArray();

        st = new StringTokenizer(br.readLine());
        int[] targets = new int[4];

        for(int i = 0; i < 4; i++){
            targets[i] = Integer.parseInt(st.nextToken());
        }

        int[] cnt = new int[4];

        for(int i = 0; i < P; i++){
            if(arr[i] == 'A') cnt[0]++;
            else if(arr[i] == 'C') cnt[1]++;
            else if(arr[i] == 'G') cnt[2]++;
            else if(arr[i] == 'T') cnt[3]++;
        }

        int s = 0;
        int e = P - 1;

        while(e < S){
            if(cnt[0] >= targets[0]
                    && cnt[1] >= targets[1]
                    && cnt[2] >= targets[2]
                    && cnt[3] >= targets[3]){
                answer++;
            }

            char before = arr[s];
            char after = arr[e];
            if(e + 1 < S){
                after = arr[e+1];
            }

            if(before == 'A') cnt[0]--;
            else if(before == 'C') cnt[1]--;
            else if(before == 'G') cnt[2]--;
            else if(before == 'T') cnt[3]--;

            if(after == 'A') cnt[0]++;
            else if(after == 'C') cnt[1]++;
            else if(after == 'G') cnt[2]++;
            else if(after == 'T') cnt[3]++;

            s++;
            e++;
        }

        System.out.println(answer);
    }
}

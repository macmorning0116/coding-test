package boj;

import java.util.*;

public class BOJ1300 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int ans = 0;
        int start = 1;
        int end = K;

        while(start <= end){
            int mid = (start + end) / 2;
            int cnt = 0;

            for(int i = 1; i <= N; i++){
                cnt += Math.min(mid / i, N );
            }

            if(cnt < K) start = mid + 1;
            else{
                ans = mid;
                end = mid - 1;
            }
        }

        System.out.println(ans);
    }
}

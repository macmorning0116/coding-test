package pgm;

import java.util.*;

class PGM정수삼각형 {
    public int solution(int[][] triangle) {
        int answer = 0;

        List<List<Integer>> list = new ArrayList<>();
        int n = triangle.length;
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];

        for(int i = 1; i < n; i++){
            for(int j = 0; j < triangle[i].length; j++){
                int t = 0;
                if(j == 0){
                    t = dp[i-1][0] + triangle[i][j];
                }else if(j == triangle[i].length - 1){
                    t = dp[i-1][j-1] + triangle[i][j];
                }else{
                    t = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }

                answer = Math.max(answer, t);
                dp[i][j] = t;
            }

        }

        return answer;
    }
}

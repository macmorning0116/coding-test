package pgm;

class PGM등굣길 {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        long[][] dp = new long[n + 1][m + 1];

        if (puddles[0].length != 0) {
            for (int i = 0; i < puddles.length; i++) {
                dp[puddles[i][1]][puddles[i][0]] = -1;
            }
        }


        for (int i = 1; i < dp.length; i++) {
            if (dp[i][1] == -1) break;
            dp[i][1] = 1;
        }

        for (int i = 1; i < dp[0].length; i++) {
            if (dp[1][i] == -1) break;
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                if (dp[i][j] != -1) {
                    long top = 0;
                    long left = 0;
                    if (dp[i - 1][j] > 0) top = dp[i - 1][j];
                    if (dp[i][j - 1] > 0) left = dp[i][j - 1];

                    dp[i][j] = ((top + left) % 1_000_000_007);
                }

            }
        }

        return (int) (dp[n][m] % 1_000_000_007);
    }
}

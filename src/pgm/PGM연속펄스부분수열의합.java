package pgm;

class PGM연속펄스부분수열의합 {
    public long solution(int[] sequence) {
        long answer = 0;

        long[][] dp = new long[sequence.length][2];
        dp[0][0] = sequence[0];
        dp[0][1] = sequence[0] * (-1);

        answer = Math.max(answer, dp[0][0]);
        answer = Math.max(answer, dp[0][1]);

        for (int i = 1; i < sequence.length; i++) {
            dp[i][0] = Math.max(sequence[i], sequence[i] + dp[i - 1][1]);
            dp[i][1] = Math.max(sequence[i] * (-1), (sequence[i] * (-1)) + dp[i - 1][0]);

            answer = Math.max(answer, dp[i][0]);
            answer = Math.max(answer, dp[i][1]);
        }

        return answer;
    }
}

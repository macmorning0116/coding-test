package pgm;

class PGM줄서는방법 {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        int[] arr = new int[n];
        boolean[] visited = new boolean[n];
        int idx = 0;


        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }

        while (n > 1) {
            long sec = fact(n - 1);
            int part = 0;

            for (int i = 0; i < visited.length; i++) {
                if (!visited[i]) part++;

                if (!visited[i] && part * sec >= k) {
                    visited[i] = true;
                    answer[idx] = arr[i];
                    idx++;
                    break;
                }
            }
            n--;
            k -= (sec * (part - 1));
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) answer[idx] = arr[i];
        }


        return answer;
    }

    private long fact(int num) {
        long sum = 1;
        for (int i = 2; i <= num; i++) {
            sum *= i;
        }

        return sum;
    }
}
package pgm;

class PGM단어변환 {
    boolean[] visited;
    int answer;

    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;

        visited = new boolean[words.length];

        dfs(begin, 0, target, words);

        if (answer == Integer.MAX_VALUE) return 0;
        return answer;
    }

    private void dfs(String now, int cnt, String target, String[] words) {
        if (now.equals(target)) {
            if (answer > cnt) answer = cnt;
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && checkWord(now, words[i])) {
                visited[i] = true;
                dfs(words[i], cnt + 1, target, words);
                visited[i] = false;
            }
        }

    }

    private boolean checkWord(String origin, String target) {
        int diff = 0;

        for (int i = 0; i < origin.length(); i++) {
            if (origin.charAt(i) != target.charAt(i)) diff++;
        }

        if (diff == 1) return true;
        return false;
    }
}

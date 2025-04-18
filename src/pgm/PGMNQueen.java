package pgm;

class PGMNQueen {
    int answer = 0;

    public int solution(int n) {
        boolean[][] visited = new boolean[n][n];
        dfs(0, n, visited);
        return answer;
    }

    private void dfs(int cnt, int n, boolean[][] visited) {
        if (cnt == n) {
            answer++;
            return;
        }

        for (int j = 0; j < n; j++) {
            if (checkQueen(cnt, j, n, visited)) {
                visited[cnt][j] = true;
                dfs(cnt + 1, n, visited);
                visited[cnt][j] = false;
            }
        }
    }

    private boolean checkQueen(int ci, int cj, int n, boolean[][] visited) {
        // 세로
        for (int i = 0; i < ci; i++) {
            if (visited[i][cj]) return false;
        }

        // 왼쪽 위 대각선
        for (int i = ci - 1, j = cj - 1; i >= 0 && j >= 0; i--, j--) {
            if (visited[i][j]) return false;
        }

        // 오른쪽 위 대각선
        for (int i = ci - 1, j = cj + 1; i >= 0 && j < n; i--, j++) {
            if (visited[i][j]) return false;
        }

        return true;
    }
}


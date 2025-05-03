package pgm;

import java.util.*;

class PGM카카오프렌즈컬러링북 {
    int max = 0;
    boolean[][] visited;

    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        int numberOfArea = 0;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    bfs(i, j, m, n, picture);
                    numberOfArea++;
                }
            }
        }


        answer[0] = numberOfArea;
        answer[1] = max;

        return answer;
    }


    private void bfs(int si, int sj, int m, int n, int[][] picture) {
        int cnt = 0;
        int[] di = {1, 0, -1, 0};
        int[] dj = {0, 1, 0, -1};
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(si, sj));
        visited[si][sj] = true;
        int num = picture[si][sj];


        while (!q.isEmpty()) {
            Node now = q.poll();
            cnt++;
            int ci = now.i;
            int cj = now.j;

            for (int i = 0; i < 4; i++) {
                int ni = ci + di[i];
                int nj = cj + dj[i];

                if (0 <= ni && ni < m && 0 <= nj && nj < n && !visited[ni][nj] && picture[ni][nj] == num) {
                    visited[ni][nj] = true;
                    q.add(new Node(ni, nj));
                }
            }
        }

        if (max < cnt) max = cnt;
    }


    class Node {
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}

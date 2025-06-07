package pgm;

import java.util.*;

class PGM경주로건설 {
    int[][][] d;

    public int solution(int[][] board) {
        int n = board.length;
        d = new int[n][n][4]; // 4는 방향(상하좌우)

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(d[i][j], Integer.MAX_VALUE);
            }
        }

        bfs(0, 0, n, board);

        return Arrays.stream(d[n - 1][n - 1]).min().getAsInt();
    }

    private void bfs(int si, int sj, int n, int[][] board) {
        Queue<Node> q = new LinkedList<>();

        for (int dir = 0; dir < 4; dir++) {
            d[si][sj][dir] = 0;
            q.add(new Node(si, sj, dir, 0));
        }

        int[] di = {-1, 1, 0, 0}; // 상 하 좌 우
        int[] dj = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            Node now = q.poll();
            int ci = now.i;
            int cj = now.j;
            int cd = now.dir;
            int cv = now.value;

            for (int i = 0; i < 4; i++) {
                int ni = ci + di[i];
                int nj = cj + dj[i];

                if (0 <= ni && ni < n && 0 <= nj && nj < n && board[ni][nj] != 1) {
                    int tempCost = (cd == i) ? cv + 100 : cv + 600;

                    if (d[ni][nj][i] > tempCost) {
                        d[ni][nj][i] = tempCost;
                        q.add(new Node(ni, nj, i, tempCost));
                    }
                }
            }
        }
    }

    class Node {
        int i;
        int j;
        int dir;  // 0: 상, 1: 하, 2: 좌, 3: 우
        int value;

        public Node(int i, int j, int dir, int value) {
            this.i = i;
            this.j = j;
            this.dir = dir;
            this.value = value;
        }
    }
}

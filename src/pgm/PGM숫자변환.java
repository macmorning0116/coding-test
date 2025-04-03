package pgm;

import java.util.LinkedList;
import java.util.Queue;

class PGM숫자변환 {
    public int solution(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[y + 1]; // x~y 범위만 체크

        queue.offer(new int[]{x, 0});
        visited[x] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int num = cur[0];
            int cnt = cur[1];

            if (num == y) return cnt;

            int[] nextNums = {num + n, num * 2, num * 3};
            for (int next : nextNums) {
                if (next <= y && !visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, cnt + 1});
                }
            }
        }

        return -1; // 도달 불가
    }
}

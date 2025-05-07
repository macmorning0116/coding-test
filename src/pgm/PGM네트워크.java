package pgm;

import java.util.*;

class PGM네트워크 {
    boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                bfs(i, computers, n);
                answer++;
            }
        }


        return answer;
    }

    private void bfs(int num, int[][] computers, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);

        while (!q.isEmpty()) {
            int now = q.poll();
            visited[now] = true;

            for (int i = 0; i < n; i++) {
                if (computers[now][i] == 1 && !visited[i]) {
                    q.add(i);
                }
            }
        }

    }
}
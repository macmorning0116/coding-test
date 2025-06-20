package pgm;

import java.util.*;

class Solution {
    boolean[] visited;
    int answer;

    public int solution(int n) {
        answer = 0;

        visited = new boolean[n];

        for (int j = 0; j < n; j++) {
            List<int[]> tList = new ArrayList<>();
            tList.add(new int[]{0, j});
            visited[j] = true;
            dfs(1, n, 1, tList);
            visited[j] = false;
        }

        return answer;
    }

    private void dfs(int dept, int n, int cnt, List<int[]> list) {
        if (dept == n) {

            if (cnt == n) answer++;
            return;
        }

        for (int j = 0; j < n; j++) {
            if (!visited[j] && check(dept, j, list)) {
                visited[j] = true;
                list.add(new int[]{dept, j});
                dfs(dept + 1, n, cnt + 1, list);
                list.remove(list.size() - 1);
                visited[j] = false;
            }
        }
    }


    private boolean check(int i, int j, List<int[]> list) {
        boolean result = true;

        for (int[] t : list) {
            if (t[0] == i || t[1] == j || Math.abs(t[0] - i) == Math.abs(t[1] - j)) {
                result = false;
                break;
            }
        }

        return result;
    }
}


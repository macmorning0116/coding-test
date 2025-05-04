package pgm;

import java.util.*;

class PGM완전범죄 {
    private static int minATrail = Integer.MAX_VALUE;

    public static int solution(int[][] info, int n, int m) {
        Set<String> isVisited = new HashSet<>();

        dfs(info, 0, 0, 0, n, m, isVisited);

        return minATrail == Integer.MAX_VALUE ? -1 : minATrail;
    }

    private static void dfs(int[][] info, int aTrail, int bTrail, int idx, int n, int m, Set<String> isVisited) {
        if (idx == info.length) {
            if (aTrail < n && bTrail < m) {
                minATrail = Math.min(minATrail, aTrail);
            }
            return;
        }

        String key = aTrail + "," + bTrail + "," + idx;
        if (isVisited.contains(key)) {
            return;
        }

        if (aTrail + info[idx][0] < n) {
            dfs(info, aTrail + info[idx][0], bTrail, idx + 1, n, m, isVisited);
        }

        if (bTrail + info[idx][1] < m) {
            dfs(info, aTrail, bTrail + info[idx][1], idx + 1, n, m, isVisited);
        }

        isVisited.add(key);
    }
}


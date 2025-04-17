package pgm;

import java.util.*;

class PGM후보키 {
    List<Set<Integer>> candidateKeys = new ArrayList<>();

    public int solution(String[][] relation) {
        int col = relation[0].length;
        int row = relation.length;

        for (int r = 1; r <= col; r++) {
            combine(new boolean[col], 0, 0, r, relation);
        }

        return candidateKeys.size();
    }

    private void combine(boolean[] visited, int depth, int start, int r, String[][] relation) {
        if (depth == r) {
            Set<Integer> cols = new HashSet<>();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) cols.add(i);
            }

            // 최소성 검사
            for (Set<Integer> key : candidateKeys) {
                if (cols.containsAll(key)) return;
            }

            // 유일성 검사
            Set<String> seen = new HashSet<>();
            for (String[] tuple : relation) {
                StringBuilder sb = new StringBuilder();
                for (int i : cols) {
                    sb.append(tuple[i]).append("|");
                }
                seen.add(sb.toString());
            }

            if (seen.size() == relation.length) {
                candidateKeys.add(cols);
            }

            return;
        }

        for (int i = start; i < visited.length; i++) {
            visited[i] = true;
            combine(visited, depth + 1, i + 1, r, relation);
            visited[i] = false;
        }
    }
}


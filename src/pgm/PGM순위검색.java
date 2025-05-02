package pgm;

import java.util.*;

class PGM순위검색 {

    private final Map<String, List<Integer>> db = new HashMap<>();

    public int[] solution(String[] info, String[] query) {

        for (String s : info) {
            String[] p = s.split(" ");
            int score = Integer.parseInt(p[4]);
            makeKeys(p, 0, new StringBuilder(), score);
        }

        for (List<Integer> list : db.values()) {
            Collections.sort(list);
        }

        int[] answer = new int[query.length];

        for (int i = 0; i < query.length; i++) {

            String q = query[i].replaceAll(" and ", " ");
            String[] p = q.split(" ");

            String key      = p[0] + " " + p[1] + " " + p[2] + " " + p[3];
            int    need     = Integer.parseInt(p[4]);
            List<Integer> list = db.getOrDefault(key, Collections.emptyList());

            int left = 0, right = list.size();
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (list.get(mid) >= need) right = mid;
                else                       left  = mid + 1;
            }
            answer[i] = list.size() - left;  // tail 개수가 조건 충족 인원
        }
        return answer;
    }

    private void makeKeys(String[] p, int depth, StringBuilder sb, int score) {
        if (depth == 4) {
            String key = sb.toString().trim();
            db.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
            return;
        }

        int len = sb.length();

        sb.append(p[depth]).append(' ');
        makeKeys(p, depth + 1, sb, score);
        sb.setLength(len);

        sb.append("- ");
        makeKeys(p, depth + 1, sb, score);
        sb.setLength(len);
    }
}

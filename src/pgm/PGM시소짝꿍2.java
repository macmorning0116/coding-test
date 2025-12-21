package pgm;

import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer, Long> cnt = new HashMap<>();

        for (int w : weights) {
            answer += cnt.getOrDefault(w, 0L);

            if (w % 2 == 0) answer += cnt.getOrDefault(w / 2, 0L);

            answer += cnt.getOrDefault(w * 2, 0L);

            if ((w * 2) % 3 == 0) answer += cnt.getOrDefault((w * 2) / 3, 0L);

            if ((w * 3) % 2 == 0) answer += cnt.getOrDefault((w * 3) / 2, 0L);

            if ((w * 3) % 4 == 0) answer += cnt.getOrDefault((w * 3) / 4, 0L);

            if ((w * 4) % 3 == 0) answer += cnt.getOrDefault((w * 4) / 3, 0L);

            cnt.put(w, cnt.getOrDefault(w, 0L) + 1);
        }

        return answer;
    }
}

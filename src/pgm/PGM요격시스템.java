package pgm;

import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        int before = -1;

        for (int[] t : targets) {
            if (t[0] + 1 <= before && before <= t[1]) continue;
            before = t[1];
            answer++;
        }


        return answer;
    }
}

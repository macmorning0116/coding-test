package pgm;

import java.util.*;

class PGM야근지수 {
    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < works.length; i++) {
            pq.add(works[i]);
        }

        for (int i = 0; i < n; i++) {
            int temp = pq.poll();
            if (temp > 0) temp--;
            pq.add(temp);
        }

        while (!pq.isEmpty()) {
            answer += (long) Math.pow(pq.poll(), 2);
        }

        return answer;
    }
}

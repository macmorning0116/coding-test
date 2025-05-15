package pgm;

import java.util.*;

class PGM징검다리건너기 {
    public int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o2.value - o1.value);

        for (int i = 0; i < k - 1; i++) {
            pq.add(new Node(i, stones[i]));
        }

        for (int i = 0; i < stones.length - (k - 1); i++) {
            pq.add(new Node(i + (k - 1), stones[i + (k - 1)]));

            while (true) {
                if (pq.peek().idx >= i && pq.peek().idx < i + k) {
                    stones[i] = pq.peek().value;
                    if (stones[i] < answer) answer = stones[i];
                    break;
                } else {
                    pq.poll();
                }
            }

        }

        return answer;
    }

    class Node {
        int idx;
        int value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}
import java.util.*;

class PGM호텔대실 {
    public int solution(String[][] book_time) {
        int answer = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.start - o2.start;
        });

        PriorityQueue<Node> endPQ = new PriorityQueue<>((o1, o2) -> o1.end - o2.end);

        for (String[] time : book_time) {
            String shour = time[0].substring(0, 2);
            String smin = time[0].substring(3);

            String ehour = time[1].substring(0, 2);
            String emin = time[1].substring(3);

            pq.add(new Node(Integer.parseInt(shour) * 60 + Integer.parseInt(smin),
                    Integer.parseInt(ehour) * 60 + Integer.parseInt(emin)));
        }

        while (!pq.isEmpty()) {
            if (endPQ.isEmpty()) {
                endPQ.add(pq.poll());
                answer++;
            } else {
                if (endPQ.peek().end + 10 <= pq.peek().start) {
                    endPQ.poll();
                    endPQ.add(pq.poll());
                } else {
                    answer++;
                    endPQ.add(pq.poll());
                }
            }
        }


        return answer;
    }

    class Node {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }
}
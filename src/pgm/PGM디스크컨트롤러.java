package pgm;

import java.util.*;

class PGM디스크컨트롤러 {
    public int solution(int[][] jobs) {
        int answer = 0;

        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < jobs.length; i++) {
            q.add(new Node(i, jobs[i][0], jobs[i][1]));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            int t1 = o1.time - o2.time;
            int t2 = o1.arrive - o2.arrive;
            int t3 = o1.no - o2.no;

            if (t1 != 0) return t1;
            else if (t2 != 0) return t2;
            else return t3;
        });

        Node nowRun = null;
        int cTime = 0;
        int endTime = 0;
        int cnt = 0;

        while (!pq.isEmpty() || !q.isEmpty() || nowRun != null) {
            while (!q.isEmpty() && cTime == q.peek().arrive) {
                pq.add(q.poll());
            }

            if (nowRun != null && endTime == cTime) {
                answer += (endTime - nowRun.arrive);
                nowRun = null;
                cnt++;
            }

            if (nowRun == null && !pq.isEmpty() && pq.peek().arrive <= cTime) {
                nowRun = pq.poll();
                endTime = cTime + nowRun.time;
            }

            cTime++;
        }

        return answer / jobs.length;
    }


    class Node {
        int no;
        int arrive;
        int time;

        public Node(int no, int arrive, int time) {
            this.no = no;
            this.arrive = arrive;
            this.time = time;
        }

        public String toString() {
            return "[" + no + ", " + arrive + ", " + time + "]";
        }
    }
}

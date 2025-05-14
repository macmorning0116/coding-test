package pgm;

import java.util.*;

class PGM가장먼노드 {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int max = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);
        List<List<Integer>> graph = new ArrayList<>();
        int[] d = new int[n + 1];

        for (int i = 2; i < d.length; i++) {
            d[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            int[] e = edge[i];
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            for (int next : graph.get(now.vertex)) {
                if (d[now.vertex] != Integer.MAX_VALUE && d[next] > d[now.vertex] + 1) {
                    d[next] = d[now.vertex] + 1;
                    pq.add(new Node(next, d[next]));
                }
            }
        }

        for (int i = 0; i < d.length; i++) {
            if (d[i] != Integer.MAX_VALUE && d[i] > max) max = d[i];
        }

        for (int i = 0; i < d.length; i++) {
            if (d[i] == max) answer++;
        }

        return answer;
    }


    class Node {
        int vertex;
        int value;

        public Node(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }
    }
}


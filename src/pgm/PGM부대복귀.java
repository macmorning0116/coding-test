package pgm;

import java.util.*;

class PGM부대복귀 {
    int[] d;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        d = new int[n + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < roads.length; i++) {
            int s = roads[i][0];
            int e = roads[i][1];

            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        for (int i = 1; i <= n; i++) {
            if (i == destination) continue;
            d[i] = Integer.MAX_VALUE;
        }

        pq.add(new Node(destination, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            for (int next : graph.get(now.vertex)) {
                if (d[now.vertex] != Integer.MAX_VALUE && d[next] > d[now.vertex] + now.value) {
                    d[next] = d[now.vertex] + 1;
                    pq.add(new Node(next, d[next]));
                }
            }
        }

        for (int i = 0; i < answer.length; i++) {
            if (d[sources[i]] != Integer.MAX_VALUE) answer[i] = d[sources[i]];
            else answer[i] = -1;
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

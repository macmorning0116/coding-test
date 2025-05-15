package pgm;

import java.util.*;

class PGM섬연결하기 {
    int[] heads;

    public int solution(int n, int[][] costs) {
        int answer = 0;
        int cnt = 0;
        List<Node> graph = new ArrayList<>();
        heads = new int[n + 1];

        for (int i = 1; i < heads.length; i++) {
            heads[i] = i;
        }

        for (int i = 0; i < costs.length; i++) {
            int n1 = costs[i][0];
            int n2 = costs[i][1];
            int w = costs[i][2];

            graph.add(new Node(n1, n2, w));
        }

        Collections.sort(graph, (o1, o2) -> o1.w - o2.w);

        for (int i = 0; i < graph.size(); i++) {
            Node node = graph.get(i);
            if (cnt == n - 1) break;
            if (find(node.n1) != find(node.n2)) {
                union(node.n1, node.n2);
                answer += node.w;
                cnt++;
            }
        }

        return answer;
    }

    private void union(int a, int b) {
        int aHead = find(a);
        int bHead = find(b);

        if (aHead != bHead) heads[bHead] = aHead;
    }

    private int find(int a) {
        if (heads[a] == a) return a;
        return find(heads[a]);
    }

    class Node {
        int n1;
        int n2;
        int w;

        public Node(int n1, int n2, int w) {
            this.n1 = n1;
            this.n2 = n2;
            this.w = w;
        }

        public String toString() {
            return "[" + n1 + ", " + n2 + ", " + w + "]";
        }
    }
}

package pgm;

import java.util.*;

class PGM도넛과막대 {
    boolean[] visited;
    int[] d;
    List<List<Integer>> graph;

    public int[] solution(int[][] edges) {
        int MAX = 1_000_001;
        int addNode = 0;
        int stick = 0;
        int donut = 0;
        int eight = 0;

        graph = new ArrayList<>();

        visited = new boolean[MAX];
        d = new int[MAX];

        for (int i = 0; i < MAX; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            d[edge[1]]++;
        }

        for (int[] edge : edges) {
            int start = edge[0];
            if (d[start] == 0 && graph.get(start).size() >= 2) {
                addNode = start;
                visited[addNode] = true;

                for (int num : graph.get(start)) {
                    d[num]--;
                }

                break;
            }
        }

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];


            if (d[start] == 0 && !visited[start] || (d[end] == 0 && start == addNode && !visited[end])) {
                if (start == addNode) start = end;
                visited[start] = true;

                Queue<Integer> q = new LinkedList<>();
                q.add(start);

                while (!q.isEmpty()) {
                    int now = q.poll();
                    visited[now] = true;

                    if (graph.get(now).size() > 0) q.add(graph.get(now).get(0));
                }

                stick++;

            }
        }

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];

            if (d[start] == 1 && !visited[start]) {
                boolean duplicate = false;
                visited[start] = true;

                Queue<Integer> q = new LinkedList<>();
                q.add(start);

                while (!q.isEmpty()) {
                    int now = q.poll();

                    visited[now] = true;

                    if (graph.get(now).size() > 1) duplicate = true;

                    for (int next : graph.get(now)) {
                        if (!visited[next]) q.add(next);
                    }
                }

                if (duplicate) eight++;
                else donut++;
            }

        }

        int[] answer = new int[4];
        answer[0] = addNode;
        answer[1] = donut;
        answer[2] = stick;
        answer[3] = eight;


        return answer;
    }
}
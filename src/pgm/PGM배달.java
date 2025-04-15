package pgm;


import java.util.*;

class PGM배달 {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        List<List<Node>> graph = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(1,0));

        int[] d = new int[N+1];

        for(int i = 2; i < d.length; i++){
            d[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < N + 1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < road.length; i++){ㅌ
            int node1 = road[i][0];
            int node2 = road[i][1];
            int cost = road[i][2];

            graph.get(node1).add(new Node(node2, cost));
            graph.get(node2).add(new Node(node1, cost));
        }


        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(d[now.vertex] < now.cost) continue;

            for(Node next: graph.get(now.vertex)){
                int newCost = d[now.vertex] + next.cost;

                if(d[next.vertex] > newCost){
                    d[next.vertex] = newCost;
                    pq.add(new Node(next.vertex, newCost));
                }
            }
        }


        for(int i = 1; i < d.length; i++){
            if(d[i] <= K) answer++;
        }

        return answer;
    }

    class Node {
        int vertex;
        int cost;

        public Node(int vertex, int cost){
            this.vertex = vertex;
            this.cost = cost;
        }
    }
}
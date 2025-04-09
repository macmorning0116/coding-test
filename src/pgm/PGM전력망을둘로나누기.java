package pgm;

import java.util.*;

class PGM전력망을둘로나누기 {
    public int solution(int n, int[][] wires) {
        int answer = n;

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n + 1; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] arr: wires){
            int node1 = arr[0];
            int node2 = arr[1];

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        for(int i = 0; i < wires.length; i++){
            int count = 0;
            boolean[] visited = new boolean[n+1];
            Queue<Integer> q = new LinkedList<>();

            int node1 = wires[i][0];
            int node2 = wires[i][1];

            graph.get(node1).remove(Integer.valueOf(node2));
            graph.get(node2).remove(Integer.valueOf(node1));

            q.add(1);
            visited[1] = true;
            count++;

            while(!q.isEmpty()){
                int now = q.poll();

                for(int next: graph.get(now)){
                    if(!visited[next]){
                        visited[next] = true;
                        count++;
                        q.add(next);
                    }
                }
            }
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);

            int t = n - count;
            int temp = Math.abs(count - t);
            if(answer > temp) answer = temp;
            if(temp == 0) break;
        }

        return answer;
    }
}

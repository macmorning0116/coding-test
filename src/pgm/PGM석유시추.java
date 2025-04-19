package pgm;

import java.util.*;

class PGM석유시추 {
    Map<Integer, Integer> map = new HashMap<>();  // 석유 집합 번호와 크기
    int idx = 1; // 석유 집합 번호
    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(land[i][j] == 1){
                    bfs(land, new Node(i,j));
                }
            }
        }

        List<Set<Integer>> setList = new ArrayList<>();

        for(int i = 0; i < m; i++){
            setList.add(new HashSet<>());
        }

        for(int j = 0; j < m; j++){
            for(int i = 0; i < n; i++){
                if(land[i][j] != 0) setList.get(j).add(land[i][j]);
            }
        }

        int answer = 0;
        for(Set<Integer> set: setList){
            int temp = 0;
            for(int num: set){
                temp += map.get(num);
            }

            if(temp > answer) answer = temp;
        }

        return answer;
    }

    // 순회하면서 번호 생성하고 넣기
    private void bfs(int[][] land, Node now){
        int size = 0;
        int[] di = {1,0,-1,0};
        int[] dj = {0,1,0,-1};
        idx++;
        land[now.i][now.j] = idx;

        Queue<Node> q = new LinkedList<>();
        q.add(now);

        while(!q.isEmpty()){
            Node c = q.poll();
            size++;

            for(int i = 0; i < 4; i++){
                int ni = c.i + di[i];
                int nj = c.j + dj[i];

                if(0 <= ni && ni < land.length && 0 <= nj && nj < land[0].length && land[ni][nj] == 1){
                    land[ni][nj] = idx;
                    q.add(new Node(ni, nj));
                }

            }
        }

        map.put(idx, size);
    }

    class Node {
        int i;
        int j;

        public Node(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}

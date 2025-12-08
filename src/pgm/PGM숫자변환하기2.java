package pgm;

import java.util.*;

class PGM숫자변환하기2 {
    int[] visited;
    Queue<int[]> q = new LinkedList<>();


    public int solution(int x, int y, int n) {
        int answer = 0;

        visited = new int[1_000_001];
        for(int i = 0; i < visited.length; i++){
            visited[i] = 1_000_000;
        }

        if(x == y) return 0;


        q.add(new int[]{x, 0});

        while(!q.isEmpty()){
            int[] now = q.poll();

            int val = now[0];
            int cnt = now[1];

            int[] nexts = {val + n, val * 2, val * 3};

            for(int next: nexts){
                if(next <= y && visited[next] > cnt + 1){
                    visited[next] = cnt + 1;
                    q.add(new int[] {next, cnt + 1});
                }
            }
        }

        if(visited[y] == 1_000_000) return -1;
        return visited[y];
    }
}

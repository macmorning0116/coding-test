package pgm;

import java.util.*;

class PGM숫자변환하기 {
    public int solution(int x, int y, int n) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[y + 1];

        q.add(new int[]{x,0});
        visited[x] = true;

        while(!q.isEmpty()){
            int[] c = q.poll();
            int num = c[0];
            int cnt = c[1];

            if(num == y) return cnt;

            int[] nexts = {num + n, num * 2, num * 3};
            for(int next: nexts){
                if(next <= y && !visited[next]){
                    visited[next] = true;
                    q.add(new int[]{next, cnt + 1});
                }
            }
        }

        return -1;
    }

}

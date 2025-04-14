package pgm;

import java.util.*;

class PGM무인도여행 {
    boolean[][] visited;
    char[][] arr;
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();

        arr = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];

        for(int i = 0; i < maps.length; i++){
            arr[i] = maps[i].toCharArray();
        }


        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(!visited[i][j] && arr[i][j] != 'X'){
                    answer.add(bfs(i,j));
                }
            }
        }
        if(answer.isEmpty()) return new int[]{-1};

        Collections.sort(answer);

        return answer.stream().mapToInt(i -> i).toArray();
    }

    private int bfs(int si, int sj){
        Queue<Node> q = new LinkedList<>();
        int[] di = {1,0,-1,0};
        int[] dj = {0,1,0,-1};
        int count = arr[si][sj] - '0';
        visited[si][sj] = true;

        q.add(new Node(si,sj));

        while(!q.isEmpty()){
            Node now = q.poll();
            int ci = now.i;
            int cj = now.j;

            for(int i = 0; i < 4; i++){
                int ni = ci + di[i];
                int nj = cj + dj[i];

                if(0 <= ni && ni < arr.length && 0 <= nj && nj < arr[0].length && arr[ni][nj] != 'X' && !visited[ni][nj]){
                    visited[ni][nj] = true;
                    count += (arr[ni][nj] - '0');
                    q.add(new Node(ni,nj));
                }
            }
        }

        return count;

    }

    class Node{
        int i;
        int j;

        public Node(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}

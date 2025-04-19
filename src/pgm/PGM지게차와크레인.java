package pgm;

import java.util.*;

class PGM지게차와크레인 {
    public int solution(String[] storage, String[] requests) {

        char[][] arr = new char[storage.length][storage[0].length()];

        for(int i = 0; i < storage.length; i++){
            arr[i] = storage[i].toCharArray();
        }

        for(int i = 0; i < requests.length; i++){
            String r = requests[i];

            if(r.length() == 1) jigae(arr, r.charAt(0));
            else crane(r.charAt(0), arr);
        }

        return count(arr);
    }

    private int count(char[][] arr){
        int count = 0;

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] != '.') count++;
            }
        }

        return count;
    }

    private void jigae(char[][] arr, char c){
        List<Node> cList = getNodeList(c, arr); // 확인해봐야할 좌표 구함

        for(Node node: cList){
            if(bfs(node, new int[arr.length][arr[0].length], arr)){
                arr[node.i][node.j] = ',';
            }
        }

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == ',') arr[i][j] = '.';
            }
        }


    }

    private boolean bfs(Node now, int[][] visited, char[][] arr){
        int[] di = {0,1,0,-1};
        int[] dj = {1,0,-1,0};
        Queue<Node> q = new LinkedList<>();
        q.add(now);

        // 경계선에 있는것이면 바로 true
        for(int i = 0; i < 4; i++){
            int ni = now.i + di[i];
            int nj = now.j + dj[i];

            if(ni < 0 || ni > arr.length - 1 || nj < 0 || nj > arr[0].length - 1) return true;
        }

        while(!q.isEmpty()){
            Node c = q.poll();

            for(int i = 0; i < 4; i++){
                int ni = c.i + di[i];
                int nj = c.j + dj[i];

                if(0 <= ni && ni < arr.length && 0 <= nj && nj < arr[0].length && arr[ni][nj] == '.' && visited[ni][nj] == 0){
                    visited[ni][nj] = visited[c.i][c.j] + 1;
                    q.add(new Node(ni, nj));
                }
            }
        }

        System.out.println();

        for(int j = 0; j < visited[0].length; j++){
            if(visited[0][j] != 0 || visited[arr.length - 1][j] != 0) return true;
        }

        for(int i = 0; i < visited.length; i++){
            if(visited[i][0] != 0 || visited[i][arr[0].length - 1] != 0) return true;
        }

        return false;
    }




    private List<Node> getNodeList(char c, char[][] arr){
        List<Node> result = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == c) result.add(new Node(i, j));
            }
        }
        return result;
    }


    private void crane(char c, char[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == c) arr[i][j] = '.';
            }
        }
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

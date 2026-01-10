package pgm;

import java.util.*;

class Solution {
    int[] di = {1, 0, -1, 0};
    int[] dj = {0, 1, 0, -1};

    int si = 0;
    int sj = 0;
    int ei = 0;
    int ej = 0;

    public int solution(String[] board) {

        int n = board.length;
        int m = board[0].length();

        char[][] cBoard = new char[n][m];
        int[][] counts = new int[n][m];

        fillCounts(counts);
        getCharBoard(board, cBoard);
        getStartAndEnd(cBoard, n, m);
        bfs(si, sj, cBoard, counts);

        if(counts[ei][ej] == Integer.MAX_VALUE) return -1;
        return counts[ei][ej];
    }

    private void fillCounts(int[][] counts){
        for(int i = 0; i < counts.length; i++){
            for(int j = 0; j < counts[0].length; j++){
                counts[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    private void getStartAndEnd(char[][] board, int n, int m){

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'R'){
                    si = i;
                    sj = j;
                }else if(board[i][j] == 'G'){
                    ei = i;
                    ej = j;
                }
            }
        }
    }

    private void getCharBoard(String[] board, char[][] cBoard){
        for(int i = 0; i < board.length; i++){
            char[] temp = board[i].toCharArray();

            for(int j = 0; j < board[0].length(); j++){
                cBoard[i][j] = temp[j];
            }
        }
    }

    private void bfs(int si, int sj, char[][] board, int[][] counts){
        Node start = new Node(si, sj);
        Queue<Node> q = new LinkedList<>();
        counts[si][sj] = 0;

        int n = board.length;         // 열
        int m = board[0].length;      // 행


        q.add(start);

        while(!q.isEmpty()){
            Node now = q.poll();
            int ci = now.i;
            int cj = now.j;

            for(int i = 0; i < 4; i++){
                int ni = ci + di[i];
                int nj = cj + dj[i];

                if(0 <= ni && ni < n && 0 <= nj && nj < m && board[ni][nj] != 'D'){
                    Node next = getNextPoint(ni, nj, n, m, i, board);

                    if(counts[next.i][next.j] > counts[ci][cj] + 1){
                        counts[next.i][next.j] = counts[ci][cj] + 1;
                        q.add(next);
                    }

                }
            }

        }
    }

    private Node getNextPoint(int i, int j, int n, int m, int dis, char[][] board){
        int ei = i;
        int ej = j;


        while(true){
            int ni = ei + di[dis];
            int nj = ej + dj[dis];

            if(0 <= ni && ni < n && 0 <= nj && nj < m && board[ni][nj] != 'D'){
                ei += di[dis];
                ej += dj[dis];
            }else {
                break;
            }
        }

        return new Node(ei, ej);
    }

    static class Node {
        int i;
        int j;

        public Node (int i, int j){
            this.i = i;
            this.j = j;
        }

        public String toString() {
            return "[" + i + ", " + j +"]";
        }
    }
}


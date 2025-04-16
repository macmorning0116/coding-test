package pgm;

class PGM가장큰정사각형찾기 {

    public int solution(int[][] board){
        int[][] arr = new int[board.length + 1][board[0].length + 1];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                arr[i+1][j+1] = board[i][j];
            }
        }

        int max = 0;

        for(int i = 1; i < arr.length; i++){
            for(int j = 1; j < arr[0].length; j++){
                if(arr[i][j] == 1){
                    arr[i][j] = Math.min(Math.min(arr[i][j-1], arr[i-1][j]), arr[i-1][j-1]) + 1;
                    if(arr[i][j] > max) max = arr[i][j];
                }
            }
        }

        return max * max;
    }
}

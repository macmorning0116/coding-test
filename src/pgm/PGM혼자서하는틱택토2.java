package pgm;

import java.util.*;

class PGM혼자서하는틱택토2 {
    public int solution(String[] board) {

        char[][] arr = new char[3][3];
        getCharArr(board, arr);
        int[] count = checkCountOx(arr); // O,X의 개수
        int winner = getWinner(arr);

        if((count[0] == count[1] || count[0] == count[1] + 1) && winner != -1){
            if(winner == 0 && (count[0] == count[1] + 1)) return 1;
            else if(winner == 1 && (count[0] == count[1])) return 1;
            else if(winner == 2) return 1;
        }

        return 0;
    }

    private void getCharArr(String[] board, char[][] arr){
        for(int i = 0; i < board.length; i++){
            String temp = board[i];

            for(int j = 0; j < temp.length(); j++){
                arr[i][j] = temp.charAt(j);
            }
        }
    }

    // -1 : 불가능(x가 2성공), 0: o가 이김, 1: x가 이김, 2: 무승부
    private int getWinner(char[][] arr){
        int oCount = 0;
        int xCount = 0;

        // 행 검사
        for(int i = 0; i < 3; i++){
            int[] temp = new int[]{0,0}; // [o, x]

            for(int j = 0; j < 3; j++){
                if(arr[i][j] == 'O') temp[0]++;
                else if(arr[i][j] == 'X') temp[1]++;
            }

            if(temp[0] == 3) oCount++;
            else if(temp[1] == 3) xCount++;
        }


        // 열 검사
        for(int j = 0; j < 3; j++){
            int[] temp = new int[]{0,0}; // [o, x]

            for(int i = 0; i < 3; i++){
                if(arr[i][j] == 'O') temp[0]++;
                else if(arr[i][j] == 'X') temp[1]++;
            }

            if(temp[0] == 3) oCount++;
            else if(temp[1] == 3) xCount++;
        }

        // \ 대각선
        int[] temp = new int[]{0,0};
        if(arr[0][0] == 'O') temp[0]++;
        else if(arr[0][0] == 'X') temp[1]++;

        if(arr[1][1] == 'O') temp[0]++;
        else if(arr[1][1] == 'X') temp[1]++;

        if(arr[2][2] == 'O') temp[0]++;
        else if(arr[2][2] == 'X') temp[1]++;

        if(temp[0] == 3) oCount++;
        else if(temp[1] == 3) xCount++;

        // / 대각선
        temp = new int[]{0,0};
        if(arr[0][2] == 'O') temp[0]++;
        else if(arr[0][2] == 'X') temp[1]++;

        if(arr[1][1] == 'O') temp[0]++;
        else if(arr[1][1] == 'X') temp[1]++;

        if(arr[2][0] == 'O') temp[0]++;
        else if(arr[2][0] == 'X') temp[1]++;

        if(temp[0] == 3) oCount++;
        else if(temp[1] == 3) xCount++;


        if((oCount >= 1 && xCount >= 1) || xCount >= 2) return -1;
        else if(oCount == 0 && xCount == 1) return 1;
        else if(oCount >= 1 && xCount == 0) return 0;
        return 2;

    }


    private int[] checkCountOx(char[][] arr){
        int[] result = new int[]{0,0};

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == 'O') result[0]++;
                else if(arr[i][j] == 'X') result[1]++;
            }
        }

        return result;
    }
}
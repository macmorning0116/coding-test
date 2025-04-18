package pgm;

class PGM혼자서하는틱택톡 {
    public int solution(String[] board) {
        char[][] arr = new char[3][3];

        for(int i = 0; i < 3; i++){
            arr[i] = board[i].toCharArray();
        }


        int oCnt = checkOX('O', arr);
        int xCnt = checkOX('X', arr);

        int oLine = checkLine('O', arr);
        int xLine = checkLine('X', arr);

        // X가 이겼을때
        if(oCnt == xCnt  && (oLine == 0 && xLine == 1)) return 1;

        // O가 이겼을때
        if(oCnt == xCnt + 1 && ((oLine == 1 && xLine == 0) || (oLine == 2 && xLine == 0))) return 1;

        // 비겼을때
        if(oCnt >= xCnt && oCnt - xCnt <= 1 && xLine == 0 && oLine == 0) return 1;
        return 0;

    }

    private int checkLine(char c, char[][] arr){
        int result = 0;
        // 가로 확인
        for(int i = 0; i < 3; i++){
            boolean check = true;
            for(int j = 0; j < 3; j++){
                if(arr[i][j] != c){
                    check = false;
                    break;
                }
            }
            if(check) result++;
        }

        // 세로 확인
        for(int j = 0; j < 3; j++){
            boolean check = true;
            for(int i = 0; i < 3; i++){
                if(arr[i][j] != c){
                    check = false;
                    break;
                }
            }
            if(check) result++;
        }

        // 오른쪽 대각선 확인
        if(arr[0][2] == c && arr[1][1] == c && arr[2][0] == c) result++;

        // 왼쪽 대각선 확인
        if(arr[0][0] == c && arr[1][1] == c && arr[2][2] == c) result++;

        return result;
    }


    private int checkOX(char c, char[][] arr){
        int result = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(arr[i][j] == c) result++;
            }
        }

        return result;
    }


}

package pgm;

class PGM프렌즈4블록 {
    public int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] arr = new char[m][n];

        int[] di = {0,1,1}; // 오른쪽, 아래쪽, 대각선 아래쪽
        int[] dj = {1,0,1};

        for(int i = 0; i < board.length; i++){
            char[] temp = board[i].toCharArray();
            for(int j = 0; j < temp.length; j++){
                arr[i][j] = temp[j];
            }
        }


        while(true){
            int count = 0;

            boolean[][] v = new boolean[m][n];

            for(int i = 0; i < m - 1; i++){
                for(int j = 0; j < n-1; j++){
                    if(arr[i][j] != 'X'){
                        boolean flag = true;
                        for(int d = 0; d < 3; d++){
                            int ni = i + di[d];
                            int nj = j + dj[d];

                            if(!(arr[ni][nj] == arr[i][j])){
                                flag = false;
                                break;
                            }
                        }

                        if(flag){
                            v[i][j] = true;
                            for(int d = 0; d < 3; d++){
                                int ni = i + di[d];
                                int nj = j + dj[d];

                                v[ni][nj] = true;
                            }
                        }

                    }

                }
            }

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(v[i][j]) count++;
                }
            }

            // 내려야됨
            for(int i = m - 1; i > 0; i--){
                for(int j = 0; j < n; j++){
                    if(v[i][j]){
                        boolean flag = false;
                        for(int k = i - 1; k >= 0; k--){
                            if(!v[k][j]){
                                arr[i][j] = arr[k][j];
                                v[k][j] = true;
                                arr[k][j] = 'X';
                                flag = true;
                                break;
                            }
                        }
                        if(!flag) {
                            arr[i][j] = 'X';
                        }

                    }
                }
            }

            // System.out.println(count);
            // for(int i = 0; i < m; i++){
            //     System.out.println(Arrays.toString(arr[i]));
            // }

            answer += count;
            if(count == 0) break;

        }






        return answer;
    }
}

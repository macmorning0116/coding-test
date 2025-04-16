package pgm;

import java.util.*;

class PGM테이블해시함수 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {

        List<List<Integer>> list = new ArrayList<>();

        for(int[] d: data){
            List<Integer> temp = new ArrayList<>();
            for(int i: d) temp.add(i);
            list.add(temp);
        }


        list.sort((a,b) -> {
            int temp = a.get(col - 1) - b.get(col - 1);
            if(temp == 0) return b.get(0) - a.get(0);
            return temp;
        });

        int result = 0;
        for(int i = row_begin - 1; i < row_end; i++){
            int temp = 0;
            for(int num: list.get(i)){
                temp += num % (i + 1);
            }

            result = result ^ temp;
        }
        return result;
    }
}

package pgm;

import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] result = new int[n];
        List<Integer> answer = new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            list.add(i);
        }

        long target = k;

        while(list.size() > 2){
            int nowSize = list.size() - 1;
            long sector = getFactor(nowSize - 1);

            for(int i = 0; i < list.size(); i++){
                long nowSector = i * sector;

                if(nowSector >= target){
                    answer.add(list.get(i));
                    target -= (i-1) * sector;
                    list.remove(i);
                    break;
                }
            }

        }

        answer.add(list.get(1));

        for(int i = 0; i < answer.size(); i++){
            result[i] = answer.get(i);
        }

        return result;
    }

    private long getFactor(int n){
        long result = 1;

        for(int i = n; i >= 1; i--){
            result *= i;
        }

        return result;
    }
}
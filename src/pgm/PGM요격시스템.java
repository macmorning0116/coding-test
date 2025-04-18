package pgm;

import java.util.*;

class PGM요격시스템 {
    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (o1,o2) -> o1[1] - o2[1]);
        int end = 0;

        for(int i = 0; i < targets.length; i++){
            if(targets[i][0] >= end){
                answer++;
                end = targets[i][1];
            }
        }

        return answer;
    }
}

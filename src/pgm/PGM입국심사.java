package pgm;

import java.util.*;

class PGM입국심사 {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = 0;
        long start = 0;
        long end = (long) times[times.length - 1] * n;

        while(start <= end){
            long mid = (start + end) / 2;
            long temp = 0;

            for(int time: times){
                temp += (mid / time);
                if(temp >= n) break;
            }

            if(temp >= n){
                end = mid - 1;
                answer = mid;
            }else{
                start = mid + 1;
            }
        }



        return answer;
    }
}

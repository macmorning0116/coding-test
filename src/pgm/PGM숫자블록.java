package pgm;

import java.util.*;

class PGM숫자블록 {
    public int[] solution(long begin, long end) {
        List<Integer> answer = new ArrayList<>();

        for (long i = begin; i <= end; i++) {
            answer.add(getNum(i));
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    private int getNum(long num) {
        int result = 1;
        if (num == 1) return 0;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                long d = num / i;

                if (d <= 10_000_000) return (int) d;
                if (i <= 10_000_000) result = Math.max(i, result);
            }
        }

        return result;
    }


}


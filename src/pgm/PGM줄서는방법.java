package pgm;

import java.util.*;

class PGM줄서는방법 {
    public int[] solution(int n, long k) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) numbers.add(i);

        int[] result = new int[n];
        k--;

        for (int i = 0; i < n; i++) {
            long fact = factorial(n - 1 - i);
            int index = (int)(k / fact);
            result[i] = numbers.remove(index);
            k %= fact;
        }

        return result;
    }

    private long factorial(int num) {
        long result = 1;
        for (int i = 2; i <= num; i++) result *= i;
        return result;
    }
}


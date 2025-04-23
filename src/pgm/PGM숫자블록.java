package pgm;

class PGM숫자블록 {

    public int[] solution(long begin, long end) {
        int size = (int)(end - begin + 1);
        int[] answer = new int[size];

        for (int i = 0; i < size; i++) {
            long num = begin + i;
            answer[i] = getMaxProperDivisor(num);
        }

        return answer;
    }

    private int getMaxProperDivisor(long num) {
        if (num == 1) return 0;

        int max = 1;

        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                long pair = num / i;

                if (pair <= 10_000_000) {
                    return (int) pair;
                }

                if (i <= 10_000_000) {
                    max = (int) i;
                }
            }
        }

        return max;
    }
}

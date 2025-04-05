package pgm;

class PGM2개이하로다른비트 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long x = numbers[i];

            if (x % 2 == 0) {
                answer[i] = x + 1;
            } else {
                long next = x + 1;
                long diff = x ^ next;
                diff = diff >> 2;
                answer[i] = next | diff;
            }
        }

        return answer;
    }
}


package pgm;

class PGM기지국설치 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int before = 1;
        for (int i = 0; i < stations.length; i++) {
            int temp = (stations[i] - (w + 1));
            if (before <= temp) {
                answer += minAdd(before, temp, 2 * w + 1);
            }
            before = stations[i] + w + 1;
        }

        if (before <= n) answer += minAdd(before, n, 2 * w + 1);
        return answer;
    }

    private int minAdd(int s, int e, int cover) {
        int size = (e - s) + 1;
        int divideAdd = size / cover;
        if (size % cover != 0) return divideAdd + 1;
        return divideAdd;
    }
}
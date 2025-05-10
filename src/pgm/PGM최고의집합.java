package pgm;

class PGM최고의집합 {
    public int[] solution(int n, int s) {

        if (n > s) return new int[]{-1};
        int[] answer = new int[n];
        int i = 0;

        while (s > 0) {
            int temp = s / n;
            s -= temp;
            n--;
            answer[i] = temp;
            i++;
        }

        return answer;

    }

}

package pgm;

class PGM조이스틱 {
    public int solution(String name) {
        int n = name.length();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int diff = name.charAt(i) - 'A';
            answer += Math.min(diff, 26 - diff);
        }

        int minMove = n - 1;

        for (int i = 0; i < n; i++) {
            int next = i + 1;
            while (next < n && name.charAt(next) == 'A') next++;

            minMove = Math.min(minMove, i * 2 + n - next);

            minMove = Math.min(minMove, (n - next) * 2 + i);
        }

        return answer + minMove;
    }
}


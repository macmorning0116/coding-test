package pgm;

class PGM가장긴팰린드롬 {
    int answer;

    public int solution(String s) {
        answer = 0;
        int len = s.length();

        // 홀수 체크
        for (int i = 0; i < len; i++) {
            func(i, s, len);
        }

        // 짝수 체크
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) func2(i - 1, i, s, len);
        }

        return answer;
    }

    private void func2(int idx1, int idx2, String s, int len) {
        int cnt = 2;

        int before = idx1 - 1;
        int next = idx2 + 1;

        while (true) {
            if (before < 0 || next > len - 1) break;
            if (s.charAt(before) == s.charAt(next)) {
                cnt += 2;
                before--;
                next++;
            } else break;
        }

        if (cnt > answer) answer = cnt;
    }

    private void func(int idx, String s, int len) {
        int cnt = 1;

        int before = idx - 1;
        int next = idx + 1;

        while (true) {
            if (before < 0 || next > len - 1) break;
            if (s.charAt(before) == s.charAt(next)) {
                cnt += 2;
                before--;
                next++;
            } else break;
        }

        if (cnt > answer) answer = cnt;
    }
}

package pgm;

class PGM마법의엘리베이터 {
    private int answer = 0;

    public int solution(int storey) {
        String str = String.valueOf(storey);

        while (!str.isEmpty()) {
            str = checkValue(str);
        }
        return answer;
    }

    private String checkValue(String str) {
        int len = str.length();
        int last = str.charAt(len - 1) - '0';
        int num  = Integer.parseInt(str);

        if (len == 1) {
            if (last > 5) {
                answer += 10 - last;
                num    += 10 - last;
            } else {
                answer += last;
                num    -= last;
            }
        } else {
            int prev = str.charAt(len - 2) - '0';
            boolean roundUp =
                    last > 5 ||
                            (last == 5 && prev >= 5);

            if (roundUp) {
                answer += 10 - last;
                num    += 10 - last;
            } else {
                answer += last;
                num    -= last;
            }
        }

        String newStr = String.valueOf(num);
        return newStr.substring(0, newStr.length() - 1);
    }
}

package pgm;

class PGM스티커모으기2 {
    public int solution(int sticker[]) {
        int answer = 0;

        if (sticker.length == 1) return sticker[0];
        int[] fdp = new int[sticker.length - 1];
        int[] ldp = new int[sticker.length - 1];

        for (int i = 0; i < sticker.length; i++) {
            if (i == 0) {
                fdp[i] = sticker[i];
            } else if (i == sticker.length - 1) {
                ldp[i - 1] = sticker[i];
            } else {
                fdp[i] = sticker[i];
                ldp[i - 1] = sticker[i];
            }
        }

        for (int i = 1; i < fdp.length; i++) {
            if (i == 1) {
                fdp[i] = Math.max(fdp[i - 1], fdp[i]);
                ldp[i] = Math.max(ldp[i - 1], ldp[i]);
            } else {
                fdp[i] = Math.max(fdp[i - 1], fdp[i - 2] + fdp[i]);
                ldp[i] = Math.max(ldp[i - 1], ldp[i - 2] + ldp[i]);
            }
        }

        return Math.max(fdp[fdp.length - 1], ldp[ldp.length - 1]);
    }
}

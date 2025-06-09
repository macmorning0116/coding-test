package pgm;

import java.util.*;

class PGM다단계칫솔판매 {
    Map<String, Integer> total = new HashMap<>(); // 총 번 돈
    Map<String, String> refer = new HashMap<>(); // 초대한 사람 종속 관계

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        for (String name : enroll) {
            total.put(name, 0);
        }

        for (int i = 0; i < referral.length; i++) {
            refer.put(enroll[i], referral[i]);
        }

        for (int i = 0; i < seller.length; i++) {
            func(seller[i], amount[i] * 100);
        }

        for (int i = 0; i < enroll.length; i++) {
            answer[i] = total.get(enroll[i]);
        }

        return answer;
    }

    private void func(String name, int money) {
        int origin = money;
        while (true) {
            if (name.equals("-")) break;

            if (origin < 10) {
                total.put(name, total.get(name) + origin);
                break;
            }
            total.put(name, total.get(name) + (origin - (int) (origin * 0.1)));
            origin = (int) (origin * 0.1);
            name = refer.get(name);
        }
    }
}

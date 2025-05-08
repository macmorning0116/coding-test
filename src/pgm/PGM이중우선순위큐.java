package pgm;

import java.util.*;

class PGM이중우선순위큐 {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> min1 = new PriorityQueue<>();
        PriorityQueue<Integer> min2 = new PriorityQueue<>();
        int cnt = 0;

        for (String oper : operations) {
            char op = oper.charAt(0);
            int temp = Integer.parseInt(oper.substring(2, oper.length()));
            if (op == 'I') {
                if (min1.isEmpty() && min2.isEmpty()) min1.add(temp);
                else if (!min1.isEmpty()) min1.add(temp);
                else min2.add(temp);
            } else if (op == 'D' && (!min1.isEmpty() || !min2.isEmpty())) {
                if (temp == -1) {
                    if (!min1.isEmpty()) min1.poll();
                    else min2.poll();
                } else {
                    if (!min1.isEmpty()) {
                        while (min1.size() > 1) {
                            min2.add(min1.poll());
                        }
                        min1.poll();
                    } else {
                        while (min2.size() > 1) {
                            min1.add(min2.poll());
                        }
                        min2.poll();
                    }
                }
            }
        }

        List<Integer> list = new ArrayList<>();

        if (!min1.isEmpty()) {
            list = new ArrayList<>(min1);
        } else if (!min2.isEmpty()) {
            list = new ArrayList<>(min2);
        }

        Collections.sort(list);

        if (list.size() > 0) {
            answer[0] = list.get(list.size() - 1);
            answer[1] = list.get(0);
        }

        return answer;
    }
}

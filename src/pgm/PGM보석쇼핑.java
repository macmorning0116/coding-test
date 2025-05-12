package pgm;

import java.util.*;

class PGM보석쇼핑 {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> cSet = new HashSet<>();
        ArrayDeque<Node> dq = new ArrayDeque<>();
        Map<String, Integer> map = new HashMap<>();
        List<Dnode> dList = new ArrayList<>();

        int total = 0;
        int now = 0;

        for (String gem : gems) {
            cSet.add(gem);
        }
        total = cSet.size();

        for (int i = 0; i < gems.length; i++) {
            String gem = gems[i];


            if (map.containsKey(gem)) {
                map.put(gem, map.get(gem) + 1);
                dq.addLast(new Node(i + 1, gem));

                while (true) {
                    if (!dq.isEmpty() && map.get(dq.peekFirst().gem) > 1) {
                        String temp = dq.pollFirst().gem;
                        map.put(temp, map.get(temp) - 1);
                    } else break;
                }
            } else {
                map.put(gem, 1);
                dq.addLast(new Node(i + 1, gem));
                now++;
            }

            if (now == total) {
                dList.add(new Dnode(dq.peekFirst().i, dq.peekLast().i));
            }
        }

        Collections.sort(dList, (o1, o2) -> {
            return o1.d - o2.d;
        });

        answer[0] = dList.get(0).s;
        answer[1] = dList.get(0).e;


        return answer;
    }

    class Dnode {
        int s;
        int e;
        int d;

        public Dnode(int s, int e) {
            this.s = s;
            this.e = e;
            d = e - s;
        }

        public String toString() {
            return "[" + s + ", " + e + "]";
        }
    }

    class Node {
        int i;
        String gem;

        public Node(int i, String gem) {
            this.i = i;
            this.gem = gem;
        }

        public String toString() {
            return "[" + i + ", " + gem + "]";
        }
    }
}
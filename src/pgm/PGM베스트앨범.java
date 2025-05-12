package pgm;


import java.util.*;

class PGM베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> ans = new ArrayList<>();
        List<Node> cList = new ArrayList<>();
        Map<String, Integer> cMap = new HashMap<>();
        Map<String, List<Inode>> tMap = new HashMap<>();


        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            if (cMap.containsKey(genre)) cMap.put(genre, cMap.get(genre) + plays[i]);
            else cMap.put(genre, plays[i]);

            if (tMap.containsKey(genre)) tMap.get(genre).add(new Inode(i, plays[i]));
            else {
                List<Inode> tmpList = new ArrayList<>();
                tmpList.add(new Inode(i, plays[i]));
                tMap.put(genre, tmpList);
            }
        }

        for (String key : cMap.keySet()) {
            cList.add(new Node(key, cMap.get(key)));
        }

        Collections.sort(cList, (o1, o2) -> {
            return o2.v - o1.v;
        });

        for (int i = 0; i < cList.size(); i++) {
            String genre = cList.get(i).s;
            List<Inode> tmpList = tMap.get(genre);

            Collections.sort(tmpList, (o1, o2) -> {
                int tmp = o2.v - o1.v;
                if (tmp != 0) return tmp;
                else return o1.i - o2.i;
            });

            int cnt = 0;
            while (cnt < tmpList.size()) {
                if (cnt > 1) break;
                ans.add(tmpList.get(cnt).i);
                cnt++;
            }

        }

        return ans.stream().mapToInt(i -> i).toArray();
    }

    class Inode {
        int i;
        int v;

        public Inode(int i, int v) {
            this.i = i;
            this.v = v;
        }

        public String toString() {
            return "[" + i + ", " + v + "]";
        }
    }

    class Node {
        String s;
        int v;

        public Node(String s, int v) {
            this.s = s;
            this.v = v;
        }

        public String toString() {
            return "[" + s + ", " + v + "]";
        }
    }
}
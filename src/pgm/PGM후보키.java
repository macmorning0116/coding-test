package pgm;

import java.util.*;

class PGM후보키 {
    Set<String> set = new HashSet<>();

    public int solution(String[][] relation) {
        List<Integer> pList = new ArrayList<>();

        dfs(0, relation[0].length, relation, pList);

        System.out.println(set.toString());

        return set.size();
    }

    private void dfs(int n, int col, String[][] relation, List<Integer> list) {
        if (n == col) {
            List<Integer> temp = new ArrayList<>(list);
            if (check(temp, relation)) insert(temp);
            return;
        }

        dfs(n + 1, col, relation, list);

        list.add(n);
        dfs(n + 1, col, relation, list);
        list.remove(list.size() - 1);


    }

    private void insert(List<Integer> list) {
        boolean result = true;

        for (String key : set) {
            boolean temp = true;
            for (String k : key.split("")) {
                if (!list.contains(Integer.parseInt(k))) {
                    temp = false;
                    break;
                }
            }
            if (temp) result = false;
        }

        if (result) {
            StringBuilder sb = new StringBuilder();
            for (int i : list) sb.append(i);
            set.add(sb.toString());
        }
    }


    private boolean check(List<Integer> list, String[][] relation) {
        boolean result = true;
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb;

        for (String[] rel : relation) {
            sb = new StringBuilder();

            for (int i : list) {
                sb.append(rel[i]);
            }

            if (map.containsKey(sb.toString())) {
                result = false;
                break;
            } else {
                map.put(sb.toString(), 1);
            }
        }

        return result;
    }
}


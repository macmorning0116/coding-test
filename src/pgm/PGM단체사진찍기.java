package pgm;

import java.util.*;

class PGM단체사진찍기 {
    List<List<Character>> list;
    boolean[] visited;
    char[] names = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};

    public int solution(int n, String[] data) {
        int answer = 0;

        list = new ArrayList<>();
        visited = new boolean[8];

        dfs(0, new ArrayList<>());

        List<List<Character>> tempList = list;

        for (int i = 0; i < data.length; i++) {
            List<List<Character>> tmp = new ArrayList<>();
            for (int j = 0; j < tempList.size(); j++) {
                if (check(data[i], tempList.get(j))) {
                    tmp.add(tempList.get(j));
                }
            }
            tempList = tmp;
        }

        return tempList.size();
    }


    private boolean check(String data, List<Character> list) {
        char[] arr = data.toCharArray();
        char a = arr[0];
        char b = arr[2];
        char oper = arr[3];
        int dis = arr[4] - '0';

        int aIdx = 0;
        int bIdx = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == a) aIdx = i;
            else if (list.get(i) == b) bIdx = i;
        }

        int abDis = Math.abs(aIdx - bIdx) - 1;

        if (oper == '=') {
            if (abDis == dis) return true;
            else return false;
        } else if (oper == '>') {
            if (abDis > dis) return true;
            else return false;
        } else {
            if (abDis < dis) return true;
            else return false;
        }
    }


    private void dfs(int n, List<Character> temp) {
        if (n == 8) {
            list.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp.add(names[i]);
                dfs(n + 1, temp);
                temp.remove(temp.size() - 1);
                visited[i] = false;
            }
        }
    }


}
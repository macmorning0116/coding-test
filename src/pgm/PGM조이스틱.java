package pgm;

import java.util.*;

class PGM조이스틱 {
    int dis;
    boolean[] visited;

    public int solution(String name) {
        int answer = 0;

        List<Integer> cList = new ArrayList<>();
        dis = name.length() - 1;

        cList.add(0);
        for (int i = 1; i < name.length(); i++) {
            if (name.charAt(i) != 'A') {
                cList.add(i);
            }
        }

        visited = new boolean[cList.size()];
        visited[0] = true;

        answer += charCnt(cList, name);
        dfs(cList, name.length() - 1, 0, 1, 0, cList.size());
        answer += dis;

        return answer;
    }

    private void dfs(List<Integer> list, int len, int sum, int cnt, int idx, int listSize) {
        if (sum > dis) return;

        if (cnt == list.size()) {
            if (dis > sum) dis = sum;
            return;
        }

        // 오른쪽으로
        int next = (idx + 1) % listSize;

        if (!visited[next]) {
            visited[next] = true;
            int temp = getRightDis(list.get(idx), list.get(next), len);
            dfs(list, len, sum + temp, cnt + 1, next, listSize);
            visited[next] = false;
        } else {
            int temp = getRightDis(list.get(idx), list.get(next), len);
            dfs(list, len, sum + temp, cnt, next, listSize);
        }

        // 왼쪽으로
        next = idx - 1;
        if (next < 0) next = listSize - 1;

        if (!visited[next]) {
            visited[next] = true;
            int temp = getLeftDis(list.get(idx), list.get(next), len);
            dfs(list, len, sum + temp, cnt + 1, next, listSize);
            visited[next] = false;
        } else {
            int temp = getLeftDis(list.get(idx), list.get(next), len);
            dfs(list, len, sum + temp, cnt, next, listSize);
        }

    }

    private int getRightDis(int now, int next, int len) {
        int dis = next - now;

        if (dis < 0) dis = len - now + next + 1;
        return dis;
    }

    private int getLeftDis(int now, int next, int len) {
        int dis = now - next;
        if (dis < 0) dis = now + (len - next) + 1;
        return dis;
    }


    private int charCnt(List<Integer> list, String name) {
        int sum = 0;
        for (int idx : list) {
            sum += calc(name.charAt(idx));
        }

        return sum;
    }

    private int calc(char c) {
        int a = (c - 'A');
        int b = ('Z' - c + 1);

        return Math.min(a, b);
    }
}
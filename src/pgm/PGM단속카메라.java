package pgm;

import java.util.*;

class PGM단속카메라 {
    List<Integer> visited;

    public int solution(int[][] routes) {
        visited = new ArrayList<>();
        int answer = 0;

        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);

        for (int i = 0; i < routes.length; i++) {
            int[] now = routes[i];
            if (!isVisited(now)) {
                visited.add(now[1] + 30000);
                answer++;
            }
        }

        return answer;
    }

    private boolean isVisited(int[] now) {
        int s = now[0] + 30000;
        int e = now[1] + 30000;

        for (int i = 0; i < visited.size(); i++) {
            int time = visited.get(i);
            if (s <= time && time <= e) return true;
        }

        return false;
    }
}
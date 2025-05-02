import java.util.*;

class PGM충돌위험찾기 {
    boolean[][] visited;
    Map<Integer, Integer>[][] map;
    int answer = 0;

    public int solution(int[][] points, int[][] routes) {
        visited = new boolean[101][101];
        int[] sPoint = new int[101];
        map = new HashMap[101][101];

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                map[i][j] = new HashMap<>();
            }
        }

        for (int i = 0; i < routes.length; i++) {
            int ci = points[routes[i][0] - 1][0];
            int cj = points[routes[i][0] - 1][1];
            sPoint[routes[i][0]]++;
            if (sPoint[routes[i][0]] == 2) answer++;
            func(routes[i], points);
        }


        return answer;
    }

    private void func(int[] route, int[][] points) {
        int si = points[route[0] - 1][0];
        int sj = points[route[0] - 1][1];
        int dis = 1;

        for (int i = 1; i < route.length; i++) {
            int ni = points[route[i] - 1][0];
            int nj = points[route[i] - 1][1];


            while (si != ni) {
                if (si < ni) si++;
                else si--;

                if (!map[si][sj].containsKey(dis)) map[si][sj].put(dis, 1);
                else {
                    if (map[si][sj].get(dis) == 1) {
                        map[si][sj].put(dis, 2);
                        answer++;
                    }
                }
                dis++;

            }

            while (sj != nj) {

                if (sj < nj) sj++;
                else sj--;

                if (!map[si][sj].containsKey(dis)) map[si][sj].put(dis, 1);
                else {
                    if (map[si][sj].get(dis) == 1) {
                        map[si][sj].put(dis, 2);
                        answer++;
                    }
                }

                dis++;
            }
        }


    }
}
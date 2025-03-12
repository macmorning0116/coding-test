package boj;

import java.util.*;
import java.io.*;

public class BOJ11438 {
    static int N;
    static List<List<Integer>> basic;   // 트리 데이터
    static int depth;
    static boolean[] visited;
    static int[] d; // 각 정점의 깊이
    static int k;
    static int[][] arr; // LCA 테이블

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        basic = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            basic.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            basic.get(a).add(b);
            basic.get(b).add(a);
        }

        d = new int[N + 1];

        depth = 0;
        visited = new boolean[N + 1];
        visited[1] = true;

        depth(0, 1);

        k = findK(depth);
        arr = new int[k + 1][N + 1];

        parentInit();
        makeArr();

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(findParent(a, b)).append("\n");
        }

        System.out.print(sb);
    }

    static int findParent(int a, int b) {
        while (d[a] != d[b]) {
            int gap = findGap(a, b);
            int level = findK(gap);

            if (d[a] > d[b]) {
                a = arr[level][a];
            } else {
                b = arr[level][b];
            }
        }

        if (a == b) return a;

        for (int i = k; i >= 0; i--) {
            if (arr[i][a] != arr[i][b]) {
                a = arr[i][a];
                b = arr[i][b];
            }
        }

        return arr[0][a];
    }

    static int findGap(int a, int b) {
        return Math.abs(d[a] - d[b]);
    }

    static void makeArr() {
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= N; j++) {
                if (arr[i - 1][j] != 0) {
                    arr[i][j] = arr[i - 1][arr[i - 1][j]];
                }
            }
        }
    }

    static void parentInit() {
        visited = new boolean[N + 1];
        visited[1] = true;
        arr[0][1] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : basic.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    arr[0][next] = now;
                    q.add(next);
                }
            }
        }
    }

    static int findK(int depth) {
        return 31 - Integer.numberOfLeadingZeros(depth);
    }

    static void depth(int n, int num) {
        d[num] = n;
        depth = Math.max(depth, n);

        for (int next : basic.get(num)) {
            if (!visited[next]) {
                visited[next] = true;
                depth(n + 1, next);
            }
        }
    }
}

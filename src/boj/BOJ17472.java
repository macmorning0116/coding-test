package boj;

import java.util.*;
import java.io.*;

public class BOJ17472 {
    static int[][] arr;
    static int island = 2;
    static int N;
    static int M;
    static int[] heads;
    static List<Edge> edges = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(arr[i][j] == 1){
                    bfs(i,j);
                }
            }
        }

        make();

        // 최소 신장 트리 수행
        edges.sort((o1,o2) -> o1.cost - o2.cost);

        heads = new int[island];
        for(int i = 0; i < heads.length; i++){
            heads[i] = i;
        }
        int count = 0;
        int answer = 0;


        for(int i = 0; i < edges.size(); i++){
            Edge now = edges.get(i);
            if(find(now.node1) != find(now.node2)){
                union(now.node1, now.node2);
                count++;
                answer += now.cost;
            }
        }

        if(count != island -3) System.out.println(-1);
        else System.out.println(answer);

    }
    static int find(int num){
        if(num == heads[num]) return num;
        return heads[num] = find(heads[num]);
    }

    static void union(int a, int b){
        int aHead = find(a);
        int bHead = find(b);

        if(aHead != bHead) heads[bHead] = aHead;
    }

    static void make(){
        // 열별로 실행
        for(int j = 0; j < M; j++){
            int count = 0;
            int before = 0;
            for(int i = 0; i < N; i++){
                if(arr[i][j] != 0){    // 0이 아닌경우
                    if(before != arr[i][j] && count >= 2){
                        edges.add(new Edge(before, arr[i][j], count));
                        before = arr[i][j];
                        count = 0;
                    }else{
                        before = arr[i][j];
                        count = 0;
                    }
                }else{                 // 0인 경우
                    if(before == 0) continue;
                    count++;
                }
            }
        }

        // 행별로 실행
        for(int i = 0; i < N; i++){
            int count = 0;
            int before = 0;
            for(int j = 0; j < M; j++){
                if(arr[i][j] != 0){    // 0이 아닌경우
                    if(before != arr[i][j] && count >= 2){
                        edges.add(new Edge(before, arr[i][j], count));
                        before = arr[i][j];
                        count = 0;
                    }else{
                        before = arr[i][j];
                        count = 0;
                    }
                }else{                 // 0인 경우
                    if(before == 0) continue;
                    count++;
                }
            }
        }
    }



    static void bfs(int i, int j){
        int[] di = {1,0,-1,0};
        int[] dj = {0,1,0,-1};
        Queue<Node> q = new LinkedList<>();
        arr[i][j] = island;
        q.add(new Node(i,j));

        while(!q.isEmpty()){
            Node now = q.poll();

            for(int d = 0; d < 4; d++){
                int ni = now.i + di[d];
                int nj = now.j + dj[d];

                if(0 <= ni && ni < N && 0 <= nj && nj < M && arr[ni][nj] == 1){
                    arr[ni][nj] = island;
                    q.add(new Node(ni,nj));
                }
            }
        }

        island++;
    }

    static class Node{
        int i;
        int j;

        public Node(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    static class Edge {
        int node1;
        int node2;
        int cost;

        public Edge(int node1, int node2, int cost){
            this.node1 = node1;
            this.node2 = node2;
            this.cost = cost;
        }

        public String toString(){
            return ""+ node1 + " " + node2 + " " + cost;
        }
    }
}

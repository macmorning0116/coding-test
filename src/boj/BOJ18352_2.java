package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ18352_2 {
    static int N;
    static int M;
    static int K;
    static int X;
    static List<List<Integer>> arr = new ArrayList<>();
    static int[] dis;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++){
            arr.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            arr.get(A).add(B);
        }

        dis = new int[N+1];
        Arrays.fill(dis, -1);
        bfs(X);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < dis.length; i++){
            if(dis[i] == K){
                sb.append(i);
                sb.append("\n");
            }
        }

        if(sb.length() == 0) System.out.println("-1");
        else System.out.print(sb.toString());
    }


    private static void bfs(int X){
        Queue<Integer> q = new LinkedList<>();
        dis[X] = 0;
        q.add(X);

        while(!q.isEmpty()){
            int now = q.poll();

            for(int next: arr.get(now)){
                if(dis[next] == -1){
                    dis[next] = dis[now] + 1;
                    q.add(next);
                }
            }
        }
    }


}

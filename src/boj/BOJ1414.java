package boj;

import java.util.*;
import java.io.*;

public class BOJ1414 {
    static int[] heads;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Edge> edges = new ArrayList<>();
        int sum = 0;

        heads = new int[N];
        for(int i = 0; i < heads.length; i++){
            heads[i] = i;
        }

        for(int i = 0; i < N; i++){
            char[] temp = br.readLine().toCharArray();
            for(int j = 0; j < N; j++){
                int num = change(temp[j] + 0);
                if(i == j){
                    sum += num;
                }else if(num != 0){
                    sum += num;
                    edges.add(new Edge(i,j,num));
                }
            }
        }

        edges.sort((o1,o2) -> o1.cost - o2.cost);
        int count = 0;
        int minSum = 0;

        for(int i = 0; i < edges.size(); i++){
            Edge now = edges.get(i);

            if(find(now.node1) != find(now.node2)){
                union(now.node1, now.node2);
                count++;
                minSum += now.cost;
            }
        }

        if(count != N - 1) System.out.println(-1);
        else System.out.println(sum - minSum);

        // 0 = 48
        // A = 65
        // Z = 90
        // a = 97
        // z = 122

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

    static int change(int num){
        if(num == 48) return 0;
        else if (num >= 65 && num <= 90) return num - 38;
        else return num - 96;
    }

    static class Edge{
        int node1;
        int node2;
        int cost;

        public Edge(int node1, int node2, int cost){
            this.node1 = node1;
            this.node2 = node2;
            this.cost = cost;

        }
    }
}

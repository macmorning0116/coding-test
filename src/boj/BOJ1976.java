package boj;

import java.util.*;
import java.io.*;

public class BOJ1976 {
    static int heads[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        heads = new int[N+1];
        for(int i = 0; i < heads.length; i++){
            heads[i] = i;
        }

        for(int i = 1; i <= N; i++){
            int[] temp = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for(int j = 0; j < temp.length; j++){
                if(temp[j] == 1) union(i, j+1);
            }
        }

        boolean flag = true;
        int head = 0;
        int[] targets = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        head = find(targets[0]);

        for(int num: targets){
            if(head != find(num)){
                flag = false;
                break;
            }
        }

        if(flag) System.out.println("YES");
        else System.out.println("NO");

    }
    static void union(int a, int b){
        int aHead = find(a);
        int bHead = find(b);

        if(aHead != bHead) heads[bHead] = aHead;
    }

    static int find(int node){
        if(node == heads[node]) return node;
        return heads[node] = find(heads[node]);
    }
}

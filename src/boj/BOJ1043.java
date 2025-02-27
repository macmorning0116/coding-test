package boj;

import java.util.*;
import java.io.*;

public class BOJ1043 {
    static int[] trueP;
    static int[] heads;
    static boolean[] trueNode;
    static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());


        trueP = new int[t];
        trueNode = new boolean[N+1];
        int answer = 0;

        for(int i = 0 ; i < t; i++){
            trueP[i] = Integer.parseInt(st.nextToken());
        }

        heads = new int[N+1];
        for(int i = 0; i < heads.length; i++){
            heads[i] = i;
        }

        for(int i = 0; i < M; i++){
            List<Integer> temp = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            st.nextToken();

            while(st.hasMoreTokens()){
                temp.add(Integer.parseInt(st.nextToken()));
            }
            for(int j = 0; j < temp.size() - 1; j++){
                union(temp.get(j), temp.get(j+1));
            }
            list.add(temp);
        }

        for(int i = 0; i < trueP.length; i++){
            trueNode[find(trueP[i])] = true;
        }

        for(int i = 0; i < list.size(); i++){
            if(check(list.get(i))) answer++;
        }

        System.out.println(Arrays.toString(heads));
        System.out.println(answer);


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

    static boolean check(List<Integer> target){
        for(int i = 0; i < target.size(); i++){
            if(trueNode[find(target.get(i))]) return false;
        }
        return true;
    }
}

package boj;

import java.util.*;
import java.io.*;

public class BOJ1068_2 {
    static int k;
    static int sum = 0;
    static List<List<Integer>> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int root = 0;

        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            list.add(new ArrayList<>());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num != -1) list.get(num).add(i);
            else root = i;
        }

        k = Integer.parseInt(br.readLine());

        dfs(root);
        System.out.println(sum);
    }

    static void dfs(int num){
        if(num == k) return;
        if(list.get(num).isEmpty()){
            sum++;
            return;
        }

        if(list.get(num).size() == 1){
            int next = list.get(num).get(0);
            if(next != k) dfs(next);
            else sum++;
        }else{
            for(int next: list.get(num)){
                dfs(next);
            }
        }

    }
}

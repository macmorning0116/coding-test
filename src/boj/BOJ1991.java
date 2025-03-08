package boj;

import java.io.*;

public class BOJ1991 {
    static int[][] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[27][2];
        for(int i = 0; i < N; i++){
            char[] temp = br.readLine().toCharArray();

            int node = temp[0] - 'A';
            char left = temp[2];
            char right = temp[4];

            if(left == '.') arr[node][0] = -1;
            else arr[node][0] = left - 'A';

            if(right == '.') arr[node][1] = -1;
            else arr[node][1] = right - 'A';
        }

        sb = new StringBuilder();
        preOrder(0);
        System.out.println(sb);

        sb = new StringBuilder();
        inOrder(0);
        System.out.println(sb);

        sb = new StringBuilder();
        postOrder(0);
        System.out.println(sb);


    }
    static void preOrder(int node){
        if(node == -1) return;

        sb.append((char)(node + 'A'));
        preOrder(arr[node][0]);
        preOrder(arr[node][1]);
    }

    static void inOrder(int node){
        if(node == -1) return;

        inOrder(arr[node][0]);
        sb.append((char)(node + 'A'));
        inOrder(arr[node][1]);

    }

    static void postOrder(int node){
        if(node == -1) return;

        postOrder(arr[node][0]);
        postOrder(arr[node][1]);
        sb.append((char)(node + 'A'));
    }
}

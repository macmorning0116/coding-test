package boj;

import java.util.*;
import java.io.*;

public class BOJ11003_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Node[] arr = new Node[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arr.length; i++){
            arr[i] = new Node(Integer.parseInt(st.nextToken()), i);
        }

        Deque<Node> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < arr.length; i++){
            Node now = arr[i];

            while(!dq.isEmpty() && dq.peekLast().value > now.value){
                dq.pollLast();
            }
            dq.addLast(now);

            while(dq.peekFirst().index < i-L+1){
                dq.pollFirst();
            }

            sb.append(dq.peekFirst().value).append(" ");
        }

        System.out.println(sb);

    }
    static class Node{
        int value;
        int index;

        public Node(int value, int index){
            this.value = value;
            this.index = index;
        }
    }
}

package boj;

import java.util.*;
import java.io.*;

public class BOJ11003 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Deque<Node> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            int now = Integer.parseInt(st.nextToken());

            if(deque.isEmpty()){
                deque.addLast(new Node(i,now));
            }else{
                if(deque.peekFirst().idx < i - L + 1){
                    deque.removeFirst();
                }
                while(!deque.isEmpty() && deque.peekLast().value > now){
                    deque.removeLast();
                }
                deque.addLast(new Node(i,now));
            }

            sb.append(deque.peekFirst().value);
            sb.append(" ");
        }

        System.out.println(sb.toString());
    }

    static class Node{
        int idx;
        int value;

        public Node(int idx, int value){
            this.idx = idx;
            this.value = value;
        }

    }
}

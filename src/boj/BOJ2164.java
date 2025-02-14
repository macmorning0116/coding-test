package boj;

import java.util.*;

public class BOJ2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Deque<Integer> deque = new LinkedList<>();

        for(int i = N; i > 0; i--){
            deque.addLast(i);
        }

        while(deque.size() > 1){
            deque.pollLast();
            int temp = deque.pollLast();
            deque.addFirst(temp);
        }

        System.out.println(deque.pop());
    }
}

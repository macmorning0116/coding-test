package boj;

import java.util.*;
import java.io.*;

public class BOJ1931 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Node[] arr = new Node[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[i] = new Node(start, end);
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1.end > o2.end) return 1;
            else if(o1.end == o2.end) return o1.start - o2.start;
            else return -1;
        });

        int answer = 0;
        int tempEnd = 0;

        for(int i = 0; i < arr.length; i++){
            Node now = arr[i];

            if(now.start >= tempEnd){
                answer++;
                tempEnd = now.end;
            }
        }

        System.out.println(answer);

    }
    static class Node{
        int start;
        int end;

        public Node(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString(){
            return "[ " + start + " " + end + " ]";
        }
    }
}

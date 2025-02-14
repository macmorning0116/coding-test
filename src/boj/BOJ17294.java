package boj;

import java.util.*;
import java.io.*;


public class BOJ17294 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[N];
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = arr.length - 1; i >= 0; i--){
            int now = arr[i];
            if(stack.isEmpty()){
                answer[i] = -1;
                stack.push(now);
            }else if(stack.peek() > now){
                answer[i] = stack.peek();
                stack.push(now);
            }else if(stack.peek() <= now){
                while(true){
                    if(!stack.isEmpty() && stack.peek() <= now){
                        stack.pop();
                    }else{
                        if(!stack.isEmpty()){
                            answer[i] = stack.peek();
                            stack.push(now);
                        }else{
                            answer[i] = -1;
                            stack.push(now);
                        }
                        break;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < answer.length; i++){
                sb.append(answer[i]);
                sb.append(" ");
        }

        System.out.println(sb);

    }

}

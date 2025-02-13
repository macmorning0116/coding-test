package boj;

import java.util.*;
import java.io.*;

public class BOJ1874 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        int num = 1;
        boolean flag = true;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());

            while(true){
                if(stack.isEmpty()){
                    stack.push(num);
                    num++;
                    sb.append("+");
                    sb.append("\n");
                }else if(stack.peek() < now){
                    stack.push(num);
                    num++;
                    sb.append("+");
                    sb.append("\n");
                }else if(stack.peek() == now){
                    stack.pop();
                    sb.append("-");
                    sb.append("\n");
                    break;
                }else{
                    flag = false;
                    break;
                }
            }

            if(!flag) break;

        }

        if(flag) System.out.println(sb.toString());
        else{
            System.out.println("NO");
        }

    }
}

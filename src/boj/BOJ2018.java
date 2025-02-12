package boj;

import java.util.*;

public class BOJ2018 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long answer = 0;

        if(N == 1){
            System.out.println("1");
        }else{

            int s = 1;
            int e = 2;
            long sum = s+e;
            while(s <= e){
                if(sum == N) {
                    answer++;
                }
                if(sum <= N && e < N){
                    e++;
                    sum += e;
                }else{
                    sum -= s;
                    s++;
                }
            }

            System.out.println(answer);
        }


    }
}

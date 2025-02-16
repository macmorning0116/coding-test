package boj;

import java.util.Scanner;

public class BOJ2023 {

    static int[] dig = {1,2,3,5,7,9};
    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        dfs(0,"");

        System.out.println(sb);

    }

    static void dfs(int n, String num){
        if(n == N) {
            sb.append(num);
            sb.append("\n");
        }

        for(int i: dig){
            if(isPrime(Integer.parseInt(num+i))){
                dfs(n+1, num+i);
            }
        }
    }

    static boolean isPrime(int num){
        if(num == 1) return false;
        if(num == 2) return true;

        for(int i = 2; i< Math.sqrt(num) + 1; i++){
            if(num%i == 0) return false;
        }
        return true;
    }
}

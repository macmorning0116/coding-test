package boj;

import java.util.*;

public class BOJ1747 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[1111112];
        for(int i = 2; i < arr.length; i++){
            arr[i] = i;
        }

        for(int i = 2; i < arr.length; i++){
            if(arr[i] == 0) continue;
            for(int j = i + i; j < arr.length; j = j + i){
                arr[j] = 0;
            }
        }

        for(int i = N; i < arr.length; i++){
            if(arr[i] != 0 && check(i)) {
                System.out.println(i);
                break;
            }
        }

    }
    static boolean check(int num){
        StringBuilder sb = new StringBuilder();
        String ori = String.valueOf(num);
        String reverse = sb.append(ori).reverse().toString();

        if(ori.equals(reverse)) return true;
        else return false;
    }
}

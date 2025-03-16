package boj;

import java.io.*;

public class BOJ1541_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        int minus = 0;
        int plus = 0;
        boolean flag = false;

        String temp = "";
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] != '-' && arr[i] != '+') {
                temp += arr[i];
            }else {
                if(!flag) plus += Integer.parseInt(temp);
                else minus += Integer.parseInt(temp);
                temp = "";
                if(arr[i] == '-'){
                    flag = true;
                }
            }
            if(i == arr.length - 1){
                if(!flag) plus += Integer.parseInt(temp);
                else minus += Integer.parseInt(temp);
            }
        }

        System.out.println(plus - minus);
    }
}

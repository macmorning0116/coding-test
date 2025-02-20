package boj;

import java.io.*;
import java.util.*;

public class BOJ1541 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        char[] charArr = input.toCharArray();
        List<String> strList = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < charArr.length; i++){
            if(charArr[i] != '-' && charArr[i] != '+') sb.append(charArr[i]);
            else{
                strList.add(sb.toString());
                sb = new StringBuilder();
                strList.add(String.valueOf(charArr[i]));
            }
            if(i == charArr.length - 1){
                strList.add(sb.toString());
            }
        }

        long temp = 0;
        long answer = 0;
        boolean status = false;

        for(int i = 0; i < strList.size(); i++){
            String now = strList.get(i);

            if(now.equals("-")){
                if(status) answer -= temp;
                else answer += temp;
                status = true;
                temp = 0;
            }else if(!now.equals("+")){
                temp += Long.parseLong(now);
            }
            if(i == strList.size() - 1){
                if(status) answer -= temp;
                else answer += temp;
            }
        }

        System.out.println(answer);

    }
}

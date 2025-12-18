package pgm;

import java.util.*;

class Solution {
    public String solution(String number, int k) {

        int len = number.length();
        int cnt = len - k;

        ArrayDeque<Character> dq = new ArrayDeque<>();

        char[] arr = number.toCharArray();
        System.out.println("cnt = "  + cnt);

        for(int i = 0; i < arr.length; i++){
            char now = arr[i];

            if(dq.isEmpty() && dq.size() < cnt) dq.add(now);
            else if(!dq.isEmpty() && dq.peekLast() < now){
                while(!dq.isEmpty()){
                    if(dq.peekLast() < now && ((dq.size() - 1) + (len - i)) >= cnt){
                        dq.pollLast();
                    }else{
                        break;
                    }
                }
                if(dq.size() < cnt) dq.addLast(now);
            }else if(!dq.isEmpty() && dq.peekLast() >= now){
                if(dq.size() < cnt) dq.addLast(now);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(char c: dq){
            sb.append(c);
        }

        return sb.toString();
    }
}
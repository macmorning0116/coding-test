package pgm;

import java.util.*;

class PGM큰수만들기 {
    public String solution(String number, int k) {
        String answer = "";
        int cnt = 0;

        if(number.length() == k) return "";

        ArrayDeque<Character> s = new ArrayDeque<>();
        char[] arr = number.toCharArray();

        s.addLast(arr[0]);
        for(int i = 1; i < arr.length; i++){
            if(cnt < k){
                while(true){
                    if(cnt == k){
                        break;
                    }
                    if(!s.isEmpty() && s.peekLast() < arr[i]){
                        // System.out.println("현재 숫자는 = " + arr[i] + "이고 빠질 숫자는 = " + s.peek() + "이다!");
                        s.pollLast();
                        cnt++;
                    }else{
                        break;
                    }
                }
                if(i == arr.length - 1){
                    if(cnt == k) s.addLast(arr[i]);
                }
                else{
                    s.addLast(arr[i]);
                }



            }else{
                s.addLast(arr[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()){
            sb.append(s.pollFirst());
        }



        return sb.toString();
    }
}

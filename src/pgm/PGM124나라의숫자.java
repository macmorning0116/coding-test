package pgm;

import java.util.*;

class PGM124나라의숫자 {
    public String solution(int n) {
        String answer = "";

        if(n <= 3){
            if(n == 1) return "1";
            else if(n == 2) return "2";
            else return "4";
        }

        int div = n;
        int mod = div;

        Stack<String> s = new Stack<>();

        while(div > 3){
            mod = div % 3;
            div /= 3;

            if(mod == 0){
                s.add("4");
                div--;
            } else {
                if(mod == 1) s.add("1");
                else s.add("2");
            }

            if(div <= 3){
                if(div == 1) s.add("1");
                else if(div == 2) s.add("2");
                else s.add("4");
            }

        }

        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()) sb.append(s.pop());

        return sb.toString();
    }
}

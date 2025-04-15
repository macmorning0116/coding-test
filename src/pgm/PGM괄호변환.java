package pgm;


import java.util.*;

class PGM괄호변환 {
    public String solution(String p) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        String[] temp = divide(p);
        strAdd(sb, temp[0], temp[1]);

        return sb.toString();

    }

    private void strAdd(StringBuilder sb, String u, String v){
        if(checkPerfect(u)){
            sb.append(u);
            if(checkPerfect(v)){
                sb.append(v);
                return;
            }
            String[] temp = divide(v);
            strAdd(sb, temp[0], temp[1]);
        }else{
            sb.append('(');
            String[] temp = divide(v);
            strAdd(sb, temp[0], temp[1]);
            sb.append(')');
            sb.append(lastConv(u));
        }
    }

    private String lastConv(String str){
        String init = str.substring(1, str.length() - 1);

        StringBuilder sb = new StringBuilder();
        for(char c : init.toCharArray()){
            if(c == '(') sb.append(')');
            else sb.append('(');
        }

        return sb.toString();
    }

    private boolean checkPerfect(String u){
        Stack<Character> s = new Stack<>();
        char[] arr = u.toCharArray();

        for(int i = 0; i < arr.length; i++){
            if(s.isEmpty()) s.push(arr[i]);
            else{
                if(s.peek() == '(' && arr[i] == ')') s.pop();
                else s.push(arr[i]);
            }
        }

        if(s.isEmpty()) return true;
        return false;
    }


    private String[] divide(String str){
        String[] result = new String[2];
        char[] arr = str.toCharArray();
        String u = "";
        String v = "";
        int open = 0;
        int close = 0;
        int idx = 0;


        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '(') open++;
            else if(arr[i] == ')') close++;

            if((open != 0 && close != 0) && (open == close)){
                idx = i;
                break;
            }
        }

        if(idx < arr.length - 1){
            u = str.substring(0, idx+1);
            v = str.substring(idx+1, arr.length);
        }else {
            u = str;
        }

        result[0] = u;
        result[1] = v;

        return result;

    }
}
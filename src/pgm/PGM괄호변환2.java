package pgm;

import java.util.Stack;

class Solution {
    public String solution(String p) {
        String answer = "";

        if(isOk(p)) return p;

        answer = func(p);

        return answer;
    }


    private String func(String w){
        String result = "";

        String[] uv = getUv(w);

        String u = uv[0];
        String v = uv[1];

        if(isOk(u)){
            result += u;
            if(!v.equals("")) result += func(v);
        }else{
            String temp = "(";
            if(!v.equals("")) temp += func(v);
            temp += ")";
            temp += changeU(u);
            return temp;
        }

        return result;
    }

    private String changeU(String u){
        String temp = u.substring(1,u.length() - 1);

        StringBuilder sb = new StringBuilder();

        for(char c: temp.toCharArray()){
            if (c == '(') sb.append(")");
            else sb.append("(");
        }

        return sb.toString();
    }

    private String[] getUv(String w) {
        int left = 0;
        int right = 0;

        if(w.charAt(0) == '(') left++;
        else right++;

        char[] arr = w.toCharArray();
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == '(') left++;
            else right++;

            if(left == right) break;
        }

        String[] result = new String[2];
        result[0] = w.substring(0, left+right);
        result[1] = w.substring(left+right);

        return result;
    }

    // 올바른 문자열이면 true, 아니면 false
    private boolean isOk(String temp){
        Stack<Character> stack = new Stack<>();

        for(char c: temp.toCharArray()){
            if(stack.isEmpty()) stack.add(c);
            else{
                if(stack.peek() == '(' && c == ')') stack.pop();
                else stack.add(c);
            }
        }

        return stack.isEmpty();

    }
}
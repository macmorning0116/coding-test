package pgm;

import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];

        List<Cfile> list = new ArrayList<>();
        for(String file: files){
            list.add(getCfile(file));
        }

        list.sort((o1, o2) -> {
            int temp = o1.head.compareTo(o2.head);
            if(temp != 0) return temp;
            else{
                return o1.number - o2.number;
            }
        });

        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i).original;
        }
        return answer;

    }


    private Cfile getCfile(String file){
        String[] temp = getSegment(file);

        return new Cfile(temp[0], temp[1], Integer.parseInt(temp[2]));
    }

    private String[] getSegment(String file){
        String[] result = new String[3];

        String original = file;
        String head = "";
        String number = "";

        boolean flag = false;
        StringBuilder sb = new StringBuilder();

        file = file.toLowerCase();

        for(char c: file.toCharArray()){
            if(!flag &&
                    (('a' <= c && c <= 'z') ||
                            (c == ' ' || c == '.' || c == '-'))) sb.append(c);
            else if(!flag && '0' <= c && c <= '9'){
                flag = true;
                head = sb.toString();
                sb = new StringBuilder();
                sb.append(c);
            }else if(flag && '0' <= c && c <= '9'){
                sb.append(c);
            }else{
                number = sb.toString();
                break;
            }
        }

        if(flag && number.equals("")){
            number = sb.toString();
        }

        result[0] = original;
        result[1] = head;
        result[2] = number;

        return result;
    }

}

class Cfile {
    String original;
    String head;
    int number;

    public Cfile(String original, String head, int number){
        this.original = original;
        this.head = head;
        this.number = number;
    }

    public String toString(){
        return "[ " + head + ", " + number + " ]";
    }
}



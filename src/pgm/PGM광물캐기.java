package pgm;

import java.util.*;

class PGM광물캐기 {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        int sum = 0;
        for(int n: picks) sum += n;
        sum = sum * 5; // 최대 개수

        if(minerals.length < sum) sum = minerals.length;
        List<Node> list = new ArrayList<>();

        int dia = 0, ion = 0, sto = 0, cnt = 0;
        for(int i = 0; i < sum; i++){
            if(minerals[i].equals("diamond")) dia++;
            else if(minerals[i].equals("iron")) ion++;
            else sto++;
            cnt++;
            if(cnt == 5 || i == sum - 1){
                list.add(new Node(dia, ion, sto));
                cnt = 0;
                dia = 0;
                ion = 0;
                sto = 0;
            }

        }

        list.sort((a, b) -> {
            int d = b.dia - a.dia;
            int i = b.ion - a.ion;
            int s = b.sto - a.sto;

            if(d == 0){
                if(i != 0) return i;
                return s;
            }else{
                return d;
            }
        });

        for(int i = 0; i < list.size(); i++){
            Node now = list.get(i);
            if(picks[0] > 0){
                answer += (now.dia + now.ion + now.sto);
                picks[0] --;
            }else if(picks[1] > 0){
                answer += (now.dia * 5);
                answer += (now.ion + now.sto);
                picks[1]--;
            } else {
                answer += (now.dia * 25);
                answer += (now.ion * 5);
                answer += (now.sto);
                picks[2]--;
            }
        }

        return answer;
    }
    class Node {
        int dia;
        int ion;
        int sto;

        public Node(int dia, int ion, int sto){
            this.dia = dia;
            this.ion = ion;
            this.sto = sto;
        }

        public String toString(){
            return "[ dia :" + dia + " ion :" + ion + " sto :" + sto + " ]";
        }
    }

}



package pgm;

import java.util.*;

class PGM서버증설횟수 {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int nowServer = 0;
        Queue<Server> q = new LinkedList<>();

        for(int i = 0; i < players.length; i++){
            int nowTime = i;
            int people = players[i];
            int want = 0;

            while(true){
                if(!q.isEmpty()){
                    if(q.peek().endTime < nowTime){
                        nowServer -= q.poll().quantity;
                    }else{
                        break;
                    }
                }
                else break;
            }

            if(people > 0) want = operCount(people, m);
            else continue;

            if(want > nowServer){
                q.add(new Server(nowTime + k - 1, want - nowServer));
                answer += (want - nowServer);
                nowServer += (want - nowServer);
            }

        }
        return answer;
    }

    private int operCount(int people, int m){
        return people / m;
    }

    class Server{
        int endTime;
        int quantity;

        public Server(int endTime, int quantity){
            this.endTime = endTime;
            this.quantity = quantity;
        }
    }
}
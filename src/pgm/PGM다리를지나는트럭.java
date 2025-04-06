package pgm;

import java.util.*;

class PGM다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> ready = new LinkedList<>();
        for(int w : truck_weights){
            ready.add(w);
        }

        int time = 0;
        int sum = 0; // 현재 다리 위 무게
        int cnt = 0; // 현재 다리 위 차 대수

        ArrayDeque<Node> dq = new ArrayDeque<>();


        while(true){
            if(ready.isEmpty() && dq.isEmpty()){
                break;
            }

            time++;
            if(dq.isEmpty()){
                int wei = ready.poll();
                dq.addLast(new Node(wei, time));
                sum += wei;
                cnt += 1;
            }
            else{
                if(time - dq.peekFirst().t == bridge_length){
                    int wei = dq.pollFirst().w;
                    sum -= wei;
                    cnt -= 1;
                }
                if(!ready.isEmpty() && cnt < bridge_length && sum + ready.peek() <= weight){
                    int wei = ready.poll();
                    sum += wei;
                    cnt += 1;
                    dq.add(new Node(wei, time));
                }
            }


        }


        return time;
    }

    class Node {
        int w;
        int t;

        public Node(int w, int t){
            this.w = w;
            this.t = t;
        }
    }
}
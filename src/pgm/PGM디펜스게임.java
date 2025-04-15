package pgm;

import java.util.*;

class PGM디펜스게임 {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < k; i++){
            if(i < enemy.length) pq.add(enemy[i]);
            else break;
        }

        int idx = k;
        k = 0;

        if(idx >= enemy.length) return enemy.length;

        for(int i = idx; i < enemy.length; i++){
            if(!pq.isEmpty() && enemy[i] >= pq.peek() && n >= pq.peek()){
                n -= pq.poll();
                pq.add(enemy[i]);
                k++;
            }
            else{
                if(n < enemy[i]){
                    idx = i;
                    break;
                } else{
                    n -= enemy[i];
                }
            }
            if(i == enemy.length - 1) idx = enemy.length;

        }

        return idx;
    }
}

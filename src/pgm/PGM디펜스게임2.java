package pgm;

import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        if(enemy.length <= k) return enemy.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int e: enemy){
            if(k > 0){
                k--;
                pq.add(e);
            }else{
                if(pq.peek() < e){
                    if(n - pq.peek() >= 0){
                        n -= pq.poll();
                        pq.add(e);
                    }else{
                        break;
                    }
                }else{
                    if(n - e >= 0){
                        n -= e;
                    }else{
                        break;
                    }
                }
            }
            answer++;
        }

        return answer;
    }
}

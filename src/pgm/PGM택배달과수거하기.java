package pgm;

import java.util.*;

class PGM택배달과수거하기 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        Queue<Integer> dq = new LinkedList<>();
        Queue<Integer> pq = new LinkedList<>();

        int dCap = 0;
        int dIdx = n - 1;

        int pCap = 0;
        int pIdx = n - 1;


        while(dIdx >= 0){
            if(dCap == 0 && deliveries[dIdx] != 0){
                if(dCap + deliveries[dIdx] <= cap){
                    dCap += deliveries[dIdx];
                    deliveries[dIdx] = 0;
                    if(dCap == cap) dCap = 0;
                    dq.add(dIdx);
                    dIdx--;
                }else{
                    int temp = cap - dCap;
                    deliveries[dIdx] -= temp;
                    dCap = 0;
                    dq.add(dIdx);
                }
            }
            else if(dCap != 0 && deliveries[dIdx] != 0){
                if(dCap + deliveries[dIdx] <= cap){
                    dCap += deliveries[dIdx];
                    deliveries[dIdx] = 0;
                    if(dCap == cap) dCap = 0;
                    dIdx--;
                }else{
                    int temp = cap - dCap;
                    deliveries[dIdx] -= temp;
                    dCap = 0;
                }
            }else{
                dIdx--;
            }
        }


        while(pIdx >= 0){
            if(pCap == 0 && pickups[pIdx] != 0){
                if(pCap + pickups[pIdx] <= cap){
                    pCap += pickups[pIdx];
                    pickups[pIdx] = 0;
                    if(pCap == cap) pCap = 0;
                    pq.add(pIdx);
                    pIdx--;
                }else{
                    int temp = cap - pCap;
                    pickups[pIdx] -= temp;
                    pCap = 0;
                    pq.add(pIdx);
                }
            }
            else if(pCap != 0 && pickups[pIdx] != 0){
                if(pCap + pickups[pIdx] <= cap){
                    pCap += pickups[pIdx];
                    pickups[pIdx] = 0;
                    if(pCap == cap) pCap = 0;
                    pIdx--;
                }else{
                    int temp = cap - pCap;
                    pickups[pIdx] -= temp;
                    pCap = 0;
                }
            }else{
                pIdx--;
            }
        }


        while(!dq.isEmpty() || !pq.isEmpty()){
            if(!dq.isEmpty() && !pq.isEmpty()){
                int dmax = dq.poll();
                int pmax = pq.poll();

                if(dmax >= pmax) answer += (2 * (dmax + 1));
                else answer += (2 * (pmax + 1));

            }else{
                if(!dq.isEmpty()) answer += (2 * (dq.poll() + 1));
                else answer += (2 * (pq.poll() + 1));
            }
        }

        return answer;
    }

}

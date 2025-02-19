package boj;

import java.io.*;
import java.util.*;

public class BOJ1744 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long answer = 0;
        List<Integer> pL = new ArrayList<>();
        List<Integer> mL = new ArrayList<>();
        Stack<Integer> zS = new Stack<>();

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num > 0) pL.add(num);
            else if (num == 0) zS.add(num);
            else mL.add(num);
        }

        Collections.sort(mL);
        Collections.sort(pL, Collections.reverseOrder());
        boolean[] pV = new boolean[pL.size()];
        boolean[] mV = new boolean[mL.size()];

        for(int i = 0; i < pL.size(); i++){
            if(!pV[i] && i < pL.size() - 1){
                long now = pL.get(i);
                long next = pL.get(i+1);
                pV[i] = true;
                pV[i+1] = true;
                if(now != 1 && next != 1) answer += (now * next);
                else answer += (now + next);
            }else if(!pV[i] && i == pL.size() - 1) {
                answer += pL.get(i);
            }
        }

        for(int i = 0; i < mL.size(); i++){
            if(!mV[i] && i < mL.size() - 1){
                long now = mL.get(i);
                long next = mL.get(i+1);
                mV[i] = true;
                mV[i+1] = true;
                answer += (now * next);
            }else if(!mV[i] && i == mL.size() - 1){
                if(!zS.isEmpty()){
                    zS.pop();
                }else{
                    answer += mL.get(i);
                }
            }
        }

        System.out.println(answer);

    }
}

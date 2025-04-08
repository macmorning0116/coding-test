package pgm;

import java.util.*;

class PGM시소짝꿍 {
    Map<Integer, Integer> map = new HashMap<>();
    public long solution(int[] weights) {
        long same = 0;
        long sum = 0;

        for(int num: weights){
            if(map.containsKey(num)) map.put(num, map.get(num) + 1);
            else map.put(num, 1);
        }

        for(int key: map.keySet()){
            if(map.get(key) >= 2){
                same += samePlus(map.get(key));  // 같은 몸무게 처리
            }
            List<Integer> temp = sumList(key);
            for(int num: temp){
                if(map.containsKey(num)) sum += (long) map.get(key) * (long) map.get(num);
            }
        }

        // System.out.println(map.toString());
//        System.out.println(same);
//        System.out.println(sum);



        long answer = same + (sum / 2);
        return answer;
    }

    private List<Integer> sumList(int num){
        int[] muls = new int[] {2,3,4};
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < muls.length; i++){
            for(int j = 0; j < muls.length; j++){
                if((num * muls[i]) % muls[j] == 0){
                    int temp = (num * muls[i]) / muls[j];
                    if(num != temp) list.add(temp);
                }
            }
        }

        return list;
    }

    private long samePlus(int num){
        return (((long) num) * ((long) (num - 1))) / 2;
    }
}

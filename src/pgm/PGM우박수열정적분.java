package pgm;

import java.util.*;

class PGM우박수열정적분 {
    List<Integer> list;
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];

        list = new ArrayList<>();

        while(k > 1){
            list.add(k);
            if(k % 2 == 0) k /= 2;
            else k = (3 * k) + 1;
        }

        list.add(1);

        double[] sum = new double[list.size()];

        for(int i = 1; i < list.size(); i++){
            sum[i] = sum[i-1] + getArea(i-1, i);
        }

        for(int i = 0; i < ranges.length; i++){
            int start = ranges[i][0];
            int end = ranges[i][1];

            if(start >= 0 && start < list.size() && sum.length - 1 + end >= 0 && sum.length - 1 + end < list.size()){
                double temp = sum[sum.length - 1 + end] - sum[start];
                if(temp >= 0) answer[i] = temp;
                else answer[i] = -1.0;
            }else {
                answer[i] = -1.0;
            }

        }

        return answer;
    }

    private double getArea(int a, int b){
        return (double) (list.get(a) + list.get(b)) / 2;
    }
}

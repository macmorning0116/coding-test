package pgm;

class PGM퍼즐게임챌린지 {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;

        int min = 1;
        int max = 0;
        int mid = 0;

        for(int i = 0; i < diffs.length; i++){
            if (diffs[i] > max) max = diffs[i];
        }

        while(min <= max){
            mid = (min + max) / 2;

            if(getSum(diffs, times, mid) <= limit){
                max = mid  - 1;
            } else {
                min = mid + 1;
            }

        }

        return min;
    }

    private long getSum(int[] diffs, int[] times, int mid){
        long result = times[0];

        for(int i = 1; i < diffs.length; i++){
            if(diffs[i] <= mid) result += times[i];
            else {
                result += (long) (times[i - 1] + times[i]) * (diffs[i] - mid);
                result += times[i];
            }
        }

        return result;
    }
}

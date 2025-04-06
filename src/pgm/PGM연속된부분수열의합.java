package pgm;

class PGM연속된부분수열의합 {
    public int[] solution(int[] sequence, int k) {
        int sIdx = 0;
        int eIdx = 0;

        int start = 0;
        int end = 0;
        long len = sequence.length;

        long sum = 0;

        sum += sequence[start];

        while(end < sequence.length){
            if(sum == k){
                if(len > end - start){
                    sIdx = start;
                    eIdx = end;
                    len = end - start;
                }
                if(end + 1 < sequence.length){
                    end++;
                    sum += sequence[end];
                }else{
                    end++;
                }
            }else if(sum > k){
                sum -= sequence[start];
                start++;
            }else if(sum < k){
                if(end + 1 < sequence.length){
                    end++;
                    sum += sequence[end];
                }else{
                    end++;
                }
            }
        }

        return new int[]{sIdx, eIdx};
    }
}
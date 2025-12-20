package pgm;

class Solution {
    public int solution(int storey) {
        int answer = 0;

        int now = storey;

        while(now > 0){
            if(now < 10){
                if(now <= 5){
                    answer += now;
                    now = 0;
                }
                else{
                    answer += (10 - now);
                    now = 10;
                }
            }else{
                int one = now % 10;
                int ten = (now / 10) % 10;

                if(one < 5){
                    answer += one;
                    now -= one;
                }
                else if (one == 5){
                    if(ten >= 5) {
                        answer += 5;
                        now += 5;
                    }else {
                        answer += 5;
                        now -= 5;
                    }
                }else{
                    answer += (10 - one);
                    now += (10 - one);
                }

                now /= 10;
            }
        }


        return answer;
    }
}
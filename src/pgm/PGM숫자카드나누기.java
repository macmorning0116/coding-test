package pgm;

class PGM숫자카드나누기 {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        if(arrayA.length == 1){
            int a = arrayA[0];
            for(int i = a; i >= 2; i--){
                boolean flag = false;
                if(a % i == 0){
                    for(int j = 0; j < arrayB.length; j++){
                        if(arrayB[j] % i == 0){
                            flag = true;
                            break;
                        }
                    }
                }
                if(!flag && answer < i) answer = i;
            }
        }

        if(arrayB.length == 1){
            int b = arrayB[0];
            for(int i = b; i >= 2; i--){
                boolean flag = false;
                if(b % i == 0){
                    for(int j = 0; j < arrayA.length; j++){
                        if(arrayA[j] % i == 0){
                            flag = true;
                            break;
                        }
                    }
                }
                if(!flag && answer < i) answer = i;
            }
        }

        if(arrayA.length != 1 && arrayB.length != 1){
            int aGcd = gcd(arrayA[0], arrayA[1]);
            int bGcd = gcd(arrayB[0], arrayB[1]);

            if(arrayA.length > 2){
                for(int i = 1; i < arrayA.length; i++){
                    aGcd = gcd(arrayA[i], aGcd);
                }
            }

            if(arrayB.length > 2){
                for(int i = 1; i < arrayB.length; i++){
                    bGcd = gcd(arrayB[i], bGcd);
                }
            }

            boolean aFlag = false;
            boolean bFlag = false;


            for(int i = 0; i < arrayB.length; i++){
                if(arrayB[i] % aGcd == 0){
                    aFlag = true;
                    break;
                }
            }

            for(int i = 0; i < arrayA.length; i++){
                if(arrayA[i] % bGcd == 0){
                    bFlag = true;
                    break;
                }
            }

            if(!aFlag && answer < aGcd) answer = aGcd;
            if(!bFlag && answer < bGcd) answer = bGcd;
        }


        return answer;
    }

    private int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}

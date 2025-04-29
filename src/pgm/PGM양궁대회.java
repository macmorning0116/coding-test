package pgm;

class PGM양궁대회 {
    int[] answer;
    public int[] solution(int n, int[] info) {
        answer = new int[11];

        dfs(n, 0, new int[11], info, 0);


        if(zeroAns()){
            int[] result = {-1};
            return result;
        };
        return answer;
    }

    private boolean zeroAns(){
        boolean flag = true;

        for(int i = 0; i < answer.length; i++){
            if (answer[i] != 0) {
                flag = false;
                break;
            }
        }

        return flag;
    }


    private void dfs(int n, int cnt, int[] arr, int[] info, int k){
        if(cnt == n){
            // 어피치를 이겼는지 검사하기
            if(getScoreGap(info, arr) > 0){
                // 여기서 기존의 정답 배열과 비교해서 정답 배열 업데이트
                int[] temp = getCopyArr(arr);
                updateAnswer(info, temp);
            }
            return;
        }


        for(int i = k; i < 11; i++){
            arr[i]++;
            dfs(n, cnt+1, arr, info, i);
            arr[i]--;
        }
    }

    // 정답 업데이트 메서드
    private void updateAnswer(int[] info, int[] newArr){
        int beforeGap = 0;
        int nowGap = 0;

        beforeGap = getScoreGap(info, answer);
        nowGap = getScoreGap(info, newArr);


        if(beforeGap < nowGap) {
            answer = newArr;
            return;
        }

        else if(beforeGap == nowGap){
            boolean flag = false;

            for(int i = 10; i >=0; i--){
                if(newArr[i] > answer[i]) break;
                if(newArr[i] < answer[i]){
                    flag = true;
                    break;
                }
            }

            if(!flag) answer = newArr;
        }

    }

    // 정답 업데이트 용 배열 복사
    private int[] getCopyArr(int[] arr){
        int[] newArr = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            newArr[i] = arr[i];
        }
        return newArr;
    }

    // 0보다 크면 라이언이 이긴것
    private int getScoreGap(int[] apache, int[] lion){
        int aScore = 0;
        int lScore = 0;

        for(int i = 0; i < apache.length; i++){
            if(apache[i] == 0 && lion[i] == 0) continue;

            if(apache[i] >= lion[i]) aScore += (10 - i);
            else lScore += (10 - i);
        }

        return lScore - aScore;
    }
}

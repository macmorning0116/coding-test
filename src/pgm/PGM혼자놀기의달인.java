package pgm;

import java.util.HashMap;

class PGM혼자놀기의달인 {
    int firstGroup = 0;
    int secondGroup = 0;
    public int solution(int[] cards) {
        int answer = 0;

        for(int i = 0; i < cards.length; i++){
            boolean[] temp = new boolean[cards.length];
            firstGroup = getGroupCount(i, temp, cards);
            for(int j = i; j < cards.length; j++){
                if(!temp[j]){
                    secondGroup = getGroupCount(j, temp, cards);
                    if(answer < firstGroup * secondGroup) answer = firstGroup * secondGroup;
                }

            }
        }

        HashMap

        return answer;
    }

    private int getGroupCount(int idx, boolean[] visited, int[] cards){
        int next = cards[idx] - 1; // 다음에 뽑아야 하는것
        visited[idx] = true; // 방문함
        int cnt = 1; // 현재 선택된거 개수

        while(true){
            if(visited[next]) break;

            visited[next] = true;
            next = cards[next] - 1;
            cnt++;
        }

        return cnt;
    }
}

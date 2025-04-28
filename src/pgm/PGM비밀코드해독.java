package pgm;

import java.util.*;

class PGM비밀코드해독 {
    List<List<Integer>> combList;
    boolean[] visited;
    public int solution(int n, int[][] q, int[] ans) {

        int answer = 0;
        getCombList(n);

        for(int i = 0 ; i < combList.size(); i++){
            if(isOkay(combList.get(i), q, ans)){
                answer++;
            }
        }

        return answer;
    }

    private boolean isOkay(List<Integer> target, int[][] q, int[] ans){
        for(int i = 0; i < q.length; i++){
            int answer = ans[i];
            int temp = 0;

            for(int num: target){
                for(int j = 0; j < q[0].length; j++){
                    if(q[i][j] == num) temp++;
                }
            }

            if(temp != answer) return false;
        }

        return true;
    }


    private void getCombList(int n){
        combList = new ArrayList<>();
        visited = new boolean[n+1];
        List<Integer> temp = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            visited[i] = true;
            temp.add(i);
            dfs(n, 1, temp, i);
            temp.remove(temp.size() - 1);
            visited[i] = false;

        }

    }

    private void dfs(int n, int cnt, List<Integer> temp, int e){
        if(cnt == 5){
            combList.add(new ArrayList<>(temp));
            return;
        }

        for(int i = e; i <= n; i++){
            if(!visited[i]){
                temp.add(i);
                visited[i] = true;
                dfs(n, cnt + 1, temp, i);
                temp.remove(temp.size() - 1);
                visited[i] = false;
            }
        }
    }
}

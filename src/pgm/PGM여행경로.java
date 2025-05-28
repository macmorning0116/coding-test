package pgm;

import java.util.*;

class PGM여행경로 {
    List<String> answer;
    boolean[] visited;
    public String[] solution(String[][] tickets) {
        answer = new ArrayList<>();
        visited = new boolean[tickets.length];

        List<String> init = new ArrayList<>();
        init.add("ICN");
        dfs(tickets, "ICN", init, tickets.length + 1);

        String[] result = new String[answer.size()];
        for(int i = 0; i < answer.size(); i++){
            result[i] = answer.get(i);
        }

        return result;
    }

    private void dfs(String[][] tickets, String next, List<String> temp, int len){
        if(temp.size() == len){

            if(checkMin(temp)){
                answer = new ArrayList<>(temp);
            }
            return;
        }

        for(int i = 0; i < tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(next)){
                visited[i] = true;
                temp.add(tickets[i][1]);
                dfs(tickets, tickets[i][1], temp, len);
                temp.remove(temp.size() - 1);
                visited[i] = false;
            }
        }
    }


    private boolean checkMin(List<String> target){
        if(answer.isEmpty()) return true;

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for(int i = 0; i < target.size(); i++){
            sb1.append(answer.get(i));
            sb2.append(target.get(i));
        }

        int tmp = sb2.toString().compareTo(sb1.toString());
        if(tmp < 0) return true;
        return false;
    }


}




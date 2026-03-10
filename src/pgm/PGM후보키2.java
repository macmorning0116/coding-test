package pgm;

import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int answer = 0;
        Set<List<Integer>> candidateSet = new HashSet<>();   // 현재 후보키
        List<List<Integer>> culList = new ArrayList<>();     // 가능한 칼럼 조합 수
        getCulList(culList, relation[0].length);             // 칼럼 조합 수 얻는 메서드

        for(List<Integer> cul: culList){
            if(!cul.isEmpty() && isNotCotainCandidate(candidateSet, cul)
                    && checkCandidate(cul, relation)){
                candidateSet.add(cul);
            }
        }
        return candidateSet.size();
    }

    // 칼럼 조합을 보고 후보키인지 확인 맞으면 true
    private boolean checkCandidate(List<Integer> cul, String[][] relation) {
        boolean result = true;
        int rowLen = relation.length;
        Set<String> set = new HashSet<>();

        for(int i = 0; i < relation.length; i++){
            String temp = "";
            String[] rel = relation[i];

            for(int idx: cul){
                temp += rel[idx - 1];
            }
            set.add(temp);
        }

        if(set.size() == rowLen) return true;
        return false;
    }


    // 현재 후보키를 포함하지 않으면 true
    private boolean isNotCotainCandidate(Set<List<Integer>> set, List<Integer> target){
        boolean result = true;

        for(List<Integer> candidate: set){
            if(target.containsAll(candidate)){
                result = false;
                break;
            }
        }

        return result;
    }

    private void getCulList(List<List<Integer>> culList, int colLen) {
        dfs(0, colLen, new ArrayList<>(), culList);

    }

    private void dfs(int n, int end, List<Integer> temp, List<List<Integer>> list){
        if (n == end){
            list.add(new ArrayList<>(temp));
            return;
        }
        dfs(n + 1, end, temp, list);

        temp.add(n+1);
        dfs(n + 1, end, temp, list);
        temp.remove(temp.size() - 1);
    }

}
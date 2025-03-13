package boj;

import java.util.*;
import java.io.*;

public class BOJ1722 {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        if(arr[0] == 1){
            int[] temp = findArr(arr[1]);
            for(int num: temp){
                sb.append(num).append(" ");
            }
            System.out.println(sb);
        }else{
            int[] temp = new int[N];
            for(int i = 0; i < temp.length; i++){
                temp[i] = (int) arr[i+1];
            }

            System.out.println(findOrder(temp));
        }

    }
    static int[] findArr(long num){
        long order = 1;
        int last = N;
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[N+1];

        while(list.size() < N ){
            int temp = last;
            for(int i = visited.length - 1 ; i >= 1; i--){
                if(!visited[i] && num >= order + findSection(last - 1) * (temp - 1)){
                    visited[i] = true;
                    order = order + findSection(last - 1) * (temp - 1);
                    last--;
                    list.add(i);
                    break;
                }else if(!visited[i]){
                    temp--;
                }
            }

        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    static long findOrder(int[] arr){
        boolean[] visited = new boolean[N+1];
        long order = 1;

        for(int num: arr){
            int rank = 0;
            for(int i = 1; i < visited.length; i++){
                if(!visited[i]) rank++;
                if(i == num){
                    visited[i] = true;
                    break;
                }
            }

            N--;
            long section = findSection(N);
            order = order + (section * (rank - 1));
        }
        return order;

    }


    static long findSection(int n){
        long section = 1;
        while(n > 0){
            section *= n;
            n--;
        }

        return section;
    }
}

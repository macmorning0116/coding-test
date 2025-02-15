package boj;

import java.util.*;
import java.io.*;

public class BOJ1377 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        Map<Integer, Queue<Integer>> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            arr[i] = num;
            if(map.containsKey(num)){
                map.get(num).add(i);
            }else{
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                map.put(num, q);
            }
        }

        Arrays.sort(arr);

        int max = 0;
        for(int i = 0; i < arr.length; i++){
            int gap = map.get(arr[i]).poll() - i;
            if(max < gap) max = gap;
        }

        System.out.println(max+1);

    }
}

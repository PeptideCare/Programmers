package com.programmers;

import java.util.*;

public class 순위검색 {

    public static void main(String[] args) {

        순위검색_Solution solution = new 순위검색_Solution();

        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        int[] solution1 = solution.solution(info, query);

        for (int i : solution1) {
            System.out.println(i);
        }

    }

}

class 순위검색_Solution {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static Map<String, List<Integer>> map = new HashMap<>();
    static int[] answer;

    public int[] solution(String[] info, String[] query) {

        answer = new int[query.length];

        for (int i=0; i<info.length; i++) {
            dfs("",0,info[i].split(" "));
        }

        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> value = entry.getValue();
            Collections.sort(value);
        }

        for (int i=0; i< query.length; i++) {
            String s = "";
            query[i] = query[i].replaceAll(" and ", " ");
            String[] arr = query[i].split(" ");

            for (int j=0; j<arr.length-1; j++) {
                s+=arr[j];
            }
            answer[i] = count(s, Integer.parseInt(arr[arr.length-1]));
        }
        return answer;
    }

    public int count(String s, int score) {
        if (!map.containsKey(s)) return 0;

        List<Integer> list = map.get(s);
        int start = 0;
        int end = list.size()-1;

        while (start<=end) {
            int mid = (start+end)/2;
            if (list.get(mid)<score) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return list.size()-start;
    }

    public void dfs(String s, int depth, String[] info) {

        if (depth == 4) {
            if (!map.containsKey(s)) {
                List<Integer> list = new ArrayList<>();
                list.add(Integer.parseInt(info[4]));
                map.put(s, list);
            } else {
                map.get(s).add(Integer.parseInt(info[4]));
            }
            return;
        }

        dfs(s+"-", depth+1, info);
        dfs(s+info[depth], depth+1, info);

    }
}
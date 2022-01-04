package com.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 후보키 {

    public static void main(String[] args) {

        후보키_Solution solution = new 후보키_Solution();
        String [][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};

        int solution1 = solution.solution(relation);
        System.out.println(solution1);
    }

}

class 후보키_Solution {

    static boolean[] visited;
    static List<String> candidate = new ArrayList<>();

    public int solution(String[][] relation) {

        int answer = 0;
        for (int i=0; i<relation[0].length; i++) {
            visited = new boolean[relation[0].length];
            dfs(0,i+1,0, relation);
        }
        answer = candidate.size();
        return answer;
    }

    public void dfs(int start, int end, int depth, String[][] relation) {

        if (depth == end) {
            List<Integer> list = new ArrayList<>();
            String key = "";
            for (int i=0; i< visited.length; i++) {
                if (visited[i]) {
                    key += String.valueOf(i);
                    list.add(i);
                }
            }

            Map<String, Integer> map = new HashMap<>();

            for (int i=0; i< relation.length; i++) {
                String s = "";

                for (Integer integer : list) {
                    s += relation[i][integer];
                }

                if (map.containsKey(s)) return;
                else {
                    map.put(s, 0);
                }
            }

            for (String s : candidate) {
                int count = 0;
                for (int i=0; i<key.length(); i++) {
                    String subs = String.valueOf(key.charAt(i));
                    if (s.contains(subs)) count++;
                }
                if (count == s.length()) return;
            }
            candidate.add(key);
            return;
        }

        for (int i=start; i<visited.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(i, end,depth+1, relation);
            visited[i] = false;
        }

    }
}
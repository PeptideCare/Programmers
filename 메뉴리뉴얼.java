package com.programmers;

import java.util.*;

public class 메뉴리뉴얼 {

    public static void main(String[] args) {
        메뉴리뉴얼_Solution solution = new 메뉴리뉴얼_Solution();
        String s[] = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int [] i = {2,3,4};
        ArrayList<String> solution1 = solution.solution(s, i);
        for (String s1 : solution1) {
            System.out.println(s1);
        }
    }

}

class 메뉴리뉴얼_Solution {

    static Map<String, Integer> map;
    static StringBuilder sb = new StringBuilder();

    public static void combi(String s, int index, int count, int n){
        if (count == n) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0)+1);
            return;
        }

        for (int i = index; i<s.length(); i++) {
            sb.append(s.charAt(i));
            combi(s,i+1, count+1, n);
            sb.delete(count, count+1);
        }
    }

    public ArrayList<String> solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();

        for (int i=0; i< orders.length; i++) {
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            orders[i] = String.valueOf(charArr);
        }

        for (int i=0; i< course.length; i++) {
            map = new HashMap<>();
            int max = Integer.MIN_VALUE;

            for (int j=0; j< orders.length; j++) {
                StringBuilder sb = new StringBuilder();

                if (course[i]<=orders[j].length()) {
                    combi(orders[j],0,0,course[i]);
                }
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                max = Math.max(max, entry.getValue());
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (max >=2 && entry.getValue() == max) {
                    answer.add(entry.getKey());
                }
            }
        }
        Collections.sort(answer);

        return answer;
    }

}

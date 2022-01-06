package com.programmers;

import java.util.Arrays;
import java.util.Comparator;

public class 파일명정렬 {

    public static void main(String[] args) {
        파일명정렬_Solution solution = new 파일명정렬_Solution();

        String[] s = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};

        String[] solution1 = solution.solution(s);
        for (String s1 : solution1) {
            System.out.println(s1);
        }
    }

}

class 파일명정렬_Solution {
    public String[] solution(String[] files) {

        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

               String o1head = o1.split("[0-9]")[0];
               String o2head = o2.split("[0-9]")[0];

               int result = o1head.toLowerCase().compareTo(o2head.toLowerCase());

               if (result == 0) {
                   result = toInt(o1, o1head.length()) - toInt(o2, o2head.length());
               }
               return result;
            }
        });

        return files;
    }

    public int toInt(String s, int length) {

        s = s.substring(length);
        String result = "";

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c) && result.length() < 5) {
                result += c;
            } else {
                break;
            }
        }

        return Integer.parseInt(result);

    }
}
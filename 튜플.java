package com.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 튜플 {

    public static void main(String[] args) {

        튜플_Solution solution = new 튜플_Solution();

        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";

        int[] ints = solution.solution(s);

        for (int val : ints) {
            System.out.println(val);
        }

    }

}

class 튜플_Solution {
    public int[] solution(String s) {

        ArrayList<ArrayList> list = split(s);
        ArrayList<Integer> answer = new ArrayList<>();

        Collections.sort(list, new Comparator<ArrayList>() {
            @Override
            public int compare(ArrayList o1, ArrayList o2) {
                return o1.size() - o2.size();
            }
        });

        for (int i=0; i<list.size(); i++) {
            for (int j=0; j<list.get(i).size(); j++) {

                int num = (int)list.get(i).get(j);

                if (!answer.contains(num)) {
                    answer.add(num);
                }

            }
        }

        int [] arr = new int[answer.size()];

        for (int i=0; i<answer.size(); i++) {
            arr[i] = answer.get(i);
        }

        return arr;

    }

    public ArrayList<ArrayList> split(String s) {

        ArrayList<ArrayList> bigList = new ArrayList<>();
        s = s.substring(1, s.length()-1);

        for (int i=0; i<s.length(); i++) {

            char c = s.charAt(i);
            if (c == '{') {
                int startIndex = i+1;
                int count = 0;
                ArrayList<Integer> smallList = new ArrayList<>();

                while (true) {
                    i++;
                    count++;
                    c = s.charAt(i);
                    if (c == '}') {
                        int num = Integer.parseInt(s.substring(startIndex, startIndex + count-1));
                        smallList.add(num);
                        break;
                    }
                    if (c == ',') {
                        int num = Integer.parseInt(s.substring(startIndex, startIndex + count-1));
                        count = 0;
                        startIndex = i+1;
                        smallList.add(num);
                    }
                }
                bigList.add(smallList);
            }
        }
        return bigList;
    }
}

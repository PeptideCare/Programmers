package com.programmers;

import java.util.ArrayList;

public class 압축 {

    public static void main(String[] args) {
        압축_Solution solution = new 압축_Solution();

        String s = "KAKAO";

        int[] ints = solution.solution(s);

        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

}
class 압축_Solution {

    public int[] solution(String msg) {

        ArrayList<String> list = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();

        // 0~25까지 알파벳
        for (int i=65; i<=90; i++) {
            list.add(String.valueOf((char)i));
        }

        for (int i=0; i<msg.length(); i++) {
            StringBuilder sb = new StringBuilder();

            while (true) {
                sb.append(msg.charAt(i));
                if (i == msg.length()-1) {

                    if (!list.contains(sb.toString())) {
                        sb = sb.deleteCharAt(sb.length() - 1);
                        answer.add(list.indexOf(sb.toString())+1);

                        answer.add(list.indexOf(String.valueOf(msg.charAt(msg.length()-1)))+1);
                    } else {
                        answer.add(list.indexOf(sb.toString())+1);
                    }
                    break;
                }
                i++;
                if (!list.contains(sb.toString())) {
                    list.add(sb.toString());
                    sb = sb.deleteCharAt(sb.length() - 1);
                    answer.add(list.indexOf(sb.toString())+1);
                    i-=2;
                    break;
                }
            }

        }
        int[] arr = new int[answer.size()];

        for (int i=0; i< answer.size(); i++) {
            arr[i] = answer.get(i);
        }
        return arr;
    }

}
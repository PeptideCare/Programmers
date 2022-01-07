package com.programmers;

import java.util.ArrayList;

public class n진수게임 {

    public static void main(String[] args) {
        n진수게임_Solution solution = new n진수게임_Solution();
        int n = 16;
        int t = 16;
        int m = 2;
        int p = 1;

        System.out.println(solution.solution(n, t, m, p));
    }

}

class n진수게임_Solution {
    static ArrayList<String> list = new ArrayList<>();
    public String solution(int n, int t, int m, int p) {

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<2*t; i++) {
            sb.append(convert(i, n));
        }

        for (int i=p-1; ; i+=m) {
            list.add(String.valueOf(sb.toString().charAt(i)));
            if (list.size() == t) break;
        }

        StringBuilder answer = new StringBuilder();
        for (String s : list) {
            answer.append(s);
        }
        return answer.toString();
    }

    public String convert(int num, int n) {

        if (num == 0) return "0";

        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            if (num % n < 10) {
                sb.append(num%n);
            } else {
                sb.append((char)(num%n - 10 + 'A'));
            }
            num /= n;
        }
        return sb.reverse().toString();
    }
}
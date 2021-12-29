package com.programmers;

public class 괄호변환 {

    public static void main(String[] args) {
        괄호변환_Solution solution = new 괄호변환_Solution();
        String p = "()))((()";
        System.out.println(solution.solution(p));
    }

}

class 괄호변환_Solution {
    public String solution(String p) {

        if (check(p)) return p;
        return divide(p);
    }

    public static boolean check(String s) {
        int open = 0;
        int close = 0;

        if (s.charAt(0) == ')') return false;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') open++;
            else close++;

            if (open<close) return false;
        }
        return true;
    }

    public static String divide(String s) {

        if (s.length() == 0) return "";

        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();

        int open = 0;
        int close = 0;

        for (int i=0; i<s.length(); i++) {

            if (s.charAt(i) == '(') open++;
            else close++;

            if (open == close) {
                u.append(s.substring(0, i+1));
                v.append(s.substring(i+1));

                if (check(u.toString())) {
                    u.append(divide(v.toString()));
                }
                else {
                    StringBuilder temp = new StringBuilder();
                    temp.append('(');
                    temp.append(divide(v.toString()));
                    temp.append(')');
                    u.deleteCharAt(0);
                    u.deleteCharAt(u.length()-1);
                    temp.append(reverse(u.toString()));
                    return temp.toString();
                }
                break;
            }
        }
        return u.toString();
    }

    public static String reverse(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                sb.append(')');
            }
            else {
                sb.append('(');
            }
        }

        return sb.toString();
    }

}
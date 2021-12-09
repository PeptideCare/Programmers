package com.programmers;

public class 문자열압축 {

    public static void main(String[] args) {
        문자열압축_Solution solution = new 문자열압축_Solution();

        String s = "ababcdcdababcdcd";

        System.out.println(solution.solution(s));
    }

}

class 문자열압축_Solution {
    public int solution(String s) {

        int answer = s.length();

        for (int i=1; i<s.length(); i++) {
            String prev = s.substring(0, i);
            int count = 1;
            String enc = "";
            String last = "";
            for (int j=i; j<s.length(); j+=i) {
                if (i+j > s.length()) {
                    last = s.substring(j);
                    continue;
                }
                if (prev.equals(s.substring(j, j+i))) {
                    count++;
                } else {
                    enc += prev;
                    if (count != 1) {
                        enc = count + enc;
                    }
                    prev = s.substring(j, j+i);
                    count = 1;
                }
            }

            enc += prev + last;
            if (count != 1) {
                enc = count + enc;
            }

            answer = Math.min(answer, enc.length());
        }
        return answer;
    }
}

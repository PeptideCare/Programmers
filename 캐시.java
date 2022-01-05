package com.programmers;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;

public class 캐시 {

    public static void main(String[] args) {
        캐시_Solution solution = new 캐시_Solution();

        int cacheSize = 5;
        String[] cities = {"seoul", "seoul", "seoul"};

        int solution1 = solution.solution(cacheSize, cities);
        System.out.println(solution1);
    }

}

class 캐시_Solution {
    public int solution(int cacheSize, String[] cities) {

        if (cacheSize == 0) return cities.length*5;

        Queue<String> q = new LinkedList<>();
        int answer = 0;

        for (int i=0; i< cities.length; i++) {
            String city = cities[i].toUpperCase(Locale.ROOT);
            if (q.contains(city)) {
                q.remove(city);
                q.offer(city);
                answer+=1;
            }
            else {
                if (q.size() == cacheSize) {
                    q.poll();
                }
                q.offer(city);
                answer+=5;
            }
        }
        return answer;

    }
}

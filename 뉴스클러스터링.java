package com.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class 뉴스클러스터링 {

    public static void main(String[] args) {

        뉴스클러스터링_Solution solution = new 뉴스클러스터링_Solution();
        String str1 = "aa1+aa2";
        String str2 = "AAAA12";
        System.out.println(solution.solution(str1, str2));

    }

}

class 뉴스클러스터링_Solution {

    public int solution(String str1, String str2) {

        str1 = str1.toUpperCase(Locale.ROOT);
        str2 = str2.toUpperCase(Locale.ROOT);

        ArrayList<String> str1List = divide(str1);
        ArrayList<String> str2List = divide(str2);

        Map<String, Integer> str1Map = new HashMap<>();
        Map<String, Integer> str2Map = new HashMap<>();


        for (int i=0; i<str1List.size(); i++) {
            str1Map.put(str1List.get(i), str1Map.getOrDefault(str1List.get(i), 0) + 1);
        }

        for (int i=0; i<str2List.size(); i++) {
            str2Map.put(str2List.get(i), str2Map.getOrDefault(str2List.get(i), 0) + 1);
        }

        int intersection = intersection(str1Map, str2Map);
        int union = union(str1Map, str2Map);

        int answer = (int)((double)intersection/union*65536);
        return answer;
    }

    public ArrayList<String> divide(String s) {

        ArrayList<String> list = new ArrayList<>();

        for (int i=0; i<s.length()-1; i++) {

            String two = s.substring(i, i+2);

            if (two.charAt(0) < 65 || two.charAt(0) > 90
                    || two.charAt(1) < 65 || two.charAt(0) > 90) continue;

            list.add(two);
        }
        return list;
    }

    public int intersection(Map<String, Integer> map1, Map<String, Integer> map2) {

        int count = 0;

        if (map1.size() <= map2.size()) {

            for (Map.Entry<String, Integer> entry1 : map1.entrySet()) {

                String key1 = entry1.getKey();

                for (Map.Entry<String, Integer> entry2 : map2.entrySet()) {
                    String key2 = entry2.getKey();

                    if (key1.equals(key2)) {
                        count = count + Math.min(map1.get(key1), map2.get(key2));
                        break;
                    }

                }

            }

        } else {
            for (Map.Entry<String, Integer> entry2 : map2.entrySet()) {

                String key2 = entry2.getKey();

                for (Map.Entry<String, Integer> entry1 : map1.entrySet()) {
                    String key1 = entry1.getKey();

                    if (key2.equals(key1)) {
                        count = count + Math.min(map1.get(key1), map2.get(key2));
                    }

                }

            }
        }

        return count;

    }

    public int union(Map<String, Integer> map1, Map<String, Integer> map2) {

        Map<String, Integer> keyMap = new HashMap<>();

        for (Map.Entry<String, Integer> entry1 : map1.entrySet()) {
            keyMap.put(entry1.getKey(), 0);
        }

        for (Map.Entry<String, Integer> entry2 : map2.entrySet()) {
            keyMap.put(entry2.getKey(), 0);
        }

        for (Map.Entry<String, Integer> entryKey : keyMap.entrySet()) {

            String key = entryKey.getKey();

            for (Map.Entry<String, Integer> entry1 : map1.entrySet()) {
                int max = 0;
                if (key.equals(entry1.getKey())) {
                    max = Math.max(keyMap.get(key), entry1.getValue());
                    keyMap.put(key, max);
                    break;
                }
            }

            for (Map.Entry<String, Integer> entry2 : map2.entrySet()) {
                int max = 0;
                if (key.equals(entry2.getKey())) {
                    max = Math.max(keyMap.get(key), entry2.getValue());
                    keyMap.put(key, max);
                    break;
                }
            }
        }

        int count = 0;
        for (Map.Entry<String, Integer> entryKey : keyMap.entrySet()) {
            count = count + entryKey.getValue();
        }
        return count;
    }

}

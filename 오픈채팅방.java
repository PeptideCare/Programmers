package com.programmers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 오픈채팅방 {

    public static void main(String[] args) {
        오픈채팅방_Solution solution = new 오픈채팅방_Solution();

        String[] strings = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        String[] solution1 = solution.solution(strings);
        for (String s : solution1) {
            System.out.println(s);
        }
    }

}

class 오픈채팅방_Solution {
    public String[] solution(String[] record) {

        Map<String, String> map = new LinkedHashMap<>();

        for (int i=0; i< record.length; i++) {
            StringTokenizer st = new StringTokenizer(record[i]);

            String commend = st.nextToken();
            String id = st.nextToken();
            String nickname = "";
            if (!commend.equals("Leave")) {
                nickname = st.nextToken();
            }

            if (commend.equals("Enter")) {
                if (map.containsKey(id)) {
                    map.remove(id);
                    map.put(id, nickname);
                } else {
                    map.put(id, nickname);
                }
            } else if (commend.equals("Change")) {
                map.remove(id);
                map.put(id, nickname);
            }
        }

        ArrayList<String> list = new ArrayList<>();

        for (int i=0; i< record.length; i++) {
            StringTokenizer st = new StringTokenizer(record[i]);

            String commend = st.nextToken();
            String id = st.nextToken();

            if (commend.equals("Enter")) {
                list.add(map.get(id) + "님이 들어왔습니다.");
            } else if (commend.equals("Leave")) {
                list.add(map.get(id) + "님이 나갔습니다.");
            }
        }

        String [] s = new String[list.size()];

        for (int i=0; i< list.size(); i++) {
            s[i] = list.get(i);
        }

        return s;
    }
}


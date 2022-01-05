package com.programmers;

public class 방금그곡 {

    public static void main(String[] args) {

        String m = "ABC";
        String[] music = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        방금그곡_Solution solution = new 방금그곡_Solution();
        String s = solution.solution(m, music);
        System.out.println(s);

    }
}
class 방금그곡_Solution {

    static int maxLength = -1;

    public String solution(String m, String[] musicinfos) {

        String answer = "";
        m = changeMelody(m);

        for (int i=0; i< musicinfos.length; i++) {

            String[] split = musicinfos[i].split(",");
            int length = makeLength(split[0], split[1]);
            String name = split[2];
            String sound = changeMelody(split[3]);
            StringBuilder sb = new StringBuilder();
            int index = 0;


            for (int j=0; j<length; j++) {
                sb.append(sound.charAt(index));
                index++;
                if (index == sound.length()) index = 0;
            }

            if (sb.toString().contains(m) && length > maxLength) {
                answer = name;
                maxLength = length;
            }
        }

        if (answer.length() == 0) answer = "(None)";

        return answer;
    }

    public int makeLength(String before, String after) {

        String[] beforeSplit = before.split(":");
        String[] afterSplit = after.split(":");

        int beforeTime = Integer.parseInt(beforeSplit[0]);
        beforeTime = beforeTime*60 + Integer.parseInt(beforeSplit[1]);

        int afterTime = Integer.parseInt(afterSplit[0]);
        afterTime = afterTime*60 + Integer.parseInt(afterSplit[1]);

        return afterTime-beforeTime;
    }

    public String changeMelody(String s) {

        String melody = s.replaceAll("C#", "Q");
        melody = melody.replaceAll("D#", "W");
        melody = melody.replaceAll("F#", "K");
        melody = melody.replaceAll("G#", "R");
        melody = melody.replaceAll("A#", "T");

        return melody;
    }
}
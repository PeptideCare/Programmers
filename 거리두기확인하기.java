package com.programmers;

import java.util.ArrayList;

public class 거리두기확인하기 {

    public static void main(String[] args) {
        거리두기확인하기_Solution solution = new 거리두기확인하기_Solution();

        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                            {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                            {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                            {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                            {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        ArrayList<Integer> arr = solution.solution(places);
        for (Integer integer : arr) {
            System.out.println(integer);
        }
    }

}

class 거리두기확인하기_Solution {

    static char[][] map;
    static ArrayList<Integer> answer = new ArrayList<>();
    static boolean[][] visited;
    static boolean check;
    static int startX;
    static int startY;

    public ArrayList<Integer> solution(String[][] places) {

        for (int i=0; i< places.length; i++) {

            map = new char[5][5];
            visited = new boolean[5][5];

            for (int j=0; j<places[i].length; j++) {
                for (int s=0; s<5; s++) {
                    map[j][s] = places[i][j].charAt(s);
                }
            }

            Loop:
            for (int j=0; j<map.length; j++) {
                for (int s=0; s<map[j].length; s++) {
                    if (map[j][s] == 'P') {
                        startY = j;
                        startY = s;
                        check = true;
                        dfs(0, j, s);

                        if (!check) {
                            answer.add(0);
                            break Loop;
                        }
                    }
                }
            }

            if (check) answer.add(1);
        }
        return answer;
    }

    public void dfs(int depth, int x, int y) {

        if (x<0 || y<0 || x>4 || y>4) return;

        if (Math.abs(startX-x) > 2 || Math.abs(startY-y) > 2) return;
        if (depth > 2) return;
        if (map[x][y] == 'X') return;
        if (visited[x][y]) return;

        if (map[x][y] == 'P' && depth != 0) {
            if (Math.abs(startX-x) + Math.abs(startY-y) <= 2) {
                check = false;
            }
        }

        visited[x][y] = true;

        dfs(depth+1,x+1, y);
        dfs(depth+1,x, y+1);
        dfs(depth+1,x-1, y);
        dfs(depth+1,x, y-1);

        visited[x][y] = false;

    }

}

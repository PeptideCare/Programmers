package com.programmers;

public class 프렌즈4블록 {

    public static void main(String[] args) {
        프렌즈4블록_Solution solution = new 프렌즈4블록_Solution();

        int m = 6;
        int n = 5;
        String[] board = {"CCZXZ",
                "CCZXZ",
                "XXZXZ",
                "AAZAA",
                "AAAAA",
                "ZAAXX"};

        int solution1 = solution.solution(m, n, board);
        System.out.println(solution1);
    }

}

class 프렌즈4블록_Solution {

    static char[][] map;
    static boolean[][] visited;

    public int solution(int m, int n, String[] board) {

        map = new char[m][n];

        int answer = 0;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }

        while (true) {
            visited = new boolean[m][n];
            for (int i=0; i<m-1; i++) {
                for (int j=0; j<n-1; j++) {
                    if (map[i][j] == '0') continue;
                    checkSquare(i, j);
                }
            }

            int count = 0;
            for (int i=0; i<m; i++) {
                for (int j=0; j<n; j++) {
                    if (visited[i][j]) {
                        count++;
                        map[i][j] = '0';
                    }
                }
            }
            if (count == 0) break;
            answer+=count;

            for (int i=m-1; i>0; i--) {
                for (int j=0; j<n; j++) {
                    if (map[i][j] == '0') {
                        drop(i, j);
                    }
                }
            }
        }
        return answer;
    }

    public void checkSquare(int i, int j) {

        char c = map[i][j];

        if (c == map[i][j+1] && c == map[i+1][j] && c == map[i+1][j+1]) {
            visited[i][j] = true;
            visited[i+1][j] = true;
            visited[i][j+1] = true;
            visited[i+1][j+1] = true;
        }

    }

    public void drop(int i, int j) {

        for (int k = i-1; k>=0; k--) {
            if (map[k][j] != '0') {
                map[i][j] = map[k][j];
                map[k][j] = '0';
                return;
            }
        }
    }
}
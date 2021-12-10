package com.programmers;

public class 단체사진찍기 {

    public static void main(String[] args) {
        단체사진찍기_Solution solution = new 단체사진찍기_Solution();
        String data[] = {"N~F=0", "R~T>2"};
        int solution1 = solution.solution(2, data);
        System.out.println(solution1);
    }

}

class 단체사진찍기_Solution {
    static int N;
    static char c;
    static char[] arr;
    static boolean[] visited;
    static char[] name;
    static int answer;
    public int solution(int n, String[] data) {

        N = n;
        name = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        arr = new char[name.length];
        visited = new boolean[name.length];
        answer = 0;

        dfs(0, name, data);
        return answer;
    }

    public void dfs(int depth, char[] name, String[] data) {

        if (depth == name.length) {

            for (int i=0; i< data.length; i++) {

                char a = data[i].charAt(0);
                char b = data[i].charAt(2);
                char sign = data[i].charAt(3);
                char signNum = data[i].charAt(4);

                int indexA = 0;
                int indexB = 0;

                for (int j=0; j<8; j++) {
                    if (arr[j] == a) {
                        indexA = j;
                    } else if (arr[j] == b) {
                        indexB = j;
                    }
                }

                switch (sign) {
                    case '=':
                        if (Math.abs(indexA-indexB) != signNum-'0'+1) return;
                        break;
                    case '>':
                        if (Math.abs(indexA-indexB) <= signNum-'0'+1) return;
                        break;
                    case '<':
                        if (Math.abs(indexA-indexB) >= signNum-'0'+1) return;
                        break;
                }
            }

            answer++;
            return;
        }

        for (int i=0; i<8; i++) {
            if (visited[i]) continue;

            arr[depth] = name[i];
            visited[i] = true;

            dfs(depth+1, name, data);

            visited[i] = false;
        }
    }

}

package com.programmers;

public class 카카오프렌즈 {

    public static void main(String[] args) {
        카카오프렌즈_Solution solution = new 카카오프렌즈_Solution();
        int [][] picture = {{0, 0, 1, 0}, {0, 0, 2, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 3}, {0, 0, 0, 0}};
        int[] solution1 = solution.solution(6, 4, picture);
        System.out.println(solution1[0]);
        System.out.println(solution1[1]);
    }

}

class 카카오프렌즈_Solution {

    static int M;
    static int N;
    static boolean[][] visited;
    static int numberOfArea;
    static int depth;
    static int maxSizeOfOneArea;

    public int[] solution(int m, int n, int[][] picture) {

        M = m;
        N = n;
        visited = new boolean[M][N];
        numberOfArea = 0;
        maxSizeOfOneArea = 0;

        for (int i=0; i<M; i++) {
            for (int j=0; j<N; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    depth = 0;
                    dfs(i, j, picture, picture[i][j]);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, depth);
                    numberOfArea++;
                }
            }
        }

        int [] ans = new int[2];
        ans[0] = numberOfArea;
        ans[1] = maxSizeOfOneArea;
        return ans;
    }

    public void dfs(int i, int j, int[][] picture, int num) {

        if (i<0 || i>M-1 || j<0 || j>N-1 || visited[i][j] || picture[i][j] == 0 || num != picture[i][j]) return;

        visited[i][j] = true;
        depth++;

        dfs(i+1, j,  picture, num);
        dfs(i, j+1,  picture, num);
        dfs(i-1, j,  picture, num);
        dfs(i, j-1,  picture, num);

    }
}

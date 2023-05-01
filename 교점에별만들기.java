package com.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 교점에별만들기 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, -1, 0}, {2, -1, 0}};

        교점에별만들기_Solution solution = new 교점에별만들기_Solution();
        String[] solution1 = solution.solution(arr);
        for (String s : solution1) {
            System.out.println(s);
        }
    }
}

class 교점에별만들기_Solution {
    public String[] solution(int[][] line) {
        List<Point> meetPointList = new ArrayList<>();

        for (int i=0; i< line.length; i++) {
            for (int j=i+1; j<line.length; j++) {
                Point meetPoint = getMeetPoint(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                if (meetPoint != null) {
                    meetPointList.add(meetPoint);
                }
            }
        }

        Point minumumPoint = getMinumumPoint(meetPointList);
        Point maximumPoint = getMaximumPoint(meetPointList);

        int width = (int) (maximumPoint.getX() - minumumPoint.getX() + 1);
        int height = (int) (maximumPoint.getY() - minumumPoint.getY() + 1);

        char[][] arr = new char[height][width];
        for (char[] chars : arr) {
            Arrays.fill(chars, '.');
        }

        for (Point point : meetPointList) {
            int x = (int) (point.getX() - minumumPoint.getX());
            int y = (int) (maximumPoint.getY() - point.getY());
            arr[y][x] = '*';
        }

        String[] answer = new String[arr.length];
        for (int i=0; i<answer.length; i++) {
            answer[i] = new String(arr[i]);
        }
        return answer;
    }

    public Point getMinumumPoint(List<Point> pointList) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for (Point point : pointList) {
            if (point.getX() < x) x = point.getX();
            if (point.getY() < y) y = point.getY();
        }
        return new Point(x, y);
    }

    public Point getMaximumPoint(List<Point> pointList) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for (Point point : pointList) {
            if (point.getX() > x) x = point.getX();
            if (point.getY() > y) y = point.getY();
        }
        return new Point(x, y);
    }

    // a와 b의 교점 찾기
    public Point getMeetPoint(long a1, long b1, long c1, long a2, long b2, long c2) {
        double x = (double) (b1*c2 - b2*c1) / (a1*b2 - a2*b1);
        double y = (double) (a2*c1 - a1*c2) / (a1*b2 - a2*b1);

        if (x%1 != 0 || y%1 != 0) return null;

        return new Point((long) x, (long) y);
    }

    class Point {
        private long x;
        private long y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        };

        public long getX() {
            return this.x;
        }

        public long getY() {
            return this.y;
        }
    }
}



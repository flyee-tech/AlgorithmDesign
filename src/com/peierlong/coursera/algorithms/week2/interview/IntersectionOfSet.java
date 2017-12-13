package com.peierlong.coursera.algorithms.week2.interview;

import com.peierlong.coursera.algorithms.week2.ShellSort;

/**
 * 求两个点数组的交集的数量
 *
 * @author elong
 * @version V1.0
 * @date 2017/12/13
 */
public class IntersectionOfSet {

    public static int countIntersection(Point[] a, Point[] b) {
        ShellSort.sort(a);
        ShellSort.sort(b);

        int i = 0, j = 0, count = 0;

        while (i < a.length && j < b.length) {
            if (a[i].compareTo(b[j]) > 0) {
                j++;
            } else if (a[i].compareTo(b[j]) < 0) {
                i++;
            } else {
                i++;
                j++;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Point[] points = new Point[10];
        for (int i = 0; i < 10; i++) {
            points[i] = new Point(i, i);
        }
        Point[] points2 = new Point[10];
        for (int i = 5; i < 15; i++) {
            points2[i - 5] = new Point(i, i);
        }
        int count = countIntersection(points, points2);
        System.out.println(count);
    }

    static class Point implements Comparable<Point> {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point that) {
            if (this.x < that.x) {
                return -1;
            }
            if (this.x > that.x) {
                return +1;
            }
            if (this.y < that.y) {
                return -1;
            }
            if (this.y > that.y) {
                return +1;
            }
            return 0;
        }

    }

}

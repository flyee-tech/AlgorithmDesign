package com.peierlong.coursera.algorithms.week3.homework;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author elong
 * @version V1.0
 * @date 2017/12/18
 */
public class FastCollinearPoints {

    private final List<LineSegment> lineSegments = new ArrayList<>();

    public FastCollinearPoints(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException("the argument is null");
        }
        if (checkAnyPointIsNull(points)) {
            throw new IllegalArgumentException("the points have null point");
        }
        Point[] copyPoints = points.clone();
        Arrays.sort(copyPoints);
        if (checkRepeatedArg(copyPoints)) {
            throw new IllegalArgumentException("the points have repeated point");
        }

        for (int i = 0; i < copyPoints.length - 3; i++) {
            Arrays.sort(copyPoints);
            Arrays.sort(copyPoints, copyPoints[i].slopeOrder());

            for (int p = 0, first = 1, last = 2; last < copyPoints.length; last++) {
                while (last < copyPoints.length &&
                        Double.compare(copyPoints[p].slopeTo(copyPoints[first]), copyPoints[p].slopeTo(copyPoints[last])) == 0) {
                    last++;
                }
                if (last - first >= 3 && copyPoints[p].compareTo(copyPoints[first]) < 0) {
                    lineSegments.add(new LineSegment(copyPoints[p], copyPoints[last - 1]));
                }
                first = last;
            }
        }
    }

    public int numberOfSegments() {
        return lineSegments.size();
    }

    public LineSegment[] segments() {
        return lineSegments.toArray(new LineSegment[0]);
    }

    private boolean checkAnyPointIsNull(Point[] points) {
        for (Point point : points) {
            if (point == null) {
                return true;
            }
        }
        return false;
    }

    private boolean checkRepeatedArg(Point[] points) {
        for (int i = 1; i < points.length; i++) {
            if (points[i].compareTo(points[i - 1]) == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }

}

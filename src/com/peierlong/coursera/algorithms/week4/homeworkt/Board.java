package com.peierlong.coursera.algorithms.week4.homeworkt;

import edu.princeton.cs.algs4.Stack;

/**
 * 一个 board 代表一个 8 puzzle 问题 数据对象
 *
 * @author elong
 * @version V1.0
 * @date 2017/12/29
 */
public class Board {
    private final int N;
    private final int[][] a;

    public Board(int[][] blocks) {
        N = blocks.length;
        a = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(blocks[i], 0, a[i], 0, N);
        }
    }

    // board dimension n
    public int dimension() {
        return N;
    }

    // number of blocks out of place
    public int hamming() {
        int hammingNumber = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (a[i][j] == getGoalVal(i, j) && !isEnd(i, j)) {
                    hammingNumber++;
                }
            }
        }
        return hammingNumber;
    }

    // sum of Manhattan distances between blocks and goal
    public int manhattan() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int value = a[i][j];
                if (value != 0 && value != getGoalVal(i, j)) {
                    int initialX = (value - 1) / N;
                    int initialY = value - 1 - initialX * N;
                    int distance = Math.abs(i - initialX)
                            + Math.abs(j - initialY);
                    sum += distance;
                }
            }
        }
        return sum;
    }

    // is this board the goal board?
    public boolean isGoal() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (a[i][j] != getGoalVal(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }


    // a board that is obtained by exchanging any pair of blocks
    public Board twin() {
        Board board = new Board(a);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (a[i][j] != 0 && a[i][j + 1] != 0) {
                    board.swap(i, j, i, j + 1);
                    return board;
                }
            }
        }
        return board;
    }

    private boolean swap(int i, int j, int it, int jt) {
        if (it < 0 || it >= N || jt < 0 || jt >= N) {
            return false;
        }
        int temp = a[i][j];
        a[i][j] = a[it][jt];
        a[it][jt] = temp;
        return true;
    }

    // 获取某个位置的目标值
    private int getGoalVal(int i, int j) {
        if (isEnd(i, j)) {
            return 0;
        }
        return 1 + i * N + j;
    }

    // 是否是最后一个位置
    private boolean isEnd(int i, int j) {
        return i == N - 1 && j == N - 1;
    }

    // does this board equal y?
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (other instanceof Board) {
            Board that = (Board) other;
            return this.N == that.N && aIsEquals(this.a, that.a);
        }
        return false;
    }

    private boolean aIsEquals(int[][] a, int[][] others) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (a[i][j] != others[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        int i0 = 0, j0 = 0;
        boolean found = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (a[i][j] == 0) {
                    i0 = i;
                    j0 = j;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        Stack<Board> boards = new Stack<>();
        Board board = new Board(a);
        boolean isNeighbor = board.swap(i0, j0, i0 - 1, j0);
        if (isNeighbor) {
            boards.push(board);
        }
        board = new Board(a);
        isNeighbor = board.swap(i0, j0, i0, j0 - 1);
        if (isNeighbor) {
            boards.push(board);
        }
        board = new Board(a);
        isNeighbor = board.swap(i0, j0, i0 + 1, j0);
        if (isNeighbor) {
            boards.push(board);
        }
        board = new Board(a);
        isNeighbor = board.swap(i0, j0, i0, j0 + 1);
        if (isNeighbor) {
            boards.push(board);
        }
        return boards;
    }


    // string representation of this board (in the output format specified below)
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(N).append("\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", a[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String[] args) {

    }

}

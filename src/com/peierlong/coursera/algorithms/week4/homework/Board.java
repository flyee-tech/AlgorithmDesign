package com.peierlong.coursera.algorithms.week4.homework;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Board对象描述了一个N*N的数据结构
 *
 * @author elong
 * @version V1.0
 * @date 2018/1/19
 */
public class Board {
    private final int[][] blocks;

    // construct a board from an n-by-n array of blocks
    // (where blocks[i][j] = block in row i, column j)
    public Board(int[][] blocks) {
        this.blocks = new int[blocks.length][blocks.length];
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks.length; j++) {
                this.blocks[i][j] = blocks[i][j];
            }
        }
    }

    // board dimension n
    public int dimension() {
        return blocks.length;
    }

    // number of blocks out of place
    public int hamming() {
        int hammingNumber = 0;
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks.length; j++) {
                if (blocks[i][j] != getGoalVal(i, j) && !isEnd(i, j)) {
                    hammingNumber++;
                }
            }
        }
        return hammingNumber;
    }

    // sum of Manhattan distances between blocks and goal
    public int manhattan() {
        int manhattanNumber = 0;
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks.length; j++) {
                int value = blocks[i][j];
                if (value != 0 && value != getGoalVal(i, j)) {
                    int ii = (value - 1) / blocks.length;
                    int jj = value - ii * blocks.length - 1;
                    int distance = Math.abs(i - ii) + Math.abs(j - jj);
                    manhattanNumber += distance;
                }
            }
        }
        return manhattanNumber;
    }

    // is this board the goal board?
    public boolean isGoal() {
        if (blocks[blocks.length - 1][blocks.length - 1] != 0) {
            return false;
        }
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks.length; j++) {
                if (blocks[i][j] != getGoalVal(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    // a board that is obtained by exchanging any pair of blocks
    public Board twin() {
        Board board = new Board(blocks);
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks.length - 1; j++) {
                if (board.blocks[i][j] != 0 && board.blocks[i][j + 1] != 0) {
                    swap(i, j, i, j + 1);
                    return board;
                }
            }
        }
        return board;
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
            if (that.blocks != this.blocks) {
                return false;
            }
            for (int i = 0; i < this.blocks.length; i++) {
                for (int j = 0; j < this.blocks.length; j++) {
                    if (this.blocks[i][j] != that.blocks[i][j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private int getGoalVal(int i, int j) {
        if (isEnd(i, j)) {
            return 0;
        }
        return i * blocks.length + j + 1;
    }

    private boolean isEnd(int i, int j) {
        return i == blocks.length - 1 && j == blocks.length - 1;
    }

    private boolean swap(int i, int j, int si, int sj) {
        if (si < 0 || si >= blocks.length || sj < 0 || sj >= blocks.length) {
            return false;
        }
        int swap = blocks[i][j];
        blocks[i][j] = blocks[si][sj];
        blocks[si][sj] = swap;
        return true;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        int i0 = 0, j0 = 0;
        boolean isFind = false;
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks.length; j++) {
                if (blocks[i][j] == 0) {
                    i0 = i;
                    j0 = j;
                    isFind = true;
                    break;
                }
            }
            if (isFind) {
                break;
            }
        }
        Stack<Board> stack = new Stack<>();
        Board board = new Board(blocks);
        boolean isSwap = board.swap(i0, j0, i0 - 1, j0);
        if (isSwap) {
            stack.push(board);
        }
        board = new Board(blocks);
        isSwap = board.swap(i0, j0, i0 + 1, j0);
        if (isSwap) {
            stack.push(board);
        }
        board = new Board(blocks);
        isSwap = board.swap(i0, j0, i0, j0 - 1);
        if (isSwap) {
            stack.push(board);
        }
        board = new Board(blocks);
        isSwap = board.swap(i0, j0, i0, j0 + 1);
        if (isSwap) {
            stack.push(board);
        }
        return stack;
    }

    // string representation of this board (in the output format specified below)
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] block : blocks) {
            for (int j = 0; j < blocks.length; j++) {
                sb.append(block[j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // unit tests (not graded)
    public static void main(String[] args) {
        int[][] is = new int[3][3];
        int start = 0;
        for (int i = 0; i < is.length; i++) {
            for (int j = 0; j < is.length; j++) {
                is[i][j] = start++;
            }
        }
        Board board = new Board(is);
        StdOut.println(board);
    }

}

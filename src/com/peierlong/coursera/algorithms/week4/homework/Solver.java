package com.peierlong.coursera.algorithms.week4.homework;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author elong
 * @version V1.0
 * @date 2018/1/22
 */
public class Solver {

    private final Stack<Board> boards;
    private boolean isSolvable;

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null) {
            throw new IllegalArgumentException("args board is null");
        }

        boards = new Stack<>();
        if (initial.isGoal()) {
            isSolvable = true;
            boards.push(initial);
            return;
        }
        if (initial.twin().isGoal()) {
            isSolvable = false;
            return;
        }

        MinPQ<SearchNode> minPQ = new MinPQ<>();
        MinPQ<SearchNode> minPQTwin = new MinPQ<>();
        Board board = initial;
        Board boardTwin = initial.twin();
        SearchNode node = new SearchNode(board, 0, null);
        SearchNode nodeTwin = new SearchNode(boardTwin, 0, null);
        minPQ.insert(node);
        minPQTwin.insert(nodeTwin);

        while (true) {
            node = minPQ.delMin();
            nodeTwin = minPQTwin.delMin();
            board = node.board;
            boardTwin = nodeTwin.board;
            if (board.isGoal()) {
                isSolvable = true;
                boards.push(board);
                while (node.previous != null) {
                    node = node.previous;
                    boards.push(node.board);
                }
                return;
            }
            if (boardTwin.isGoal()) {
                isSolvable = false;
                return;
            }
            node.moves++;
            nodeTwin.moves++;

            Iterable<Board> neighbors = board.neighbors();
            for (Board b : neighbors) {
                if (node.previous != null && node.previous.board.equals(b)) {
                    continue;
                }
                minPQ.insert(new SearchNode(b, node.moves, node));
            }

            Iterable<Board> neighborsTwin = boardTwin.neighbors();
            for (Board b : neighborsTwin) {
                if (nodeTwin.previous != null && nodeTwin.previous.board.equals(b)) {
                    continue;
                }
                minPQTwin.insert(new SearchNode(b, nodeTwin.moves, nodeTwin));
            }

        }

    }

    // is the initial board solvable?
    public boolean isSolvable() {
        return isSolvable;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        if (isSolvable) {
            return boards.size() - 1;
        }
        return -1;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        if (isSolvable) {
            return boards;
        }
        return null;
    }

    private class SearchNode implements Comparable<SearchNode> {
        private Board board;
        private int moves;
        private SearchNode previous;
        private int cachedPriority = -1;

        public SearchNode(Board board, int moves, SearchNode previous) {
            this.board = board;
            this.moves = moves;
            this.previous = previous;
        }

        private int priority() {
            if (cachedPriority == -1) {
                cachedPriority = board.manhattan() + moves;
            }
            return cachedPriority;
        }

        @Override
        public int compareTo(SearchNode that) {
            return Integer.compare(this.priority(), that.priority());
        }

    }

    // solve a slider puzzle (given below)
    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}

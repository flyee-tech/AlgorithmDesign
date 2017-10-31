package com.peierlong.base.union_find;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 动态连接，使用List加Set实现

 输入数据：
 10
 4 3
 1 2
 5 6
 2 5
 2 2
 2 6
 4 9
 8 0

 输出数据: java UF < data.txt
 [0][1][2][3, 4][5][6][7][8][9]
 9 components
 [0][1, 2][3, 4][5][6][7][8][9]
 8 components
 [0][1, 2][3, 4][5, 6][7][8][9]
 7 components
 [0][3, 4][1, 2, 5, 6][7][8][9]
 6 components
 [0][3, 4][1, 2, 5, 6][7][8][9]
 6 components
 [0][3, 4][1, 2, 5, 6][7][8][9]
 6 components
 [0][1, 2, 5, 6][7][8][3, 4, 9]
 5 components
 [1, 2, 5, 6][7][0, 8][3, 4, 9]
 4 components

 * BY: elong
 * ON: 30/10/2017
 */
public class UF {

    private List<Set<Integer>> list = new ArrayList<>();

    UF(int N) {
        for (int i = 0; i < N; i++) {
            Set<Integer> set = new HashSet<>();
            set.add(i);
            list.add(set);
        }
    }

    void union(int p, int q) throws Exception {
        int idxP = find(p);
        int idxQ = find(q);
        if (idxP == idxQ) return;
        if (idxP > idxQ) {
            list.get(idxP).addAll(list.get(idxQ));
            list.remove(idxQ);
        } else if (idxP < idxQ) {
            list.get(idxQ).addAll(list.get(idxP));
            list.remove(idxP);
        }
    }

    boolean connected(int p, int q) {
        for (Set<Integer> set : list) {
            if (set.contains(p) && set.contains(q)) {
                return true;
            }
        }
        return false;
    }

    int find(int p) throws Exception {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains(p)) {
                return i;
            }
        }
        throw new Exception("未找到");
    }

    int count() {
        return list.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Set<Integer> set : list) {
            sb.append(set);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
            }
            StdOut.println(uf.toString());
            StdOut.println(uf.count() + " components");
        }
    }

}

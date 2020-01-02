package com.peierlong.coursera.v1.week1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Peiel
 * @version V1.0
 * @date 2020/1/2
 */
public class QuickFindUF implements InterfaceUF {
    private int[] id;

    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int pid = find(p);
        int qid = find(q);
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public int count() {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < id.length; i++) {
            set.add(find(i));
        }
        return set.size();
    }

    public static void main(String[] args) {
        InterfaceUF uf = new QuickFindUF(8);
        uf.union(1, 4);
        uf.union(4, 5);
        uf.union(2, 3);
        uf.union(2, 6);
        uf.union(3, 6);
        uf.union(3, 7);

        System.out.println(uf.connected(0, 7));
        System.out.println(uf.connected(1, 7));
        System.out.println(uf.connected(1, 5));
        System.out.println(uf.connected(2, 7));

    }

}

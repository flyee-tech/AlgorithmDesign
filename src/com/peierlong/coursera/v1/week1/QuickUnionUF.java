package com.peierlong.coursera.v1.week1;

/**
 * @author Peiel
 * @version V1.0
 * @date 2020/1/6
 */
public class QuickUnionUF implements InterfaceUF {
    private int[] id;
    private int count;

    public QuickUnionUF(int N) {
        id = new int[N];
        count = N;
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    //时间复杂度 N+
    @Override
    public void union(int p, int q) {
        if (!connected(p, q)) {
            int i = root(p);
            int j = root(q);
            id[i] = j;
            count--;
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    //时间复杂度 N
    @Override
    public int find(int p) {
        return root(p);
    }

    @Override
    public int count() {
        return count;
    }

    public static void main(String[] args) {
        InterfaceUF uf = new QuickUnionUF(8);
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

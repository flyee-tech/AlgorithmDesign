package com.peierlong.coursera.v1.week1;

/**
 * 优化快速联通算法 - 始终让比较重的树合并到比较轻的树上，这样可以降低树的高度。
 *
 * @author Peiel
 * @version V1.0
 * @date 2020/1/6
 */
public class QuickUnionImprovementsUF implements InterfaceUF {
    private int[] id;
    private int[] size;
    private int count;

    public QuickUnionImprovementsUF(int N) {
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }
        count = N;
    }

    private int root(int i) {
        while (i != id[i]) {
            // 优化一：控制树的高度,把当前节点指向上上个节点。
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    //时间复杂度 logN
    @Override
    public void union(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);
        if (rootP == rootQ) {
            return;
        }
        // 优化二：重量小的向重量大的合并，建立一个数组来记录相应root节点的权重
        if (size[rootP] < size[rootQ]) {
            id[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            id[rootQ] = id[rootP];
            size[rootP] += size[rootQ];
        }
        count--;
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    //时间复杂度 logN
    @Override
    public int find(int p) {
        return root(p);
    }

    @Override
    public int count() {
        return count;
    }

    public static void main(String[] args) {
        InterfaceUF uf = new QuickUnionImprovementsUF(8);
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

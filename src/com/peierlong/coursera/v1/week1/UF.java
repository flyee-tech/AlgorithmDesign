package com.peierlong.coursera.v1.week1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Peiel
 * @version V1.0
 * @date 2020/1/2
 */
public class UF {
    private int N;
    private List<List<Integer>> components;

    public UF(int N) {
        this.N = N;
        components = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            List<Integer> component = new ArrayList<>();
            component.add(i);
            components.add(component);
        }
    }

    /**
     * add connection between p and q
     */
    void union(int p, int q) {
        int pidx = find(p);
        int qidx = find(q);
        if (pidx != qidx) {
            List<Integer> qcomponent = components.get(qidx);
            List<Integer> pcomponent = components.get(pidx);
            pcomponent.addAll(qcomponent);
            components.remove(qidx);
        }
    }

    /**
     * are p and q in the same component?
     */
    boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * component identifier for p (0 to N – 1)
     */
    int find(int p) {
        for (List<Integer> component : components) {
            for (Integer z : component) {
                if (p == z) {
                    return components.indexOf(component);
                }
            }
        }
        return -1;
    }

    /**
     * number of components
     */
    int count() {
        return components.size();
    }


    public static void main(String[] args) {
        UF uf = new UF(8);
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

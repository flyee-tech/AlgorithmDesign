package com.peierlong.coursera.v1.week1;

/**
 * @author Peiel
 * @version V1.0
 * @date 2020/1/2
 */
public interface InterfaceUF {

    /**
     * add connection between p and q
     */
    void union(int p, int q);

    /**
     * are p and q in the same component?
     */
    boolean connected(int p, int q);

    /**
     * component identifier for p (0 to N – 1)
     */
    int find(int p);

    /**
     * number of components
     */
    int count();

}

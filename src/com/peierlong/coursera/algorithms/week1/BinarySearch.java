package com.peierlong.coursera.algorithms.week1;

/**
 * 二叉搜索实现
 *
 * @author elong
 * @version V1.0
 * @date 04/12/2017
 */
public class BinarySearch {

    public static int binarySearch(int[] a, int key) {
        int loIdx = 0, hiIdx = a.length - 1;
        while (loIdx <= hiIdx) {
            int mid = (loIdx + hiIdx) / 2;
            if (a[mid] > key) {
                hiIdx = mid - 1;
            } else if (a[mid] < key) {
                loIdx = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 8, 9, 10, 19, 99, 100, 282, 283, 284, 888};
        int index = binarySearch(a, 3);
        System.out.println(index);
    }


}

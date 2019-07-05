package com.peierlong.base.sort;

/**
 * 冒泡排序算法实现
 *
 * @author Peiel
 * @version V1.0
 * @date 2019-07-05
 */
public class bubbleSort {

    public static void sort(int[] a) {
        int n = a.length;
        if (n <= 1) {
            return;
        }
        for (int i = n - 1; i > 0; i--) {
            boolean flag = false;
            for (int j = n - 1; j > n - i - 1; j--) {
                if (a[j] < a[j - 1]) {
                    swap(a, j, j - 1);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
//        int[] a = {8, 1, 3, 8, 1, 2, 4, 3, 0, 6};
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        sort(a);
        for (int i : a) {
            System.out.print(i + ", ");
        }
    }


}

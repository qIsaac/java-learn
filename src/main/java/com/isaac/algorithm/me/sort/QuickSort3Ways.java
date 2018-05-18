package com.isaac.algorithm.me.sort;

/**
 * @Author : Isaac
 * @Description: laing
 * @Date :Created in 11:37 2018/5/17
 */
public class QuickSort3Ways {
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);
        Comparable v = arr[l];
        int lt = l;
        int gt = r + 1;
        int i = l + 1;
        while (i < gt) {
            if (arr[i].compareTo(v) < 0) {
                swap(arr, i++, ++lt);
            } else if (arr[i].compareTo(v) > 0) {
                swap(arr, i, --gt);
            } else {
                i++;
            }
        }
        swap(arr, l, lt);
        sort(arr, l, lt - 1);
        sort(arr, gt, r);
    }

    public static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

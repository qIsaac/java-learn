package com.isaac.algorithm.me.sort;

import com.isaac.algorithm.util.SortHelper;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 17:36 2018/5/16
 */
public class SelectionSort {
    //私有化构造器
    private SelectionSort() {
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int N = 20000;
        Integer[] arr = SortHelper.generateRandomArray(N,0, 100000);
        SortHelper.printArray(arr);
        sort(arr);
        SortHelper.printArray(arr);
    }
}

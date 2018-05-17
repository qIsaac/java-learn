package com.isaac.algorithm.me.sort;

import com.isaac.algorithm.util.SortHelper;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 17:57 2018/5/16
 */
public class InsertionSort {
    private InsertionSort(){}

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            Comparable e = arr[i];
            int j = i;
            for (; j > 0 && arr[j - 1].compareTo(e) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }

    public static void main(String[] args) {
        int N = 20000;
        Integer[] arr = SortHelper.generateRandomArray(N,0, 100000);
        System.out.println("before:");
        SortHelper.printArray(arr);
        sort(arr);
        System.out.println("after:");
        SortHelper.printArray(arr);
    }

    // 对arr[l...r]的区间使用InsertionSort排序
    public static void sort(Comparable[] arr, int l, int r){

        for( int i = l + 1 ; i <= r ; i ++ ){
            Comparable e = arr[i];
            int j = i;
            for( ; j > l && arr[j-1].compareTo(e) > 0 ; j--)
                arr[j] = arr[j-1];
            arr[j] = e;
        }
    }
}

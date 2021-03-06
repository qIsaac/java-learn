package com.isaac.algorithm.me.sort;

import com.isaac.algorithm.util.SortHelper;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 11:37 2018/5/17
 */
public class QuickSort {
    public static void  sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n-1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if ( l >= r){
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p-1);
        sort(arr, p+1, r);
    }

    private static int partition(Comparable[] arr, int l, int r) {
        Comparable v = arr[l];
        int j = l;
        for (int i = l+1; i <= r ; i++) {
            if (arr[i].compareTo(v) < 0) {
                swap(arr, ++j ,i);
            }
        }
        swap(arr,l,j);
        return j;
    }
    public static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int N = 30000;
        Integer[] arr = SortHelper.generateRandomArray(N,0, 100000);
        System.out.println("before:");
        SortHelper.printArray(arr);
        sort(arr);
        System.out.println("after:");
        SortHelper.printArray(arr);
    }
}

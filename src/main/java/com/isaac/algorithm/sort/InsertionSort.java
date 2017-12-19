package com.isaac.algorithm.sort;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 11:31 2017/12/19
 */
public class InsertionSort implements Sort {
    public void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0 ;i < n ; i++) {
            Comparable e = arr[i];
            int j = i;
            for ( ; j > 0 && arr[j-1].compareTo(e) > 0 ; j-- ){
                arr[j] = arr[j -1];
            }
            arr[j] = e;
        }
    }
}

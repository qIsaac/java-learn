package com.isaac.algorithm.me.sort;

import java.util.Arrays;

import static com.isaac.algorithm.me.sort.MergeSort.merge;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 9:09 2018/5/17
 */
public class MergeSortBU {
    private MergeSortBU(){}

    private static void sort(Comparable[] arr){
        int n = arr.length;

        for (int i = 0; i <n ; i += 16) {
            InsertionSort.sort(arr, i, Math.min(i + 15,n - 1));
        }
        for (int sz = 16; sz < n; sz += sz) {
            for (int i = 0; i < n - sz ; i += sz + sz) {
                if( arr[i+sz-1].compareTo(arr[i+sz]) > 0 )
                    merge(arr, i, i+sz-1, Math.min(i+sz+sz-1,n-1) );
            }
        }
    }
}

package com.isaac.algorithm.sort;

import com.isaac.algorithm.util.SortHelper;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 11:00 2017/12/19
 */
public class SelectionSort implements Sort {
    public void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i=0 ; i < n ; i++){
            int minIndex = i;
            //查找[i,n)的最小值索引
            for (int j = i + 1 ;j < n; j++ ) {
                if (arr[j].compareTo(arr[minIndex]) < 0 ) {
                    minIndex = j;
                }
            }
            SortHelper.swap(arr,i,minIndex);
        }
    }
}

package com.isaac.algorithm.me.sort;

import java.util.Arrays;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 18:10 2018/5/16
 */
public class MergeSort {
    private MergeSort () {}
    public static void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j - 1];
                j++;
            }else if (j > r){
                arr[k] = aux[i - 1];
                i++;
            }else if (aux[i - 1].compareTo(aux[j - 1]) < 0) { //左边小于右边
                arr[k] = aux[i - 1];
                i++;
            }else{
                arr[k] = aux[j - 1];
                j++;
            }
        }
    }

    private static void sort (Comparable[] arr, int l, int r) {
        //小规模数据使用插入排序
        if (r -l <= 15) {
            InsertionSort.sort(arr, l, r);
            return ;
        }
        int mid = l - (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid+1, r);
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr,l,mid,r);
        }

    }

    public static void sort (Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n-1);
    }

}

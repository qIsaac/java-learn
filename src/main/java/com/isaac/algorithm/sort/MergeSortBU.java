package com.isaac.algorithm.sort;

import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * Created by Isaac on 2017/12/19.
 */
public class MergeSortBU implements Sort{
    @Override
    public void sort(Comparable[] arr) {
        int n = arr.length;
        for( int i = 0 ; i < n ; i += 16 )
            InsertionSort.sort(arr, i, Math.min(i+15, n-1) );

        for( int sz = 16; sz < n ; sz += sz )
            for( int i = 0 ; i < n - sz ; i += sz+sz )
                // 对于arr[mid] <= arr[mid+1]的情况,不进行merge
                if( arr[i+sz-1].compareTo(arr[i+sz]) > 0 )
                    merge(arr, i, i+sz-1, Math.min(i+sz+sz-1,n-1) );
    }

    /**
     * 对arr[l...mid] 和arr[mid+1 ....r] 范围内进行排序
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    private static void merge(Comparable[] arr, int l, int mid, int r){
       Comparable[] aux = Arrays.copyOfRange(arr,l,r+1);
       int i = l,j = mid+1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j-l];
                j++;
            }else if (j > r){
                arr[k] = aux[i-l];
                i++;
            }else if (aux[i - l].compareTo(aux[j - l]) < 0) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }
    /**
     * 对arr[l...r] 范围内进行排序
     * @param arr
     * @param l
     * @param r
     */
    private void sort(Comparable[] arr,int l,int r) {
        if (l >= r) {
            return ;
        }
        int mid = (l+r)/2;//当l和r非常大的时候发生溢出
        sort(arr,l,mid);
        sort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }
}

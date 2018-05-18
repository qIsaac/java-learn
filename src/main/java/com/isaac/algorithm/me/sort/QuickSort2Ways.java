package com.isaac.algorithm.me.sort;

/**
 * @Author : Isaac
 * @Description: laing
 * @Date :Created in 11:37 2018/5/17
 */
public class QuickSort2Ways {
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    private static int partition(Comparable[] arr, int l, int r) {
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);
        Comparable v = arr[l];
        int j = r;
        int i = l + 1;
        while(true){
            while (i <= r && arr[i].compareTo(v) < 0){
                i++;
            }
            while (j >= l+1 && arr[j].compareTo(v) > 0){
                j--;
            }
            if (i > j) break;
            swap(arr,i,j);
            i++;
            j--;
        }

        swap(arr, l, j);
        return j;
    }

    public static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

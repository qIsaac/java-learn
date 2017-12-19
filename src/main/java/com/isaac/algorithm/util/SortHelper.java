package com.isaac.algorithm.util;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 10:55 2017/12/19
 */
public class SortHelper {
    // SortHelper不允许产生任何实例
    private SortHelper(){}

    /**
     *  交换数据
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    /**
     * 生成有n个元素的随机数组,每个元素的随机范围为[rangeL, rangeR]
     * @param n
     * @param rangeL
     * @param rangeR
     * @return
     */
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {

        assert rangeL <= rangeR;

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++)
            arr[i] = new Integer((int)(Math.random() * (rangeR - rangeL + 1) + rangeL));
        return arr;
    }

    /**
     * 打印arr数组的所有内容
     * @param arr
     */
    public static void printArray(Object arr[]) {

        for (int i = 0; i < arr.length; i++){
            System.out.print( arr[i] );
            System.out.print( ' ' );
        }
        System.out.println();

        return;
    }

    /**
     * 判断arr数组是否有序
     * @param arr
     * @return
     */
    public static boolean isSorted(Comparable[] arr){

        for( int i = 0 ; i < arr.length - 1 ; i ++ )
            if( arr[i].compareTo(arr[i+1]) > 0 )
                return false;
        return true;
    }
}

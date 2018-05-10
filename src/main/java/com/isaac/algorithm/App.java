package com.isaac.algorithm;

import com.isaac.algorithm.sort.*;
import com.isaac.algorithm.util.SortHelper;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 10:34 2017/12/19
 */
public class App {
    public static void main(String [] args){
        Integer[] arr = SortHelper.generateRandomArray(1000000,0,100000);
        Integer[] arr2 = SortHelper.generateRandomArray(1000000,0,100000);
        Sort sort = new MergeSortBU();
        Sort sort2 = new MergeSort();
        SortExecutor executor = new SortExecutor(sort);
        SortExecutor executor2 = new SortExecutor(sort2);
        long startTime = System.currentTimeMillis();
        // 调用排序函数
        executor.execute(arr);
        long endTime = System.currentTimeMillis();
        System.out.println( SortExecutor.class.getSimpleName()+ " : " + (endTime-startTime) + "ms" );
        long startTime2 = System.currentTimeMillis();
        executor2.execute(arr2);
        long endTime2 = System.currentTimeMillis();
        System.out.println( SortExecutor.class.getSimpleName()+ " : " + (endTime2-startTime2) + "ms" );
    }

}

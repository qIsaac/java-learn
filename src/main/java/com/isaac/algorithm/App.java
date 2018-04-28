package com.isaac.algorithm;

import com.isaac.algorithm.sort.InsertionSort;
import com.isaac.algorithm.sort.SelectionSort;
import com.isaac.algorithm.sort.Sort;
import com.isaac.algorithm.sort.SortExecutor;
import com.isaac.algorithm.util.SortHelper;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 10:34 2017/12/19
 */
public class App {
    public static void main(String [] args){
        Integer[] arr = SortHelper.generateRandomArray(20000,0,100000);
        Sort sort = new SelectionSort();
        SortExecutor executor = new SortExecutor(sort);
        long startTime = System.currentTimeMillis();
        // 调用排序函数
        executor.execute(arr);
        long endTime = System.currentTimeMillis();
        System.out.println( SortExecutor.class.getSimpleName()+ " : " + (endTime-startTime) + "ms" );
    }

}

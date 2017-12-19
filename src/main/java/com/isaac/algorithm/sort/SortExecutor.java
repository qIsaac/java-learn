package com.isaac.algorithm.sort;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 11:10 2017/12/19
 */
public class SortExecutor {
    private Sort sort;

    public SortExecutor(Sort sort) {
        this.sort = sort;
    }

    public void changeSort(Sort sort){
        this.sort = sort;
    }
    public void execute(Comparable [] arr){
        sort.sort(arr);
    }
}

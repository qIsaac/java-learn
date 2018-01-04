package com.isaac.thread;

import java.util.concurrent.*;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 10:45 2018/1/4
 */
public class CountTask  extends RecursiveTask<Integer>{
    private static final Integer THRESHOLD = 2;
    private Integer start;
    private Integer end;

    public CountTask(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end -start) <= THRESHOLD;
        if (canCompute) {
            for (int i = start;i <= end; i++ ) {
                sum += i;
            }
        }else {
            int middle = (start + end) / 2;
            CountTask leftTask = new CountTask(start,middle);
            CountTask rightTask = new CountTask(middle+1,end);
            leftTask.fork();
            rightTask.fork();
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();
            sum = leftResult + rightResult ;
        }
        return sum;
    }
    public static void main(String [] args){
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask countTask = new CountTask(1,4);
        Future<Integer> result = forkJoinPool.submit(countTask);
        try {
            System.out.println("sum : "+result.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

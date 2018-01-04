package com.isaac.juc;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Isaac on 2017/12/9.
 */
public class AlternateRun {
    public static void main(String[] args){
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate= new CountDownLatch(3);
        final AlternateTask task = new AlternateTask();
        for (int i = 0;i < 3;i++){
            Thread thread = new Thread(){
                public void run(){
                    try{
                        startGate.await();
                        try {
                            task.run();
                        }finally {
                            endGate.countDown();
                        }
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            };
            thread.start();
        }
        long start = System.nanoTime();
        startGate.countDown();
        try {
            endGate.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();
        System.out.println("total time:"+(end-start));

    }
}

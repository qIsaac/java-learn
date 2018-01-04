package com.isaac.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Isaac on 2017/12/9.
 */
public class ABCAlternate2 {
    private static int state = 0;
    public static void main(String[] args){
        final Lock lock = new ReentrantLock();
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                while (state <= 30){
                    lock.lock();
                    if (state % 3 == 0){
                        System.out.println(Thread.currentThread().getName());
                        state++;
                    }
                    lock.unlock();
                }
            }
        },"A");
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                while (state <= 30){
                    lock.lock();
                    if (state % 3 == 1){
                        System.out.println(Thread.currentThread().getName());
                        state++;
                    }
                    lock.unlock();
                }
            }
        },"B");
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                while (state <= 30){
                    lock.lock();
                    if (state % 3 == 2){
                        System.out.println(Thread.currentThread().getName());
                        state++;
                    }
                    lock.unlock();
                }
            }
        },"C");
        long start = System.nanoTime();
        threadA.start();
        threadB.start();
        threadC.start();
        long end = System.nanoTime();
        System.out.println("total time:"+(end-start));
    }

}

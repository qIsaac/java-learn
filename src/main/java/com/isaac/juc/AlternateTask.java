package com.isaac.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Isaac on 2017/12/9.
 */
public class AlternateTask implements Runnable {
    private static int state = 0;
    final Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while (state <= 30){
            lock.lock();
            if (state % 3 == 0){
                System.out.println("A");
                state++;
            }else if(state % 3 == 1){
                System.out.println("B");
                state++;
            }else{
                System.out.println("C");
                state++;
            }
            lock.unlock();
        }
    }
}

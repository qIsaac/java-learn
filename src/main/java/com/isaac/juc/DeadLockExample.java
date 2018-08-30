package com.isaac.juc;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 10:41 2018/8/30
 */
@Slf4j
@Getter
public class DeadLockExample extends Thread {
    private String first;
    private String second;
    public DeadLockExample(String first, String second){
        this.first = first;
        this.second = second;
    }
    @Override
    public void run() {
        synchronized (first) {
            log.info(this.getName() + "- obtained" + first);
            try {
                Thread.sleep(1000L);
                synchronized (second){
                    log.info(this.getName() + "- obtained" + second);
                }
            } catch (InterruptedException e) {
                log.error(e.getMessage(),e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String lockA = "lockA";
        String lockB = "lockB";
        DeadLockExample deadLockExample1 = new DeadLockExample(lockA, lockB);
        DeadLockExample deadLockExample2 = new DeadLockExample(lockB, lockA);
        deadLockExample1.start();
        deadLockExample2.start();
        deadLockExample1.join();
        deadLockExample2.join();
    }
}

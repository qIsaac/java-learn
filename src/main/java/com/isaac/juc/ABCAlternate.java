package com.isaac.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Isaac on 2017/7/23.
 */
public class ABCAlternate {
    public static void main(String [] args){
       final AlternateDemo ad = new AlternateDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1;i <= 10; i++){
                    ad.loopA(i);
                }

            }
        },"A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1;i <= 10; i++){
                    ad.loopB(i);
                }

            }
        },"B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1;i <= 10; i++){
                    ad.loopC(i);
                    System.out.println("--"+i+"--");
                }
            }
        },"C").start();
    }
}

class AlternateDemo{
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();//交替A
    private Condition condition2 = lock.newCondition();//交替B
    private Condition condition3 = lock.newCondition();//交替C

    public void loopA(int totalLoop){
        lock.lock();
        try {
            //判断
            if (number != 1 ){
                condition1.await();
            }
            //打印
            System.out.println("A");
            //唤醒下一个
            number = 2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void loopB(int totalLoop){
        lock.lock();
        try {
            //判断
            if (number != 2 ){
                condition2.await();
            }
            //打印
            System.out.println("B");
            //唤醒下一个
            number = 3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void loopC(int totalLoop){
        lock.lock();
        //判断
        try {
            if (number != 3 ){
                condition3.await();
            }
            //打印
            System.out.println("C");
            //唤醒下一个
            number = 1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

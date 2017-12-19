package com.isaac.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 14:16 2017/12/19
 */
public class Shutdown {
    public static void main(String [] args) throws Exception{
        Runner one = new Runner();
        Thread countThread = new Thread( one, "CountThread");
        countThread. start();
        // 睡眠 1 秒， main 线程 对 CountThread 进行 中断， 使 CountThread 能够 感知 中断 而 结束
        TimeUnit. SECONDS. sleep( 1);
        countThread. interrupt();
        Runner two = new Runner();
        countThread = new Thread( two, "CountThread");
        countThread. start();
        // 睡眠 1 秒， main 线程 对 Runner two 进行 取消， 使 CountThread 能够 感知 on 为 false 而 结束
        TimeUnit. SECONDS. sleep( 1);
        two.cancel();

    }
    private static class Runner implements Runnable {
        private long i ;
        private volatile boolean on = true ;
        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i ++ ;
            }
            System.out.println("Count i = " + i);
        }
        public void cancel(){
            on = false ;
        }
    }
}

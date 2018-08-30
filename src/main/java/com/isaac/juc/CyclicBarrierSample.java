package com.isaac.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 14:45 2018/8/30
 */
@Slf4j
public class CyclicBarrierSample {
    static class CyclicWorker implements Runnable{
        private CyclicBarrier cyclicBarrier;

        public CyclicWorker(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                    log.info("Executed!");
                    cyclicBarrier.await();
                   log.info("Executed -- 1!");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                log.info("Action.....Go again");
            }
        });
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new CyclicWorker(cyclicBarrier));
            thread.start();
        }
    }
}

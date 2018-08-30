package com.isaac.juc;

import lombok.extern.slf4j.Slf4j;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 10:56 2018/8/30
 */
@Slf4j
public class ThreadMXBeanExample {
    public static void main(String[] args) {
        ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
        Runnable dlcheck = new Runnable() {
            @Override
            public void run() {
                long[] threadIds = mxBean.findDeadlockedThreads();
                if (threadIds != null) {
                    ThreadInfo[] threadInfos = mxBean.getThreadInfo(threadIds);
                    log.info("Deceted DeadLock Threads:");
                    for (ThreadInfo info : threadInfos) {
                        log.info(info.getThreadName());
                    }
                }
            }
        };
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(dlcheck,5L,10L, TimeUnit.SECONDS);
    }
}

package com.isaac.thread;

import com.sun.corba.se.impl.oa.poa.AOMEntry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 16:26 2018/2/2
 */
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job>  {
    // 线程池最大限制数
    private static final int      MAX_WORKER_NUMBERS     = 10;
    // 线程池默认的数量
    private static final int      DEFAULT_WORKER_NUMBERS = 5;
    // 线程池最小的数量
    private static final int      MIN_WORKER_NUMBERS     = 1;
    //工作列表添加工作
    private final LinkedList<Job> jobs = new LinkedList<Job>();
    //工作列表
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());
    // 工作者线程的数量
    private int workerNum  = DEFAULT_WORKER_NUMBERS;
    //线程编号
    private AtomicLong threadNum = new AtomicLong();

    public DefaultThreadPool() {
        initializeWokers(DEFAULT_WORKER_NUMBERS);
    }
    public DefaultThreadPool(int num) {
        workerNum = num > MAX_WORKER_NUMBERS ? MAX_WORKER_NUMBERS : num < MIN_WORKER_NUMBERS ? MIN_WORKER_NUMBERS : num;
        initializeWokers(DEFAULT_WORKER_NUMBERS);
    }
    // 初始化线程工作者
    private void initializeWokers(int num) {
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker, "ThreadPool-Worker-" + threadNum.incrementAndGet());
            thread.start();
        }
    }
    @Override
    public void execute(Job job) {
        if (job != null ){
            jobs.add(job);
            jobs.notify();
        }
    }

    @Override
    public void shutdown() {
        for (Worker worker : workers) {
            worker.shutDown();
        }
    }

    @Override
    public void addWorkers(int num) {
        synchronized(jobs){
            if (this.workerNum + num > MAX_WORKER_NUMBERS) num = MAX_WORKER_NUMBERS - this.workerNum;
            initializeWokers(num);
            this.workerNum += num;
        }
    }

    @Override
    public void removeWorker(int num) {
        synchronized (jobs) {
            if (num >= this.workerNum) {
                throw new IllegalArgumentException("beyond workNum");
            }
            int count = 0;
            while (count < num) {
                workers.get(count).shutDown();
                count ++;
            }
            this.workerNum -= count;
        }

    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }
    class Worker implements Runnable {
        private volatile boolean running = true ;
        @Override
        public void run() {
            while(running){
                Job job = null;
                synchronized(jobs){
                    while(jobs.isEmpty()) {
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().isInterrupted();
                            return ;
                        }
                    }
                    //取出job
                    job = jobs.removeFirst();
                }
                if (job != null) {
                    try {
                        job.run();
                    } catch (Exception e) {
                       //暂不考虑执行任务异常
                    }
                }
            }
        }
        public void shutDown(){
            running = false;
        }
    }

}

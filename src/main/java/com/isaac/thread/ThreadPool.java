package com.isaac.thread;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 16:19 2018/2/2
 */
public interface ThreadPool<Job extends Runnable> {
    //执行一个job工作
    void execute(Job job);
    //关闭线程池
    void shutdown();
    //增加worker
    void addWorkers(int num);
    //删除worker
    void removeWorker(int num);
    //获取等待执行的任务数量
    int getJobSize();
}

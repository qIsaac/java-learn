package com.isaac.thread;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 9:25 2017/10/19
 *
 *
 * 1.当一个变量是“只读”时，变量的值不能直接改变，但是可以在其它变量发生改变的时候发生改变
 */
public class MyRunnable implements Runnable {
    private NoThreadSafe instance = null;

    public MyRunnable(NoThreadSafe instance) {
        this.instance = instance;
    }

    @Override
    public void run() {

    }
}

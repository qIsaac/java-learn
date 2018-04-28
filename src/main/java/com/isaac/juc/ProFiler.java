package com.isaac.juc;

import java.util.concurrent.TimeUnit;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 15:33 2018/2/1
 */
public class ProFiler {
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>(){
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };
    public static final void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws Exception {
        ProFiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: " + ProFiler.end() + " mills");
    }
}

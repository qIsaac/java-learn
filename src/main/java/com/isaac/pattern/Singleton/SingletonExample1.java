package com.isaac.pattern.Singleton;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 10:56 2018/8/27
 */
public class SingletonExample1 {
    private SingletonExample1() {

    }
    public static SingletonExample1 getInstance() {
        return Singleton.INSTANCE.getSingletonExample1();
    }
    private enum Singleton {
        INSTANCE;

        private SingletonExample1 singletonExample1;

        Singleton() {
            singletonExample1 = new SingletonExample1();
        }

        public SingletonExample1 getSingletonExample1() {
            return singletonExample1;
        }
    }
}

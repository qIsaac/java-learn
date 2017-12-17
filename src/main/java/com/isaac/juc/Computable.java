package com.isaac.juc;

/**
 * Created by Isaac on 2017/12/10.
 */
public interface Computable<A,V> {
    V compute(A arg) throws InterruptedException;
}

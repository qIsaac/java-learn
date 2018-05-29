package com.isaac.Java8.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 14:46 2018/5/29
 */
public class Fibonacci {
    private final Map<Integer, Long> cache ;

    public Fibonacci() {
        cache = new HashMap<>();
        cache.put(0, 0L);
        cache.put(1, 1L);
    }
    public  long fibonacci(int x){
        return cache.computeIfAbsent(x, n -> fibonacci(n-1)+fibonacci(n-2));
    }
}

package com.isaac.guava.base;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 18:12 2018/7/25
 */
@Slf4j
public class OptionalTest {
    public static void main(String[] args) {
        Integer value1 = null;
        Integer value2 = new Integer(10);
        Optional<Integer> a = Optional.ofNullable(value1);
        log.info("a is:{}",a.isPresent() ? a.get(): "null");
        Optional<Integer> b = Optional.of(value2);

        log.info("Sum : {}",sum(a,b).toString());
    }

    public static Integer sum(Optional<Integer> a, Optional<Integer> b) {
        log.info("First parameter is present:{}", a.isPresent());
        log.info("Second parameter is present:{}", b.isPresent());
        Integer value1 = a.orElse(new Integer(0));
        Integer value2 = b.get();
        return value1 + value2;
    }
}

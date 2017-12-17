package com.isaac.thread;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 9:21 2017/10/19
 */
public class NoThreadSafe {
    StringBuilder builder = new StringBuilder();

    public void add(String text) {
        this.builder.append(text);
    }
}

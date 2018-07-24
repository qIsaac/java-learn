package com.isaac.pattern.proxy;


/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 10:11 2018/7/24
 */
public class Wizard {
    private final String name;

    public Wizard(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

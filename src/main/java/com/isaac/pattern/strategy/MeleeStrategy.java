package com.isaac.pattern.strategy;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 9:12 2017/12/15
 */
public class MeleeStrategy implements DragonSlayingStrategy {

    public void execute() {
        System.out.println("Melee ..........");
    }
}

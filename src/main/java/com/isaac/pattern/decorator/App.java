package com.isaac.pattern.decorator;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 17:22 2017/12/13
 */
public class App {
    public static void main(String[] args) {
        Troll troll = new SimpleTroll();
        int power = troll.getAttackPower();
        System.out.println(power);
        troll = new ClubbedTroll(troll);
        int doublePower =  troll.getAttackPower();
        System.out.println(doublePower);
    }
}

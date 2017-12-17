package com.isaac.pattern.decorator;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 17:19 2017/12/13
 */
public class ClubbedTroll implements Troll {
    private Troll troll;

    public ClubbedTroll(Troll troll) {
        this.troll = troll;
    }

    public void attack() {

    }

    public int getAttackPower() {
        return troll.getAttackPower()+10;
    }

    public void fleeBattle() {

    }
}

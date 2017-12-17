package com.isaac.pattern.strategy;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 9:18 2017/12/15
 */
public class APP {
    public static void main (String [] args) {
        DragonSlayer dragonSlayer = new DragonSlayer(new MeleeStrategy());
        dragonSlayer.gotoBattle();
        dragonSlayer.chageStrategy(new ProjectileStrategy());
        dragonSlayer.gotoBattle();
    }
}

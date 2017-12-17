package com.isaac.pattern.strategy;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 9:15 2017/12/15
 */
public class DragonSlayer {
    private DragonSlayingStrategy dragonSlayingStrategy;

    public DragonSlayer(DragonSlayingStrategy dragonSlayingStrategy) {
        this.dragonSlayingStrategy = dragonSlayingStrategy;
    }
    public void chageStrategy(DragonSlayingStrategy dragonSlayingStrategy){
        this.dragonSlayingStrategy = dragonSlayingStrategy;
    }
    public void gotoBattle(){
        dragonSlayingStrategy.execute();
    }
}

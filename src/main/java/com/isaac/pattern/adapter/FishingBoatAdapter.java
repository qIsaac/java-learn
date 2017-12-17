package com.isaac.pattern.adapter;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 16:39 2017/12/13
 */
public class FishingBoatAdapter implements RowingBoat {
    private FishingBoat fishingBoat;

    public FishingBoatAdapter() {
        this.fishingBoat = new FishingBoat();
    }

    public void row() {
        fishingBoat.sail();
    }
}

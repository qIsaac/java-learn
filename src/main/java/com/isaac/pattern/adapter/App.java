package com.isaac.pattern.adapter;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 16:43 2017/12/13
 */
public class App {
    public static void main(String[] args){
        FishingBoatAdapter fishingBoatAdapter = new FishingBoatAdapter();
        Captain captain = new Captain(fishingBoatAdapter);
        captain.row();
    }
}

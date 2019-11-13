package com.isaac.example;

import java.util.ArrayList;
import java.util.List;

public final class MyCollection {
    private List<Collectable> myStuff;

    public MyCollection() {
        this.myStuff = new ArrayList<>();
    }
    public void add(String s,int yb,int ym, int pp){
        Item item = new Model(yb,ym,pp,s);
        myStuff.add(item);
    }
    public void add (Collectable collectable){
        myStuff.add(collectable);
    }

    public void printStatus(int thisYear){
        String str = new String();
        for (Collectable collectable : myStuff) {
            Item item = (Item) collectable;
            str = item.getLabel() + ": cost me $" + item.getProcePaid();
            int worth = item.currentWorth(thisYear);
            str += ", now worth $" + worth + ".";
            if (worth <= 0) {
                str += "\n * Lost all its value: get rid of it! *";
            }else if (worth < item.getProcePaid()) {
                str += "\n - Lost sone value - ";
            }
            System.out.println(str);
        }
    }

    public void cleanOutRubbish(int thisyear, int minWorth) {

        ArrayList<Collectable> newMyStuff = new ArrayList<Collectable>();

        for (Collectable col : myStuff) {

            Item it = (Item) col;

            int worth = it.currentWorth(thisyear);

            if (worth >= minWorth)

                newMyStuff.add(col);
        }

        myStuff = newMyStuff;
    }

    public Collectable findBiggestGain(int thisYear){
        Collectable item = null;
        return item;
    }
}

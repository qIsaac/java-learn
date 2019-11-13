package com.isaac.example;

public class Main {
    public static void main(String[] args) {
        MyCollection theStuff = new MyCollection();
        Collectable col1 = new MatchBoxCar(1990, 1970, 250,"Ford Capri",true);
        Collectable col2 = new Figurine(2002,2001,120,"China Cat");
        ((Figurine)col2).setNumCracks(5);
        Item col3 = new Model(2005,2004,5,"Unknown Thing");
        theStuff.add(col1);
        theStuff.add(col2);
        theStuff.add(col3);
        theStuff.printStatus(2007);
        theStuff.cleanOutRubbish(2001,2010);
        theStuff.printStatus(2007);
    }
}

package com.isaac.example;

public class Model extends Item {

    public Model(int yearBought, int yearMade, int procePaid, String label) {
        super(yearBought, yearMade, procePaid, label);
    }

    @Override
    public int currentWorth(int thisYear) {
        return procePaid + ( yearBought - thisYear);
    }

    @Override
    public int insurableValue(int thisYear) {
        return procePaid;
    }
}

package com.isaac.example;

public class MatchBoxCar extends Model {

    private boolean stillInBox;

    public MatchBoxCar(int yearBought, int yearMade, int procePaid, String label, boolean inBox) {
        super(yearBought, yearMade, procePaid, label);
        stillInBox = inBox;
    }

    @Override
    public int currentWorth(int thisYear) {
        double increase = 0.0D;
        if (stillInBox){
            increase = getProcePaid() / 10;
        } else {
            increase = -getProcePaid() /100;
        }
        return (int) increase * (thisYear - yearMade);
    }

    @Override
    public int insurableValue(int thisYear) {
        if (stillInBox) {
            return procePaid * (thisYear - yearMade);
        }
        return procePaid;
    }
}

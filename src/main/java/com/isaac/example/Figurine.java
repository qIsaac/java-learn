package com.isaac.example;

public class Figurine extends Item {
    protected int numCracks;


    public Figurine(int yearBought, int yearMade, int procePaid, String label) {
        super(yearBought, yearMade, procePaid, label);
        numCracks = 0;
    }

    public void setNumCracks(int numCracks) {
        this.numCracks = numCracks;
    }

    @Override
    public int currentWorth(int thisYear) {
        double value = (thisYear - getYearBought()) /10;
        return (int) ((double)getProcePaid() * value ) - 10 * numCracks;
    }

    @Override
    public int insurableValue(int thisYear) {
        return Math.max(procePaid - 10 *numCracks ,0);
    }


}

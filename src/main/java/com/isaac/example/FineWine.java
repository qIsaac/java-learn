package com.isaac.example;

public class FineWine extends Item {
    protected String type;
    protected String vineYard;

    public FineWine(int yearBought, int yearMade, int procePaid, String label, String type, String vineYard) {
        super(yearBought, yearMade, procePaid, label);
        this.type = type;
        this.vineYard = vineYard;
    }

    @Override
    public int currentWorth(int thisYear) {
        return super.currentWorth(thisYear);
    }

    @Override
    public int insurableValue(int thisYear) {
        return super.insurableValue(thisYear);
    }
}

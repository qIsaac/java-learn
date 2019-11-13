package com.isaac.example;

public class Item implements Collectable {

    protected int yearBought;
    protected int yearMade;
    protected int procePaid;
    protected String label;

    public Item(int yearBought, int yearMade, int procePaid, String label) {
        this.yearBought = yearBought;
        this.yearMade = yearMade;
        this.procePaid = procePaid;
        this.label = label;
    }

    public int getYearBought() {
        return yearBought;
    }

    public int getYearMade() {
        return yearMade;
    }

    public int getProcePaid() {
        return procePaid;
    }

    public String getLabel() {
        return label;
    }

    public void setYearBought(int yb){
        assert yearBought > 0;
        yearBought = yb;

    }

    public void setProcePaid(int pp){
        assert pp > 0;
        procePaid = pp;

    }

    public void setYearMade(int yearMade) {
        assert yearMade > 0;
        this.yearMade = yearMade;
    }

    @Override
    public int currentWorth(int thisYear) {
        return procePaid;
    }

    public int insurableValue(int thisYear){
        return procePaid;
    }
}

package com.isaac.pattern.adapter;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 16:33 2017/12/13
 */
public class Captain implements RowingBoat {
    private RowingBoat rowingBoat;

    public Captain(RowingBoat rowingBoat) {
        this.rowingBoat = rowingBoat;
    }

    public void row() {
        rowingBoat.row();
    }
}

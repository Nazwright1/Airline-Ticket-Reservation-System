/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinereserve;

/**
 *
 * @author nazwright
 */
public class First extends Business{
    private boolean hasWine;

    public First(){
        hasWine = false;
        setAisleSeat(false);
        setHasSnack(false);
        setWindowSeat(false);
    }
    public boolean isHasWine() {
        return hasWine;
    }

    public void setHasWine(boolean hasWine) {
        this.hasWine = hasWine;
    }
}


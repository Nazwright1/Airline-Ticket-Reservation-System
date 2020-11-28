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
public class Economy {
    private boolean isAisleSeat;
    private boolean isWindowSeat;

    public Economy(){
        setAisleSeat(false);
        setWindowSeat(false);
    }

    public boolean isAisleSeat() {
        return isAisleSeat;
    }

    public void setAisleSeat(boolean aisleSeat) {
        isAisleSeat = aisleSeat;
    }

    public boolean isWindowSeat() {
        return isWindowSeat;
    }

    public void setWindowSeat(boolean windowSeat) {
        isWindowSeat = windowSeat;
    }
}

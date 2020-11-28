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
import java.util.ArrayList;

public class Business extends Economy {
   private boolean hasSnack;
   private ArrayList<Snack> Snacks;

   public Business(){
       setAisleSeat(false);
       setWindowSeat(false);
       hasSnack = false;

   }
    public boolean isHasSnack() {
        return hasSnack;
    }

    public void setHasSnack(boolean hasSnack) {
        this.hasSnack = hasSnack;
    }
    public int getNumSnacks(){
       return Snacks.size();
    }
    public Snack getSnack(int index){
        return Snacks.get(index);
    }
    public void setSnack(int index, Snack snack){
       Snacks.add(index, snack);
    }
    public void addSnack(Snack snack){
       Snacks.add(snack);
    }
}

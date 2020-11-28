/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinereserve;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author nazwright
 */
public class AirlineReserve {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Dashboard dash = new Dashboard();
        dash.setDefaultCloseOperation(EXIT_ON_CLOSE);
        dash.setVisible(true);
    }
    
}

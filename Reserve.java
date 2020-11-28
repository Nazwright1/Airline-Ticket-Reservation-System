/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinereserve;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author nazwright
 */
public class Reserve extends JFrame {
 Utility info;
 int numSeats;
 int numRows;
 int rowNumber;
 int seatLetter;
 final Map<Point, Passenger> seats;
 DefaultListModel addedlistModel;
 DefaultListModel deflistModel;
 Object prviousSelect;
 String currVal;
//set a person  
//seats.put(new Point(a,b), myPerson);
//get a person
//myPerson = seats.get(new Point(a,b));
    /**
     * Creates new form ReserveTicket
     */
    public Reserve() {
        initComponents();
        info = new Utility();
        numSeats = 30;
        // three seats A, B, C
        numRows = numSeats / 3;
        this.seats = new HashMap<>();
        classSelections.removeAllItems();
        classSelections.addItem("--------");
        classSelections.addItem("First");
        classSelections.addItem("Business");
        classSelections.addItem("Economy");
        addedlistModel = new DefaultListModel();
        deflistModel = new DefaultListModel();
        deflistModel.addElement("");
        availJList.setModel(deflistModel);
        
        addedJList.clearSelection();
        
    }
    
    public void clearFields(){
        for (Component C : redPanel.getComponents())
         {    
         if (C instanceof JTextField || C instanceof JTextArea){

          ((JTextComponent) C).setText(""); //abstract superclass
         }
      }
    }
    
    // Exception Handler 
    
    public class TCAirplaneFullException extends Exception { 
        public TCAirplaneFullException(String errorMessage) {
            super(errorMessage);
        }
    }
    
    public void returnTicket(int row, int seatLet){
        String message;
        Passenger seat = seats.get(new Point(row, seatLet));
        if(seat == null){
            message = "Error: Seat at row " + row + " , seat " + seatLet + " is Empty.";
            JOptionPane.showMessageDialog(null, message);
        }
        else{
            // return the seat
            seat = null;
            message = "Success!: Seat at row " + row + " , seat " + seatLet + " returned.";
            JOptionPane.showMessageDialog(null, message);
        }
    }
    
    
    
    public void PurchaseTicket() throws TCAirplaneFullException{
       String message;
        // if Airplane is full
       if(seats.size() == numSeats ){
           throw new TCAirplaneFullException("AirPlane is Full!!");
       }
       
       int rowNumber = Integer.parseInt(aisleLet.getText());
       if( rowNumber > numRows || rowNumber < 1 ){
           message = "Row number must be 1-10";
           JOptionPane.showMessageDialog(null, message);
           clearFields();
           return;
       }
       int seatLetter = getSeatLetter(seatLet.getText());
       if( seatLetter > 3 || seatLetter < 1 ){
           message = "Seat letter must be A, B, or C";
           JOptionPane.showMessageDialog(null, message);
           clearFields();
           return;
       }
       
       Passenger seat = seats.get(new Point(rowNumber , seatLetter));
       if(seat == null){
           
           Passenger passenger = new Passenger();
           Economy flightClass;
           Object classType = classSelections.getSelectedItem();
           String classT = classType.toString();
           // the addons from this customer such as the cookies, snacks, aisle seat
           ListModel<String> preferences = addedJList.getModel();
           int i; 
           
           passenger.setCustomerName(jTextField1.getText());
           Ticket ticket = new Ticket();
           ticket.setStartingCity(jTextField2.getText());
           ticket.setDestination(jTextField3.getText());
           ticket.setFlightNumber(jTextField4.getText());
           ticket.setDepartureDate(departDate.getText());
           ticket.setDepartureTime(departTime.getText());
           passenger.setTicket(ticket);
           seats.put(new Point(rowNumber ,seatLetter), passenger);
            message = "Success: Seat Booked at row " + aisleLet.getText() + ", seat"
                  + seatLet.getText() + " by customer: " + passenger.getCustomerName();
           JOptionPane.showMessageDialog(null, message);
           // now fill text area with information here...
           
           detailsTextArea.setText("Previous Flight Details:\n" + 
                   "Customer: " + passenger.getCustomerName() + "\n" + 
                   "Starting City: " + passenger.getTicket().getStartingCity()+ "\n"+
                   "Destination: " + passenger.getTicket().getDestination() + "\n" +
                   "Flight Number: " + passenger.getTicket().getFlightNumber() + "\n"+
                   "Departure Date: " + passenger.getTicket().getDepartureDate() + "\n" + 
                   "Departure Time: " + passenger.getTicket().getDepartureTime() 
                   
                   );
           //detailsTextArea
           clearFields();
       }
       // seat already taken
       else{
           //display joptionpane message (seat filled by: seat.getCustomerName) choose another please
           //then clear aisleLet and seatNum
           message = "Error: Seat Taken at row " + aisleLet.getText()
                  + seatLet.getText() + " by customer: " + seat.getCustomerName()
                   + "\n Please enter another seat.";
           JOptionPane.showMessageDialog(null, message);
           aisleLet.setText("");
           seatLet.setText("");
           
       }

    }
    
   
    
    
    public int getSeatLetter(String seatLetter){
       int letter = 0;
      switch(seatLetter){
          case "A":
              letter = Aisle.AISLE_A;
              break;
          case "B":
              letter = Aisle.AISLE_B;
              break;
          case "C":
              letter = Aisle.AISLE_C;
              break;
          default:
           String message = "Please enter valid seat letter. A-C";
           JOptionPane.showMessageDialog(null, message);
           seatLet.setText("");
           
      }
      return letter;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        redPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        departDate = new javax.swing.JTextField();
        departTime = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        aisleLet = new javax.swing.JTextField();
        classSelections = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        availJList = new javax.swing.JList<>();
        seatLet = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        addedJList = new javax.swing.JList<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        detailsTextArea = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1055, 735));

        redPanel.setBackground(new java.awt.Color(255, 51, 51));

        jLabel3.setText("Customer:");

        jLabel4.setText("Departure:");

        jLabel5.setText("Arrival:");

        jLabel6.setText("Flight No.");

        jLabel7.setText("Class:");

        jLabel8.setText("Departure Date:");

        jLabel9.setText("Departure Time:");

        departDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departDateActionPerformed(evt);
            }
        });

        jLabel11.setText("Seat:");

        classSelections.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        classSelections.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                classSelectionsItemStateChanged(evt);
            }
        });
        classSelections.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classSelectionsActionPerformed(evt);
            }
        });

        availJList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        availJList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                availJListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(availJList);

        jLabel12.setText("Row");

        jLabel13.setText("Seat Letter");

        addedJList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(addedJList);

        jLabel15.setText("Added Addons:");

        jLabel16.setText("Available Addons");

        jButton3.setText("add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout redPanelLayout = new javax.swing.GroupLayout(redPanel);
        redPanel.setLayout(redPanelLayout);
        redPanelLayout.setHorizontalGroup(
            redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(redPanelLayout.createSequentialGroup()
                .addGroup(redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addGroup(redPanelLayout.createSequentialGroup()
                        .addGroup(redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(redPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(44, 44, 44)
                                .addGroup(redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                    .addComponent(jTextField2)
                                    .addComponent(jTextField3)
                                    .addComponent(jTextField4)))
                            .addGroup(redPanelLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(departDate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(redPanelLayout.createSequentialGroup()
                                .addGroup(redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(redPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(34, 34, 34)
                                        .addComponent(jLabel13))
                                    .addComponent(departTime, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(redPanelLayout.createSequentialGroup()
                                        .addComponent(aisleLet, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addComponent(seatLet, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(classSelections, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(redPanelLayout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jLabel16))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, redPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(114, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, redPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(56, 56, 56))
        );
        redPanelLayout.setVerticalGroup(
            redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(redPanelLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addGroup(redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(redPanelLayout.createSequentialGroup()
                        .addGroup(redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(departDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(departTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(classSelections, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(aisleLet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seatLet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)))
                    .addGroup(redPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        detailsTextArea.setColumns(20);
        detailsTextArea.setRows(5);
        jScrollPane3.setViewportView(detailsTextArea);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );

        jButton1.setText("Reserve");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Flight Details");

        jLabel2.setFont(new java.awt.Font("Kohinoor Devanagari", 0, 18)); // NOI18N
        jLabel2.setText("Add Flight Information");

        jLabel10.setText("Enter Customer Reservation Information");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(203, 203, 203))
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(redPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(39, 39, 39)
                                .addComponent(jButton2))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(9, 9, 9)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(redPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     try {
         // TODO add your handling code here:
         PurchaseTicket();
     } catch (TCAirplaneFullException ex) {
         Logger.getLogger(Reserve.class.getName()).log(Level.SEVERE, null, ex);
     }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void classSelectionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classSelectionsActionPerformed
        // TODO add your handling code here:
        

    }//GEN-LAST:event_classSelectionsActionPerformed

    private void departDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_departDateActionPerformed

    private void classSelectionsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_classSelectionsItemStateChanged
        // TODO add your handling code here:
        Object selected = classSelections.getSelectedItem();
        if(selected == null){
            return;
        }
        
        DefaultListModel listModel;
        listModel = new DefaultListModel();
        if(selected.toString().equals("First")){
            
            listModel.addElement("Wine");
            listModel.addElement("Aisle Seat");
            listModel.addElement("Window Seat");
            listModel.addElement("Cookie");
            listModel.addElement("Nuts");
            
        }

        else if(selected.toString().equals("Business")){
            listModel.addElement("Aisle Seat");
            listModel.addElement("Window Seat");
            listModel.addElement("Cookie");
            listModel.addElement("Nuts");
        }
        else if(selected.toString().equals("Economy")){
            listModel = new DefaultListModel();
            listModel.addElement("Aisle Seat");
            listModel.addElement("Window Seat");
            
        }
        else{
            listModel.addElement("");
        }
       availJList.setModel(listModel);
       
    }//GEN-LAST:event_classSelectionsItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        if(currVal == null){
            return;
        }
        addedlistModel.addElement(currVal);
        addedJList.setModel(addedlistModel);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void availJListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_availJListValueChanged
        // TODO add your handling code here:
        Object selected = availJList.getSelectedValue();
        if(selected == null){
            return;
        }
        currVal = (String)selected;
    }//GEN-LAST:event_availJListValueChanged

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Object selected = availJList.getSelectedValue();
        if(selected == null){
            return;
        }
        addedlistModel.removeAllElements();;
        addedJList.setModel(addedlistModel);
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> addedJList;
    private javax.swing.JTextField aisleLet;
    private javax.swing.JList<String> availJList;
    private javax.swing.JComboBox<String> classSelections;
    private javax.swing.JTextField departDate;
    private javax.swing.JTextField departTime;
    private javax.swing.JTextArea detailsTextArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JPanel redPanel;
    private javax.swing.JTextField seatLet;
    // End of variables declaration//GEN-END:variables
}

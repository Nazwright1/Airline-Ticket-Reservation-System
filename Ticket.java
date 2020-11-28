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
public class Ticket {
    private String departureTime;
    private String flightNumber;
    private String flightClass;
    private String startingCity;
    private String destination;
    private String departureDate;
    private double totalCharge;
    String[] days = {"Monday","Tuesday", "Wednesday", "Thursday", "Friday","Saturday", "Sunday" };
    /**
     * @return the departureTime
     */
    public String getDepartureTime() {
        return departureTime;
    }

    /**
     * @param departureTime the departureTime to set
     */
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    /**
     * @return the flightNumber
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * @param flightNumber the flightNumber to set
     */
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    /**
     * @return the flightClass
     */
    public String getFlightClass() {
        return flightClass;
    }

    /**
     * @param flightClass the flightClass to set
     */
    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    /**
     * @return the startingCity
     */
    public String getStartingCity() {
        return startingCity;
    }

    /**
     * @param startingCity the startingCity to set
     */
    public void setStartingCity(String startingCity) {
        this.startingCity = startingCity;
    }

    /**
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * @return the totalCharge
     */
    public double getTotalCharge() {
        return totalCharge;
    }

    /**
     * @param totalCharge the totalCharge to set
     */
    public void setTotalCharge(double totalCharge) {
        this.totalCharge = totalCharge;
    }

    /**
     * @return the departureDate
     */
    public String getDepartureDate() {
        return departureDate;
    }

    /**
     * @param departureDate the departureDate to set
     */
    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }
    public String getDay(int day){
        return days[day];
    }
}

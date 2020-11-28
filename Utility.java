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
public class Utility {
    
    public Utility(){
        cookieCost = 5.00;
        wineCost = 12.00;
        nutCost = 5.00;
        businessPrice = 200.00;
        firstPrice = 300.00;
        economyPrice = 100.00;
        basePrice = 200.00;
    }
    
    private double cookieCost;
    private double wineCost;
    private double nutCost;
    private double businessPrice;
    private double firstPrice;
    private double economyPrice;
    private double basePrice; 

    /**
     * @return the cookieCost
     */
    public double getCookieCost() {
        return cookieCost;
    }

    /**
     * @param cookieCost the cookieCost to set
     */
    public void setCookieCost(double cookieCost) {
        this.cookieCost = cookieCost;
    }

    /**
     * @return the wineCost
     */
    public double getWineCost() {
        return wineCost;
    }

    /**
     * @param wineCost the wineCost to set
     */
    public void setWineCost(double wineCost) {
        this.wineCost = wineCost;
    }

    /**
     * @return the nutCost
     */
    public double getNutCost() {
        return nutCost;
    }

    /**
     * @param nutCost the nutCost to set
     */
    public void setNutCost(double nutCost) {
        this.nutCost = nutCost;
    }

    /**
     * @return the businessPrice
     */
    public double getBusinessPrice() {
        return businessPrice;
    }

    /**
     * @param businessPrice the businessPrice to set
     */
    public void setBusinessPrice(double businessPrice) {
        this.businessPrice = businessPrice;
    }

    /**
     * @return the firstPrice
     */
    public double getFirstPrice() {
        return firstPrice;
    }

    /**
     * @param firstPrice the firstPrice to set
     */
    public void setFirstPrice(double firstPrice) {
        this.firstPrice = firstPrice;
    }

    /**
     * @return the economyPrice
     */
    public double getEconomyPrice() {
        return economyPrice;
    }

    /**
     * @param economyPrice the economyPrice to set
     */
    public void setEconomyPrice(double economyPrice) {
        this.economyPrice = economyPrice;
    }

    /**
     * @return the basePrice
     */
    public double getBasePrice() {
        return basePrice;
    }

    /**
     * @param basePrice the basePrice to set
     */
    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }
}

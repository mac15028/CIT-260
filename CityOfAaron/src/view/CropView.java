package view;

import model.*;
import control.*;
import java.util.Scanner;
import cityofaaron.CityOfAaron;
import exceptions.CropException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CropView {
    // Create a Scanner object
    private static Scanner keyboard = new Scanner(System.in);
    
    // Get references to the Game object and the CropData object
    private static Game theGame = CityOfAaron.getTheGame();
    private static CropData cropData = theGame.getCropData();
    
    /**
     * The buyLandView method
     * Purpose: interface with the user input for buying land
     * Parameters: none
     * Returns: none
     */
    public static void buyLandView() {
        // Get the cost of land for this round
        int price = CropControl.calcLandCost();
        
        // Prompt the user to enter the number of acres to buy
        System.out.format("\nLand may be purchased for %d bushels per acre.%n",price);
        int acresToBuy;
        boolean paramsNotOkay;
        // exception handling
        do {
            paramsNotOkay = false;
            System.out.print("How many acres of land do you wish to buy? ");
            acresToBuy = keyboard.nextInt();
            try {
                CropControl.buyLand(price, acresToBuy, cropData);
            }
            catch(CropException e) {
                System.out.println("I am sorry master, I cannot do this.");
                System.out.println(e.getMessage());
                paramsNotOkay = true;
            }
        } while(paramsNotOkay);
        
        // Output how much land we now own
        System.out.format("You now own %d acres of land.%n", cropData.getAcresOwned());
    }
    
    public static void sellLandView() {
        // Get the cost of land for this round
        int price = CropControl.calcLandCost();
        
        // Prompt the user to enter the number of acres to sell
        System.out.format("\nLand may be sold for %d bushels per acre.%n",price);
        int acresToSell;
        boolean paramsNotOkay;
        // exception handling
        do {
            paramsNotOkay = false;       
            System.out.print("How many acres of land do you wish to sell? ");
            acresToSell = keyboard.nextInt();
            try {
            CropControl.sellLand(price, acresToSell, cropData);
            }
            catch(CropException e) {
                System.out.println("I am sorry master, I cannot do this.");
                System.out.println(e.getMessage());
                paramsNotOkay = true;
            }
        } while(paramsNotOkay);
        
        // Output how much land we now own
        System.out.format("You now own %d acres of land.%n", cropData.getAcresOwned());
    }
    
    public static void feedPeopleView() {
        // Prompt the user to enter the amount of wheat to set aside
        System.out.format("\nYou have %d bushels of wheat in store. ", cropData.getWheatInStore());
        int wheatForPeople;
        boolean paramsNotOkay;
        // exception handling
        do {
            paramsNotOkay = false;
            System.out.print("\nHow much wheat would you like to set aside for food? ");
            wheatForPeople = keyboard.nextInt();
            try {
            CropControl.feedPeople(wheatForPeople, cropData);
            }
            catch(CropException e) {
                System.out.println("I am sorry master, I cannot do this.");
                System.out.println(e.getMessage());
                paramsNotOkay = true;
            }
        } while(paramsNotOkay);
        
        // Output how much wheat set aside
        System.out.format("You have set aside %d bushels of wheat.%n", cropData.getWheatForPeople());
    }
    
    public static void plantCropsView() {
        // Prompt the user to enter the amount of wheat to plant
        System.out.format("\nYou have %d bushels of wheat and own %d acres. ", cropData.getWheatInStore(), cropData.getAcresOwned());
        boolean paramsNotOkay;
        // exception handling
        do {
            paramsNotOkay = false;
            System.out.print("\nHow many acres would you like to plant? ");
            int acresPlanted = keyboard.nextInt();
            try {
                CropControl.plantCrops(acresPlanted, cropData);
            }
            catch(CropException e) {
                System.out.println("I am sorry master, I cannot do this.");
                System.out.println(e.getMessage());
                paramsNotOkay = true;
            }
        } while(paramsNotOkay);
        
        // Output how many acres are planted
        System.out.format("You have planted %d acres of wheat.%n", cropData.getAcresPlanted());
    }
    
    public static void setOfferingView() {
        boolean paramsNotOkay;
        // exception handling
        do {
            paramsNotOkay = false;
            // prompt the user for input
            System.out.print("\nWhat percent of your harvest would you like give as an offering? ");
            int offering = keyboard.nextInt();
            try {
                CropControl.setOffering(offering, cropData);
            }
            catch(CropException e) {
                System.out.println("I am sorry master, I cannot do this.");
                System.out.println(e.getMessage());
                paramsNotOkay = true;
            }
        } while(paramsNotOkay);
        
        System.out.format("You have offered %d percent of your harvest.%n", cropData.getOffering());
    }
    
    public static void harvestCropsView() {
        // call the harvestCrops() method
        System.out.print("\nHarvesting crops...");
        CropControl.harvestCrops(cropData);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(CropView.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.print("\nDone.\n");
    }
    
    public static void payOfferingView() {
        // call the payOffering() method
        System.out.print("\nPaying offering...");
        CropControl.payOffering(cropData);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(CropView.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.print("\nDone.\n");
    }
        
    public static void storeWheatView() {
        // call the storeWheat() method
        System.out.print("\nStoring harvest...");
        CropControl.storeWheat(cropData);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(CropView.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.print("\nDone.\n");
    }
    
    public static void displayCropsReportView() {
        System.out.print("\nGenerating annual report...");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ex) {
            Logger.getLogger(CropView.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.print("\nDone.\n\n");
        
        System.out.format("******************************\n"
                        + "*        End of Year %d       *\n" 
                        + "******************************\n", cropData.getYear());
        System.out.format("People starved: %d", cropData.getNumStarved());
        System.out.format("\nNew people: %d", cropData.getNewPeople());
        System.out.format("\nCurrent population: %d", cropData.getPopulation());
        System.out.format("\nAcres owned: %d", cropData.getAcresOwned());
        System.out.format("\nCrop yield per acre: %d bushels", cropData.getCropYield());
        System.out.format("\nHarvest amount: %d bushels", cropData.getHarvest());
        System.out.format("\nOffering amount: %d bushels", cropData.getOfferingBushels());
        System.out.format("\nNet harvest: %d bushels", cropData.getHarvestAfterOffering());
        System.out.format("\nEaten by rats: %d bushels", cropData.getEatenByRats());
        System.out.format("\nWheat in store: %d bushels\n", cropData.getWheatInStore());
        System.out.println("\nPress enter to continue.");
        try {
            System.in.read();
        }
        catch (java.io.IOException ioe) {
            System.out.println("I/O Exception: " +ioe);
        }
    }
    
    /**
     * The runCropsView method()
     * Purpose: runs the Hammurabi game
     * Parameters: none
     * Returns: none
     */
    public static void runCropsView() {
        // call the buyLandView() method
        buyLandView();
        
        // call the sellLandView() method
        sellLandView();
        
        // call the feedPeopleView() method
        feedPeopleView();
        
        // call the plantCropsView() method
        plantCropsView();
        
        // call the setOfferingView() method
        setOfferingView();
        
        // harvest the crops
        harvestCropsView();
        
        // pay the offering
        payOfferingView();
        
        // store the harvest
        storeWheatView();
        
        // calculate eaten by rats
        CropControl.calcEatenByRats(cropData);
        
        // grow the population
        CropControl.growPopulation(cropData);
        
        // calculate the number starved
        CropControl.calcStarved(cropData);
        
        // display the year-end report
        displayCropsReportView();
        
        // increment the year
        int year = cropData.getYear();
        year = year + 1;
        cropData.setYear(year);
    }
}

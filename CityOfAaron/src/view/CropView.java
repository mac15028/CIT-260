package view;

import model.*;
import control.*;
import java.util.Scanner;
import cityofaaron.CityOfAaron;
import exceptions.CropException;

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
    
    public static void displayCropsReportView() {
        
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
        
        // add calls to the other crop view methods
        // as they are written
    }
}

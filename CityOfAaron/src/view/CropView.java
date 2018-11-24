package view;

import model.*;
import control.*;
import java.util.Scanner;
import cityofaaron.CityOfAaron;

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
        System.out.format("Land is selling for %d bushels per acre.%n",price);
        System.out.print("How many acres of land do you wish to buy? ");
        
        // Get the user's input and save it
        int acresToBuy;
        acresToBuy = keyboard.nextInt();
        
        // Call the buyLand() method in the control layer to buy the land
        CropControl.buyLand(acresToBuy, price, cropData);
        
        // Output how much land we now own
        System.out.format("You now own %d acres of land. ", cropData.getAcresOwned());
    }
    
    public static void sellLandView() {
        // Get the cost of land for this round
        int price = CropControl.calcLandCost();
        
        // Prompt the user to enter the number of acres to sell
        System.out.format("Land is selling for %d bushels per acre.%n",price);
        System.out.print("How many acres of land do you wish to sell? ");
        
        // Get the user's input and save it
        int acresToSell;
        acresToSell = keyboard.nextInt();
        
        // Call the sellLand() method in the control layer to sell the land
        CropControl.sellLand(acresToSell, price, cropData);
        
        // Output how much land we now own
        System.out.format("You now own %d acres of land. ", cropData.getAcresOwned());
    }
    
    public static void feedPeopleView() {
        // Prompt the user to enter the amount of wheat to set aside
        System.out.format("You have %d bushels of wheat in store. ", cropData.getWheatInStore());
        System.out.print("How much would you like to set aside for food? ");
        
        // Get the user's input and save it
        int wheatForPeople;
        wheatForPeople = keyboard.nextInt();
        
        // Call the feedPeople() method in the control layer
        CropControl.feedPeople(wheatForPeople, cropData);
        
        // Output how much wheat set aside
        System.out.format("You have set aside %d bushels of wheat. ", cropData.getWheatForPeople());
    }
    
    public static void plantCropsView() {
        // Prompt the user to enter the amount of wheat to plant
        System.out.format("You have %d bushels of wheat and own %d acres. ", cropData.getWheatInStore(), cropData.getAcresOwned());
        System.out.print("How many acres would you like to plant? ");
        
        // Get the user's input and save it
        int acresPlanted = keyboard.nextInt();
        
        // Call the plantCrops() method in the control layer
        CropControl.plantCrops(acresPlanted, cropData);
        
        // Output how many acres are planted
        System.out.format("You have %d acres of wheat planted. ", cropData.getAcresPlanted());
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

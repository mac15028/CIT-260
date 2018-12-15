// The MainMenuView class - part of the view layer
// Object of this class manages the main menu
// Author: Taylor Mackintosh
// Date last modified: Nov 2018
//-------------------------------------------------------------
package view;

import cityofaaron.CityOfAaron;
import control.GameControl;
import model.Game;

public class MainMenuView extends MenuView{

    /**
    * The MainMenuView constructor
    * Purpose: Initialize the menu data
    * Parameters: none
    * Returns: none
    */
    // ===================================
    public MainMenuView ()
    {
        super( "\n" +
               "***********************************\n" +
               "*  CITY OF AARON: MAIN GAME MENU  *\n" +
               "***********************************\n" +
               " 1 - Start new game\n" +
               " 2 - Get and start a saved game\n" +
               " 3 - Get help on playing the game\n" +
               " 4 - Save game\n" +
               " 5 - Quit\n",
        5);
    }

    /**
    *The doAction method
    * Purpose: performs the selected action
    * @param option
    * Returns: none
    */
    // ===================================
    @Override public void doAction(int option) {
        switch (option) {
            case 1: // create and start a new game
                startNewGame();
                break;
            case 2: // get and start a saved game
                startSavedGame();
                break;
            case 3: // get help menu
                displayHelpMenuView();
                break;
            case 4: // save game
                displaySaveGameView();
                break;
            case 5:
                System.out.println("Thanks for playing ... goodbye.");
        }
    }
    
    /**
    * The startNewGame method
    * Purpose: creates game object and starts the game
    * Parameters: none
    * Returns: none
    */
    // =================================== 
    public void startNewGame() {
        // Display the Banner Page.
        System.out.println("\nWelcome to the City of Aaron.\n\n"
                         + "You have been summoned here by the high priest\n"
                         + "to assume your role as the ruler of the city\n"
                         + "Your responsibility is to buy and sell land,\n"
                         + "determine how much wheat to plant each year,\n"
                         + "and how much to feed your people. In addition,\n"
                         + "it will be your job to pay an annual tithe on\n"
                         + "the wheat that is harvested.\n\n"
                         + "If you fail to provide enough wheat for your\n"
                         + "people, they will starve, and your workforce\n"
                         + "will be diminished. Plan very carefully, or\n"
                         + "you may find yourself in trouble. Good luck!");
        
        // Prompt for and get the user's name
        String name;
        System.out.println("Please type in your first name: ");
        name = keyboard.next();
          
        // Call the createNewGame() method in the GameControl class
        // pass the name as a parameter
        GameControl.createNewGame(name);
          
        // Display a welcome message
        System.out.println("\nWelcome, " + name + ". Have fun!");
        
        // Display the Game menu
        GameMenuView gmv = new GameMenuView();
        gmv.displayMenu();
    }

    /**
     * The startSavedGame method
     * Purpose: loads a saved game object from disk and start the game
     */
    public void startSavedGame() {
        // get rid of \n character left in the stream
        keyboard.nextLine();
        
        // prompt user and get a file path
        System.out.println("Enter the path to your saved game: ");
        String filePath = keyboard.next();
        
        // call the getSavedGame() method in the GameControl class to load the game
        GameControl.getSavedGame(filePath);
        
        // display the game menu for the loaded game
        GameMenuView gmv = new GameMenuView();
        gmv.displayMenu();
    }

    public void displayHelpMenuView() {
        HelpMenuView hmv = new HelpMenuView();
        hmv.displayMenu();
    }

    /**
     * The displaySaveGameView method
     * Purpose: saves a game object to disk
     */
    public void displaySaveGameView() {
        // System.out.println("Save game option selected.");
        
        // get rid of \n character left in the stream
        keyboard.nextLine();
        
        // prompt user and get a file path
        System.out.println("Enter a file name to save the game to: ");
        String filePath = keyboard.next();
        
        Game theGame = CityOfAaron.getTheGame();
        
        // call the saveGame() method in the GameControl class to save the game
        GameControl.saveGame(theGame, filePath);
    }
}

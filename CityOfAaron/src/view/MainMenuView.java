// The MainMenuView class - part of the view layer
// Object of this class manages the main menu
// Author: Taylor Mackintosh
// Date last modified: Nov 2018
//-------------------------------------------------------------
package view;

import java.util.Scanner;
import cityofaaron.CityOfAaron;
import control.GameControl;

public class MainMenuView {
    Scanner keyboard = new Scanner(System.in);
    
    private String theMenu;
    private int max;
    
    /**
    * The MainMenuView constructor
    * Purpose: Initialize the menu data
    * Parameters: none
    * Returns: none
    */
    // ===================================
    public MainMenuView() {
        theMenu = "\n" +
        "**********************************\n" +
        "* CITY OF AARON: MAIN GAME MENU *\n" +
        "**********************************\n" +
        " 1 - Start new game\n" +
        " 2 - Get and start a saved game\n" +
        " 3 - Get help on playing the game\n" +
        " 4 - Save game\n" +
        " 5 - Quit\n";
        max = 5;
    }

    /**
    * The displayMenu method
    * Purpose: displays the menu, gets the user's input, and does the
    * selected action
    * Parameters: none
    * Returns: none
    */
    // =========================================================

    public void displayMenu() {
        int menuOption;
        do {
            // Display the menu
            System.out.println(theMenu);

            // Prompt the user and get the user’s input
            menuOption = getMenuOption();

            // Perform the desired action
            doAction(menuOption);

            // Determine and display the next view       
        } while (menuOption != max);
    }

    /**
    * The getMenuOption method
    * Purpose: gets the user's input
    * Parameters: none
    * Returns: integer - the option selected
    */
    // ===================================
    public int getMenuOption() {
        // declare a variable to hold user’s input
        int userInput;

        // begin loop
        do {
            // get user input from the keyboard
            userInput = keyboard.nextInt();

            // if it is not a valid value, output an error message
            if (userInput < 1 || userInput > max) {
                System.out.println("Option must be between 1 and " + max);
            }

        // loop back to the top if input was not valid
        } while(userInput < 1 || userInput > max);

        // return the value input by the user
        return userInput;
    }

    /**
    *The doAction method
    * Purpose: performs the selected action
    * Parameters: none
    * Returns: none
    */
    // ===================================
    public void doAction(int option) {
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
        System.out.println("Welcome to the city of Aaron./n"
                + "You have been summoned here by the High Priest to assume your role as ruler of the city./n"
                + "Your responsibility is to buy and sell land, determine how much wheat to plant each year, and how much to set aside to feed your people./n"
                + "In addition, it will be your job to pay an annual tithe on the wheat that is harvested./n"
                + "If you fail to provide enough wheat for the people, people will starve,  some people will die, and your workforce will be diminished./n"
                + "Plan carefully.");
        
        // Prompt for and get the user's name
        String name;
        System.out.println("Please type in your first name: ");
        name = keyboard.next();
          
        // Call the createNewGame() method in the GameControl class
        // pass the name as a parameter
        GameControl.createNewGame(name);
          
        // Display a welcome message
        System.out.println("Welcome " + name + " have fun!");
        
        // Display the Game menu
          
    }

    public void startSavedGame() {
        System.out.println("Start saved game option selected.");
    }

    public void displayHelpMenuView() {
        System.out.println("Help menu option selected.");
    }

    public void displaySaveGameView() {
        System.out.println("Save game option selected.");
    }
}

package view;

import java.util.Scanner;
import model.Game;

public class GameMenuView {
    Scanner keyboard = new Scanner(System.in);
    private String gameMenu;
    private static Game Game = null;
    private int max;

    public GameMenuView() {
        gameMenu = "\n" +
        "GAME MENU VIEW\n" +
        "1 - View the map\n" +
        "2 - View the list\n" +
        "3 - Move to a new location\n" +
        "4 - Manage crops\n" +
        "5 - Exit to main menu";
        max = 5;
    }
    
    public void displayMenuView() {
        int menuOption;
        do {
            // display the menu
            System.out.println(gameMenu);
            
            // get the user's selection
            menuOption = getMenuOption();
            
            // perform the selected action
            doAction(menuOption);
        } while (menuOption != max);
    } // end of displayMenuView method
    
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
    
    public void doAction(int option) {
        switch (option) {
            case 1: // view the map
                viewMap();
                break;
            case 2: // view the list
                viewList();
                break;
            case 3: // move to new location
                moveToNewLocation();
                break;
            case 4: // manage crops
                manageCrops();
                break;
            case 5: // return to main menu
                return;
        }
    }
    
    public void viewMap() {
        System.out.println("Map view selected.");
    }
    
    public void viewList() {
        ListMenuView lmv = new ListMenuView();
        lmv.displayMenuView();
    }
    
    public void moveToNewLocation() {
        System.out.println("Move to new location selected.");
    }
    
    public void manageCrops() {
        System.out.println("Manage crops selected.");
    }
}


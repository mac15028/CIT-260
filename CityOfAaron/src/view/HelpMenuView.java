package view;

import java.util.Scanner;

public class HelpMenuView {
    Scanner keyboard = new Scanner(System.in);
    private String helpMenu;
    private int max;
    
    public HelpMenuView() {
        helpMenu = "\n" +
        "Help Menu\n" + 
        "1 - View goals\n" + 
        "2 - View map help\n" +
        "3 - View move help\n" +
        "4 - View list help\n" +
        "5 - Exit to main menu";
        max = 5;
    }
    
    public void displayMenuView() {
        int menuOption;
        do {
            // display the menu
            System.out.println(helpMenu);
            
            // get the user's selection
            menuOption = getMenuOption();
            
            // perform the selected action
            doAction(menuOption);
        } while (menuOption != max);
    } // end of helpMenuView method
    
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
            case 1: // view goals
                viewGoals();
                break;
            case 2: // view map help
                viewMapHelp();
                break;
            case 3: // view move help
                viewMoveHelp();
                break;
            case 4: // view list help
                viewListHelp();
                break;
            case 5: // return to main menu
                return;
        }
    }
    
    public void viewGoals() {
        System.out.println("View goals selected.");
    }
    public void viewMapHelp() {
        System.out.println("View map help selected.");
    }
    public void viewMoveHelp() {
        System.out.println("View move help selected.");
    }
    public void viewListHelp() {
        System.out.println("View list help selected.");
    }
}

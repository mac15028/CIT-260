package view;

import java.util.Scanner;

public class ListMenuView {
    Scanner keyboard = new Scanner(System.in);
    private String listMenu;
    private int max;
    
    public ListMenuView() {
        listMenu = "\n" +
        "List Menu\n" +
        "1 - List animals\n" +
        "2 - List tools\n" +
        "3 - List provisions\n" +
        "4 - List team\n" +
        "5 - Return to game";
        max = 5;
    }
    public void displayMenuView() {
        int menuOption;
        do {
            // display the menu
            System.out.println(listMenu);
            
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
            case 1: // list animals
                listAnimals();
                break;
            case 2: // list tools
                listTools();
                break;
            case 3: // list provisions
                listProvisions();
                break;
            case 4: // list team
                listTeam();
                break;
            case 5: // return to game
                return;
        }
    }
    
    public void listAnimals() {
        System.out.println("List animals selected.");
    }
    
    public void listTools() {
        System.out.println("List tools selected.");
    }
    
    public void listProvisions() {
        System.out.println("List provisions selected.");
    }
    
    public void listTeam() {
        System.out.println("List team selected.");
    }
}

/**
 * The MenuView class - base abstract class for all menu views
 * Author: Taylor Mackintosh
 * Date last modified: Nov 2018
 */
package view;

import java.util.Scanner;

public abstract class MenuView implements ViewInterface{
    // the data members common to all menu views
    protected final static Scanner keyboard = new Scanner(System.in);
    
    protected String menu; // this string holds the menu string
    protected int max; // this int holds the max input value
    
    /**
     * MenuView Constructor
     * Purpose: Initialize the view object with the menu string
     * @param _menu
     * @param _max
     */
    public MenuView(String _menu, int _max){
        this.menu = _menu;
        this.max = _max;
    }
    
   /**
    * The displayMenu method
    * Purpose: displays the menu, gets the user's input, and does the
    * selected action
    * Parameters: none
    * Returns: none
    */
    // =========================================================
    @Override public void displayMenu() {
        int menuOption;
        do {
            // display the menu
            System.out.println(menu);

            // get the user's selection
            menuOption = getMenuOption();

            // perform the selected action
            doAction(menuOption);     
        } while (menuOption != max);
    }
    
   /**
    * The getMenuOption method
    * Purpose: gets the user's input
    * Parameters: none
    * Returns: integer - the option selected
    */
    // ===================================
    @Override public int getMenuOption() {
        int inputValue;
        do {
            System.out.format("Please enter an option (1 - %d):", max);
            inputValue = keyboard.nextInt();
            if (inputValue < 1 || inputValue > max) {
                System.out.format("Option must be between 1 and %d.", max);
            }
        } while(inputValue < 1 || inputValue > max);

        return inputValue;
    }
}

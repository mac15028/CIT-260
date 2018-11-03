/*
* The main() class file for the cityOfAaron project
* CIT-260
* Fall 2018
* Team members: Taylor Mackintosh
*/
package cityofaaron;

import model.Game;
import view.*;

public class CityOfAaron {
    // variable for keeping a reference to the Game object;
    private static Game Game = null;
    
    // main function - entry point for the program
    // runs the main menu
    public static void main(String[] args) {
        MainMenuView mmv = new MainMenuView();
        mmv.displayMenu();
    }

    public static Game getGame() {
        return Game;
    }

    public static void setGame(Game Game) {
        CityOfAaron.Game = Game;
    }
    
}
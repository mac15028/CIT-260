/**
* Source code for the GameControl class
* The GameControl class is a member of the control layer
* Methods in the GameControl class manage Game objects
* Author: Taylor Mackintosh
* Date Last modified: Nov 2018
*/
// ==============================================================
package control;
import model.*;
import cityofaaron.CityOfAaron;
import java.util.ArrayList;

public class GameControl {
    // size of the Locations array
    private static int MAX_ROW = 5;
    private static int MAX_COL = 5;
    private static Game theGame;
    
    public static void createNewGame(String _name) {
        // create the game object
        theGame = new Game();
        
        // save a reference to the Game object
        CityOfAaron.setTheGame(theGame);
        
        // create the player object and set the name
        Player thePlayer = new Player();
        thePlayer.setName(_name);
        
        // save reference to the player object in the game object
        theGame.setPlayer(thePlayer);
        
        createCropDataObject();
        createAnimalList();
        createToolList();
        createProvisionsList();
        createMap();
    }
    
    public static void createCropDataObject(){        
        // create a CropData object
        CropData cropData = new CropData();
        
        // initialize the CropData values
        cropData.setYear(0);
        cropData.setPopulation(100);
        cropData.setNewPeople(5);
        cropData.setCropYield(3);
        cropData.setNumberWhoDied(0);
        cropData.setWheatInStore(2700);
        cropData.setAcresOwned(1000);
        cropData.setAcresPlanted(1000);
        cropData.setHarvest(3000);
        cropData.setAcresPlanted(1000);
        
        // save a reference to it in the Game object
        theGame.setCropData(cropData);
    }
    
    public static void createMap(){
        // create the Map object
        // refer to the Map constructor
        Map theMap = new Map(MAX_ROW, MAX_COL);
        
        // River location
        String river = "You are on the river, the source of life for our city.";
        Location loc = new Location();
        loc.setDescription(river);
        loc.setSymbol("~~~");
        for(int i = 0; i < MAX_COL; i++){
            theMap.setLocation(0, i, loc);
        }
        
        // Mountains location
        String mountain = "You have reached an impassable mountain range.";
        loc = new Location();
        loc.setDescription(mountain);
        loc.setSymbol("^^^");
        for(int i = 0; i < 4; i++){
            theMap.setLocation(4, i, loc);
        }
        
        // Desert location
        String desert = "You are in the hot, dry desert."
                      + "\nThis area is inhospitable to your people.";
        loc = new Location();
        loc.setDescription(desert);
        loc.setSymbol("###");
        theMap.setLocation(2, 0, loc);
        theMap.setLocation(3, 0, loc);
        
        // Farmland location        
        String farmland = "You are on the city's farmland.";
        loc = new Location();
        loc.setDescription(farmland + "\nOne bushel will plant two acres of"
                + "wheat.");
        loc.setSymbol("!!!");
        theMap.setLocation(1, 0, loc);
        theMap.setLocation(1, 1, loc);
        theMap.setLocation(1, 2, loc);
        theMap.setLocation(1, 3, loc);
        theMap.setLocation(1, 4, loc);
        theMap.setLocation(2, 4, loc);
        
        // Undeveloped land location
        String undev = "You are on undeveloped land.";
        loc = new Location();
        loc.setDescription(undev);
        loc.setSymbol("___");
        for(int i = 1; i < MAX_COL; i++){
            theMap.setLocation(3, i, loc);
        }
        
        // Ruler location
        String ruler = "This is the ruler's palace; your home.";
        loc = new Location();
        loc.setDescription(ruler);
        loc.setSymbol("$$$");
        theMap.setLocation(2, 1, loc);
        
        // Village location
        String village = "You are in the City of Aaron."
                       + "\nYou can see your people going about their day.";
        loc = new Location();
        loc.setDescription(village);
        loc.setSymbol("@@@");
        theMap.setLocation(2, 2, loc);
        
        // Storehouse location
        String storehouse = "You are at the city's storehouse."
                          + "\nThis is where your city's wheat, animals,"
                          + "\n and tools are kept.";
        loc = new Location();
        loc.setDescription(storehouse + "\n 20 bushels of wheat will feed one"
                + " person for a year.");
        loc.setSymbol("&&&");
        theMap.setLocation(2, 3, loc);
        
        // Lamanite land
        String lamanite = "This is the border of the Lamanite territory."
                        + "\nAdvancing any further will be "
                        + "\nconsidered an act of war.";
        loc = new Location();
        loc.setDescription(lamanite);
        loc.setSymbol("***");
        theMap.setLocation(4, 4, loc);
        
        theGame.setMap(theMap);
    }
    
    public void viewMap() {
        Game theGame = CityOfAaron.getTheGame();
        Map theMap = theGame.getMap();     
                System.out.println(  
                "\n**************************************"
              + "\n*              City Map              *"
              + "\n**************************************"
              + "\n        1     2     3     4     5     "
              + "\n       ___   ___   ___   ___   ___    ");
                
        // nested for loop to display locations
        for(int i = 0; i < 5; i++){
            String row = "\n   "+ (i + 1) + " |"; 
            for(int j = 0; j < 5; j++){
                row += " " + theMap.getLocation(i, j).getSymbol()+ " |";
                System.out.print(row);
                row = "";
            }
        }
        
        // map key
        System.out.println(
              "\n"
            + "\n   Legend:"
            + "\n   ~~~ - River"
            + "\n   ### - Desert"
            + "\n   ^^^ - Mountains"
            + "\n   !!! - Farmland"
            + "\n   ___ - Undeveloped land"
            + "\n   $$$ - Ruler's Palace"
            + "\n   @@@ - City of Aaron"
            + "\n   &&& - City Storehouse"
            + "\n   *** - Lamanite Territory");
    }
    
    public static void createAnimalList() {
        ArrayList<ListItem> animals = new ArrayList<>();
        
        animals.add(new ListItem("Cows", 10));
        animals.add(new ListItem("Chickens", 17));
        animals.add(new ListItem("Pigs", 8));
        animals.add(new ListItem("Goats", 9));
        
        theGame.setAnimals(animals);
    }
    
    public void displayAnimalList() {
        ArrayList<ListItem> animalList = theGame.getAnimals();
        
        System.out.println("\n***************************"
                         + "\n*       Animal List       *"
                         + "\n***************************"
                         + "\n"
                         + "\nThere are:\n");
        
        for(int i = 0; i < animalList.size(); i++) {
            System.out.println("- " + animalList.get(i).getNumber() + " "
                    + animalList.get(i).getName());
        }
        System.out.println("\nIn the storehouse.");
    }
    
    public static void createToolList() {
        ArrayList<ListItem> tools = new ArrayList<>();
        
        tools.add(new ListItem("Pickaxes", 15));
        tools.add(new ListItem("Shovels", 20));
        tools.add(new ListItem("Hoes", 10));
        tools.add(new ListItem("Axes", 18));
        tools.add(new ListItem("Swords", 5));
        
        theGame.setTools(tools);
    }
    
    public void displayToolList() {
        ArrayList<ListItem> toolList = theGame.getTools();
        
        System.out.println("\n***************************"
                         + "\n*        Tool List        *"
                         + "\n***************************"
                         + "\n"
                         + "\nThere are:\n");
        
        for(int i = 0; i < toolList.size(); i++) {
            System.out.println("- " + toolList.get(i).getNumber() + " "
                    + toolList.get(i).getName());
        }
        System.out.println("\nIn the storehouse.");
    }
    
    public static void createProvisionsList() {
        ArrayList<ListItem> provisions = new ArrayList<>();
        
        provisions.add(new ListItem("Pounds of flour", 20));
        provisions.add(new ListItem("Blankets", 10 ));
        provisions.add(new ListItem("Tents", 2 ));
        provisions.add(new ListItem("Ropes", 5));
        provisions.add(new ListItem("Cords of firewood", 1));
        provisions.add(new ListItem("Sets of clothes", 7 ));
        
        theGame.setProvisions(provisions);
    }
    
    public void displayProvisionsList() {
        ArrayList<ListItem> provisionsList = theGame.getProvisions();
        
        System.out.println("\n***************************"
                         + "\n*     Provisions List     *"
                         + "\n***************************"
                         + "\n"
                         + "\nThere are:\n");
        
        for(int i = 0; i < provisionsList.size(); i++) {
            System.out.println("- " + provisionsList.get(i).getNumber() + " "
                    + provisionsList.get(i).getName());
        }
        System.out.println("\nIn the storehouse.");
    }
}



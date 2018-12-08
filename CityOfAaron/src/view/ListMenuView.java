package view;

import control.*;

public class ListMenuView extends MenuView{
   
    public ListMenuView()
    {
        super( "\n" +
               "List Menu\n" +
               "1 - List animals\n" +
               "2 - Save animal list\n" +
               "3 - List tools\n" +
               "4 - Save tool list\n" +
               "5 - List provisions\n" +
               "6 - Save provisions list\n" +
               "7 - List team members\n" +
               "8 - Return to game",
        8);
    }
    
    @Override public void doAction(int option) {
        switch (option) {
            case 1: // list animals
                listAnimals();
                break;
            case 2: // save animals
                printAnimals();
                break;
            case 3: // list tools
                listTools();
                break;
            case 4: // save tools
                printTools();
                break;
            case 5: // list provisions
                listProvisions();
                break;
            case 6: // save provisions
                printProvisions();
                break;
            case 7: // list team
                listTeam();
                break;
            case 8: // return to game
                return;
        }
    }
    
    public void listAnimals() {
        //System.out.println("List animals selected.");
        GameControl gameControl = new GameControl();
        gameControl.displayAnimalList();
    }
    
    public void listTools() {
        //System.out.println("List tools selected.");
        GameControl gameControl = new GameControl();
        gameControl.displayToolList();
    }
    
    public void listProvisions() {
        //System.out.println("List provisions selected.");
        GameControl gameControl = new GameControl();
        gameControl.displayProvisionsList();
    }
    
    public void listTeam() {
        System.out.println("List team selected.");
    }
    
    public void printAnimals() {
        GameControl gameControl = new GameControl();
        gameControl.printAnimalList();
    }
    
    public void printTools() {
        GameControl gameControl = new GameControl();
        gameControl.printToolList();
    }
        
    public void printProvisions() {
        GameControl gameControl = new GameControl();
        gameControl.printProvisionsList();
    }
}

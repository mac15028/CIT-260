package view;

import control.*;

public class ListMenuView extends MenuView{
   
    public ListMenuView()
    {
        super( "\n" +
               "List Menu\n" +
               "1 - List animals\n" +
               "2 - List tools\n" +
               "3 - List provisions\n" +
               "4 - List team\n" +
               "5 - Return to game",
        5);
    }
    
    @Override public void doAction(int option) {
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
}

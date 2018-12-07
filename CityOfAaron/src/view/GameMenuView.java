package view;

import control.*;

public class GameMenuView extends MenuView{

    public GameMenuView()
    {
        super( "\n" +
               "GAME MENU VIEW\n" +
               "1 - View the map\n" +
               "2 - View the list\n" +
               "3 - Move to a new location\n" +
               "4 - Manage crops\n" +
               "5 - Exit to main menu",
        5);
    }
    
    @Override public void doAction(int option) {
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
        GameControl gameControl = new GameControl();
        gameControl.viewMap();
    }
    
    public void viewList() {
        ListMenuView lmv = new ListMenuView();
        lmv.displayMenu();
    }
    
    public void moveToNewLocation() {
        System.out.println("Move to new location selected.");
    }
    
    public void manageCrops() {
        CropView.runCropsView();
    }
}


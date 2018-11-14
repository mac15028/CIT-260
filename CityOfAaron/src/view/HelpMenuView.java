package view;

public class HelpMenuView extends MenuView{
    
    public HelpMenuView()
    {
        super( "\n" +
               "Help Menu\n" + 
               "1 - View goals\n" + 
               "2 - View map help\n" +
               "3 - View move help\n" +
               "4 - View list help\n" +
               "5 - Exit to main menu",
        5);
    }
    
    @Override public void doAction(int option) {
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

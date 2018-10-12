/*
* The main() class file for the cityOfAaron project
* CIT-260
* Spring 2018
* Team members: Taylor Mackintosh
*/
package cityofaaron;

import model.CropData;
import model.ListItem;
import model.Location;
import model.Player;
import model.TeamMember;
import static model.TeamMember.Taylor;

public class CityOfAaron {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
// Player class test
        Player playerOne = new Player();
        playerOne.setName("Fred Flintstone");
        String playerOneName = playerOne.getName();
        System.out.println("Player name = " + playerOneName);
        
// TeamMember class test 
        TeamMember memberOne = Taylor;
        String memberOneName = memberOne.getName();
        String memberOneTitle = memberOne.getTitle();
        System.out.println("Group member name = " + memberOneName + 
                ", title = " + memberOneTitle);
        
// Location class test
        Location locationOne = new Location();
        locationOne.setDescription("Placeholder location");
        String locationOneDesc = locationOne.getDescription();
        locationOne.setSymbol("###");
        String locationOneSymbol = locationOne.getSymbol();
        System.out.println("Location description = " + locationOneDesc +
                ", symbol = " + locationOneSymbol);
        
// ListItem class test
        ListItem itemOne = new ListItem();
        itemOne.setName("Placeholder item");
        String itemOneName = itemOne.getName();
        itemOne.setNumber(1);
        int itemOneNumber = itemOne.getNumber();
        System.out.println("Item name = " + itemOneName + ", number = " +
                itemOneNumber);
        
// CropData class test
        CropData year = new CropData();
        year.setYear(1);
        int yearNumber = year.getYear();
        System.out.println("Year = " + yearNumber);
    }
}

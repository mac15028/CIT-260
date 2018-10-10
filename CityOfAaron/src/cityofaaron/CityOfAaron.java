/*
* The main() class file for the cityOfAaron project
* CIT-260
* Spring 2018
* Team members: Taylor Mackintosh
*/
package cityofaaron;

import model.Player;
import model.TeamMember;
import static model.TeamMember.Taylor;

public class CityOfAaron {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player playerOne = new Player();
        
        playerOne.setName("Fred Flintstone");
        
        String playerOneName = playerOne.getName();
        
        System.out.println("Player name = " + playerOneName);
        
        TeamMember memberOne = Taylor;
        
        String memberOneName = memberOne.getName();
        String memberOneTitle = memberOne.getTitle();
        
        System.out.println("Group member name = " + memberOneName + 
                ", title = " + memberOneTitle);
    }
}

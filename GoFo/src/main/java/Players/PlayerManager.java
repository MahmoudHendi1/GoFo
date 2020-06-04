 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Players;

import Utilits.Booking;
import java.awt.List;
import java.sql.Date;
import java.util.ArrayList;
import Utilits.Playground;
/**
 *
 * @author Lenovo
 */
public class PlayerManager {
    public Team createTeam(Player player,String name){
        var teamsList = player.getTeams() ;
        if(teamsList==null)
           teamsList = new ArrayList<Team>();
        Team team = new Team(name);
        team.addMember(player);
        teamsList.add(team);
        return team;
       
        
        
    }

    
    public Booking bookPlayground(Playground P){
        
        return null;
    }
    public Boolean cancelBooking(Booking booking){
        
        return true; 
    }
    public ArrayList<Playground> viewPlaygrounds(){
        ArrayList<Playground> Playgrounds = null;
        return Playgrounds;
    }
    public ArrayList<Date> viewPlaygroundHours(Playground P){
        ArrayList<Date> availableDates = null;
        return availableDates;
    }
}

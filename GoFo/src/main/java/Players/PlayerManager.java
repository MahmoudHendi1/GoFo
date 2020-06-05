 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Players;

import Utilits.Booking;
import java.awt.List;
import java.util.Date;
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
    
    public Booking bookPlayground(Playground playground , Date bookingDate , int duration , Player player){
        if(playground==null||!playground.isApproved()||bookingDate==null||duration<1)
            return null;
        Date now = new Date();
         Date end_date  = new Date(bookingDate.getTime());
         end_date.setHours(end_date.getHours()+duration);
        if(bookingDate.before(now))
            return null;
             
        for(var booking : playground.getBookdeTimes()){
            if(booking.isPlayed()||booking.getEndDate().before(bookingDate)||booking.getDate().after(end_date))
                continue;
            return null;  
        }
        Booking booking = new Booking(bookingDate, player, duration);
        playground.getBookdeTimes().add(booking);
        player.getBookings().add(booking);
        return booking;
    }
    public boolean cancelBooking(Booking booking){
        if(booking.isPlayed())
        return false;
        var playground = booking.getPlayground();
        return playground.getBookdeTimes().remove(booking) && booking.getBooker().getBookings().remove(booking);
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

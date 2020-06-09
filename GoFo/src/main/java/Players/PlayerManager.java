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
 *PlayerManager is a controller which holds the responsibility
 * of all the functionalities such as creating team, booking, cancel a booking,etc..
 * @author Lenovo
 * @version 1.0
 * @since 9/6/2020
 */
public class PlayerManager {
    /**
     * This function creates a team consiting of multiple players
     * @param player
     * @param name
     * @return team that is formed
     */
    public Team createTeam(Player player,String name){
        var teamsList = player.getTeams() ;
        if(teamsList==null)
           teamsList = new ArrayList<Team>();
        Team team = new Team(name);
        team.addMember(player);
        teamsList.add(team);
        return team;     
    }
    /**
     * This function performs the action of booking a playground in a certain
     * date by a certain player
     * @param playground
     * @param bookingDate
     * @param duration
     * @param player
     * @return booking if succeeded or NULL if failed
     */
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
    /**
     * This functions performs the action of cancelling a booking
     * @param booking
     * @return whether the cancellation process succeeded or not
     */
    public boolean cancelBooking(Booking booking){
        if(booking.isPlayed())
        return false;
        var playground = booking.getPlayground();
        return playground.getBookdeTimes().remove(booking) && booking.getBooker().getBookings().remove(booking);
    }
    /**
     * This function views playgrounds as a player browses 
     * @return 
     */
    public ArrayList<Playground> viewPlaygrounds(){
        ArrayList<Playground> Playgrounds = null;
        return Playgrounds;
    }
    /**
     * This function views playing hours of a given playground
     * @param P
     * @return  ArrayList of dates
     */
    public ArrayList<Date> viewPlaygroundHours(Playground P){
        ArrayList<Date> availableDates = null;
        return availableDates;
    }
}

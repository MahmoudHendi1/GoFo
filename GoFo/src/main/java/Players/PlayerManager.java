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
import Utilits.PlayGround;
/**
 *
 * @author Lenovo
 */
public class PlayerManager {
    public Team createTeam(String name){
        return null;
    }
    public Booking bookPlayground(PlayGround P){
        
        return null;
    }
    public Boolean cancelBooking(Booking booking){
        
        return true; 
    }
    public ArrayList<PlayGround> viewPlaygrounds(){
        ArrayList<PlayGround> Playgrounds = null;
        return Playgrounds;
    }
    public ArrayList<Date> viewPlaygroundHours(PlayGround P){
        ArrayList<Date> availableDates = null;
        return availableDates;
    }
}

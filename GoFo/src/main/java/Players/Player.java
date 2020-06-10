/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Players;

import Users.User;
import Utilits.Booking;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class Player extends User{
    private ArrayList<Team> teams;
    private ArrayList<Booking> bookings;
   public Boolean hasTeam(){
       return true;
   }

    public Player(String name, String username, String password, String email, String phoneNumber, String address) {
        super(name, username, password, email, phoneNumber, address);
    }

    public ArrayList<Team> getTeams() {
        return teams;      
    }

    public ArrayList<Booking> getBookings() {
        if(bookings==null)
            bookings = new ArrayList<Booking>();
        return bookings ;
    }

    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }
    
   
   @Override
   public String toString(){
       teams = new ArrayList<Team>();
       return "\nPlayer:\n"+super.toString()+"\nTeams:"+teams.toString() + "\n" + bookings.toString();
   }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilits;

import Players.Player;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 *Booking is an entity that describes the details of the action that a player
 * takes to book a playground
 * @author ShawkyDev
 * @version 1.0
 * @since 9/6/2020
 * 
 */
public class Booking implements Serializable{
    
    private static final long serialVersionUID = 2L;
    private Date date;
    private String booker;
    private int DuratoinInHours;
    private Playground playground;

    public Booking(Date timing, Player booker, int DuratoinInHours , Playground playground) {
        this.date = timing;
        this.booker = booker.getUserName();
        this.DuratoinInHours = DuratoinInHours;
        this.playground = playground;
    }

    
    
    public boolean isPlayed(){
        /**comparing current date to booking date+duration [end date].
         * 
         * @return whether the booking has been played or not
         */
        Date end_date  = new Date(date.getTime());
        end_date.setHours(end_date.getHours()+DuratoinInHours);
        return new Date().after(end_date);
        
        
    }

    public Date getDate() {
        return date;
    }
    
    public Date getEndDate(){
        Date end_date  = new Date(date.getTime());
        end_date.setHours(end_date.getHours()+DuratoinInHours);
        end_date.setTime(end_date.getTime()-1000);
        return end_date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDuratoinInHours() {
        return DuratoinInHours;
    }

    public void setDuratoinInHours(int DuratoinInHours) {
        this.DuratoinInHours = DuratoinInHours;
    }

    public Playground getPlayground() {
        return playground;
    }

    public void setPlayground(Playground playground) {
        this.playground = playground;
    }

    public Player getBooker() {
        return (Player) Users.UserManger.getUserbyUsername(booker);
    }
    public String getBookerUsername(){
        return booker;
    }

    public void setBooker(Player booker) {
        this.booker = booker.getUserName();
    }

    @Override
    public String toString() {
        return "Booking{" + "date=" + date + ", booker=" + booker + ", DuratoinInHours=" + DuratoinInHours + ", playground=" + playground.getName() + '}';
    }
    

    
    
    
}

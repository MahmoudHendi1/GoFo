/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilits;

import Players.Player;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author ShawkyDev
 */
public class Booking {
    private Date date;
    private Player booker;
    private int DuratoinInHours;

    public Booking(Date timing, Player booker, int DuratoinInHours) {
        this.date = timing;
        this.booker = booker;
        this.DuratoinInHours = DuratoinInHours;
    }
    
    public boolean isPlayed(){
        //comparing current dat to booking date+duration [end date].
        Date end_date  = new Date(date.getTime());
        end_date.setHours(end_date.getHours()+DuratoinInHours);
        return new Date().after(date);
        
        
    }
    
    
}

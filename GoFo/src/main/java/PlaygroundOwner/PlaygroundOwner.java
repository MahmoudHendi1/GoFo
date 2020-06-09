/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlaygroundOwner;

import Players.BookingPage;
import Users.User;
import Utilits.Playground;
import java.util.ArrayList;



/**
 *Playground owner is a user extended entity that describes when the user
 * is a playground owner
 * @author ShawkyDev
 * @version 1.0
 * @since 9/6/2020
 */
public class PlaygroundOwner extends User{
    private ArrayList<Playground> playgroundsList ;

    public ArrayList<Playground> getPlaygroundsList() {
        //if(playgroundsList==null)
       // playgroundsList = new ArrayList<Playground>();
        return playgroundsList;
    }
    
    public PlaygroundOwner() {
    }

    public PlaygroundOwner(String name, String username, String password, String email, String phoneNumber, String address) {
        super(name, username, password, email, phoneNumber, address);
         playgroundsList = new ArrayList<Playground>();
    }
    @Override
    public String toString(){
        if(playgroundsList==null)
        playgroundsList = new ArrayList<Playground>();
        return "\nPlaygroundOwner:\n"+super.toString()+"\nPlaygrounds:"+playgroundsList.toString();
    }
    
    
}

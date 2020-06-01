/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Players;

import Users.User;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class Player extends User{
    private ArrayList<Team> teams;
   public Boolean hasTeam(){
       return true;
   }

    public Player(String name, String username, String password, String email, String phoneNumber, String address) {
        super(name, username, password, email, phoneNumber, address);
    }
   
   @Override
   public String toString(){
       teams = new ArrayList<Team>();
       return "\nPlayer:\n"+super.toString()+"\nTeams:"+teams.toString();
   }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Players;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class Team {
    String name;
    ArrayList<String> playersUsernames;
    
    public Team(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String tosString(){
        return "name:"+name + "\nPLayer:" + playersUsernames.toString(); 
    }
    
}

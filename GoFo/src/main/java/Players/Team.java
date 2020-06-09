/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Players;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *Team represents the team of players
 * 
 * @author Lenovo
 * @version  1.0
 * @since 9/6/2020
 */
public class Team implements Serializable{
    private static final long serialVersionUID = 5L;
    String name;
    ArrayList<Player> members;
    
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
        return "name:"+name + "\nPLayer:" + members.toString(); 
    }
    /**
     * This function adds a member to the team
     * @param member 
     */
    public void addMember(Player member){
        if(this.members==null)
            members = new ArrayList<Player>();
        this.members.add(member);
        member.getTeams().add(this);
    }
    
}

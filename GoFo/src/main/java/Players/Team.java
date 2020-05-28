/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Players;

/**
 *
 * @author Lenovo
 */
public class Team {
    String name;
    int id;
    
    public Team(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}

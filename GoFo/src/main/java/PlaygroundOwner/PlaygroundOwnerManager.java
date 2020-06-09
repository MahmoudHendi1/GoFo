/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlaygroundOwner;

import DB.DatabaseSimulator;
import Utilits.Playground;
import java.util.ArrayList;

/**
 *The PlaygroundOwnerManager is a controller which holds the responsibility
 * of all the functionalities a playground owner can perform such as adding 
 * a playground or deleting one.
 * @author ShawkyDev
 * @version 1.0
 * @since 9/6/2020
 */
public class PlaygroundOwnerManager {
    /**
     * This function takes a playground and name of its owner and add it to the playground list
     * @param playground
     * @param owner
     * @return whether the adding playground to list process succeeded or not
     */
    public static boolean addPlayground(Playground playground,PlaygroundOwner owner){
            playground.setOwner(owner);
           var list = owner.getPlaygroundsList();
           if(list==null)
               list = new ArrayList<Playground>();
           list.add(playground);
           System.out.println("added this : " + owner.getPlaygroundsList().toString());
           return DatabaseSimulator.addplaygroundToDB(playground);
        
    }
    /**
     * This function removes a playground from the playground list
     * @param playground
     * @return whether deletion process has succeeded or not
     */
    public static boolean deletePlayground(Playground playground){
        var isRemoved = DatabaseSimulator.deletePlayground(playground);
        var owner = playground.getOwner().getPlaygroundsList().remove(playground);
        return isRemoved;
    }
    
    
}

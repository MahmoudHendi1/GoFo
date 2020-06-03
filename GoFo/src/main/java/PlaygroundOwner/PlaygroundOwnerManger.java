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
 *
 * @author ShawkyDev
 */
public class PlaygroundOwnerManger {
    public static boolean addPlayground(Playground playground,PlaygroundOwner owner){
            playground.setOwner(owner);
           var list = owner.getPlaygroundsList();
           if(list==null)
               list = new ArrayList<Playground>();
           list.add(playground);
           System.out.println("added this : " + owner.getPlaygroundsList().toString());
           return DatabaseSimulator.addplaygroundToDB(playground);
        
    }
    public static boolean deletePlayground(Playground playground){
        var isRemoved = DatabaseSimulator.deletePlayground(playground);
        var owner = playground.getOwner().getPlaygroundsList().remove(playground);
        return isRemoved;
    }
    
    
}

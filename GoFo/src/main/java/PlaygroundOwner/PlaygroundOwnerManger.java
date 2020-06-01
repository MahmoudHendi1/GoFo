/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlaygroundOwner;

import DB.DatabaseSimulator;
import Utilits.Playground;

/**
 *
 * @author ShawkyDev
 */
public class PlaygroundOwnerManger {
    public static boolean addPlayground(Playground playground){
           return DatabaseSimulator.addplaygroundToDB(playground);
        
    }
    
    
}

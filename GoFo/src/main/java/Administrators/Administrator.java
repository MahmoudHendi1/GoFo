/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrators;

import DB.DatabaseSimulator;
import Utilits.Playground;
import java.sql.Array;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class Administrator extends Users.User{
    public static ArrayList<Playground> getNonApprovedPlaygrounds(){
        var prlaygrounds = DatabaseSimulator.getPlaygroundsList();
        ArrayList<Playground> nonApprovedPlaygrounds = new ArrayList<Playground>();
        for(Playground playground : nonApprovedPlaygrounds)
            if(!playground.isApproved())
                nonApprovedPlaygrounds.add(playground);
        return nonApprovedPlaygrounds;
        
    }
    public static void approvePlayground(Playground playground){
        playground.setApproved(true);
        
    }
    
    
}

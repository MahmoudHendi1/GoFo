/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrators;

import DB.DatabaseSimulator;
import Utilits.Playground;
import java.util.ArrayList;

/**
 *The AdministratorManager controls all the functionalities an administrator
 * can perform such as approving or suspending a playground
 * @author Lenovo
 */
public class AdministratorManager {
    /**
     * Thus functions returns a list of nonApproved playgrounds
     * @return Arraylist of playgrounds
     */
   public static ArrayList<Playground> getNonApprovedPlaygrounds(){
        var prlaygrounds = DatabaseSimulator.getPlaygroundsList();
        ArrayList<Playground> nonApprovedPlaygrounds = new ArrayList<Playground>();
        for(Playground playground : nonApprovedPlaygrounds)
            if(!playground.isApproved())
                nonApprovedPlaygrounds.add(playground);
        return nonApprovedPlaygrounds;
        
    }
   public static  ArrayList<Playground> getAllPlaygrounds(){
       //System.out.println(DatabaseSimulator.getPlaygroundsList().toString());
       return DatabaseSimulator.getPlaygroundsList();
   }
   
    public static void approvePlayground(Playground playground){
        playground.setApproved(true);
        
    }
    public static boolean isAdmin(String username , String password){
        // assuming there is only one admin and it's fixed :
        return username.equals("admin") && password.equals("admin12345");
    }
    
}

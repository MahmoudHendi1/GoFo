/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilits;

import DB.DatabaseSimulator;
import Players.Player;
import PlaygroundOwner.PlaygroundOwner;
import Users.User;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ShawkyDev
 */
public class tst {
    public static void main(String[] args) {
        DatabaseSimulator.initializeDatabase();
        //((Player)DatabaseSimulator.getUserbyUsername("hendi")).setPassword(password);
        
       for(var x : DatabaseSimulator.getPlayers())
            x.getTeams().clear();
       
            
       
       
           DatabaseSimulator.save();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Users.User;
import Utilits.Playground;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ShawkyDev
 */
public class DatabaseSimulator {
    private static FileOutputStream fOut;
    private static FileInputStream fIn;
    private static ArrayList<User> usersList ;
    private static ArrayList<Playground> playGroundsList;
    //private static ArrayList<PlayGround>;

    public DatabaseSimulator() {
        
        /*try {
           // fIn = new FileInputStream("Users.txt");
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DatabaseSimulator.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        
    }
 
    public static<T> ArrayList<T> fillListFromFile(ArrayList<T> list,String fileName ){
        try {
            FileInputStream fin = new FileInputStream("Users.txt");
            ObjectInputStream oin = new ObjectInputStream(fin) ;
            list = (ArrayList<T>) oin.readObject();
            System.out.println("a:"+list);
            return list;
        } catch (Exception ex) {
            Logger.getLogger(DatabaseSimulator.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("err in fullUserList() in DBsim :"+ex.getMessage());
                    
            return null;
            
        }
    }
    public static boolean writeListToFile(ArrayList<?> list , String fileName){
        try {
            FileOutputStream fout = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(list);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DatabaseSimulator.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("err in writeListRoFile in DB sim "+ ex.getMessage());
            return false;
        }
        
    }
    public static boolean init(){
        usersList = fillListFromFile(usersList, "Users.txt");
        playGroundsList = fillListFromFile(playGroundsList, "Playgrounds.txt");
        return usersList!=null && playGroundsList !=null ;
    }
    
            
            
}

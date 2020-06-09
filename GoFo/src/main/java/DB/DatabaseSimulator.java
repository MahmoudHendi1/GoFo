/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Players.Player;
import Users.User;
import Utilits.Playground;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *The DatabaseSimulator simulates the database by having an array list
 * of users and playground to be saved persistently, while in fact we write and read
 * from files
 * 
 * @author ShawkyDev
 * @version 1.0
 * @since 9/6/2020
 */
public class DatabaseSimulator {
/**
 * Arraylist of user and playground to store them
 * 
 */
    private static ArrayList<User> usersList;
    private static ArrayList<Playground> playgroundsList;
    private static boolean isInit = false;
    //private static ArrayList<PlayGround>;

    /**
     * 
     * @return whether the writing on the file process is succeeded 
     */
    public static boolean save() {
        return writeListToFile(usersList, "Users.txt") && writeListToFile(playgroundsList, "Playgrounds.txt");

    }
/**
 * This function searches the user in the file by his phone number
 * and returns the user if exists 
 * @param phone
 * @return  user and null if the user is not found
 */
    public static User getUserbyPhone(String phone) {
        if (!isInit) {
            init();
        }
        if (usersList == null) {
            return null;
        }
        for(User user : usersList)
            if(user.getPhoneNumber().compareTo(phone)==0)
                return user;
        return null;
    }
    /**
     * This function deletes playground from the file
     * @param playground
     * @return whether the deletion process succeeded or not 
     */

    public static boolean deletePlayground(Playground playground) {
        return playgroundsList.remove(playground);
    }

    public DatabaseSimulator() {

        /*try {
           // fIn = new FileInputStream("Users.txt");
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DatabaseSimulator.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
/**
 * This functions loads all the data (users, playgrounds) from the files and load so the data saved 
 * before becomes available, 
 * @param <T>
 * @param list
 * @param fileName
 * @return users list and playgrounds list
 */
    public static <T> ArrayList<T> fillListFromFile(ArrayList<T> list, String fileName) {
        try {
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream oin = new ObjectInputStream(fin);
            list = (ArrayList<T>) oin.readObject();
            //System.out.println("a:"+list);
            return list;
        } catch (Exception ex) {

            System.out.println("err in filllUserList() in DBsim :" + ex.toString());
            return new ArrayList<T>();

        }

    }

    public static boolean writeListToFile(ArrayList<?> list, String fileName) {
        try {
            FileOutputStream fout = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(list);
            return true;
        } catch (Exception ex) {

            System.out.println("err in writeListRoFile in DB sim " + ex.getMessage());
            return false;
        }

    }

    public static boolean init() {
        usersList = fillListFromFile(usersList, "Users.txt");
        playgroundsList = fillListFromFile(playgroundsList, "Playgrounds.txt");
        isInit = true;
        return usersList != null || playgroundsList != null;
    }

    public static User getUser(String username, String password) {
        if (!isInit) {
            init();
        }
        if (usersList == null) {
            return null;
        }
        for (User user : usersList) {
            if (user.getUserName().compareTo(username) == 0 && user.getPassword().compareTo(password) == 0) {
                return user;
            }
        }
        return null;

    }

    public static boolean checkUserbyUserName(String username) {
        if (!isInit) {
            init();
        }
        if (usersList == null) {
            return false;
        }
        for (User user : usersList) {
            if (user.getUserName().compareTo(username) == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkUserbyEmail(String email) {
        if (!isInit) {
            init();
        }
        if (usersList == null) {
            return false;
        }
        for (User user : usersList) {
            if (user.getEmail().compareTo(email) == 0) {
                return true;
            }
        }
        return false;
    }

    public static void addUserToDB(User user) {
        if (!isInit) {
            init();
        }
        if (usersList == null) {
            usersList = new ArrayList<User>();
        }
        usersList.add(user);

    }

    ///used mainly for  testing
    public static void printArrayLists(int popUp) {
        System.out.println("called!");
        if (usersList != null) {
            if (popUp == 0) {
                System.out.println("Users :" + usersList.toString());
            } else {
                JOptionPane.showMessageDialog(null, usersList.toString(), "Users Data", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            System.out.println("userslist is null");
        }
        if (playgroundsList != null) {
            if (popUp == 0) {
                System.out.println("Users :" + playgroundsList.toString());
            } else {
                JOptionPane.showMessageDialog(null, playgroundsList.toString(), "PlayGround Data", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            System.out.println("playGroundsList is null");
        }

    }

    public static boolean deleteUserWithUsername(String username) {
        if (!isInit) {
            init();
        }
        if (usersList == null) {
            return false;
        }
        for (User user : usersList) {
            if (user.getUserName().compareTo(username) == 0) {
                usersList.remove(user);
                return true;
            }
        }
        return false;

    }
    public static boolean addplaygroundToDB(Playground playground){
         if (!isInit) {
            init();
        }
        if (playgroundsList == null) {
            return false;
        }
        playgroundsList.add(playground);
        return true;
    }
    public static void reset() {
        usersList.clear();
        playgroundsList.clear();
        File folder = new File("playerPhotos");
        for(File file : folder.listFiles()){
            System.out.println("file :"+file.getName());
            if(!file.getName().contains("default"))
                file.delete();
        }
        

    }
    public static User getUserbyUsername(String username){
        if (!isInit) {
            init();
        }
        if (usersList == null) {
            return null;
        }
        for(User user : usersList)
            if(user.getUserName().compareTo(username)==0)
                return user;
        return null;
        
    }
    public static boolean checkUserbyUsername(String username) {
        if (!isInit) {
            init();
        }
        if (usersList == null) {
            return false;
        }
        for (User user : usersList) {
            if (user.getUserName().compareTo(username) == 0) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Player> getPlayers() {
        ArrayList<Player> players = new  ArrayList<Player>();
        for( User user : usersList)
            if(user instanceof Player)
                players.add((Player)user);
        return players;
    }

    public static ArrayList<Playground> getPlaygroundsList() {
        return playgroundsList;
    }
    public static ArrayList<Playground> getApprovedPlaygrounds(){
        if (!isInit) {
            init();
        }
        if (playgroundsList == null) {
            return null;
        }
        ArrayList<Playground> approvedPlaygrounds = new ArrayList<Playground>();
        for(var playground : playgroundsList)
            if(playground.isApproved())
                approvedPlaygrounds.add(playground);
        return approvedPlaygrounds;
        
    }
    

}

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
 * is
 * 
 */
    private static ArrayList<User> usersList;
    private static ArrayList<Playground> playgroundsList;
    private static boolean isInitialized = false;
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
        if (!isInitialized) {
            initializeDatabase();
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
 * This functions loads data from the file and load so the data saved 
 * before becomes available, it used twice inside function initializeDatabase so 
 * it loads the users and the playgrounds
 * @see initializeDatabase
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
/**
 * This function write on the file the new added users and playgrounds
 * it is processed before the program terminates.
 * @param list
 * @param fileName
 * @return  whether the writing process is succeeded or not
 */
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
/**
 * This function reads from the files and fills the list for both playgrounds
 * and users
 * @return whether the initialization process succeeded or not
 */
    public static boolean initializeDatabase() {
        usersList = fillListFromFile(usersList, "Users.txt");
        playgroundsList = fillListFromFile(playgroundsList, "Playgrounds.txt");
        isInitialized = true;
        return usersList != null || playgroundsList != null;
    }
/**
 * This function takes in username and password and returns the user of if the
 * credentials given are correct. used in login
 * @param username
 * @param password
 * @return  user
 */
    public static User getUser(String username, String password) {
        if (!isInitialized) {
            initializeDatabase();
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
    /**
     * This function check if the user exists in the list by searching
     * using the username
     * @param username
     * @return whether the user exists in the list or not
     */

    public static boolean checkUserbyUserName(String username) {
        if (!isInitialized) {
            initializeDatabase();
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
/**
 * This function check if the user exists in the list by searching
 * using the email
 * @param email
 * @return whether the user exists in the list or not
 */
    public static boolean checkUserbyEmail(String email) {
        if (!isInitialized) {
            initializeDatabase();
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
    /**
     * This function adds the given user to the Arraylist
     * @param user 
     */

    public static void addUserToDB(User user) {
        if (!isInitialized) {
            initializeDatabase();
        }
        if (usersList == null) {
            usersList = new ArrayList<User>();
        }
        usersList.add(user);

    }

    /**
     * This function prints the Arraylist
     * it is used mainly for testing
     * @param popUp 
     */
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
/**
 * This function checks if the user is in list
 * then deletes the user 
 * @param username
 * @return whether the user is deleted or not
 */
    public static boolean deleteUserWithUsername(String username) {
        if (!isInitialized) {
            initializeDatabase();
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
    /**
     * This function adds a playground to the Arraylist of playgrounds
     * @param playground
     * @return whether the adding process succeeded or not
     */
    public static boolean addplaygroundToDB(Playground playground){
         if (!isInitialized) {
            initializeDatabase();
        }
        if (playgroundsList == null) {
            return false;
        }
        playgroundsList.add(playground);
        return true;
    }
    /**
     * This functions resets the database
     */
    public static void reset() {
        usersList.clear();
        playgroundsList.clear();
        File folder = new File("playerPhotos");
        for(File file : folder.listFiles()){
            System.out.println("file :"+file.getName());
            if(!file.getName().contains("default"))
                file.delete();
        }
        folder = new File("playgroundPhotos");
        for(File file : folder.listFiles()){
            System.out.println("file :"+file.getName());
                file.delete();
        }

    }
    /**
     * Gets the user from the list by his username
     * @param username
     * @return user if the user is found or NULL if not
     */
    public static User getUserbyUsername(String username){
        if (!isInitialized) {
            initializeDatabase();
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
        if (!isInitialized) {
            initializeDatabase();
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
/**
 * This function returns list of players
 * @return 
 */
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
        if (!isInitialized) {
            initializeDatabase();
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

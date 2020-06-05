/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import DB.DatabaseSimulator;
import jdk.jshell.spi.ExecutionControl;

/**
 *
 * @author ShawkyDev
 */
public class UserManger {
    public static User loginUser(String username , String password){
        return DatabaseSimulator.getUser(username, password);
    }
    public static boolean registerUser(User user){
        if(DatabaseSimulator.checkUserbyUserName(user.getUserName())
                ||
            DatabaseSimulator.checkUserbyEmail(user.getEmail())
                ||
            DatabaseSimulator.getUserbyPhone(user.getPhoneNumber())==null)
            return false;
         DatabaseSimulator.addUserToDB(user);
         return true;
                
    }
   
    public static User getUserbyEmail(String email){
        return null;
    }
     public static User getUserbyUsername(String username){
        return DatabaseSimulator.getUserbyUsername(username);
    }
     public static User getUserByPhone(String phone){
         return DatabaseSimulator.getUserbyPhone(phone);
     }
}

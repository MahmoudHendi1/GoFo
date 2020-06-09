package Users;

import DB.DatabaseSimulator;
import jdk.jshell.spi.ExecutionControl;

/**
 *User manager is a controller that performs all the required operations
 * to login and register an entity user
 * 
 * 
 * @author ShawkyDev
 * @version 1.0
 * @since 9/6/2020
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
            DatabaseSimulator.getUserbyPhone(user.getPhoneNumber())!=null)
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

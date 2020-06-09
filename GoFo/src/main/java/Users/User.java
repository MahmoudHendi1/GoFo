package Users;
//import org.apache.commons.validator.routines.EmailValidator;

import java.io.Serializable;
import java.util.Date;

/**
 *User is the main entity that describes player and playground owner 
 * and will be used throughout the program
 * @author Lenovo
 * @version 1.0
 * @since 9/6/20120
 */
public class User implements  Serializable{
    
    //assigning uinque ID for each serlaized class
   private static final long serialVersionUID = 1L;
   private Date expirtyOfRigisteration;
    private String name,
           userName,
           password,
           email,
           phoneNumber,
           address,
           photoLink="playerPhotos/default.jpg";

    public User() {
        System.out.println("created !");
    }

    public User( String name, String username, String password, String email, String phoneNumber, String address) {
        this.userName = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.name = name;
        this.expirtyOfRigisteration = new Date(new Date().getTime()+365 * 24 * 60 * 60 * 1000); ///one year
        
    }
     

   

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }
    
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

   

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
 

        @Override
	public String toString() {
            
              /** this.expirtyOfRigisteration = new Date(new Date().getTime()+365l * 24 * 60 * 60 * 1000); one year after now
		return id+',' + name +',' + password +',' + email+','+phoneNumber+','+address;*/
                return "name:" +name +"\nuserName:"+userName+ "\npassword:" + password + "\nemail:"+email + "\nphoneNumber:"
                        +phoneNumber+"\naddress:"+address+"\n"+  "photoPath"+ photoLink+"\nDate" + expirtyOfRigisteration.toString()+"\n";
                        
                        
                        
                       
	}
    
}

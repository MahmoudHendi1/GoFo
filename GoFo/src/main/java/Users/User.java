/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;
//import org.apache.commons.validator.routines.EmailValidator;

import java.io.Serializable;

/**
 *
 * @author Lenovo
 */
public class User implements  Serializable{
    int id;
    static int ID_COUNTER =1;
    //no idea what it does but never touch it
   private static final long serialVersionUID = 1L;
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
        this.id = ID_COUNTER++;
        this.userName = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.name = name;
    }
     

    public int getId() {
        return id;
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
		//return id+',' + name +',' + password +',' + email+','+phoneNumber+','+address;
                return "id:"+id +"\nname:" +name +"\nuserName:"+userName+ "\npassword:" + password + "\nemail:"+email + "\nphneNumber:"
                        +phoneNumber+"\naddress:"+address+"\n";
                        
                        
                        
                       
	}
    
}

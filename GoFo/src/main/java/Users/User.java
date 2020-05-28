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
    //no idea what it does but never touch it
   private static final long serialVersionUID = 1L;
    String name,
           password,
           email,
           phoneNumber,
           address;

    public User() {
        System.out.println("created !");
    }

    public User(int id, String name, String password, String email, String phoneNumber, String address) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public int getId() {
        return id;
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

    public void setId(int id) {
        this.id = id;
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
 

        @Override
	public String toString() {
		//return id+',' + name +',' + password +',' + email+','+phoneNumber+','+address;
                return "id:"+id +"\nname:" +name + "\npassword:" + password + "\nemail:"+email + "\nphneNumber:"
                        +phoneNumber+"\naddress:"+address+"\n";
                        
                        
                        
                       
	}
    
}

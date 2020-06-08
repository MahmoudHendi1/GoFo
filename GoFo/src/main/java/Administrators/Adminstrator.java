/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrators;

/**
 *
 * @author Feras
 */
public class Adminstrator {
    String Username;
    String password;

    public Adminstrator(String Username, String password) {
        this.Username = Username;
        this.password = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


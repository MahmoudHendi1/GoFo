/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrators;

/**
 *The administrator entity represents the administrator with all its
 * needed information such as username and password.
 * @author Feras
 * @version 1.0
 * @since 7/6/2020
 */
public class Administrator {
    String Username;
    String password;

    public Administrator(String Username, String password) {
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


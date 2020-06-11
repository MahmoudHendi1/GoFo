/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import Administrators.AdminProfile;
import Administrators.AdministratorManager;
import DB.DatabaseSimulator;
import Players.Player;
import Players.PlayerProfile;
import PlaygroundOwner.PlaygroundOwner;
import PlaygroundOwner.PlaygroundOwnerManager;
import PlaygroundOwner.PlaygroundOwnerProfile;
import Utilits.Playground;
import java.awt.Color;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.sql.*;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.validator.routines.LongValidator;

/**
 *
 * @author Lenovo
 */
public class UserMainForm extends javax.swing.JFrame {

    /**
     * Creates new form First
     */
    public UserMainForm() {

        initComponents();
        //System.out.println(getClass().getResource("Forms/login.jpg"));
        //loginPhoto.setIcon(new ImageIcon()); // NOI18N

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        loginPanel = new javax.swing.JPanel();
        loginUsernameField = new javax.swing.JFormattedTextField();
        loginPasswordField = new javax.swing.JPasswordField();
        loginPasswordLabel = new javax.swing.JLabel();
        loginUsernameLabel = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        RegisterPanel = new javax.swing.JPanel();
        usernameField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        phoneField = new javax.swing.JTextField();
        addressField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        usernameLabel1 = new javax.swing.JLabel();
        passwordLabel1 = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        addressLabel1 = new javax.swing.JLabel();
        register = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        UserType = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                formAncestorResized(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        loginPanel.setName(""); // NOI18N

        loginPasswordLabel.setLabelFor(loginPasswordField);
        loginPasswordLabel.setText("Password");

        loginUsernameLabel.setLabelFor(loginUsernameField);
        loginUsernameLabel.setText("Username");

        loginButton.setText("Login");
        loginButton.setActionCommand("loginButton");
        loginButton.setName("loginButton"); // NOI18N
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        loginButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginButtonKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(loginUsernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(loginUsernameField, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                .addGap(13, 13, 13))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginUsernameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginPasswordLabel))
                .addGap(37, 37, 37)
                .addComponent(loginButton)
                .addContainerGap(195, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Login", loginPanel);

        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });

        usernameLabel1.setText("Username *");

        passwordLabel1.setText("Password *");

        emailLabel.setText("E-mail *");

        phoneLabel.setText("Phone *");

        addressLabel1.setText("Address");

        register.setText("Register");
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });

        nameLabel.setText("name *");

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        UserType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Player", "Playground Owner", " " }));
        UserType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RegisterPanelLayout = new javax.swing.GroupLayout(RegisterPanel);
        RegisterPanel.setLayout(RegisterPanelLayout);
        RegisterPanelLayout.setHorizontalGroup(
            RegisterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegisterPanelLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisterPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(RegisterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(UserType, 0, 155, Short.MAX_VALUE)
                    .addComponent(addressLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordField)
                    .addComponent(usernameField)
                    .addComponent(phoneField)
                    .addComponent(addressField)
                    .addComponent(emailLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phoneLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usernameLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(emailField)
                    .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameField))
                .addGap(63, 63, 63))
        );
        RegisterPanelLayout.setVerticalGroup(
            RegisterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegisterPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(usernameLabel1)
                .addGap(13, 13, 13)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nameLabel)
                .addGap(4, 4, 4)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phoneLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addressLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(UserType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(register)
                .addGap(19, 19, 19))
        );

        jTabbedPane1.addTab("Register", RegisterPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        User user;
        loginUsernameLabel.setForeground(Color.green);
        loginPasswordLabel.setForeground(Color.green);
        if(loginPasswordField.getText().length()<8){
            loginPasswordLabel.setForeground(Color.red);
            JOptionPane.showMessageDialog(null, "password is too short", "fail", JOptionPane.INFORMATION_MESSAGE);
        }else{
            user=UserManger.loginUser(loginUsernameField.getText(), loginPasswordField.getText());
        if(user!=null){
             //JOptionPane.showMessageDialog(null, "Logged In!", "Success", JOptionPane.INFORMATION_MESSAGE);
             this.setVisible(false);
             PlayerProfile playerProfile ;
             PlaygroundOwnerProfile playgroundOwnerProfile ;
             if(user instanceof Player){
                playerProfile = new PlayerProfile((Player)user);
                playerProfile.setVisible(true);
             }else{
                 try {
                     playgroundOwnerProfile =new PlaygroundOwnerProfile((PlaygroundOwner)user);
                     playgroundOwnerProfile.setVisible(true);

                 } catch (IOException ex) {
                     Logger.getLogger(UserMainForm.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
             this.dispose();
             return ;
        }else{
            if(AdministratorManager.isAdmin(loginUsernameField.getText(), loginPasswordField.getText())){
                AdminProfile adminProfile  = new AdminProfile();
                adminProfile.setVisible(true);
                this.dispose();
                return ;
            }
            if(UserManger.getUserbyUsername(loginUsernameField.getText())!=null){
                JOptionPane.showMessageDialog(null, "password is incrorect", "fail", JOptionPane.INFORMATION_MESSAGE);
                loginPasswordLabel.setForeground(Color.red);
            }else{
                JOptionPane.showMessageDialog(null, "no such user with this username", "fail", JOptionPane.INFORMATION_MESSAGE);
                loginUsernameLabel.setForeground(Color.red);
            }
            
        }
            
                
        
    }
        
    }//GEN-LAST:event_loginButtonActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized

    }//GEN-LAST:event_formComponentResized

    private void formAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_formAncestorResized
        //loginPhoto.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\Lenovo\\Pictures\\79232558_1503101963186490_8902551968552058880_n.png").getImage().getScaledInstance(-1, loginPhoto.getWidth(),Image.SCALE_AREA_AVERAGING)));
    }//GEN-LAST:event_formAncestorResized

    private void loginButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginButtonKeyPressed

    }//GEN-LAST:event_loginButtonKeyPressed

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        // TODO add your handling code here:
       
        boolean isAllRight = true;
            emailLabel.setForeground(Color.GREEN);
            passwordLabel1.setForeground(Color.GREEN);
            phoneLabel.setForeground(Color.GREEN);
            nameLabel.setForeground(Color.GREEN);
            
        EmailValidator emailValidator = EmailValidator.getInstance();
        if (!emailValidator.isValid(emailField.getText())) {
            emailLabel.setForeground(Color.red);
            isAllRight = false;
        }
        if(nameField.getText().isBlank()){
            isAllRight = false;
            nameLabel.setForeground(Color.red);
        }
        else {
            for (int i = 0 ; i < nameField.getText().length();++i)
                if( !Character.isLetter(nameField.getText().charAt(i))&&nameField.getText().charAt(i)!=' ')
                {
                    
                    isAllRight = false;
                    nameLabel.setForeground(Color.red);
                    break;
                }
        }
        
        if(passwordField.getText().length()<8){
            isAllRight = false;
            passwordLabel1.setForeground(Color.red);
        }
        try {
            Double.parseDouble(phoneField.getText());
            isAllRight= isAllRight&&phoneField.getText().charAt(0)=='0'&&phoneField.getText().length()==11;
        } catch (NumberFormatException e) {
            isAllRight= false;
            phoneLabel.setForeground(Color.RED);
        }
        //User( String name, String password, String email, String phoneNumber, String address)
        User tmpUser;
         if(UserType.getSelectedIndex()==0){
            tmpUser = new Player(nameField.getText(), usernameField.getText(),passwordField.getText(),
            emailField.getText(),phoneField.getText(),addressField.getText());   
         }else{
             tmpUser =  new PlaygroundOwner(nameField.getText(), usernameField.getText(),passwordField.getText(),
            emailField.getText(),phoneField.getText(),addressField.getText());
         }
           if(isAllRight && UserManger.registerUser(tmpUser)){
               JOptionPane.showMessageDialog(null, "Reistered!", "Success", JOptionPane.INFORMATION_MESSAGE);
               tmpUser = UserManger.loginUser(tmpUser.getUserName(), tmpUser.getPassword());
                if(UserType.getSelectedIndex()==0){
                   PlayerProfile playerProfile = new PlayerProfile((Player)tmpUser); 
                    playerProfile.setVisible(true);
                }else{
                   try {
                       PlaygroundOwnerProfile playgroundOwnerProfile = new PlaygroundOwnerProfile((PlaygroundOwner)tmpUser);
                       playgroundOwnerProfile.setVisible(true);
                   } catch (IOException ex) {
                       Logger.getLogger(UserMainForm.class.getName()).log(Level.SEVERE, null, ex);
                   }
                }
               this.dispose();
           }
           else {
               JOptionPane.showMessageDialog(null, "not Reistered!", "Faild", JOptionPane.INFORMATION_MESSAGE);
               System.out.println("bec"+isAllRight);
           }
               
           
           

    }//GEN-LAST:event_registerActionPerformed

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void UserTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserTypeActionPerformed
    private static class ShutDownTask extends Thread {
 
	@Override
	public void run() {
		System.out.println("Performing shutdown");
                System.out.println("Saving...");
                if(DB.DatabaseSimulator.save())
                    System.out.println("Done saving");
                else 
                    System.out.println("couldn't save!");
                
	}
 
   }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserMainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserMainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserMainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserMainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        ShutDownTask shutDownTask = new ShutDownTask();
	// add shutdown hook - to save the data [Write it to File]
	Runtime.getRuntime().addShutdownHook(shutDownTask);
         DatabaseSimulator.initializeDatabase();
         //DatabaseSimulator.reset();
         
         
         DatabaseSimulator.printArrayLists(1);
        
         
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserMainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel RegisterPanel;
    private javax.swing.JComboBox<String> UserType;
    private javax.swing.JTextField addressField;
    private javax.swing.JLabel addressLabel1;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPasswordField loginPasswordField;
    private javax.swing.JLabel loginPasswordLabel;
    private javax.swing.JFormattedTextField loginUsernameField;
    private javax.swing.JLabel loginUsernameLabel;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel1;
    private javax.swing.JTextField phoneField;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JButton register;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel1;
    // End of variables declaration//GEN-END:variables
}

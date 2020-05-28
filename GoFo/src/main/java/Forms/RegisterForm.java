/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;
import Users.User;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.apache.commons.validator.routines.*;

/**
 *
 * @author Lenovo
 */
public class RegisterForm extends javax.swing.JFrame {

     public FileOutputStream f;
     public ObjectOutputStream out ;     
    public RegisterForm() {
         try {
             this.f = new FileOutputStream("myObjects.txt", true);
             this.out = new ObjectOutputStream(f);
             
         } catch (IOException ex) {
             Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
         }
      
        initComponents();
    }
/**
     * Creates new form RegisterForm
     */
        public boolean WriteToFile(User user){
        try {
	
        
        out.writeObject(user);
        
        return true;
            
        }catch(IOException ex){
            System.out.println("Erro in writing to file - Registered Form"
                    + "err:"+ex.getMessage());
          
            return false;
                 
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginPhoto = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        usernameField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        phoneField = new javax.swing.JTextField();
        addressField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        addressLabel1 = new javax.swing.JLabel();
        register = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(897, 545));

        loginPhoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginPhoto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        usernameLabel.setLabelFor(usernameField);
        usernameLabel.setText("Username *");

        passwordLabel.setLabelFor(passwordField);
        passwordLabel.setText("Password *");

        emailLabel.setLabelFor(emailField);
        emailLabel.setText("E-mail *");

        phoneLabel.setText("Phone *");

        addressLabel1.setText("Address");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addressLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(usernameField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(phoneField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addressField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(emailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phoneLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(emailField, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(63, 63, 63))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(usernameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordLabel)
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
                .addContainerGap(29, Short.MAX_VALUE))
        );

        register.setText("Register");
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginPhoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(register)
                        .addGap(0, 225, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        // TODO add your handling code here:
         EmailValidator emailValidator = EmailValidator.getInstance();
        if(!emailValidator.isValid(emailField.getText())){
            emailLabel.setForeground(Color.red);
        }else{
            emailLabel.setForeground(Color.GREEN);
        }
        LongValidator phoneValidator =LongValidator.getInstance();
        if(!phoneValidator.isValid(phoneField.getText()) && phoneField.getText().length()==11){
            phoneLabel.setForeground(Color.red);
        }else{
            phoneLabel.setForeground(Color.GREEN);
        }
        
        User x ,y;
        try {
            //(int id, String name, String password, String email, String phoneNumber, String address) {
            FileInputStream f = new FileInputStream("myObjects.txt");
            ObjectInputStream in = new ObjectInputStream(f);
            System.out.println("ahlan :");
            x = ((User)in.readObject());
            System.out.println(x.toString());
            y = ((User)in.readObject());
            System.out.println("sec:");
            System.out.println(y.toString());
               in.close();
               f.close();
        } catch (Exception ex) {
            System.out.println("err:" + ex.getMessage());
            //Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         User user = new User(69,usernameField.getText(),"pass",emailField.getText(),phoneField.getText(),addressField.getText());
        //WriteToFile(user);
         

    }//GEN-LAST:event_registerActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressField;
    private javax.swing.JLabel addressLabel1;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel loginPhoto;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField phoneField;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JButton register;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}

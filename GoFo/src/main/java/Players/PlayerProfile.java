/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Players;

import Users.User;
import Utilits.Playground;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author Lenovo
 */
public class PlayerProfile extends javax.swing.JFrame {

    /**
     * Creates new form PlayerProfile
     */
    Player player;
    private ImageIcon scale(String path){
        Image image = new ImageIcon(path).getImage();
        Image newimg = image.getScaledInstance(playerProfile.getWidth(),-1,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        return new ImageIcon(newimg);
    }
    public void selectPhoto(Path originalPath) throws IOException{
        Path copied = Paths.get("playerPhotos/"+player.getUserName() +".jpg");
        Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
        playerProfile.setIcon(scale(copied.toString()));

    } 
    
    public void setInfo(){
        player = new Player("Shawky", "ShawkyDev", "password_gamed", "youssef@gmail.com", "01157572128", "zayed , Giza");
        playerNameField.setText(player.getName());
        playerEmailField.setText(player.getEmail());
        playerPhoneNumField.setText(player.getPhoneNumber());
        playerAddressField.setText(player.getAddress());
        playerProfile.setIcon(scale(player.getPhotoLink()));
    }
    
    
    public PlayerProfile(){
        initComponents();
        setInfo();
        
    }
    public PlayerProfile(Player player){
        initComponents();
        setInfo();
        this.player = player;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profilePane = new javax.swing.JPanel();
        playerProfile = new javax.swing.JLabel();
        playerNameLabel = new javax.swing.JLabel();
        playerAddressLabel = new javax.swing.JLabel();
        playerPhoneNumLabel = new javax.swing.JLabel();
        playerNameField = new javax.swing.JTextField();
        playerPhoneNumField = new javax.swing.JTextField();
        playerAddressField = new javax.swing.JTextField();
        playerEmailField = new javax.swing.JTextField();
        playerEmailLabel = new javax.swing.JLabel();
        choosePhotoButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        playerProfile.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        playerNameLabel.setLabelFor(playerNameField);
        playerNameLabel.setText("Name: ");

        playerAddressLabel.setLabelFor(playerAddressField);
        playerAddressLabel.setText("Address:");

        playerPhoneNumLabel.setText("Phone Number:");

        playerNameField.setEditable(false);
        playerNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerNameFieldActionPerformed(evt);
            }
        });

        playerPhoneNumField.setEditable(false);
        playerPhoneNumField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerPhoneNumFieldActionPerformed(evt);
            }
        });

        playerAddressField.setEditable(false);
        playerAddressField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerAddressFieldActionPerformed(evt);
            }
        });

        playerEmailField.setEditable(false);
        playerEmailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerEmailFieldActionPerformed(evt);
            }
        });

        playerEmailLabel.setLabelFor(playerNameField);
        playerEmailLabel.setText("Email");

        choosePhotoButton.setText("jButton1");
        choosePhotoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choosePhotoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout profilePaneLayout = new javax.swing.GroupLayout(profilePane);
        profilePane.setLayout(profilePaneLayout);
        profilePaneLayout.setHorizontalGroup(
            profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(choosePhotoButton, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(playerProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addGroup(profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playerNameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(profilePaneLayout.createSequentialGroup()
                        .addGroup(profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(playerAddressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playerPhoneNumLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playerEmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 28, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playerEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerPhoneNumField, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        profilePaneLayout.setVerticalGroup(
            profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(profilePaneLayout.createSequentialGroup()
                        .addGroup(profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(playerNameLabel)
                            .addComponent(playerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(playerEmailLabel)
                            .addComponent(playerEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(playerAddressLabel)
                            .addComponent(playerAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(playerPhoneNumLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playerPhoneNumField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(playerProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(choosePhotoButton)
                .addContainerGap(271, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(profilePane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(profilePane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void choosePhotoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choosePhotoButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                selectPhoto(Paths.get(selectedFile.getAbsolutePath()));
            } catch (IOException ex) {
                Logger.getLogger(PlayerProfile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_choosePhotoButtonActionPerformed

    private void playerEmailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerEmailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playerEmailFieldActionPerformed

    private void playerAddressFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerAddressFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playerAddressFieldActionPerformed

    private void playerPhoneNumFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerPhoneNumFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playerPhoneNumFieldActionPerformed

    private void playerNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playerNameFieldActionPerformed

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
            java.util.logging.Logger.getLogger(PlayerProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlayerProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlayerProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlayerProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlayerProfile().setVisible(true);
            }
        });
    }
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton choosePhotoButton;
    private javax.swing.JTextField playerAddressField;
    private javax.swing.JLabel playerAddressLabel;
    private javax.swing.JTextField playerEmailField;
    private javax.swing.JLabel playerEmailLabel;
    private javax.swing.JTextField playerNameField;
    private javax.swing.JLabel playerNameLabel;
    private javax.swing.JTextField playerPhoneNumField;
    private javax.swing.JLabel playerPhoneNumLabel;
    private javax.swing.JLabel playerProfile;
    private javax.swing.JPanel profilePane;
    // End of variables declaration//GEN-END:variables
}

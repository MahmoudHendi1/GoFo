/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Players;

import Users.User;
import Users.UserMainForm;
import Users.UserManger;
import Utilits.Playground;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.validator.routines.EmailValidator;

/**
 *PlayerProfile represents the profile of the player in addition to the teams he has
 * and a button of browsing playgrounds
 * @author Lenovo
 * @version  1.0
 * @since 12/06/2020
 */
public class PlayerProfile extends javax.swing.JFrame {

    /**
     * Creates new form PlayerProfile
     */
    private Player player;
    private boolean editMode = false;

    public PlayerProfile(String text, String text0, String text1, String text2, String text3, String text4) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private ImageIcon scale(String path) {
        Image image = new ImageIcon(path).getImage();
        Image newimg = image.getScaledInstance(playerPhoto.getWidth(), -1, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        return new ImageIcon(newimg);
    }
    /**
     * This function resizes the Player's photo so it fits the best in the GUI.
     * @param inputImagePath
     * @param Photo
     * @throws IOException 
     */
    public void resizePlayerPhoto(String inputImagePath, JLabel Photo)
            throws IOException {
        // reads input image
        String outputImagePath="playerPhotos/" + player.getName() + ".jpg";
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);
 
        int scaledWidth= Photo.getWidth();
        int scaledHeight=Photo.getHeight();
        // creates output image
        BufferedImage outputImage = new BufferedImage(scaledWidth,
                scaledHeight, inputImage.getType());
        
        // scales the input image to the output image
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();
 
        // extracts extension of output file
        String formatName = outputImagePath.substring(outputImagePath
                .lastIndexOf(".") + 1);
 
        // writes to output file
        ImageIO.write(outputImage, formatName, new File(outputImagePath));
        playerPhoto.setIcon(scale(outputImagePath));
        player.setPhotoLink(outputImagePath);
    }
    /**
     * This function selects a photo from the device
     * @param originalPath
     * @throws IOException 
     */
    public void selectPhoto(Path originalPath) throws IOException {
        Path copied = Paths.get("playerPhotos/" + player.getUserName() + ".jpg");
        Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
        playerPhoto.setIcon(scale(copied.toString()));
        player.setPhotoLink(copied.toString());

    }
/**
 * This function sets the info of the player entered
 */
    public void setInfo() {

        playerNameField.setText(player.getName());
        playerEmailField.setText(player.getEmail());
        playerPhoneNumField.setText(player.getPhoneNumber());
        playerAddressField.setText(player.getAddress());
        playerPhoto.setIcon(scale(player.getPhotoLink()));
        choosePhotoButton.setVisible(false);
    }

    public PlayerProfile() {
        initComponents();
        player = new Player("Shawky", "ShawkyDev", "password_gamed", "youssef@gmail.com", "01157572128", "zayed , Giza");
        setInfo();

    }
     public class playersListRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(
                JList list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {

            JLabel label = (JLabel) super.getListCellRendererComponent(
                    list, value, index, isSelected, cellHasFocus);
            Image image = new ImageIcon(((Player)value).getPhotoLink()).getImage();
            Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            label.setIcon(new ImageIcon(newimg));
            label.setHorizontalTextPosition(JLabel.RIGHT);
            label.setBackground(Color.RED);
            setText(((Player)value).getUserName());
            return label;
        }
    }
      public class teamListRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(
                JList list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {

            JLabel label = (JLabel) super.getListCellRendererComponent(
                    list, value, index, isSelected, cellHasFocus);
            label.setHorizontalTextPosition(JLabel.CENTER);
            label.setText(((Team)value).getName());
            return label;
        }
    }
    public PlayerProfile(Player player) {
        initComponents();
        this.player = player;
        playersScrollPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        playersList.setCellRenderer(new playersListRenderer());
        teamsList.setCellRenderer(new teamListRenderer());
        teamPlayersScrollPane1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        if(player.getTeams()!=null)
            for(Team t : player.getTeams()){
                teams.addElement(t);
            }
        teamsList.setSelectedIndex(-1);
        setInfo();

    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPane = new javax.swing.JTabbedPane();
        profilePane = new javax.swing.JPanel();
        playerPhoto = new javax.swing.JLabel();
        playerNameLabel = new javax.swing.JLabel();
        playerAddressLabel = new javax.swing.JLabel();
        playerPhoneNumLabel = new javax.swing.JLabel();
        playerNameField = new javax.swing.JTextField();
        playerPhoneNumField = new javax.swing.JTextField();
        playerAddressField = new javax.swing.JTextField();
        playerEmailField = new javax.swing.JTextField();
        playerEmailLabel = new javax.swing.JLabel();
        choosePhotoButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        browsePlagroundButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        teamPane = new javax.swing.JPanel();
        usernamelField = new javax.swing.JTextField();
        usernameLabel = new javax.swing.JLabel();
        inviteButton = new javax.swing.JButton();
        teamNameField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        playersScrollPane = new javax.swing.JScrollPane();
        playersList = new javax.swing.JList<>();
        addPlayerButton = new javax.swing.JButton();
        creatTeamButton = new javax.swing.JButton();
        teamPlayersScrollPane1 = new javax.swing.JScrollPane();
        teamsList = new javax.swing.JList<>();
        teamLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        playerPhoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

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

        choosePhotoButton.setText("choose photo");
        choosePhotoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choosePhotoButtonActionPerformed(evt);
            }
        });

        EditButton.setText("Edit");
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });

        browsePlagroundButton.setText("Browse playgrounds");
        browsePlagroundButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browsePlagroundButtonActionPerformed(evt);
            }
        });

        logoutButton.setText("Log out");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout profilePaneLayout = new javax.swing.GroupLayout(profilePane);
        profilePane.setLayout(profilePaneLayout);
        profilePaneLayout.setHorizontalGroup(
            profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePaneLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(choosePhotoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playerPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playerEmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerAddressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerPhoneNumLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(playerPhoneNumField)
                    .addComponent(playerNameField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playerEmailField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playerAddressField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(browsePlagroundButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(profilePaneLayout.createSequentialGroup()
                        .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        profilePaneLayout.setVerticalGroup(
            profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(profilePaneLayout.createSequentialGroup()
                        .addComponent(playerPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(choosePhotoButton))
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
                            .addComponent(playerPhoneNumField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(browsePlagroundButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPane.addTab("Profile", profilePane);

        usernamelField.setEditable(false);
        usernamelField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernamelFieldActionPerformed(evt);
            }
        });

        usernameLabel.setText("Usename");

        inviteButton.setText("Send Email");

        teamNameField.setEditable(false);
        teamNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teamNameFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Team Name");

        playersList.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        playersList.setModel(playersModel);
        playersList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        playersList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        playersList.setEnabled(false);
        playersList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                playersListValueChanged(evt);
            }
        });
        playersScrollPane.setViewportView(playersList);

        addPlayerButton.setText("Add");
        addPlayerButton.setEnabled(false);
        addPlayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlayerButtonActionPerformed(evt);
            }
        });

        creatTeamButton.setText("New Team");
        creatTeamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creatTeamButtonActionPerformed(evt);
            }
        });

        teamsList.setModel(teams);
        teamsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        teamsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                teamsListValueChanged(evt);
            }
        });
        teamPlayersScrollPane1.setViewportView(teamsList);

        teamLabel.setLabelFor(playersList);
        teamLabel.setText("Team Members");

        javax.swing.GroupLayout teamPaneLayout = new javax.swing.GroupLayout(teamPane);
        teamPane.setLayout(teamPaneLayout);
        teamPaneLayout.setHorizontalGroup(
            teamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, teamPaneLayout.createSequentialGroup()
                .addGroup(teamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(teamPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(teamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(teamPaneLayout.createSequentialGroup()
                                .addGroup(teamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(teamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(usernamelField)
                                    .addComponent(teamNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(addPlayerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(teamPlayersScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(teamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(teamPaneLayout.createSequentialGroup()
                        .addComponent(creatTeamButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inviteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(playersScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teamLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        teamPaneLayout.setVerticalGroup(
            teamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(teamPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(teamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(teamPaneLayout.createSequentialGroup()
                        .addGroup(teamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(teamNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(teamLabel))
                        .addGap(31, 31, 31)
                        .addGroup(teamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usernamelField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(teamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(teamPaneLayout.createSequentialGroup()
                                .addComponent(addPlayerButton)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, teamPaneLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(teamPlayersScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(teamPaneLayout.createSequentialGroup()
                        .addGap(0, 28, Short.MAX_VALUE)
                        .addComponent(playersScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(teamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inviteButton)
                            .addComponent(creatTeamButton)))))
        );

        mainPane.addTab("Team", teamPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void choosePhotoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choosePhotoButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileFilter imageFilter = new FileNameExtensionFilter(
        "Image files", ImageIO.getReaderFileSuffixes());
        fileChooser.addChoosableFileFilter(imageFilter);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                resizePlayerPhoto(selectedFile.getAbsolutePath(),playerPhoto);
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
 * When the edit button is chosen, the fields becomes editable 
 * for the user to edit his data
 * @param evt 
 */
    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        //flip the flag 
        editMode = !editMode;
        if (editMode) {
            playerAddressField.setEditable(true);
            playerEmailField.setEditable(true);
            playerNameField.setEditable(true);
            playerPhoneNumField.setEditable(true);
            choosePhotoButton.setVisible(true);
            EditButton.setText("Save");
        } else {
            boolean isAllValid = true;
            playerAddressLabel.setForeground(Color.GREEN);
            playerEmailLabel.setForeground(Color.GREEN);
            playerNameLabel.setForeground(Color.GREEN);
            playerPhoneNumLabel.setForeground(Color.GREEN);

            EmailValidator emailValidator = EmailValidator.getInstance();
            if (!emailValidator.isValid(playerEmailField.getText())) {
                playerEmailLabel.setForeground(Color.red);
                isAllValid = false;
            }
            if (playerNameField.getText().isBlank()) {
                isAllValid = false;
                playerNameLabel.setForeground(Color.red);
            } else {
                for (int i = 0; i < playerNameField.getText().length(); ++i) {
                    if (!Character.isLetter(playerNameField.getText().charAt(i)) && playerNameField.getText().charAt(i) != ' ') {

                        isAllValid = false;
                        playerNameLabel.setForeground(Color.red);
                        break;
                    }
                }
            }
            if (playerAddressField.getText().isBlank()) {
                isAllValid = false;
                playerAddressLabel.setForeground(Color.red);
            }
            try {
                Double.parseDouble(playerPhoneNumField.getText());
                isAllValid = isAllValid && playerPhoneNumField.getText().charAt(0) == '0' && playerPhoneNumField.getText().length() == 11;
            } catch (NumberFormatException e) {
                isAllValid = false;
                playerPhoneNumLabel.setForeground(Color.RED);
            }
            if (isAllValid) {
                //checking the uniquness of the  phoneNumber , Email 
                if ((UserManger.getUserbyEmail(playerEmailField.getText()) != player &&  UserManger.getUserbyEmail(playerEmailField.getText()) != null) ){
                    JOptionPane.showMessageDialog(null, "This email is already in use", "Fail", JOptionPane.INFORMATION_MESSAGE);
                    playerEmailLabel.setForeground(Color.RED);
                } else if (UserManger.getUserByPhone(playerPhoneNumField.getText()) != player && UserManger.getUserByPhone(playerPhoneNumField.getText()) != null) {
                    JOptionPane.showMessageDialog(null, "This Phone number is already in use", "Fail", JOptionPane.INFORMATION_MESSAGE);
                    playerPhoneNumLabel.setForeground(Color.RED);
                } else {
                    /// allvalid and the data is unique :
                    //update
                    player.setAddress(playerAddressField.getText());
                    player.setName(playerNameField.getText());
                    player.setPhoneNumber(playerPhoneNumField.getText());
                    player.setEmail(playerEmailField.getText());
                    playerAddressField.setEditable(false);
                    playerEmailField.setEditable(false);
                    playerNameField.setEditable(false);
                    playerPhoneNumField.setEditable(false);
                    choosePhotoButton.setVisible(false);
                    EditButton.setText("Edit");
                    editMode=false;
                }

            } else {
                JOptionPane.showMessageDialog(null, "All data must be Valid", "Fail", JOptionPane.INFORMATION_MESSAGE);
                editMode = true;
                
            }

            

        }
    }//GEN-LAST:event_EditButtonActionPerformed

    private void browsePlagroundButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browsePlagroundButtonActionPerformed
        // TODO add your handling code here:
        BookingPage bookingPage = new BookingPage(player);
        this.dispose();
        bookingPage.setVisible(true);
    }//GEN-LAST:event_browsePlagroundButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
        UserMainForm loginFrom = new UserMainForm();
        loginFrom.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void addPlayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPlayerButtonActionPerformed
        // TODO add your handling code here:
        String playerUsername= usernamelField.getText();

        for(Player player : DB.DatabaseSimulator.getPlayers()){
            if (player.getUserName().equals(playerUsername)) {
                for(int i=0 ;i < playersModel.getSize();i++){
                    if(player.equals(playersModel.getElementAt(i)))
                    usernameLabel.setForeground(Color.red);
                    return;
                }
                usernameLabel.setForeground(Color.green);
                playersModel.addElement(player);
                return;
            }
        }
        usernameLabel.setForeground(Color.red);
    }//GEN-LAST:event_addPlayerButtonActionPerformed

    private void playersListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_playersListValueChanged

        // TODO add your handling code here:
    }//GEN-LAST:event_playersListValueChanged

    private void teamNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teamNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_teamNameFieldActionPerformed

    private void usernamelFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernamelFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernamelFieldActionPerformed
    private boolean isCreatingTeam = false;
    private void creatTeamButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creatTeamButtonActionPerformed
        // TODO add your handling code here:
        isCreatingTeam = !isCreatingTeam;
        
        teamsList.setSelectedIndex(-1);

        if(isCreatingTeam){
         creatTeamButton.setText("Create!");
         teamNameField.setEditable(true);
         usernamelField.setEditable(true);
         addPlayerButton.setEnabled(true);
         teamsList.enable(false);
        
        
        }else{
         Team team = new Team(teamNameField.getText());
         if(playersModel.size()>0)
            for(var obj : playersModel.toArray())
               team.addMember((Player)obj);
         player.getTeams().add(team);
         teams.addElement(team);
         
         teamNameField.setText("");
         usernamelField.setText("");

         creatTeamButton.setText("New Team");
         addPlayerButton.setEnabled(false);
         teamNameField.setEditable(false);
         usernamelField.setEditable(false);
         teamsList.enable(true);

            
        }
         playersModel.removeAllElements();

    }//GEN-LAST:event_creatTeamButtonActionPerformed

    private void teamsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_teamsListValueChanged
        // TODO add your handling code here:
        playersModel.removeAllElements();
        if(teamsList.getSelectedIndex()!=-1){
            for(Player p: teamsList.getSelectedValue().members){
                playersModel.addElement(p);
            }
        }
    }//GEN-LAST:event_teamsListValueChanged

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

   DefaultListModel playersModel= new DefaultListModel();
   DefaultListModel teamPlayersModel= new DefaultListModel();
   DefaultListModel teams = new DefaultListModel();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EditButton;
    private javax.swing.JButton addPlayerButton;
    private javax.swing.JButton browsePlagroundButton;
    private javax.swing.JButton choosePhotoButton;
    private javax.swing.JButton creatTeamButton;
    private javax.swing.JButton inviteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JTabbedPane mainPane;
    private javax.swing.JTextField playerAddressField;
    private javax.swing.JLabel playerAddressLabel;
    private javax.swing.JTextField playerEmailField;
    private javax.swing.JLabel playerEmailLabel;
    private javax.swing.JTextField playerNameField;
    private javax.swing.JLabel playerNameLabel;
    private javax.swing.JTextField playerPhoneNumField;
    private javax.swing.JLabel playerPhoneNumLabel;
    private javax.swing.JLabel playerPhoto;
    private javax.swing.JList<Player> playersList;
    private javax.swing.JScrollPane playersScrollPane;
    private javax.swing.JPanel profilePane;
    private javax.swing.JLabel teamLabel;
    private javax.swing.JTextField teamNameField;
    private javax.swing.JPanel teamPane;
    private javax.swing.JScrollPane teamPlayersScrollPane1;
    private javax.swing.JList<Team> teamsList;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernamelField;
    // End of variables declaration//GEN-END:variables
}

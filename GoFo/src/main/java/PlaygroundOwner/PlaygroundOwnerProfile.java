/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlaygroundOwner;

import Users.UserMainForm;
import Users.UserManger;
import Utilits.Playground;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dialog.ModalityType;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import org.apache.commons.validator.routines.EmailValidator;

/**
 *
 * @author Lenovo
 */
public class PlaygroundOwnerProfile extends javax.swing.JFrame {
    
    
    private ImageIcon scale(String path, JLabel Photo) throws IOException {
        Image image = new ImageIcon(path).getImage();
        System.out.println(playgroundPhoto.getWidth());
        Image newimg = image.getScaledInstance(Photo.getWidth(),-1, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 

        return new ImageIcon(newimg);
    }

    public void selectPlayerPhoto(Path originalPath) throws IOException {
        Path copied = Paths.get("playerPhotos/" + playgroundOwner.getName() + ".jpg");
        Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
        playgroundOwnerProfilePhoto.setIcon(scale(copied.toString(),playgroundOwnerProfilePhoto));
        playgroundOwner.setPhotoLink(copied.toString());

    }
    public void selectPlaygroundPhoto(Path originalPath,String name) throws IOException {
        Path copied = Paths.get("playgroundPhotos/" + "dummy" + ".jpg");
        Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);

        playgroundPhoto.setIcon(scale(copied.toString(),playgroundPhoto));

    }

    public void setInfo() throws IOException {

        playgroundOwnerNameField.setText(playgroundOwner.getName());
        playgroundOwnerEmailField.setText(playgroundOwner.getEmail());
        playgroundOwnerPhoneNumField.setText(playgroundOwner.getPhoneNumber());
        playgroundOwnerAddressField.setText(playgroundOwner.getAddress());
        playgroundOwnerProfilePhoto.setIcon(scale(playgroundOwner.getPhotoLink(),playgroundOwnerProfilePhoto));
        choosePhotoButton.setVisible(false);
    }
    /**
     * Creates new form PlaygroundOwnerProfile
     */
    //not used 
    public PlaygroundOwnerProfile() throws IOException {
        initComponents();
        LeftPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        playgroundList.setCellRenderer(new PlaygroundListRenderer());
        
  
        //testing
        
        setInfo();

    }
    public PlaygroundOwnerProfile(PlaygroundOwner playgroundOwner) throws IOException {
        initComponents();
        LeftPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        playgroundList.setCellRenderer(new PlaygroundListRenderer());
        this.playgroundOwner= playgroundOwner;
        
        for(int i=0;i<playgroundOwner.getPlaygroundsList().size();i++){
            playGroundModel.add(i,playgroundOwner.getPlaygroundsList().get(i));
            
        }

        
        fromComboBox.setSelectedIndex(-1);
        toComboBox.setSelectedIndex(-1);
       setInfo();
 
    }
    
    
    public class PlaygroundListRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(
                JList list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {

            JLabel label = (JLabel) super.getListCellRendererComponent(
                    list, value, index, isSelected, cellHasFocus);
            Image image = new ImageIcon("playgroundPhotos\\" +((Playground)value).getName()+".jpg").getImage();
            Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            label.setIcon(new ImageIcon(newimg));
            label.setHorizontalTextPosition(JLabel.RIGHT);
            if(((Playground)value).isApproved())
                label.setBackground(Color.GREEN);
            else
                 label.setBackground(Color.RED);
            setText(((Playground)value).getName());
            return label;
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

        addPlaygroundDialog = new javax.swing.JDialog();
        addPlaygroundPane = new javax.swing.JPanel();
        playgroundPhoto = new javax.swing.JLabel();
        descriptionLabel1 = new javax.swing.JLabel();
        nameLabel1 = new javax.swing.JLabel();
        addressLabel1 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        AddressField = new javax.swing.JTextField();
        choosePhotoButton1 = new javax.swing.JButton();
        descriptionArea = new javax.swing.JTextArea();
        priceField = new javax.swing.JTextField();
        PriceLabel = new javax.swing.JLabel();
        fromComboBox = new javax.swing.JComboBox<>();
        toComboBox = new javax.swing.JComboBox<>();
        timeLabel = new javax.swing.JLabel();
        fromLabel = new javax.swing.JLabel();
        toLabel = new javax.swing.JLabel();
        addPlaygroundButton = new javax.swing.JButton();
        MainPane = new javax.swing.JTabbedPane();
        profilePane = new javax.swing.JPanel();
        playgroundOwnerProfilePhoto = new javax.swing.JLabel();
        playgroundOwnerNameLabel = new javax.swing.JLabel();
        playgroundOwnerAddressLabel = new javax.swing.JLabel();
        playgroundOwnerPhoneNumLabel = new javax.swing.JLabel();
        playgroundOwnerNameField = new javax.swing.JTextField();
        playgroundOwnerPhoneNumField = new javax.swing.JTextField();
        playgroundOwnerAddressField = new javax.swing.JTextField();
        playgroundOwnerEmailField = new javax.swing.JTextField();
        playgroundOwnerEmailLabel = new javax.swing.JLabel();
        choosePhotoButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        PlaygroudsPane = new javax.swing.JPanel();
        LeftPane = new javax.swing.JScrollPane();
        playgroundList = new javax.swing.JList<>();
        RightPane = new javax.swing.JPanel();
        playgroundImage = new javax.swing.JLabel();
        playgroundNameLabel = new javax.swing.JLabel();
        playgroundAddressLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        playgrounDescriptionTextArea = new javax.swing.JTextArea();
        descriptionLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        priceLabelField = new javax.swing.JLabel();
        playgroindPriceLabel = new javax.swing.JLabel();

        addPlaygroundDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addPlaygroundDialog.setMinimumSize(new java.awt.Dimension(560, 370));
        addPlaygroundDialog.setSize(addPlaygroundDialog.getPreferredSize());
        addPlaygroundDialog.setType(java.awt.Window.Type.POPUP);

        playgroundPhoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        playgroundPhoto.setMaximumSize(new java.awt.Dimension(300, 300));
        playgroundPhoto.setMinimumSize(new java.awt.Dimension(196, 188));
        playgroundPhoto.setPreferredSize(new java.awt.Dimension(196, 188));
        playgroundPhoto.setRequestFocusEnabled(false);

        descriptionLabel1.setText("Description");

        nameLabel1.setText("Name: ");

        addressLabel1.setText("Address: ");

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        choosePhotoButton1.setText("choose photo");
        choosePhotoButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choosePhotoButton1ActionPerformed(evt);
            }
        });

        descriptionArea.setColumns(20);
        descriptionArea.setLineWrap(true);
        descriptionArea.setRows(5);

        priceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceFieldActionPerformed(evt);
            }
        });

        PriceLabel.setText("Price:");

        fromComboBox.setModel(time1);
        fromComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromComboBoxActionPerformed(evt);
            }
        });

        toComboBox.setModel(time2);

        timeLabel.setText("Available Time");

        fromLabel.setLabelFor(fromComboBox);
        fromLabel.setText("From");

        toLabel.setLabelFor(toComboBox);
        toLabel.setText("To");

        addPlaygroundButton.setText("Add");
        addPlaygroundButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlaygroundButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addPlaygroundPaneLayout = new javax.swing.GroupLayout(addPlaygroundPane);
        addPlaygroundPane.setLayout(addPlaygroundPaneLayout);
        addPlaygroundPaneLayout.setHorizontalGroup(
            addPlaygroundPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPlaygroundPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addPlaygroundPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playgroundPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choosePhotoButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(addPlaygroundPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addPlaygroundPaneLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(addPlaygroundPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addressLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(addPlaygroundPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(AddressField)
                            .addComponent(priceField, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)))
                    .addGroup(addPlaygroundPaneLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(addPlaygroundPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descriptionLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(addPlaygroundPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descriptionArea)
                            .addGroup(addPlaygroundPaneLayout.createSequentialGroup()
                                .addGroup(addPlaygroundPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(fromLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fromComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 85, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(addPlaygroundPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(toComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(toLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(addPlaygroundButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(44, 44, 44))
        );
        addPlaygroundPaneLayout.setVerticalGroup(
            addPlaygroundPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPlaygroundPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addPlaygroundPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addPlaygroundPaneLayout.createSequentialGroup()
                        .addComponent(playgroundPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(choosePhotoButton1))
                    .addGroup(addPlaygroundPaneLayout.createSequentialGroup()
                        .addGroup(addPlaygroundPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(addPlaygroundPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(addPlaygroundPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addressLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(addPlaygroundPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descriptionLabel1)
                            .addComponent(descriptionArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(addPlaygroundPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addPlaygroundPaneLayout.createSequentialGroup()
                                .addComponent(timeLabel)
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addPlaygroundPaneLayout.createSequentialGroup()
                                .addGroup(addPlaygroundPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fromLabel)
                                    .addComponent(toLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(addPlaygroundPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fromComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(toComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addComponent(addPlaygroundButton)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout addPlaygroundDialogLayout = new javax.swing.GroupLayout(addPlaygroundDialog.getContentPane());
        addPlaygroundDialog.getContentPane().setLayout(addPlaygroundDialogLayout);
        addPlaygroundDialogLayout.setHorizontalGroup(
            addPlaygroundDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addPlaygroundPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        addPlaygroundDialogLayout.setVerticalGroup(
            addPlaygroundDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addPlaygroundPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        playgroundOwnerProfilePhoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        playgroundOwnerNameLabel.setText("Name: ");

        playgroundOwnerAddressLabel.setText("Address:");

        playgroundOwnerPhoneNumLabel.setText("Phone Number:");

        playgroundOwnerNameField.setEditable(false);
        playgroundOwnerNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playgroundOwnerNameFieldActionPerformed(evt);
            }
        });

        playgroundOwnerPhoneNumField.setEditable(false);
        playgroundOwnerPhoneNumField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playgroundOwnerPhoneNumFieldActionPerformed(evt);
            }
        });

        playgroundOwnerAddressField.setEditable(false);
        playgroundOwnerAddressField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playgroundOwnerAddressFieldActionPerformed(evt);
            }
        });

        playgroundOwnerEmailField.setEditable(false);
        playgroundOwnerEmailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playgroundOwnerEmailFieldActionPerformed(evt);
            }
        });

        playgroundOwnerEmailLabel.setText("Email");

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
                .addContainerGap()
                .addGroup(profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(choosePhotoButton, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(playgroundOwnerProfilePhoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playgroundOwnerEmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playgroundOwnerNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playgroundOwnerAddressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playgroundOwnerPhoneNumLabel))
                .addGroup(profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(playgroundOwnerPhoneNumField)
                    .addComponent(playgroundOwnerNameField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playgroundOwnerEmailField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playgroundOwnerAddressField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(profilePaneLayout.createSequentialGroup()
                        .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(216, Short.MAX_VALUE))
        );
        profilePaneLayout.setVerticalGroup(
            profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(profilePaneLayout.createSequentialGroup()
                        .addGroup(profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(playgroundOwnerNameLabel)
                            .addComponent(playgroundOwnerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(playgroundOwnerEmailLabel)
                            .addComponent(playgroundOwnerEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(playgroundOwnerAddressLabel)
                            .addComponent(playgroundOwnerAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(playgroundOwnerPhoneNumLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playgroundOwnerPhoneNumField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(playgroundOwnerProfilePhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(profilePaneLayout.createSequentialGroup()
                        .addGroup(profilePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(141, Short.MAX_VALUE))
                    .addGroup(profilePaneLayout.createSequentialGroup()
                        .addComponent(choosePhotoButton)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        MainPane.addTab("Profile", profilePane);

        playgroundList.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        playgroundList.setModel(playGroundModel);
        playgroundList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        playgroundList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        playgroundList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                playgroundListValueChanged(evt);
            }
        });
        LeftPane.setViewportView(playgroundList);

        playgroundImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        playgrounDescriptionTextArea.setEditable(false);
        playgrounDescriptionTextArea.setColumns(20);
        playgrounDescriptionTextArea.setLineWrap(true);
        playgrounDescriptionTextArea.setRows(5);
        jScrollPane2.setViewportView(playgrounDescriptionTextArea);

        descriptionLabel.setText("Description");

        nameLabel.setText("Name: ");

        addressLabel.setText("Address: ");

        addButton.setText("Add ");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        playgroindPriceLabel.setText("Price:");

        javax.swing.GroupLayout RightPaneLayout = new javax.swing.GroupLayout(RightPane);
        RightPane.setLayout(RightPaneLayout);
        RightPaneLayout.setHorizontalGroup(
            RightPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightPaneLayout.createSequentialGroup()
                .addComponent(playgroundImage, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(RightPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(RightPaneLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(RightPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(RightPaneLayout.createSequentialGroup()
                                .addGroup(RightPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(playgroindPriceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(RightPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(priceLabelField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(playgroundAddressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                    .addComponent(playgroundNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(RightPaneLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightPaneLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        RightPaneLayout.setVerticalGroup(
            RightPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RightPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playgroundImage, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(RightPaneLayout.createSequentialGroup()
                        .addGroup(RightPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                            .addComponent(playgroundNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(RightPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(playgroundAddressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(RightPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(priceLabelField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playgroindPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(descriptionLabel)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout PlaygroudsPaneLayout = new javax.swing.GroupLayout(PlaygroudsPane);
        PlaygroudsPane.setLayout(PlaygroudsPaneLayout);
        PlaygroudsPaneLayout.setHorizontalGroup(
            PlaygroudsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PlaygroudsPaneLayout.createSequentialGroup()
                .addGap(0, 207, Short.MAX_VALUE)
                .addComponent(RightPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PlaygroudsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PlaygroudsPaneLayout.createSequentialGroup()
                    .addComponent(LeftPane, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 536, Short.MAX_VALUE)))
        );
        PlaygroudsPaneLayout.setVerticalGroup(
            PlaygroudsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RightPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PlaygroudsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(LeftPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
        );

        MainPane.addTab("Playgrounds", PlaygroudsPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 723, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(MainPane))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 356, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(MainPane))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playgroundOwnerNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playgroundOwnerNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playgroundOwnerNameFieldActionPerformed

    private void playgroundOwnerPhoneNumFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playgroundOwnerPhoneNumFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playgroundOwnerPhoneNumFieldActionPerformed

    private void playgroundOwnerAddressFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playgroundOwnerAddressFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playgroundOwnerAddressFieldActionPerformed

    private void playgroundOwnerEmailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playgroundOwnerEmailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playgroundOwnerEmailFieldActionPerformed

    private void choosePhotoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choosePhotoButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                selectPlayerPhoto(Paths.get(selectedFile.getAbsolutePath()));
            } catch (IOException ex) {
                Logger.getLogger(PlaygroundOwnerProfile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_choosePhotoButtonActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        //flip the flag
        editMode = !editMode;
        if (editMode) {
            playgroundOwnerAddressField.setEditable(true);
            playgroundOwnerEmailField.setEditable(true);
            playgroundOwnerNameField.setEditable(true);
            playgroundOwnerPhoneNumField.setEditable(true);
            choosePhotoButton.setVisible(true);
            EditButton.setText("Save");
        } else {
            boolean isAllValid = true;
            playgroundOwnerAddressLabel.setForeground(Color.GREEN);
            playgroundOwnerEmailLabel.setForeground(Color.GREEN);
            playgroundOwnerNameLabel.setForeground(Color.GREEN);
            playgroundOwnerPhoneNumLabel.setForeground(Color.GREEN);

            EmailValidator emailValidator = EmailValidator.getInstance();
            if (!emailValidator.isValid(playgroundOwnerEmailField.getText())) {
                playgroundOwnerEmailLabel.setForeground(Color.red);
                isAllValid = false;
            }
            if (playgroundOwnerNameField.getText().isBlank()) {
                isAllValid = false;
                playgroundOwnerNameLabel.setForeground(Color.red);
            } else {
                for (int i = 0; i < playgroundOwnerNameField.getText().length(); ++i) {
                    if (!Character.isLetter(playgroundOwnerNameField.getText().charAt(i)) && playgroundOwnerNameField.getText().charAt(i) != ' ') {

                        isAllValid = false;
                        playgroundOwnerNameLabel.setForeground(Color.red);
                        break;
                    }
                }
            }
            if (playgroundOwnerAddressField.getText().isBlank()) {
                isAllValid = false;
                playgroundOwnerAddressLabel.setForeground(Color.red);
            }
            try {
                Double.parseDouble(playgroundOwnerPhoneNumField.getText());
                isAllValid = isAllValid && playgroundOwnerPhoneNumField.getText().charAt(0) == '0' && playgroundOwnerPhoneNumField.getText().length() == 11;
            } catch (NumberFormatException e) {
                isAllValid = false;
                playgroundOwnerPhoneNumLabel.setForeground(Color.RED);
            }
            if (isAllValid) {
                //checking the uniquness of the  phoneNumber , Email
                if (UserManger.getUserbyEmail(playgroundOwnerEmailField.getText()) != playgroundOwner &&  UserManger.getUserbyEmail(playgroundOwnerEmailField.getText()) != null) {
                    JOptionPane.showMessageDialog(null, "This email is already in use", "Fail", JOptionPane.INFORMATION_MESSAGE);
                    playgroundOwnerEmailLabel.setForeground(Color.RED);
                } else if (UserManger.getUserByPhone(playgroundOwnerPhoneNumField.getText()) != playgroundOwner && UserManger.getUserByPhone(playgroundOwnerPhoneNumField.getText()) != null) {
                    JOptionPane.showMessageDialog(null, "This Phone number is already in use", "Fail", JOptionPane.INFORMATION_MESSAGE);
                    playgroundOwnerPhoneNumLabel.setForeground(Color.RED);
                } else {
                    /// allvalid and the data is unique :
                    //update
                    playgroundOwner.setAddress(playgroundOwnerAddressField.getText());
                    playgroundOwner.setName(playgroundOwnerNameField.getText());
                    playgroundOwner.setPhoneNumber(playgroundOwnerPhoneNumField.getText());
                    playgroundOwner.setEmail(playgroundOwnerEmailField.getText());
                    playgroundOwnerAddressField.setEditable(false);
                    playgroundOwnerEmailField.setEditable(false);
                    playgroundOwnerNameField.setEditable(false);
                    playgroundOwnerPhoneNumField.setEditable(false);
                    choosePhotoButton.setVisible(false);
                    EditButton.setText("Edit");
                    editMode=false;
                    //comment
                }

            } else {
                JOptionPane.showMessageDialog(null, "All data must be Valid", "Fail", JOptionPane.INFORMATION_MESSAGE);
                editMode = true;

            }

        }
    }//GEN-LAST:event_EditButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
        UserMainForm loginFrom = new UserMainForm();
        loginFrom.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_logoutButtonActionPerformed

    private void playgroundListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_playgroundListValueChanged

        // TODO add your handling code here:
        Image image = new ImageIcon("playgroundPhotos\\" +((Playground)playgroundList.getSelectedValue()).getName()+".jpg").getImage();
            Image newimg = image.getScaledInstance(playgroundImage.getWidth(),-1,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            playgroundImage.setIcon(new ImageIcon(newimg) );
            priceLabelField.setText(Double.toString(playgroundList.getSelectedValue().getDefaultPricePerHour()));
            playgroundNameLabel.setText( playgroundList.getSelectedValue().getName());
            playgroundAddressLabel.setText(playgroundList.getSelectedValue().getAddress());
            playgrounDescriptionTextArea.setText(playgroundList.getSelectedValue().getDescription());
          


    }//GEN-LAST:event_playgroundListValueChanged

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        addPlaygroundDialog.setVisible(true);
    }//GEN-LAST:event_addButtonActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void choosePhotoButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choosePhotoButton1ActionPerformed
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            pathPhoto =selectedFile.getAbsolutePath();
            try {
                
                selectPlaygroundPhoto(Paths.get(selectedFile.getAbsolutePath()), nameField.getText());
            } catch (IOException ex) {
                Logger.getLogger(PlaygroundOwnerProfile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_choosePhotoButton1ActionPerformed

    private void priceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceFieldActionPerformed

    private void fromComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fromComboBoxActionPerformed

    private void addPlaygroundButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPlaygroundButtonActionPerformed
        // TODO add your handling code here:
        
                Boolean isAllright=true;

        String playgroundName =nameField.getText();
        for(Playground tmpPlayground: playgroundOwner.getPlaygroundsList()){
            if(tmpPlayground.getName().equals(playgroundName)||playgroundName.equals("")){
                nameLabel1.setForeground(Color.red);
                isAllright=false;
            }else{
                nameLabel1.setForeground(Color.green);

            }
        }
        
        double price;
        try {
             price = Double.parseDouble(priceField.getText());
            
        } catch (NumberFormatException e) {
            price = -1;
        }
            
        if(AddressField.getText().equals("")){
            isAllright=false;
            addressLabel1.setForeground(Color.red);
        }else{
            addressLabel1.setForeground(Color.green);

        }
        if(descriptionArea.getText().equals("")){
            isAllright=false;
            descriptionLabel1.setForeground(Color.red);
        }else{
            descriptionLabel1.setForeground(Color.green);

        }
        if(price <0){
            isAllright=false;
            PriceLabel.setForeground(Color.red);
        }else{
            timeLabel.setForeground(Color.green);

        }
        if(fromComboBox.getSelectedIndex() == -1 ||toComboBox.getSelectedIndex() == -1){
            isAllright=false;
            timeLabel.setForeground(Color.red);
        }else{
            timeLabel.setForeground(Color.green);

        }
        if(isAllright){
            Playground newPlayground =  new Playground(playgroundName, AddressField.getText(), descriptionArea.getText(), price);
            newPlayground.setOpeningHour((int) toComboBox.getSelectedItem());
            newPlayground.setOpeningHour((int) fromComboBox.getSelectedItem());
     
            PlaygroundOwnerManager.addPlayground(newPlayground, playgroundOwner);
            
            if(playgroundPhoto.getIcon()!=null){
             playgroundOwner.getPlaygroundsList().get(playgroundOwner.getPlaygroundsList().size()-1).setImageLink("playerPhotos/" + nameField.getText() + ".jpg");
             Path source=Paths.get("playgroundPhotos/" +"dummy" + ".jpg");


                try {
                Files.copy(source, Paths.get("playgroundPhotos/" +nameField.getText() + ".jpg"), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException ex) {
                    Logger.getLogger(PlaygroundOwnerProfile.class.getName()).log(Level.SEVERE, null, ex);
                }


 
            }
            playGroundModel.addElement(playgroundOwner.getPlaygroundsList().get(playgroundOwner.getPlaygroundsList().size()-1));
            addPlaygroundDialog.dispose();
            
            
        }
    }//GEN-LAST:event_addPlaygroundButtonActionPerformed

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
            java.util.logging.Logger.getLogger(PlaygroundOwnerProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlaygroundOwnerProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlaygroundOwnerProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlaygroundOwnerProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PlaygroundOwnerProfile().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(PlaygroundOwnerProfile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    private PlaygroundOwner playgroundOwner;
    private boolean editMode = false;
    DefaultListModel playGroundModel= new DefaultListModel();
    private String pathPhoto="";
    DefaultComboBoxModel time1=   new javax.swing.DefaultComboBoxModel<>(new Integer[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24  });
    DefaultComboBoxModel time2=   new javax.swing.DefaultComboBoxModel<>(new Integer[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24  });

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AddressField;
    private javax.swing.JButton EditButton;
    private javax.swing.JScrollPane LeftPane;
    private javax.swing.JTabbedPane MainPane;
    private javax.swing.JPanel PlaygroudsPane;
    private javax.swing.JLabel PriceLabel;
    private javax.swing.JPanel RightPane;
    private javax.swing.JButton addButton;
    private javax.swing.JButton addPlaygroundButton;
    private javax.swing.JDialog addPlaygroundDialog;
    private javax.swing.JPanel addPlaygroundPane;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel addressLabel1;
    private javax.swing.JButton choosePhotoButton;
    private javax.swing.JButton choosePhotoButton1;
    private javax.swing.JTextArea descriptionArea;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JLabel descriptionLabel1;
    private javax.swing.JComboBox<Integer> fromComboBox;
    private javax.swing.JLabel fromLabel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton logoutButton;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel nameLabel1;
    private javax.swing.JLabel playgroindPriceLabel;
    private javax.swing.JTextArea playgrounDescriptionTextArea;
    private javax.swing.JLabel playgroundAddressLabel;
    private javax.swing.JLabel playgroundImage;
    private javax.swing.JList<Playground> playgroundList;
    private javax.swing.JLabel playgroundNameLabel;
    private javax.swing.JTextField playgroundOwnerAddressField;
    private javax.swing.JLabel playgroundOwnerAddressLabel;
    private javax.swing.JTextField playgroundOwnerEmailField;
    private javax.swing.JLabel playgroundOwnerEmailLabel;
    private javax.swing.JTextField playgroundOwnerNameField;
    private javax.swing.JLabel playgroundOwnerNameLabel;
    private javax.swing.JTextField playgroundOwnerPhoneNumField;
    private javax.swing.JLabel playgroundOwnerPhoneNumLabel;
    private javax.swing.JLabel playgroundOwnerProfilePhoto;
    private javax.swing.JLabel playgroundPhoto;
    private javax.swing.JTextField priceField;
    private javax.swing.JLabel priceLabelField;
    private javax.swing.JPanel profilePane;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JComboBox<Integer> toComboBox;
    private javax.swing.JLabel toLabel;
    // End of variables declaration//GEN-END:variables
}

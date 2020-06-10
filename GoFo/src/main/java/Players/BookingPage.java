/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Players;

import DB.DatabaseSimulator;
import Utilits.Booking;
import Utilits.Playground;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.xml.crypto.Data;

/**
 *
 * @author Lenovo
 */
public class BookingPage extends javax.swing.JFrame {

    private Player player;

    /**
     * Creates new form BookingPage
     */
    public BookingPage() {
        /*
        initComponents();
        jScrollPane1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        playgroundList.setCellRenderer(new PlaygroundListRenderer());

        Playground p = new Playground("Dummy", "garbage1", "garbage1", DEFAULT_CURSOR);
        Playground p1 = new Playground("Dummy", "garbage2", "garbage2", DEFAULT_CURSOR);
        Playground p2 = new Playground("Dummy", "garbage3", "garbage3", DEFAULT_CURSOR);
        Playground p3 = new Playground("Dummy", "garbage4", "garbage4", DEFAULT_CURSOR);
        playGroundModel.add(0, p);
        playGroundModel.add(1, p1);
        playGroundModel.add(2, p2);
        playGroundModel.add(3, p3);
         */
    }

    BookingPage(Player player) {
        this.player = player;
        initComponents();
        jScrollPane1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        playgroundList.setCellRenderer(new PlaygroundListRenderer());
        bookingButton.setEnabled(false);
        var playgroundlist = DatabaseSimulator.getApprovedPlaygrounds();
        for (var playground : playgroundlist) {
            playGroundModel.addElement(playground);
        }
        OpenHours.removeAllElements();
        closeHours.removeAllElements();
        if (DateChooser.getDate() == null) {
            DateChooser.setDate(new Date());
        }

        for (int i = 0; i < 24; i++) {
            OpenHours.addElement((Integer) i);
            closeHours.addElement((Integer) (i));
        }
        fromComboBox.setSelectedIndex(-1);
        toComboBox.setSelectedIndex(-1);

    }

    public class PlaygroundListRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(
                JList list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {

            JLabel label = (JLabel) super.getListCellRendererComponent(
                    list, value, index, isSelected, cellHasFocus);
            Image image = new ImageIcon("playgroundPhotos\\" + ((Playground) value).getName() + ".jpg").getImage();
            Image newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            label.setIcon(new ImageIcon(newimg));
            label.setHorizontalTextPosition(JLabel.RIGHT);
            setText(((Playground) value).getName());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        playgroundList = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        playgroundImage = new javax.swing.JLabel();
        playgroundNameLabel = new javax.swing.JLabel();
        playgroundAddressLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        playgrounDescriptionTextArea = new javax.swing.JTextArea();
        descriptionLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        bookingButton = new javax.swing.JButton();
        addressField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        priceField = new javax.swing.JTextField();
        timeLabel = new javax.swing.JLabel();
        fromLabel = new javax.swing.JLabel();
        fromComboBox = new javax.swing.JComboBox<>();
        toComboBox = new javax.swing.JComboBox<>();
        toLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        filterButton = new javax.swing.JButton();
        DateChooser = new com.toedter.calendar.JDateChooser();
        nameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        priceLabel1 = new javax.swing.JLabel();
        playgroundPriceLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        playgroundList.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        playgroundList.setModel(playGroundModel);
        playgroundList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        playgroundList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        playgroundList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playgroundListMouseClicked(evt);
            }
        });
        playgroundList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                playgroundListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(playgroundList);

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        playgroundImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        playgrounDescriptionTextArea.setEditable(false);
        playgrounDescriptionTextArea.setColumns(20);
        playgrounDescriptionTextArea.setRows(5);
        jScrollPane2.setViewportView(playgrounDescriptionTextArea);

        descriptionLabel.setLabelFor(playgrounDescriptionTextArea);
        descriptionLabel.setText("Description");

        nameLabel.setText("Name: ");

        addressLabel.setLabelFor(playgroundAddressLabel);
        addressLabel.setText("Address: ");

        bookingButton.setText("Book");
        bookingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingButtonActionPerformed(evt);
            }
        });

        addressField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Name");

        jLabel2.setText("Price:");

        priceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceFieldActionPerformed(evt);
            }
        });

        timeLabel.setText("Play Time");

        fromLabel.setText("From");

        fromComboBox.setModel(OpenHours);
        fromComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromComboBoxActionPerformed(evt);
            }
        });

        toComboBox.setModel(closeHours);

        toLabel.setText("To");

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        filterButton.setText("Filter");
        filterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterButtonActionPerformed(evt);
            }
        });

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        jLabel3.setText("Addres:");

        priceLabel1.setLabelFor(playgroundAddressLabel);
        priceLabel1.setText("Price:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(playgroundImage, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(priceLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(playgroundAddressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(playgroundNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(playgroundPriceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 67, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(filterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(bookingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(40, 40, 40)
                        .addComponent(timeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(fromLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fromComboBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(toComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(toLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(DateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(playgroundImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                            .addComponent(playgroundNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(playgroundAddressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(playgroundPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(priceLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(descriptionLabel)
                        .addGap(1, 1, 1)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fromLabel)
                            .addComponent(toLabel)
                            .addComponent(timeLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fromComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(toComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playgroundListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_playgroundListValueChanged

        // TODO add your handling code here:
        bookingButton.setEnabled(true);
        if (playgroundList.getSelectedValue() == null) {
            return;
        }
        Image image = new ImageIcon("playgroundPhotos\\" + ((Playground) playgroundList.getSelectedValue()).getName() + ".jpg").getImage();
        Image newimg = image.getScaledInstance(playgroundImage.getWidth(), -1, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        playgroundImage.setIcon(new ImageIcon(newimg));

        playgroundNameLabel.setText(playgroundList.getSelectedValue().getName());
        playgroundAddressLabel.setText(playgroundList.getSelectedValue().getAddress());
        playgrounDescriptionTextArea.setText(playgroundList.getSelectedValue().getDescription());
        playgroundPriceLabel.setText(playgroundList.getSelectedValue().getDefaultPricePerHour() + "");
        int OpeningHour = playgroundList.getSelectedValue().getOpeningHour();
        int ClosingHour = playgroundList.getSelectedValue().getClosingHour();
        OpenHours.removeAllElements();
        closeHours.removeAllElements();

        for (int i = OpeningHour; i != ClosingHour; i = (i + 1) % 24) {
            OpenHours.addElement((Integer) i);
            closeHours.addElement((Integer) (i + 1));
        }
        fromComboBox.setSelectedIndex(-1);
        toComboBox.setSelectedIndex(-1);


    }//GEN-LAST:event_playgroundListValueChanged

    private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterButtonActionPerformed
        // TODO add your handling code here:
        //var date = DateChooser.getDate();
        int hour = (fromComboBox.getSelectedItem() != null) ? ((Integer) fromComboBox.getSelectedItem()).intValue() : -1;
        int duration = (hour != -1) ? ((Integer) toComboBox.getSelectedItem()).intValue() - hour : -1;
        Calendar calendar = null;
        if (DateChooser.getCalendar() != null) {
            calendar = DateChooser.getCalendar();
            calendar.set(Calendar.HOUR_OF_DAY, hour);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            System.out.println("cal:" + calendar.getTime().toString());
        }

        double price = -1;
        try {
            price = Double.parseDouble(priceField.getText());
        } catch (NumberFormatException e) {
            price = -1;
        }

        var filteredPlaygrounds = GetFilteredPlaygrounds(addressField.getText(), nameField.getText(), price, (calendar != null) ? calendar.getTime() : null, duration);
        playGroundModel.clear();
        System.out.println("here");
        for (var playground : filteredPlaygrounds) {
            playGroundModel.addElement(playground);
        }

        System.out.println("filtered");

    }//GEN-LAST:event_filterButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        PlayerProfile playerProfile = new PlayerProfile(player);
        playerProfile.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_backButtonActionPerformed

    private void fromComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromComboBoxActionPerformed
        // TODO add your handling code here:
        if (fromComboBox.getSelectedIndex() == -1) {
            toComboBox.setEnabled(false);
        } else if (playgroundList.getSelectedIndex() == -1) {

            int OpeningHour = (int) fromComboBox.getSelectedItem();
            closeHours.removeAllElements();
            for (int i = OpeningHour + 1; i != OpeningHour; i = (i + 1) % 24) {
                closeHours.addElement((Integer) (i));
            }
            toComboBox.setEnabled(true);

        } else {
            if (OpenHours.getSize() > 1) {
                int OpeningHour = (int) fromComboBox.getSelectedItem();
                int ClosingHour = playgroundList.getSelectedValue().getClosingHour();
                closeHours.removeAllElements();
                for (int i = OpeningHour; i != ClosingHour; i = (i + 1) % 24) {
                    closeHours.addElement((Integer) (i + 1));
                }
            }
            toComboBox.setEnabled(true);
        }

    }//GEN-LAST:event_fromComboBoxActionPerformed

    private void priceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceFieldActionPerformed

    private void addressFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressFieldActionPerformed

    private void bookingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingButtonActionPerformed
        if (toComboBox.getSelectedItem() == null || fromComboBox.getSelectedItem() == null || DateChooser.getDate() == null || playgroundList.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(null, "missing Info!", "please specify start , end time", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int hour = ((Integer) fromComboBox.getSelectedItem()).intValue();
            int duration = ((Integer) toComboBox.getSelectedItem()).intValue() - hour;
            Calendar calendar = null;
            if (DateChooser.getCalendar() != null) {
                calendar = DateChooser.getCalendar();
                calendar.set(Calendar.HOUR_OF_DAY, hour);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                int responsecode = PlayerManager.isBookngPossible(playgroundList.getSelectedValue(), calendar.getTime(), duration, player);
                if (responsecode == 1) {
                    PlayerManager.bookPlayground(playgroundList.getSelectedValue(), calendar.getTime(), duration, player);
                    JOptionPane.showMessageDialog(null, "success", "Booked!", JOptionPane.INFORMATION_MESSAGE);
                    return;

                } else {
                    if(responsecode == 10 )
                    JOptionPane.showMessageDialog(null, "can't book a playground in the past \n try again after (or before :D) inventing the time machine  :D", "Did you invent the time machine ?", JOptionPane.INFORMATION_MESSAGE);
                    if(responsecode == 15 )
                    JOptionPane.showMessageDialog(null, "The playground is Booked at the same date \ntry another date or playground :d ", "Already Booked slot!", JOptionPane.INFORMATION_MESSAGE);
                    
                }
            }
        }
    }//GEN-LAST:event_bookingButtonActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void playgroundListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playgroundListMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_playgroundListMouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        playgroundList.clearSelection();
        bookingButton.setEnabled(false);
        playgroundImage.setIcon(null);
        playgroundNameLabel.setText("");
        playgrounDescriptionTextArea.setText("");
        playgroundAddressLabel.setText("");
        playgroundPriceLabel.setText("");
        OpenHours.removeAllElements();
        closeHours.removeAllElements();
        if (DateChooser.getDate() == null) {
            DateChooser.setDate(new Date());
        }

        for (int i = 0; i < 24; i++) {
            OpenHours.addElement((Integer) i);
            closeHours.addElement((Integer) (i));
        }
        fromComboBox.setSelectedIndex(-1);
        toComboBox.setSelectedIndex(-1);


    }//GEN-LAST:event_jPanel1MouseClicked
    private ArrayList<Playground> GetFilteredPlaygrounds(String location, String name, double price, Date available, int duration) {
        var playgrounds = DatabaseSimulator.getApprovedPlaygrounds();
        ArrayList<Playground> filtered = new ArrayList<Playground>();
        for (var playground : playgrounds) {
            if (name.isBlank() || playground.getName().toLowerCase().contains(name.toLowerCase())) {
                if (location.isBlank() || playground.getAddress().toLowerCase().contains(location.toLowerCase())) {
                    if (price < 0 || playground.getDefaultPricePerHour() <= price) {
                        if (available == null || (playground.getOpeningHour() <= available.getHours() && playground.isAvailable(available, Math.max(1, duration)))) {
                            filtered.add(playground);
                        }
                    }
                }
            }
        }
        return filtered;
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
            java.util.logging.Logger.getLogger(BookingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookingPage().setVisible(true);
            }
        });
    }

    DefaultListModel playGroundModel = new DefaultListModel();
    DefaultComboBoxModel time = new javax.swing.DefaultComboBoxModel<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24});
    DefaultComboBoxModel OpenHours = new DefaultComboBoxModel<>(new Integer[]{});
    DefaultComboBoxModel closeHours = new DefaultComboBoxModel<>(new Integer[]{});
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateChooser;
    private javax.swing.JTextField addressField;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JButton backButton;
    private javax.swing.JButton bookingButton;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JButton filterButton;
    private javax.swing.JComboBox<Integer> fromComboBox;
    private javax.swing.JLabel fromLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextArea playgrounDescriptionTextArea;
    private javax.swing.JLabel playgroundAddressLabel;
    private javax.swing.JLabel playgroundImage;
    private javax.swing.JList<Playground> playgroundList;
    private javax.swing.JLabel playgroundNameLabel;
    private javax.swing.JLabel playgroundPriceLabel;
    private javax.swing.JTextField priceField;
    private javax.swing.JLabel priceLabel1;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JComboBox<Integer> toComboBox;
    private javax.swing.JLabel toLabel;
    // End of variables declaration//GEN-END:variables
}

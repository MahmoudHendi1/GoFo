/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilits;

import PlaygroundOwner.PlaygroundOwner;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author ShawkyDev
 */
public class Playground implements Serializable{
    private static final long serialVersionUID = 3L;
    private PlaygroundOwner owner;
    private String name;
    private Boolean approved;
    private String address;
    private String description;
    private double defaultPricePerHour;
    private BufferedImage image;
    private String imageLink;
    private URL locationOnMap;

    private static ArrayList<Booking> bookdesTimes;

    public Playground(String name, String addres, String description, double defaultPriceHour, URL url) {
        this.name = name;
        this.address = addres;
        this.description = description;
        this.defaultPricePerHour = defaultPriceHour;
        this.locationOnMap = url;
        this.approved = false;

        //this.image=ImageIO.read(new File(name+".jpg"));

    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public Playground(String name, String addres, String description, double defaultPricePerHour) {
        this.name = name;
        this.address = addres;
        this.description = description;
        this.defaultPricePerHour = defaultPricePerHour;
    }

    public BufferedImage getImage() {
        return image;
    }

    

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Boolean getApproved() {
        return approved;
    }
    
    public String getAddress() {
        return address;
    }

    public PlaygroundOwner getOwner() {
        return owner;
    }

    public void setOwner(PlaygroundOwner owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public double getDefaultPricePerHour() {
        return defaultPricePerHour;
    }

    public static ArrayList<Booking> getBookdesTimes() {
        return bookdesTimes;
    }

    public String getName() {
        return name;
    }

 
    @Override
    public String toString() {
        return "\nPlayground{" + "name=" + name + ", approved=" + approved + ", address=" + address + ", description=" + description + ", defaultPricePerHour=" + defaultPricePerHour + ", image=" + image + ", locationOnMap=" + locationOnMap + '}';
    }

    

    public URL getLocationOnMap() {
        return locationOnMap;
    }
    public void setApproved(boolean approve){
        this.approved = approve;
    }

    public void setLocationOnMap(URL locationOnMap) {
        this.locationOnMap = locationOnMap;
    }
    

    
}

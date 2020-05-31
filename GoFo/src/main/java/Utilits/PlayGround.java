/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilits;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author ShawkyDev
 */
public class Playground {
    private String name;
    private String addres;
    private String description;
    private double defaultPricePerHour;
    private BufferedImage image;
    private URL locationOnMap;

    private static ArrayList<Booking> bookdesTimes;

    public Playground(String name, String addres, String description, double defaultPriceHour, URL url) {
        this.name = name;
        this.addres = addres;
        this.description = description;
        this.defaultPricePerHour = defaultPriceHour;
        this.locationOnMap = url;

        //this.image=ImageIO.read(new File(name+".jpg"));

    }

    public Playground(String name, String addres, String description, double defaultPricePerHour) {
        this.name = name;
        this.addres = addres;
        this.description = description;
        this.defaultPricePerHour = defaultPricePerHour;
    }

    public BufferedImage getImage() {
        return image;
    }

    public String getAddres() {
        return addres;
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
        return name; //To change body of generated methods, choose Tools | Templates.
    }

    public URL getLocationOnMap() {
        return locationOnMap;
    }

    public void setLocationOnMap(URL locationOnMap) {
        this.locationOnMap = locationOnMap;
    }
    

    
}

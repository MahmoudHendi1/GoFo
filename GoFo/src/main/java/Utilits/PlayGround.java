/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilits;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author ShawkyDev
 */
public class Playground {
    private String name;
    private String addres;
    private String description;
    private double defaultPriceHour;
    private BufferedImage image;

    private static ArrayList<Booking> bookdesTimes;

    public Playground(String name, String addres, String description, double defaultPriceHour) {
        this.name = name;
        this.addres = addres;
        this.description = description;
        this.defaultPriceHour = defaultPriceHour;

        //this.image=ImageIO.read(new File(name+".jpg"));

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

    public double getDefaultPriceHour() {
        return defaultPriceHour;
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
    

    
}

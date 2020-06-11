package Utilits;

import PlaygroundOwner.PlaygroundOwner;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ShawkyDev
 * @version  1.0
 * @since 9/6/2020
 */
public class Playground implements Serializable{
    private static final long serialVersionUID = 3L;
    private PlaygroundOwner owner;
    private String name;
    private boolean approved;
    private String address;
    private String description;
    private double defaultPricePerHour;
    private BufferedImage image;
    private String imageLink;
    private URL locationOnMap;
    private int openingHour;
    private int closingHour;

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

    public int getOpeningHour() {
        return openingHour;
    }

    public void setOpeningHour(int openingHour) {
        this.openingHour = openingHour;
    }

    public int getClosingHour() {
        return closingHour;
    }

    public void setClosingHour(int closingHour) {
        this.closingHour = closingHour;
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

    public void setDefaultPricePerHour(double defaultPricePerHour) {
        this.defaultPricePerHour = defaultPricePerHour;
    }

    

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public boolean getApproved() {
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

    public  ArrayList<Booking> getBookdeTimes() {
        if(bookdesTimes==null)
            bookdesTimes= new ArrayList<Booking>();
        return bookdesTimes;
    }

    public String getName() {
        return name;
    }

 
    
    public String toString() {
        return "\nPlayground{" + "name=" + name + ", approved=" + approved + ", address=" + address + ", description=" + description + ", defaultPricePerHour=" + defaultPricePerHour + ", image=" + image + ", locationOnMap=" + locationOnMap + '}';
    }

    

    public URL getLocationOnMap() {
        return locationOnMap;
    }
   

    public void setLocationOnMap(URL locationOnMap) {
        this.locationOnMap = locationOnMap;
    }

    public boolean isAvailable(Date available , int duratoin) {
        ///sets time to end time (time in mellisecond = hours * 60 * 60 * 1000
        Date end_date = new Date(available.getTime() + duratoin * 60 * 60 * 1000);
        
        if(bookdesTimes ==null) return true;
        for(var booking : bookdesTimes){
            if(booking.getDate().after(end_date)||booking.getEndDate().before(available)){
                /// okay no conflict;
            }
            else{
                return false;
            }
        }
        return true;
    }
    

    
}

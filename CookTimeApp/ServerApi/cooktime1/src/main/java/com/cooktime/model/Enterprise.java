package com.cooktime.model;

import java.util.ArrayList;

/**
 * Class in charge of creating enterprises.
 */
public class Enterprise {
    
    private String name;
    private String logo;
    private String contact;
    private String schedule;
    private String direction;
    private int calification = 0;
    private int followers = 0;
    private ArrayList<String> members = new ArrayList<String>();
    private ArrayList<Recipe> myMenuList = new ArrayList<Recipe>();

    /**
     * Constructor of this class.
     * @param name String name of the enterprise.
     * @param logo String logo of the enterprise.
     * @param contact String contact of the enterprise.
     * @param schedule String schedule of the enterprise.
     * @param direction String direction of the enterprise.
     * @param members ArrayList members of the enterprise.
     */
    public Enterprise(String name, String logo, String contact, String schedule, String direction, ArrayList<String> members) {
        
        this.name = name;
        this.logo = logo;
        this.contact = contact;
        this.schedule = schedule;
        this.direction = direction;
        this.members = members;
        
    }
    
    /**
     * Constructor of this class.
     * @param name String name of the enterprise.
     * @param logo String logo of the enterprise.
     * @param contact String contact of the enterprise.
     * @param schedule String schedule of the enterprise.
     * @param direction String direction of the enterprise.
     * @param calification int calification of the enterprise.
     * @param followers int followers of the enterprise.
     * @param members ArrayList members of the enterprise.
     * @param myMenuList ArrayList myMenuList list of recipes.
     */
    public Enterprise(String name, String logo, String contact, String schedule, String direction, int calification, int followers,
                      ArrayList<String> members, ArrayList<Recipe> myMenuList) {
        
        this.name = name;
        this.logo = logo;
        this.contact = contact;
        this.schedule = schedule;
        this.direction = direction;
        this.calification = calification;
        this.followers = followers;
        this.members = members;
        this.myMenuList = myMenuList;
        
    } 
    
    public String getName() {
        
        return name;
        
    }

    public void setName(String name) {
        
        this.name = name;
        
    }

    public String getLogo() {
        
        return logo;
        
    }

    public void setLogo(String logo) {
        
        this.logo = logo;
        
    }

    public String getContact() {
        
        return contact;
        
    }

    public void setContact(String contact) {
        
        this.contact = contact;
        
    }

    public String getSchedule() {
        
        return schedule;
        
    }

    public void setSchedule(String schedule) {
        
        this.schedule = schedule;
    }
    
    public String getDirection() {
        
        return direction;
        
    }

    public void setDirection(String direction) {
        
        this.direction = direction;
        
    }

    public ArrayList<String> getMembers() {
        
        return members;
        
    }

    public void setMembers(ArrayList<String> members) {
        
        this.members = members;
        
    }

    public int getCalification() {
        
        return calification;
        
    }

    public void setCalification(int calification) {
        
        this.calification = calification;
        
    }
    
    public int getFollowers() {
        
        return followers;
        
    }

    public void setFollowers(int followers) {
        
        this.followers = followers;
        
    }

    public ArrayList<Recipe> getMyMenuList() {
        
        return myMenuList;
        
    }

    public void setMyMenuList(ArrayList<Recipe> myMenuList) {
        
        this.myMenuList = myMenuList;
        
    }
       
}

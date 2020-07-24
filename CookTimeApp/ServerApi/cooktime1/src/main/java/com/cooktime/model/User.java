package com.cooktime.model;

import java.util.ArrayList;

/**
 * Class in charge of creating users.
 */
public class User {
    
    private String email;
    private String name;
    private String lastName;
    private int age;
    private String password;
    private String photo;
    private ArrayList<Recipe> myMenuList = new ArrayList<Recipe>();
    private String lastSort = "BubbleSort";
    private int followers = 0;
    private int followed = 0;
    private boolean chef;
        
    /**
     * Constructor of this class.
     * @param email String email of the user.
     */
    public User(String email) {
        
        this.email = email;
        
    }

    /**
     * Constructor of this class.
     * @param email String email of the user.
     * @param name String name of the user.
     * @param lastName String lastName of the user.
     * @param age int age of the user.
     * @param password String password of the user.
     * @param photo String photo of the user.
     * @param chef boolean chef of the user.
     */
    public User(String email, String name, String lastName, int age, String password,
                String photo, boolean chef) {
        
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.password = password;
        this.photo = photo;
        this.chef = chef;
        
    }
    
    /**
     * Constructor of this class.
     * @param email String email of the user.
     * @param name String name of the user.
     * @param lastName String lastName of the user.
     * @param age int age of the user.
     * @param password String password of the user.
     * @param photo String photo of the user.
     * @param myMenuList ArrayList myMenuList of the user.
     * @param followers int followers of the user.
     * @param followed int followed of the user
     * @param chef boolean chef of the user.
     */
    public User(String email, String name, String lastName, int age, String password, String photo,
                ArrayList<Recipe> myMenuList, int followers, int followed, boolean chef) {
        
        BubbleSort bubbleSort = new BubbleSort();
        
        bubbleSort.sort(myMenuList);
                
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.password = password;
        this.photo = photo;
        this.myMenuList = myMenuList;
        this.followers = followers;
        this.followed = followed;
        this.chef = chef;
        
    }

    public String getEmail() {
        
        return email;
        
    }

    public void setEmail(String email) {
        
        this.email = email;
        
    }

    public String getName() {
        
        return name;
        
    }

    public void setName(String name) {
        
        this.name = name;
        
    }

    public String getLastName() {
        
        return lastName;
        
    }

    public void setLastName(String lastName) {
        
        this.lastName = lastName;
        
    }

    public int getAge() {
        
        return age;
        
    }

    public void setAge(int age) {
        
        this.age = age;
        
    }

    public String getPassword() {
        
        return password;
        
    }

    public void setPassword(String password) {
        
        this.password = password;
        
    }

    public String getPhoto() {
        
        return photo;
        
    }

    public void setPhoto(String photo) {
        
        this.photo = photo;
        
    }

    public ArrayList<Recipe> getMyMenuList() {
        
        return myMenuList;
        
    }

    public void setMyMenuList(ArrayList<Recipe> myMenuList) {
        
        this.myMenuList = myMenuList;
        
    }

    public String getLastSort() {
        
        return lastSort;
        
    }

    public void setLastSort(String lastSort) {
        
        this.lastSort = lastSort;
        
    }

    public int getFollowers() {
        
        return followers;
        
    }

    public void setFollowers(int followers) {
        
        this.followers = followers;
        
    }

    public int getFollowed() {
        
        return followed;
        
    }

    public void setFollowed(int followed) {
        
        this.followed = followed;
        
    }

    public boolean getChef() {
        
        return chef;
        
    }

    public void setChef(boolean chef) {
        
        this.chef = chef;
        
    }
        
}

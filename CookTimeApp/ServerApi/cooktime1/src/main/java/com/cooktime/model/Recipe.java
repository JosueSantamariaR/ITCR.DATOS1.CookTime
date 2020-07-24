package com.cooktime.model;

import java.util.ArrayList;

public class Recipe {
    
    private String name;
    private String author;
    private String type;
    private int portions;
    private int duration;
    private String time;
    private int difficulty;
    private String dietTag;
    private String photo;
    private String ingredients;
    private String steps;
    private int price;
    private int calification = 0;
    private int day;
    private int month;
    private int year;
    private ArrayList<String> commentary = new ArrayList<String>();

    public Recipe(String name, String author, String type, int portions, int duration,
                  String time, int difficulty, String dietTag, String photo, String ingredients,
                  String steps, int price, int day, int month, int year) {
        
        this.name = name;
        this.author = author;
        this.type = type;
        this.portions = portions;
        this.duration = duration;
        this.time = time;
        this.difficulty = difficulty;
        this.dietTag = dietTag;
        this.photo = photo;
        this.ingredients = ingredients;
        this.steps = steps;
        this.price = price;
        this.day = day;
        this.month = month;
        this.year = year;
        
    }
    
    public Recipe(String name, String author, String type, int portions, int duration,
                  String time, int difficulty, String dietTag, String photo, String ingredients,
                  String steps, int price, int calification, int day, int month, int year,
                  ArrayList<String> commentary) {
        
        this.name = name;
        this.author = author;
        this.type = type;
        this.portions = portions;
        this.duration = duration;
        this.time = time;
        this.difficulty = difficulty;
        this.dietTag = dietTag;
        this.photo = photo;
        this.ingredients = ingredients;
        this.steps = steps;
        this.price = price;
        this.calification = calification;
        this.day = day;
        this.month = month;
        this.year = year;
        this.commentary = commentary;
        
    }
  
    public String getName() {
        
        return name;
        
    }

    public void setName(String name) {
        
        this.name = name;
        
    }

    public String getAuthor() {
        
        return author;
        
    }

    public void setAuthor(String author) {
        
        this.author = author;
        
    }

    public String getType() {
        
        return type;
        
    }

    public void setType(String type) {
        
        this.type = type;
        
    }

    public int getPortions() {
        
        return portions;
        
    }

    public void setPortions(int portions) {
        
        this.portions = portions;
        
    }

    public int getDuration() {
        
        return duration;
        
    }

    public void setDuration(int duration) {
        
        this.duration = duration;
        
    }

    public String getTime() {
        
        return time;
    }
    
    public void setTime(String time) {
        
        this.time = time;
        
    }

    public int getDifficulty() {
        
        return difficulty;
        
    }

    public void setDifficulty(int difficulty) {
        
        this.difficulty = difficulty;
        
    }

    public String getDietTag() {
        
        return dietTag;
        
    }

    public void setDietTag(String dietTag) {
        
        this.dietTag = dietTag;
        
    }

    public String getPhoto() {
        
        return photo;
        
    }

    public void setPhoto(String photo) {
        
        this.photo = photo;
        
    }

    public String getIngredients() {
        
        return ingredients;
        
    }

    public void setIngredients(String ingredients) {
        
        this.ingredients = ingredients;
        
    }

    public String getSteps() {
        
        return steps;
        
    }

    public void setSteps(String steps) {
        
        this.steps = steps;
        
    }

    public int getPrice() {
        
        return price;
        
    }

    public void setPrice(int price) {
        
        this.price = price;
        
    }

    public int getCalification() {
        
        return calification;
        
    }

    public void setCalification(int calification) {
        
        this.calification = calification;
        
    }

    public int getDay() {
        
        return day;
        
    }

    public void setDay(int day) {
        
        this.day = day;
        
    }

    public int getMonth() {
        
        return month;
        
    }

    public void setMonth(int month) {
        
        this.month = month;
        
    }

    public int getYear() {
        
        return year;
        
    }

    public void setYear(int year) {
        
        this.year = year;
        
    }   

    public ArrayList<String> getCommentary() {
        
        return commentary;
        
    }

    public void setCommentary(ArrayList<String> commentary) {
        
        this.commentary = commentary;
        
    }
       
}

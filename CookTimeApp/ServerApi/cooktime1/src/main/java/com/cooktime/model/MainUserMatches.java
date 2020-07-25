package com.cooktime.model;

import java.util.ArrayList;

public class MainUserMatches {
    
    
    
    public static void main() {
        
        
        BinaryTree binaryTree = BinaryTree.getInstance();
        
        binaryTree.insert("@IgnacioA", "IgnacioA", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert("@IgnacioB", "IgnacioB", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert("@IgnacioC", "IgnacioC", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert("@IgnacioD", "IgnacioD", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert("@IgnacioE", "IgnacioE", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert("@IgnacioF", "IgnacioF", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert("@IgnacioG", "IgnacioG", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert("@IgnacioH", "IgnacioH", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert("@IgnacioI", "IgnacioI", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert("@IgnacioJ", "IgnacioJ", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert("@IgnacioK", "IgnacioK", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert("@IgnacioL", "IgnacioL", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert("@IgnacioM", "IgnacioM", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert("@IgnacioN", "IgnacioN", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert("@Ignacio—", "Ignacio—", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert("@IgnacioO", "IgnacioO", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert("@IgnacioP", "IgnacioP", "Granados", 20, "abc", "photo.png", true);
        
        UserJson.insertFollowed("@IgnacioA", "@Nacho");
        UserJson.insertFollowed("@IgnacioA", "@Santa");
        UserJson.insertFollowed("@IgnacioA", "@Akion");
        
        //System.out.println(binaryTree.getUser("@IgnacioA").getFollowedNames());
                        
        //ArrayList<User> newList = new ArrayList<User>();
               
        //newList = binaryTree.matches("Ignacio", 7);
        
        //print(newList);
        
    }
    
    private static void print(ArrayList<User> list) {
        
        for (int i = 0; i < list.size(); i ++) {
            
            System.out.println(list.get(i).getName());
            
        }
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

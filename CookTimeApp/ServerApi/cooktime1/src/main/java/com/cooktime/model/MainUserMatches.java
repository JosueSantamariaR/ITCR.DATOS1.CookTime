package com.cooktime.model;

import java.util.ArrayList;

public class MainUserMatches {
    
    
    
    public static void main(String args[]) {        
        
        BinaryTree binaryTree = BinaryTree.getInstance();
        
        binaryTree.insert("@IgnacioA", "IgnacioA", "Granados", 20, "abc", "photo.png", false);
        binaryTree.insert("@IgnacioB", "IgnacioB", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert("@IgnacioC", "IgnacioC", "Granados", 20, "abc", "photo.png", false);
        binaryTree.insert("@IgnacioD", "IgnacioD", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert("@IgnacioE", "IgnacioE", "Granados", 20, "abc", "photo.png", false);
        binaryTree.insert("@IgnacioF", "IgnacioF", "Granados", 20, "abc", "photo.png", true);
        
        String[] list = {"IgnacioA","@IgnacioA"};
        
        //ArrayList<User> matches = binaryTree.matches("Ignacio", 7);
                
        AVLTree aVLTree = AVLTree.getInstance();
        
        aVLTree.insert("Arroz1", "", "Desayuno", 0, 0, "Aperitivo", 0, "Vegano", "", "", "", 0, 0, 0, 0);
        aVLTree.insert("Arroz2", "", "Almuerzo", 0, 0, "Plato", 0, "Carnivoro", "", "", "", 0, 0, 0, 0);
        aVLTree.insert("Arroz3", "", "Cena", 0, 0, "Bebida", 0, "Animal", "", "", "", 0, 0, 0, 0);
        aVLTree.insert("Arroz4", "", "Desayuno", 0, 0, "Aperitivo", 0, "Vegano", "", "", "", 0, 0, 0, 0);
        aVLTree.insert("Arroz5", "", "Almuerzo", 0, 0, "Plato", 0, "Carnivoro", "", "", "", 0, 0, 0, 0);
        aVLTree.insert("Arroz6", "", "Cena", 0, 0, "Bebida", 0, "Animal", "", "", "", 0, 0, 0, 0);
               
        aVLTree.getRecipe("Arroz1").setEmail("@IgnacioA");
        aVLTree.getRecipe("Arroz2").setEmail("@IgnacioB");
        aVLTree.getRecipe("Arroz3").setEmail("@IgnacioC");
        aVLTree.getRecipe("Arroz4").setEmail("@IgnacioD");
        aVLTree.getRecipe("Arroz5").setEmail("@IgnacioE");
        aVLTree.getRecipe("Arroz6").setEmail("@IgnacioF");
        
        
        
        
        
        
        
        
        ArrayList<Recipe> matches = aVLTree.matches("Arroz",5);
      
        
        
        
        
      
        
        
        
        
        for (int i = 0; i < matches.size(); i ++) {
            
            System.out.println(matches.get(i).getName());
            
        }
        
        
        /*
        binaryTree.insert("@IgnacioG", "IgnacioG", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert("@IgnacioH", "IgnacioH", "Granados", 20, "abc", "photo.png", false);
        binaryTree.insert("@IgnacioI", "IgnacioI", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert("@IgnacioJ", "IgnacioJ", "Granados", 20, "abc", "photo.png", false);
        binaryTree.insert("@IgnacioK", "IgnacioK", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert("@IgnacioL", "IgnacioL", "Granados", 20, "abc", "photo.png", false);
        binaryTree.insert("@IgnacioM", "IgnacioM", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert("@IgnacioN", "IgnacioN", "Granados", 20, "abc", "photo.png", false);
        binaryTree.insert("@IgnacioÑ", "IgnacioÑ", "Granados", 20, "abc", "photo.png", true);
        binaryTree.insert("@IgnacioO", "IgnacioO", "Granados", 20, "abc", "photo.png", false);
        binaryTree.insert("@IgnacioP", "IgnacioP", "Granados", 20, "abc", "photo.png", true);
        */
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //UserJson.insertFollowed("@IgnacioA", "@Nacho");
        //UserJson.insertFollowed("@IgnacioA", "@Santa");
        //UserJson.insertFollowed("@IgnacioA", "@Akion");
        
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

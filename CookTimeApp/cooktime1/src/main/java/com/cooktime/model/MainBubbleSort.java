package com.cooktime.model;

import java.util.ArrayList;

public class MainBubbleSort {

    public static void main() {
        
        ArrayList<String> commentary = new ArrayList<String>();
        
        Recipe r1 = new Recipe("Arroz", "Juan", "Desayuno", 1, 0, "Aperitivo", 18, "Vegetariana", "photo.png", "Harina", "comer", 100, 18,    2, 2, 2020, commentary); // 4
        Recipe r2 = new Recipe("Avena", "Juan", "Desayuno", 1, 0, "Aperitivo", 11, "Vegetariana", "photo.png", "Harina", "comer", 100, 14,    2, 2, 2019, commentary); // 3
        Recipe r3 = new Recipe("Galletas", "Juan", "Desayuno", 1, 0, "Aperitivo", 22, "Vegetariana", "photo.png", "Harina", "comer", 100, 22, 2, 2, 2024, commentary); // 5
        Recipe r4 = new Recipe("Frijoles", "Juan", "Desayuno", 1, 0, "Aperitivo", 1, "Vegetariana", "photo.png", "Harina", "comer", 100, 1,   2, 2, 2010, commentary);   // 1
        Recipe r5 = new Recipe("Pasta", "Juan", "Desayuno", 1, 0, "Aperitivo", 9, "Vegetariana", "photo.png", "Harina", "comer", 100, 9,      2, 2, 2016, commentary);   // 2
        
        ArrayList<Recipe> list = new ArrayList<Recipe>();
        
        list.add(r1);
        list.add(r2);
        list.add(r3);
        list.add(r4);
        list.add(r5);
        
        AVLTree aVLTree = AVLTree.getInstance();
        
        aVLTree.insert("Arroz1", "", "Desayuno", 0, 0, "Aperitivo", 0, "Vegano", "", "", "", 0, 0, 0, 0);
        aVLTree.insert("Arroz2", "", "Almuerzo", 0, 0, "Plato", 0,     "Carnivoro", "", "", "", 0, 0, 0, 0);
        aVLTree.insert("Arroz3", "", "Cena", 0, 0, "Bebida", 0,        "Animal", "", "", "", 0, 0, 0, 0);
        aVLTree.insert("Arroz4", "", "Desayuno", 0, 0, "Aperitivo", 0, "Vegano", "", "", "", 0, 0, 0, 0);
        aVLTree.insert("Arroz5", "", "Almuerzo", 0, 0, "Plato", 0,     "Carnivoro", "", "", "", 0, 0, 0, 0);
        aVLTree.insert("Arroz6", "", "Cena", 0, 0, "Bebida", 0,        "Animal", "", "", "", 0, 0, 0, 0);
        
        ArrayList<Recipe> array = aVLTree.dietTagFilter("Animal");
        
                
        //BubbleSort bubbleSort = new BubbleSort();
        
        //bubbleSort.sort(list);
        
        for (int i = 0; i < array.size(); i++) {
            
            System.out.println(array.get(i).getName());
            
        }


        
    }

    
}

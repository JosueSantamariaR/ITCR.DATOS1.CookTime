package com.cooktime.model;

import java.util.ArrayList;

public class MainRadixSort {

    public static void main() {
        
        ArrayList<String> commentary = new ArrayList<String>();
        
        Recipe r1 = new Recipe("Arroz", "Juan", "Desayuno", 1, 0, "Aperitivo",    18, "Vegetariana", "photo.png", "Harina", "comer", 100, 18, 12, 2, 2020, commentary); // 4
        Recipe r2 = new Recipe("Avena", "Juan", "Desayuno", 1, 0, "Aperitivo",    11, "Vegetariana", "photo.png", "Harina", "comer", 100, 14, 12, 2, 2020, commentary); // 3
        Recipe r3 = new Recipe("Galletas", "Juan", "Desayuno", 1, 0, "Aperitivo", 22, "Vegetariana", "photo.png", "Harina", "comer", 100, 22, 12, 2, 2020, commentary); // 5
        Recipe r4 = new Recipe("Frijoles", "Juan", "Desayuno", 1, 0, "Aperitivo", 1, "Vegetariana", "photo.png", "Harina", "comer", 100, 1, 12, 2, 2020, commentary);   // 1
        Recipe r5 = new Recipe("Pasta", "Juan", "Desayuno", 1, 0, "Aperitivo",    9, "Vegetariana", "photo.png", "Harina", "comer", 100, 9, 12, 2, 2020, commentary);   // 2
               
        ArrayList<Recipe> list = new ArrayList<Recipe>();
        
        list.add(r1);
        list.add(r2);
        list.add(r3);
        list.add(r4);
        list.add(r5);
                        
        RadixSort radix = new RadixSort();                      
        
        int size = list.size();                   
        
        ArrayList<Recipe> finalList = radix.sort(list, size);               
        
        for (int i = 0; i < finalList.size(); i++) {
            
            System.out.println(finalList.get(i).getName());
            
        }        
        
    }   
       
}

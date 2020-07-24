package com.cooktime.model;

import java.util.ArrayList;

public class MainQuickSort {

    public static void main() {
        
        ArrayList<String> commentary = new ArrayList<String>();
        
        Recipe r1 = new Recipe("Arroz", "Juan", "Desayuno", 1, 0, "Aperitivo", 1, "Vegetariana", "photo.png", "Harina", "comer", 100,    18, 12, 2, 2020, commentary); // 4
        Recipe r2 = new Recipe("Avena", "Juan", "Desayuno", 1, 0, "Aperitivo", 1, "Vegetariana", "photo.png", "Harina", "comer", 100,    14, 12, 2, 2020, commentary); // 3
        Recipe r3 = new Recipe("Galletas", "Juan", "Desayuno", 1, 0, "Aperitivo", 1, "Vegetariana", "photo.png", "Harina", "comer", 100,    22, 12, 2, 2020, commentary); // 5
        Recipe r4 = new Recipe("Frijoles", "Juan", "Desayuno", 1, 0, "Aperitivo", 1, "Vegetariana", "photo.png", "Harina", "comer", 100, 1, 12, 2, 2020, commentary);  // 1
        Recipe r5 = new Recipe("Pasta", "Juan", "Desayuno", 1, 0, "Aperitivo", 1, "Vegetariana", "photo.png", "Harina", "comer", 100,    9, 12, 2, 2020, commentary);  // 2
        
        
        ArrayList<Recipe> list = new ArrayList<Recipe>();
        
        list.add(r1);
        list.add(r2);
        list.add(r3);
        list.add(r4);
        list.add(r5);
        
        int minIndex = 0;
        int maxIndex = list.size() - 1;
        
        QuickSort quickSort = new QuickSort();
        
        quickSort.sort(list, minIndex, maxIndex);
        
        for (int i = 0; i < list.size(); i++) {
            
            System.out.println(list.get(i).getName());
            
        }
        
    }
    
}

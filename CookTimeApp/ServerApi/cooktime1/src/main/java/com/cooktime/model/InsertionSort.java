package com.cooktime.model;

import java.util.ArrayList;

public class InsertionSort {
    
    public void sort(ArrayList<Recipe> array, String lastSort) {
        
        Recipe aux;
        
        if (lastSort == "BubbleSort") {

            for (int i = 1; i < array.size(); i++) {

                aux = array.get(i);

                //for (int j = i - 1; j >= 0 && array.get(j).getPublication() > aux.getPublication(); j--) {
                
                for (int j = i - 1; j >= 0 && array.get(j).getYear()>= aux.getYear()
                                           && array.get(j).getMonth()>= aux.getMonth()
                                           && array.get(j).getDay()>= aux.getDay(); j--) {                

                    array.set(j + 1, array.get(j));
                    array.set(j, aux);

                }

            }        
                        
        } else if (lastSort == "QuickSort") {
            
            for (int i = 1; i < array.size(); i++) {

                aux = array.get(i);

                for (int j = i - 1; j >= 0 && array.get(j).getCalification() > aux.getCalification(); j--) {

                    array.set(j + 1, array.get(j));
                    array.set(j, aux);

                }

            }            
                        
        } else if (lastSort == "RadixSort") {
            
            for (int i = 1; i < array.size(); i++) {

                aux = array.get(i);

                for (int j = i - 1; j >= 0 && array.get(j).getDifficulty() > aux.getDifficulty(); j--) {

                    array.set(j + 1, array.get(j));
                    array.set(j, aux);

                }

            }             
                        
        }
                        
    }
    
}

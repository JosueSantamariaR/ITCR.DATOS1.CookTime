package com.cooktime.model;

import java.util.ArrayList;

/**
 * Class in charge of quicksorting a list.
 */
public class QuickSort {
          
    /**
     * Method that sorts the array.
     * @param array ArrayList array to sort.
     * @param minIndex int minIndex of the array.
     * @param maxIndex int maxIndex of the array. 
     */
    public void sort(ArrayList<Recipe> array, int minIndex, int maxIndex) {
                
        int i = minIndex;
        int j = maxIndex;
        
        float pivot = array.get(minIndex + (maxIndex - minIndex) / 2).getCalification();
        Recipe aux;
        
        while (i <= j) {
            
            while (array.get(i).getCalification()< pivot) {
                
                i ++;
                
            }
            
            while (array.get(j).getCalification() > pivot) {
                
                j --;
                
            }
            
            if (i <= j) {
                
                aux = array.get(i);
                array.set(i, array.get(j));
                array.set(j, aux);
                                
                i ++;
                j --;
                
            }
            
        }
        
        if (minIndex < j) {
            
            sort(array, minIndex, j);
            
        }
        
        if (i < maxIndex) {
            
            sort(array, i, maxIndex);
            
        }
        
    }
              
}

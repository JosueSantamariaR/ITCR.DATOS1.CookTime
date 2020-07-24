package com.cooktime.model;

import java.util.ArrayList;

/**
 * Class in charge of radixsorting a list.
 */
public class RadixSort {
    
    private static final ArrayList<Integer> sortedList = new ArrayList<Integer>();
    
    /**
     * Method that sorts the array.
     * @param array ArrayList array to sort.
     * @param size int size of the array.
     * @return ArrayList.
     */
    public ArrayList<Recipe> sort(ArrayList<Recipe> array, int size) {
        
        sortAux(array, size);               
        
        ArrayList<Recipe> finalList = new ArrayList<Recipe>();
        
        for (int i = 0; i < size; i ++) {
            
            finalList.add(getRecipe(array, RadixSort.sortedList.get(i)));
            
        }
        
        return finalList;
        
    }
    
    /**
     * Auxiliarymethod of sort method.
     * @param array ArrayList array to sort.
     * @param size int size of the array.
     */
    public void sortAux(ArrayList<Recipe> array, int size) {
        
        for (int j = 0; j < size; j ++) {
            
            sortedList.add(0);
            
        }
        
        int max = getMax(array, size); 
  
        for (int exp = 1; max /exp > 0; exp *= 10) {
            
            countSort(array, size, exp);
            
        }
             
    } 
    
    /**
     * Method that gets the maximun node in the array.
     * @param array ArrayList<Recipe> array to sort.
     * @param size int size of the array.
     * @return int.
     */
    private int getMax(ArrayList<Recipe> array, int size) {
        
        int max = array.get(0).getDifficulty();
        
        for (int i = 1; i < size; i ++) {
            
            if (array.get(i).getDifficulty() > max) {
                
                max = array.get(i).getDifficulty();
                
            }
            
        }
                
        return max;
                
    }
     
    /**
     * Method that counts the sorts.
     * @param array ArrayList<Recipe> array to sort.
     * @param size int size of the array.
     * @param exp int exp of the array.
     */
    private void countSort(ArrayList<Recipe> array, int size, int exp) {
        
        int output[] = new int[size];
        int count[] = new int[10]; 
  
        for (int i = 0; i < size; i ++) {
            
            count[(array.get(i).getDifficulty() / exp) % 10] ++;
                        
        }
  
        for (int i = 1; i < 10; i++) {
            
            count[i] += count[i - 1];
            
        }
  
        for (int i = size - 1; i >= 0; i --) { 
            
            output[count[ (array.get(i).getDifficulty() / exp) % 10] - 1 ] = array.get(i).getDifficulty();
            count[ (array.get(i).getDifficulty() / exp) % 10 ] --;
                        
        } 
  
        for (int i = 0; i < size; i++) {
            
            sortedList.set(i, output[i]);
                        
        }
        
    } 
  
    /**
     * Method that counts the sorts.
     * @param array ArrayList<Recipe> array to sort.
     * @param difficulty int difficulty of the recipe.\
     * @return Recipe.
     */
    private Recipe getRecipe(ArrayList<Recipe> array, int difficulty) {
                
        for (int i = 0; i < array.size(); i ++){
            
            if (array.get(i).getDifficulty() == difficulty) {
                
                return array.get(i);
                
            }
            
        }
        
        return array.get(0);
        
    }
          
}
    
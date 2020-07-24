package com.cooktime.model;

import com.cooktime.model.Recipe;
import java.util.ArrayList;

/**
 * Class in charge of creating the AVL Tree.
 */
public class AVLTree { 
    
    private static AVLTree instance = null;
    private NodeAVLTree root;
    private final ArrayList<Recipe> recipeList = new ArrayList<Recipe>();

    /**
     * Constructor of this class.
     */
    private AVLTree() {
        
        this.root = null;
        
    }
    
    /**
     * Method that creates only one instance of this class.
     * @return AVLTree instance of the tree.
     */
    public static AVLTree getInstance() {
        
        if (instance == null) {
            
            instance = new AVLTree();
            
        }
        
        return instance;
                
    }
    
    /**
     * Method that checks if a recipe is in the tree.
     * @param name String name of the recipe.
     * @return boolean
     */
    public boolean contains(String name) {
        
        return this.containsAux(name, this.root);
        
    }

    /**
     * Auxiliary method of contains method.
     * @param name String name of the recipe.
     * @param node NodeAVLTree root of the tree.
     */
    private boolean containsAux(String name, NodeAVLTree node) {
        
        if (node == null) {
            
            return false;
        
        } else {
            
            int compareResult = name.compareTo(node.getRecipe().getName());

            if (compareResult < 0) {

                return containsAux(name, node.getLeft());

            } else if (compareResult > 0) {

                return containsAux(name, node.getRight());

            } else {

                return true;

            }
        
        }
        
    }

    /**
     * Method that gets a recipe of the tree.
     * @param name String name of the recipe.
     * @return Recipe
     */
    public Recipe getRecipe(String name) {

        return this.getRecipeAux(name, this.root);

    }

    /**
     * Auxiliary method of getRecipe method.
     * @param name String name of the recipe.
     * @param node NodeAVLTree root of the tree.
     */
    private Recipe getRecipeAux(String name, NodeAVLTree node) {
        
        int compareResult = name.compareTo(node.getRecipe().getName());

        if (compareResult < 0) {

            return getRecipeAux(name, node.getLeft());

        } else if (compareResult > 0) {

            return getRecipeAux(name, node.getRight());

        } else {

            return node.getRecipe();

        }

    }
          
    /**
     * Method that gets a node height.
     * @param node NodeAVLTree root of the tree.
     * @return int.
     */
    private int height(NodeAVLTree node) {  
        
        if (node == null) {
            
            return 0;
            
        }
        
        return node.getHeight();  
        
    }
    
    /**
     * Method that gets the minimun node in the tree.
     * @param node NodeAVLTree node of the tree.
     * @return NodeAVLTree.
     */
    private NodeAVLTree findMin(NodeAVLTree node1) {  
        
        NodeAVLTree node2 = node1;  
  
        while (node2.getLeft() != null) {
            
            node2 = node2.getLeft(); 
            
        } 
  
        return node2;  
        
    } 
  
    /**
     * Method that gets the maximun node in the tree.
     * @param height1 int height of the first node.
     * @param height2 int height of the second node
     */
    private int findMax(int height1, int height2) {  
        
        return (height1 > height2) ? height1 : height2;  
        
    }  
  
    /**
     * Method that rotates the node with the right node.
     * @param node NodeAVLTree node to rotate.
     * @return NodeAVLTree.
     */
    private NodeAVLTree rightRotate(NodeAVLTree node1) {
        
        NodeAVLTree node2 = node1.getLeft();  
        NodeAVLTree node3 = node2.getRight();  
  
        node2.setRight(node1);
        node1.setLeft(node3);
        
        node1.setHeight(findMax(height(node1.getLeft()), height(node1.getRight())) + 1);
        node2.setHeight(findMax(height(node2.getLeft()), height(node2.getRight())) + 1);
        
        return node2; 
        
    }  
 
    /**
     * Method that rotates the node with the left node.
     * @param node NodeAVLTree node to rotate.
     */
    private NodeAVLTree leftRotate(NodeAVLTree node1) {  
        
        NodeAVLTree node2 = node1.getRight();  
        NodeAVLTree node3 = node2.getLeft();  
    
        node2.setLeft(node1);
        node1.setRight(node3);
        
        node1.setHeight(findMax(height(node1.getLeft()), height(node1.getRight())) + 1);
        node2.setHeight(findMax(height(node2.getLeft()), height(node2.getRight())) + 1);
  
        return node2;  
        
    }  
   
    /**
     * Method that gets the balance factor of the node.
     * @param node NodeAVLTree node balance.
     */
    private int getBalance(NodeAVLTree node) {
        
        if (node == null) {
            
            return 0;
            
        }
        
        return height(node.getLeft()) - height(node.getRight()); 
        
    }         
    
    /**
     * Method that inserts recipes in the tree.
     * @param name String name of the recipe.
     * @param author String author of the recipe.
     * @param type String type of the recipe.
     * @param portions String portions of the recipe.
     * @param duration int duration of the recipe.
     * @param time String time of the recipe.
     * @param difficulty  difficulty of the recipe.
     * @param dietTag String dietTag of the recipe.
     * @param photo String photo of the recipe.
     * @param ingredients String ingredients of the recipe.
     * @param steps String steps of the recipe.
     * @param price int price of the recipe.
     * @param day int day of the recipe.
     * @param month int month of the recipe.
     * @param year  int  year of the recipe.
     */
    public void insert(String name, String author, String type, int portions, int duration,
                       String time, int difficulty, String dietTag, String photo, String ingredients,
                       String steps, int price, int day, int month, int year) {

        Recipe recipe = new Recipe(name, author, type, portions, duration, time, difficulty, dietTag,
                                   photo, ingredients, steps, price, day, month, year);

        this.root = this.insertAux(recipe, this.root);

    }
    
    /**
     * Auxiliary method of insert method.
     * @param recipe Recipe recipe to insert.
     * @param node NodeAVLTree root of the tree.
     */
    private NodeAVLTree insertAux(Recipe recipe, NodeAVLTree node) {  
        
        if (node == null) {
            
            return new NodeAVLTree(recipe);  
            
        }
        
        int compareResult = recipe.getName().compareTo(node.getRecipe().getName());
        
        if (compareResult < 0) {

            node.setLeft(this.insertAux(recipe, node.getLeft()));

        } else if (compareResult > 0) {

            node.setRight(this.insertAux(recipe, node.getRight()));
            
        } else {
            
            return node;
            
        } 
        
        node.setHeight(findMax(height(node.getLeft()), height(node.getRight())) + 1);
           
        int balance = getBalance(node);  
        
        if (balance > 1) {
            
            int compare1 = recipe.getName().compareTo(node.getLeft().getRecipe().getName());
            
            if (compare1 < 0)  {
            
                return rightRotate(node); 
            
            } 

            if (compare1 > 0) {  

                node.setLeft(leftRotate(node.getLeft()));

                return rightRotate(node); 

            }
                        
        } else if (balance < -1) {
            
            int compare = recipe.getName().compareTo(node.getRight().getRecipe().getName());
        
         
            if (compare < 0) {  

                node.setRight(rightRotate(node.getRight()));

                return leftRotate(node);  

            } 

            if (compare > 0) {

                return leftRotate(node); 

            }
          
        }
        
        return node; 
                
    }  
    
    /**
     * Method that removes a recipe of the tree.
     * @param name String name of the recipe.
     */
    public void remove(String name) {
        
        this.root = this.removeAux(name, this.root);
        
    }
    
    /**
     * Auxiliary method of remove method.
     * @param name String name of the recipe.
     * @param node NodeAVLTree root of the tree.
     */
    private NodeAVLTree removeAux(String name, NodeAVLTree node) {  
         
        if (node == null) {
            
            return node; 
            
        } 
        
        int compareResult = name.compareTo(node.getRecipe().getName());
        
        if (compareResult < 0) {
        
            node.setLeft(removeAux(name, node.getLeft()));
            
        } else if (compareResult > 0) {
        
            node.setRight(removeAux(name, node.getRight()));
            
        } else { 
  
            if ((node.getLeft() == null) || (node.getRight() == null)) {  
                
                NodeAVLTree current = null; 
                
                if (current == node.getLeft()) {
                    
                    current = node.getRight();
                    
                } 
                     
                else
                    current = node.getLeft();  
  
                if (current == null) {  
                    
                    current = node;  
                    node = null;  
                    
                } else {
                    
                    node = current;
                    
                }

            } else {  
    
                NodeAVLTree current = findMin(node.getRight());  
  
                node.setRecipe(current.getRecipe());                
                node.setRight(removeAux(current.getRecipe().getName(), node.getRight()));
                
            }  
            
        }  
        
        if (node == null) {
            
            return node; 
            
        }   
        
        node.setHeight(findMax(height(node.getLeft()), height(node.getRight())) + 1);
          
        int balance = getBalance(node);  
  
        if (balance > 1 && getBalance(node.getLeft()) >= 0) {
            
            return rightRotate(node);  
            
        }  
        
        if (balance > 1 && getBalance(node.getLeft()) < 0) {
            
            node.setLeft(leftRotate(node.getLeft()));
            
            return rightRotate(node);  
            
        }  
  
        if (balance < -1 && getBalance(node.getRight()) <= 0) {
            
            return leftRotate(node); 
            
        } 
  
        if (balance < -1 && getBalance(node.getRight()) > 0) {             
            
            node.setRight(rightRotate(node.getRight()));
                        
            return leftRotate(node);  
            
        }  
  
        return node;  
        
    } 
        
    /**
     * Method that walks through the tree.
     * @return ArrayList.
     */
    public ArrayList<Recipe> inOrder() {

        this.recipeList.clear();

        return this.inOrderAux(recipeList, this.root);

    }

    /**
     * Auxiliary method of inOrder method.
     * @param recipeList ArrayList<Recipe> recipeList list of recipes.
     * @param node NodeAVLTree root of the tree.
     */
    private ArrayList<Recipe> inOrderAux(ArrayList<Recipe> recipeList, NodeAVLTree node) {

        if (node == null) {

            return null;

        }

        inOrderAux(recipeList, node.getLeft());
        recipeList.add(node.getRecipe());
        inOrderAux(recipeList, node.getRight());

        return recipeList;

    }
    
    /**
     * Method that gets the matches of recipe names of the tree.
     * @param name String name of the recipe.
     * @param endIndex int endIndex last index of the string of the recipe name.
     * @return ArrayList.
     */
    public ArrayList<Recipe> matches(String name, int endIndex) {
                        
        ArrayList<Recipe> matchesList = new ArrayList<Recipe>();
        
        matchesList = matchesAux(matchesList, name, endIndex, this.root);
        
        ArrayList<Recipe> finalMatchesList = new ArrayList<Recipe>();
        
        int cont = 0;
        
        int size = matchesList.size();
        
        while (cont < 15) {
            
            if (cont < size) {
                
                finalMatchesList.add(matchesList.get(cont));
                
            } else {
                
                break;
                
            }            
            
            cont ++;
            
        }
                
        return finalMatchesList;
 
    }
    
    /**
     * Auxiliary method of matches method.
     * @param matchesList ArrayList<Recipe> matchesList list of recipes.
     * @param name String name of the recipe.
     * @param endIndex int endIndex last index of the string of the recipe name.
     * @param node NodeAVLTree root of the tree.
     */
    private ArrayList<Recipe> matchesAux(ArrayList<Recipe> matchesList, String name, int endIndex, NodeAVLTree node) {

        if (node == null) {

            return null;

        }

        matchesAux(matchesList, name, endIndex, node.getLeft());

        if (node.getRecipe().getName().length() >= name.length()) {

            String slice = node.getRecipe().getName().substring(0, endIndex);

            int result = slice.compareTo(name);

            if (result == 0) {

                matchesList.add(node.getRecipe());

            }

        }

        matchesAux(matchesList, name, endIndex, node.getRight());

        return matchesList;

    }
    
    /**
     * Method that filters the recipes for type.
     * @param type String type filter.
     * @return ArrayList.
     */
    public ArrayList<Recipe> typeFilter(String type) {
        
        ArrayList<Recipe> array = new ArrayList<Recipe>();
        
        return this.typeFilterAux(array, type, this.root);
        
    }
    
    /**
     * Auxiliary method of typeFilter method.
     * @param array ArrayList<Recipe> array list of recipes.
     * @param type String type filter.
     * @param node NodeAVLTree root of the tree.
     */
    private ArrayList<Recipe> typeFilterAux(ArrayList<Recipe> array, String type, NodeAVLTree node) {
        
        if (node == null) {

            return null;

        }

        typeFilterAux(array, type, node.getLeft());
                
        int result = node.getRecipe().getType().compareTo(type);
        
        if (result == 0) {
            
            array.add(node.getRecipe());
            
        }
        
        typeFilterAux(array, type, node.getRight());

        return array;        
                        
    }
    
    /**
     * Method that filters the recipes for time.
     * @param time String time filter.
     * @return ArrayList.
     */
    public ArrayList<Recipe> timeFilter(String time) {
        
        ArrayList<Recipe> array = new ArrayList<Recipe>();
        
        return this.timeFilterAux(array, time, this.root);
        
        
    }
    
    /**
     * Auxiliary method of timeFilter method.
     * @param array ArrayList<Recipe> array list of recipes.
     * @param time String time filter.
     * @param node NodeAVLTree root of the tree.
     */
    private ArrayList<Recipe> timeFilterAux(ArrayList<Recipe> array, String time, NodeAVLTree node) {
        
        if (node == null) {

            return null;

        }

        timeFilterAux(array, time, node.getLeft());
        
        int result = node.getRecipe().getTime().compareTo(time);
                
        if (result == 0) {
            
            array.add(node.getRecipe());
            
        }
                
        timeFilterAux(array, time, node.getRight());

        return array;  
        
        
    }
    
    /**
     * Method that filters the recipes for time.
     * @param dietTag String dietTag filter.
     * @return ArrayList.
     */
    public ArrayList<Recipe> dietTagFilter(String dietTag) {
        
        ArrayList<Recipe> array = new ArrayList<Recipe>();
        
        return this.dietTagFilterAux(array, dietTag, this.root);
        
        
    }
    
    /**
     * Auxiliary method of timeFilter method.
     * @param array ArrayList<Recipe> array list of recipes.
     * @param dietTag String dietTag filter.
     * @param node NodeAVLTree root of the tree.
     */
    private ArrayList<Recipe> dietTagFilterAux(ArrayList<Recipe> array, String dietTag, NodeAVLTree node) {
        
        if (node == null) {

            return null;

        }

        dietTagFilterAux(array, dietTag, node.getLeft());
        
        int result = node.getRecipe().getDietTag().compareTo(dietTag);
        
        if (result == 0) {
            
            array.add(node.getRecipe());
            
        }
        
        dietTagFilterAux(array, dietTag, node.getRight());

        return array;  
               
        
    }

}  
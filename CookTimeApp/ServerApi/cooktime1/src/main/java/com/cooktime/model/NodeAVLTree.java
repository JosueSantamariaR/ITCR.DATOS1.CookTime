package com.cooktime.model;

/**
 * Class in charge of creating AVLTree nodes.
 */
public class NodeAVLTree {
    
    private Recipe recipe;
    private NodeAVLTree left;
    private NodeAVLTree right;
    private int height;
    
    /**
     * Constructor of this class.
     * @param recipe Recipe recipe to insert.
     */
    public NodeAVLTree(Recipe recipe) {
        
        this.recipe = recipe;
        this.left = null;
        this.right = null;
        this.height = 1;
    
    }
    
    public Recipe getRecipe() {
        
        return recipe;
        
    }

    public void setRecipe(Recipe recipe) {
        
        this.recipe = recipe;
        
    }

    public NodeAVLTree getLeft() {
        
        return left;
        
    }

    public void setLeft(NodeAVLTree left) {
        
        this.left = left;
        
    }

    public NodeAVLTree getRight() {
        
        return right;
        
    }

    public void setRight(NodeAVLTree right) {
        
        this.right = right;
        
    }

    public int getHeight() {
        
        return height;
        
    }

    public void setHeight(int height) {
        
        this.height = height;
        
    }
        
}

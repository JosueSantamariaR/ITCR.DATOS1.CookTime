package com.cooktime.model;

import com.cooktime.model.Recipe;

public class NodeAVLTree {
    
    private Recipe recipe;
    private NodeAVLTree left;
    private NodeAVLTree right;
    private int height;
    
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

    @Override
    public int hashCode() {
        
        int hash = 5;
        hash = 89 * hash + (this.recipe != null ? this.recipe.hashCode() : 0);
        
        return hash;
        
    }

    @Override
    public boolean equals(Object obj) {
        
        if (this == obj) {
            
            return true;
            
        }
        
        if (obj == null) {
            
            return false;
            
        }
        
        if (getClass() != obj.getClass()) {
            
            return false;
            
        }
        
        final NodeAVLTree other = (NodeAVLTree) obj;
        
        if (this.recipe != other.getRecipe() && (this.recipe == null || !this.recipe.equals(other.getRecipe()))) {
            
            return false;
            
        }
        
        return true;
        
    }
        
}

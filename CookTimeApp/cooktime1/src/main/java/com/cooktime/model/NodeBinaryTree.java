package com.cooktime.model;

public class NodeBinaryTree {
    
    private User user;
    private NodeBinaryTree left;
    private NodeBinaryTree right;
        
    public NodeBinaryTree(User user) {
        
        this(user, null, null);
        
    }
    
    public NodeBinaryTree(User user, NodeBinaryTree left, NodeBinaryTree right) {
        
        this.user = user;
        this.left = left;
        this.right = right;
        
    }

    public User getUser() {
        
        return user;
        
    }

    public void setUser(User user) {
        
        this.user = user;
        
    }

    public NodeBinaryTree getLeft() {
        
        return left;
        
    }

    public void setLeft(NodeBinaryTree left) {
        
        this.left = left;
        
    }

    public NodeBinaryTree getRight() {
        
        return right;
        
    }

    public void setRight(NodeBinaryTree right) {
        
        this.right = right;
        
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + (this.user != null ? this.user.hashCode() : 0);
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
        final NodeBinaryTree other = (NodeBinaryTree) obj;
        if (this.user != other.user && (this.user == null || !this.user.equals(other.user))) {
            return false;
        }
        return true;
    }

}

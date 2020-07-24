package com.cooktime.model;

/**
 * Class in charge of creating BinaryTree nodes.
 */
public class NodeBinaryTree {
    
    private User user;
    private NodeBinaryTree left;
    private NodeBinaryTree right;
        
    /**
     * Constructor of this class.
     * @param user User user to insert.
     */
    public NodeBinaryTree(User user) {
        
        this(user, null, null);
        
    }
    
    /**
     * Constructor of this class.
     * @param user User user to insert.
     * @param left NodeBinaryTree left node.
     * @param right NodeBinaryTree right node.
     */
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

}

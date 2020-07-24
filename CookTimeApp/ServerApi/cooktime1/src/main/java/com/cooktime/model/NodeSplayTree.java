package com.cooktime.model;

/**
 * Class in charge of creating SplayTree nodes.
 */
public class NodeSplayTree {
    
    private Enterprise enterprise;
    private NodeSplayTree left;
    private NodeSplayTree right;
    private NodeSplayTree parent;
    
    /**
     * Constructor of this class.
     */
    public NodeSplayTree() {
        
        this.enterprise = null;
        this.left = null;
        this.right = null;
        this.parent = null;
        
    }

    /**
     * Constructor of this class.
     * @param enterprise Enterprise enterprise to insert.
     */
    public NodeSplayTree(Enterprise enterprise) {
        
        this.enterprise = enterprise;
        this.left = null;
        this.right = null;
        this.parent = null;
        
    }
    
    /**
     * Constructor of this class.
     * @param enterprise Enterprise enterprise to insert.
     * @param left NodeSplayTree left node.
     * @param right NodeSplayTree right node.
     * @param parent NodeSplayTree parent node.
     */
    public NodeSplayTree(Enterprise enterprise, NodeSplayTree left,
                         NodeSplayTree right, NodeSplayTree parent) {
        
        this.enterprise = enterprise;
        this.left = left;
        this.right = right;
        this.parent = parent;
        
    }

    public Enterprise getEnterprise() {
        
        return enterprise;
        
    }

    public void setEnterprise(Enterprise enterprise) {
        
        this.enterprise = enterprise;
        
    }

    public NodeSplayTree getLeft() {
        
        return left;
        
    }

    public void setLeft(NodeSplayTree left) {
        
        this.left = left;
        
    }

    public NodeSplayTree getRight() {
        
        return right;
        
    }

    public void setRight(NodeSplayTree right) {
        
        this.right = right;
        
    }

    public NodeSplayTree getParent() {
        
        return parent;
        
    }

    public void setParent(NodeSplayTree parent) {
        
        this.parent = parent;
        
    }
        
}

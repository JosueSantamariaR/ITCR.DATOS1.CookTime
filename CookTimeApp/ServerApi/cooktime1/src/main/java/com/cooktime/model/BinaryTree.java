package com.cooktime.model;

import com.cooktime.model.NodeBinaryTree;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BinaryTree {
    
    private static BinaryTree instance = null;
    private NodeBinaryTree root;
    private ArrayList<User> userList = new ArrayList<User>();

    private BinaryTree() {

        this.root = null;

    }
    
    public static BinaryTree getInstance() {
        
        if (instance == null) {
            
            instance = new BinaryTree();
            
        }
        
        return instance;
                
    }

    public boolean isEmpty() {

        return this.root == null;

    }
    
    public boolean contains(String email) {
        
        return this.containsAux(email, this.root);
        
    }
    
    private boolean containsAux(String email, NodeBinaryTree node) {
        
        if (node == null) {
            
            return false;
        
        } else {
            
            int compareResult = email.compareTo(node.getUser().getEmail());

            if (compareResult < 0) {

                return containsAux(email, node.getLeft());

            } else if (compareResult > 0) {

                return containsAux(email, node.getRight());

            } else {

            return true;

            }
        
        }
        
    }
    
    public User getUser(String email) {
        
        return this.getUserAux(email, this.root);
        
    }
    
    private User getUserAux(String email, NodeBinaryTree node) {        
                    
        int compareResult = email.compareTo(node.getUser().getEmail());

        if (compareResult < 0) {

            return getUserAux(email, node.getLeft());

        } else if (compareResult > 0) {

            return getUserAux(email, node.getRight());

        } else {

        return node.getUser();

        }
        
        
        
    }
    
    public User findMin() {
        
        if (this.isEmpty()) {
            
            return null;
        
        } else {
            
            return this.findMinAux(this.root);
        
        }
        
    }       
    
    private User findMinAux(NodeBinaryTree node) {
        
        if (node == null) {
            
            return null;
            
        } else if (node.getLeft() == null) {
            
            return node.getUser();
            
        } else {
            
            return findMinAux(node.getLeft());
            
        }
        
    }
    
    public User findMax() {

        if (this.isEmpty()) {

            return null;

        } else {

            return this.findMaxAux(this.root);

        }
        
    }
        
    private User findMaxAux(NodeBinaryTree node) {
        
        if (node!= null) {
    
            while (node.getRight() != null) {
    
                node = node.getRight();
    
            }    
            
        }
    
        return node.getUser();           
        
    }
       
    public void insert(String email, String name, String lastName, int age, String password, String photo, boolean chef) {
        
        String newPassword = encrypte(password);        
                
        User newUser = new User(email, name, lastName, age, newPassword, photo, chef);
        
        this.root = this.insertAux(newUser, this.root);
        
    }
        
    private NodeBinaryTree insertAux(User newUser, NodeBinaryTree node) {
    
        if (node == null) {
    
            return new NodeBinaryTree(newUser, null, null);
            
        }
    
        int compareResult = newUser.getEmail().compareTo(node.getUser().getEmail());
    
        if (compareResult < 0) {
    
            node.setLeft(this.insertAux(newUser, node.getLeft()));
            
        } else if (compareResult > 0) {
    
            node.setRight(this.insertAux(newUser, node.getRight()));          
            
        }
    
        return node;            
    
    }
    
    public void remove(String email) {
 
        this.root = this.removeAux(email, this.root);
 
    }
    
    private NodeBinaryTree removeAux(String email, NodeBinaryTree node) {
        
        if (node == null) {
                    
            return node;
            
        }

        int compareResult = email.compareTo(node.getUser().getEmail());
        
        if (compareResult < 0) {
        
            node.setLeft(removeAux(email, node.getLeft()));
            
        } else if (compareResult > 0) {
        
            node.setRight(removeAux(email, node.getRight()));
            
        } else if (node.getLeft() != null && node.getRight() != null){
                    
            node.setUser(findMinAux(node.getRight()));
            node.setRight(removeAux(node.getUser().getEmail(), node.getRight()));
                    
        } else {                
            
            node = node.getLeft() != null ? node.getLeft() : node.getRight();
                
        }
        
        return node;
        
    }
    
    public ArrayList<User> inOrder() {
        
        this.userList.clear();
        
        return this.inOrderAux(userList, this.root);
      
    }
    
    private ArrayList<User> inOrderAux(ArrayList<User> userList, NodeBinaryTree node) {
        
      if (node == null) {
          
        return null;
        
      }
      
      inOrderAux(userList, node.getLeft());
      userList.add(node.getUser());
      inOrderAux(userList, node.getRight());
      
      return userList;
      
    }
    
    public ArrayList<User> matches(String name, int endIndex) {
                        
        ArrayList<User> matchesList = new ArrayList<User>();
        
        matchesList = matchesAux(matchesList, name, endIndex, this.root);
        
        ArrayList<User> finalMatchesList = new ArrayList<User>();
        
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
    
    private ArrayList<User> matchesAux(ArrayList<User> matchesList, String name, int endIndex, NodeBinaryTree node) {
        
      if (node == null) {
          
        return null;
        
      }
      
      matchesAux(matchesList, name, endIndex, node.getLeft());
      
      if (node.getUser().getName().length() >= name.length()) {

            String slice = node.getUser().getName().substring(0, endIndex);

            int result = slice.compareTo(name);

            if (result == 0) {

                matchesList.add(node.getUser());

            }

        }
            
      matchesAux(matchesList, name, endIndex, node.getRight());
      
      return matchesList;
      
    }
    
    public String encrypte(String password) {
        
        Charset UTF_8 = StandardCharsets.UTF_8;
        
        byte[] md5InBytes = digest(password.getBytes(UTF_8));
        
        String encryptedPassword = bytesToHex(md5InBytes);
        
        return encryptedPassword;
        
    }
    
    private byte[] digest(byte[] input) {

        MessageDigest md;

        try {

            md = MessageDigest.getInstance("MD5");

        } catch (NoSuchAlgorithmException e) {

            throw new IllegalArgumentException(e);

        }

        byte[] result = md.digest(input);
        return result;

    }

    private String bytesToHex(byte[] bytes) {

        StringBuilder sb = new StringBuilder();

        for (byte b : bytes) {

            sb.append(String.format("%02x", b));

        }

        return sb.toString();

    }

}

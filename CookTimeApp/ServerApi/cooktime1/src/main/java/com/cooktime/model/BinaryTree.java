package com.cooktime.model;

import com.cooktime.model.NodeBinaryTree;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Class in charge of creating the Binary Tree.
 */
public class BinaryTree {
    
    private static BinaryTree instance = null;
    private NodeBinaryTree root;
    private final ArrayList<User> userList = new ArrayList<User>();

    /**
     * Constructor of this class.
     */
    private BinaryTree() {

        this.root = null;

    }
    
    /**
     * Method that creates only one instance of this class.
     * @return BinaryTree instance of the tree.
     */
    public static BinaryTree getInstance() {
        
        if (instance == null) {
            
            instance = new BinaryTree();
            
        }
        
        return instance;
                
    }

    /**
     * Method that checks if the tree is empty.
     * @return boolean.
     */
    public boolean isEmpty() {

        return this.root == null;

    }
    
     /**
     * Method that checks if a user is in the tree.
     * @param email String email of the user.
     * @return boolean.
     */
    public boolean contains(String email) {
        
        return this.containsAux(email, this.root);
        
    }
    
    /**
     * Auxiliary method of contains method.
     * @param email String email of the user.
     * @param node NodeBinaryTree root of the tree.
     */
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
    
    /**
     * Method that gets a user of the tree.
     * @param email String email of the user.
     * @return User.
     */
    public User getUser(String email) {
        
        return this.getUserAux(email, this.root);
        
    }
    
    /**
     * Auxiliary method of getUser method.
     * @param emial String emial of the user.
     * @param node NodeBinaryTree root of the tree.
     */
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
    
    /**
     * Method that gets the minimun node in the tree.
     * @return User. 
     */
    public User findMin() {
        
        if (this.isEmpty()) {
            
            return null;
        
        } else {
            
            return this.findMinAux(this.root);
        
        }
        
    }       
    
    /**
     * Auxiliary method of findMin method.
     * @param node NodeBinaryTree root of the tree.
     */
    private User findMinAux(NodeBinaryTree node) {
        
        if (node == null) {
            
            return null;
            
        } else if (node.getLeft() == null) {
            
            return node.getUser();
            
        } else {
            
            return findMinAux(node.getLeft());
            
        }
        
    }
    
    /**
     * Method that gets the maximun node in the tree.
     * @return User.
     */
    public User findMax() {

        if (this.isEmpty()) {

            return null;

        } else {

            return this.findMaxAux(this.root);

        }
        
    }
        
    /**
     * Auxiliary method of findMax method.
     * @param node NodeBinaryTree root of the tree.
     */
    private User findMaxAux(NodeBinaryTree node) {
        
        if (node!= null) {
    
            while (node.getRight() != null) {
    
                node = node.getRight();
    
            }    
            
        }
    
        return node.getUser();           
        
    }
       
    /**
     * Method that inserts users in the tree.
     * @param email String email of the user.
     * @param name String name of the user.
     * @param lastName String lastName of the user.
     * @param age int age of the user.
     * @param password String password of the user.
     * @param photo String photo of the user.
     * @param chef boolean chef of the user.
     */
    public void insert(String email, String name, String lastName, int age, String password, String photo, boolean chef) {
        
        String newPassword = encrypte(password);        
                
        User newUser = new User(email, name, lastName, age, newPassword, photo, chef);
        
        this.root = this.insertAux(newUser, this.root);
        
    }
        
    /**
     * Auxiliary method of insert method.
     * @param newUser User newUser to insert.
     * @param node NodeBinaryTree root of the tree.
     */
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
    
    /**
     * Method that removes a user of the tree.
     * @param email String email of the user.
     */
    public void remove(String email) {
 
        this.root = this.removeAux(email, this.root);
 
    }
    
    /**
     * Auxiliary method of remove method.
     * @param email String email of the user.
     * @param node NodeBinaryTree root of the tree.
     */
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
    
    /**
     * Method that walks through the tree.
     * @return ArrayList.
     */
    public ArrayList<User> inOrder() {
        
        this.userList.clear();
        
        return this.inOrderAux(userList, this.root);
      
    }
    
    /**
     * Auxiliary method of inOrder method.
     * @param userList ArrayList<User>  userList list of users.
     * @param node NodeBinaryTree root of the tree.
     */
    private ArrayList<User> inOrderAux(ArrayList<User> userList, NodeBinaryTree node) {
        
      if (node == null) {
          
        return null;
        
      }
      
      inOrderAux(userList, node.getLeft());
      userList.add(node.getUser());
      inOrderAux(userList, node.getRight());
      
      return userList;
      
    }
    
    /**
     * Method that gets the matches of user names of the tree.
     * @param name String name of the user.
     * @param endIndex int endIndex last index of the string of the user name.
     * @return ArrayList.
     */
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
    
    /**
     * Auxiliary method of matches method.
     * @param matchesList ArrayList<User> matchesList list of users.
     * @param name String name of the user.
     * @param endIndex int endIndex last index of the string of the user name.
     * @param node NodeBinaryTree root of the tree.
     */
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
    
    /**
     * Method that encryptes the user password.
     * @param password String password of the user.
     * @return ArrayList.
     */
    public String encrypte(String password) {
        
        Charset UTF_8 = StandardCharsets.UTF_8;
        
        byte[] md5InBytes = digest(password.getBytes(UTF_8));
        
        String encryptedPassword = bytesToHex(md5InBytes);
        
        return encryptedPassword;
        
    }
    
    /**
     * Method that digests the user password.
     * @param input byte[] password of the user.
     * @return byte[].
     */
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

    /**
     * Method that converts byte to hex.
     * @param bytes byte[] password of the user.
     * @return String.
     */
    private String bytesToHex(byte[] bytes) {

        StringBuilder sb = new StringBuilder();

        for (byte b : bytes) {

            sb.append(String.format("%02x", b));

        }

        return sb.toString();

    }

}

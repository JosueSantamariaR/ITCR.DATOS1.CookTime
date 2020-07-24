package com.cooktime.model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.codehaus.jettison.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class UserJson {
    
    private static BinaryTree binaryTree = BinaryTree.getInstance();
    private static AVLTree avlTree = AVLTree.getInstance();
    private static final String directionJson = "C:\\Users\\ExtremeTech\\Documents\\NetBeansProjects\\CookTime-RestApi\\cooktime1\\users.json";
    
    public static void insert(String email, String name, String lastName, int age, String password, String photo,
                               boolean chef) throws JSONException, IOException {
        
        binaryTree.insert(email, name, lastName, age, password, photo, chef);
        
        ArrayList<Recipe> myMenuList = new ArrayList<Recipe>();
        int followers = 0;
        int followed = 0;
        
        JSONObject newUserJson = createJsonUser(email, name, lastName, age, password, photo,myMenuList, followers, followed, chef);
                
        writeJson(newUserJson, email, true);
        
    }
    
    public static void insertChef(String email) {
        
        User user = binaryTree.getUser(email);

        String name = user.getName();
        String lastName = user.getLastName();
        int age = user.getAge();
        String password = user.getPassword();
        String photo = user.getPhoto();
        ArrayList<Recipe> myMenuList = user.getMyMenuList();
        int followers = user.getFollowers();
        int followed = user.getFollowed();
                                
        JSONObject newUserJson = createJsonUser(email, name, lastName, age, password, photo, myMenuList, followers, followed, true);
        
        user.setChef(true);

        writeJson(newUserJson, email, false);
        
    }
    
    public static void insertMyMenuList(String email, String newRecipe) {

        User user = binaryTree.getUser(email);

        String name = user.getName();
        String lastName = user.getLastName();
        int age = user.getAge();
        String password = user.getPassword();
        String photo = user.getPhoto();
        ArrayList<Recipe> myMenuList = user.getMyMenuList();
        int followers = user.getFollowers();
        int followed = user.getFollowed();
        boolean chef = user.getChef();
        
        myMenuList.add(avlTree.getRecipe(newRecipe));
        
        JSONObject newUserJson = createJsonUser(email, name, lastName, age, password, photo, myMenuList, followers, followed, chef);

        user.setMyMenuList(myMenuList);

        writeJson(newUserJson, email, false);

    }
        
    public static void insertBubbleSort(String email) {

        User user = binaryTree.getUser(email);

        String name = user.getName();
        String lastName = user.getLastName();
        int age = user.getAge();
        String password = user.getPassword();
        String photo = user.getPhoto();
        ArrayList<Recipe> myMenuList = user.getMyMenuList();
        int followers = user.getFollowers();
        int followed = user.getFollowed();
        boolean chef = user.getChef();
                
        BubbleSort bubbleSort = new BubbleSort();
        
        bubbleSort.sort(myMenuList);

        JSONObject newUserJson = createJsonUser(email, name, lastName, age, password, photo, myMenuList, followers, followed, chef);

        user.setMyMenuList(myMenuList);
        
        user.setLastSort("BubbleSort");

        writeJson(newUserJson, email, false);

    }
        
    public static void insertQuickSort(String email) {

        User user = binaryTree.getUser(email);

        String name = user.getName();
        String lastName = user.getLastName();
        int age = user.getAge();
        String password = user.getPassword();
        String photo = user.getPhoto();
        ArrayList<Recipe> myMenuList = user.getMyMenuList();
        int followers = user.getFollowers();
        int followed = user.getFollowed();
        boolean chef = user.getChef();   
                               
        int minIndex = 0;
        int maxIndex = myMenuList.size() - 1;
        
        QuickSort quickSort = new QuickSort();
        
        quickSort.sort(myMenuList, minIndex, maxIndex);
        
        JSONObject newUserJson = createJsonUser(email, name, lastName, age, password, photo, myMenuList, followers, followed, chef);

        user.setMyMenuList(myMenuList);
        
        user.setLastSort("QuickSort");

        writeJson(newUserJson, email, false);

    }
        
    public static void insertRadixSort(String email) {

        User user = binaryTree.getUser(email);

        String name = user.getName();
        String lastName = user.getLastName();
        int age = user.getAge();
        String password = user.getPassword();
        String photo = user.getPhoto();
        ArrayList<Recipe> myMenuList = user.getMyMenuList();
        int followers = user.getFollowers();
        int followed = user.getFollowed();
        boolean chef = user.getChef();        

        RadixSort radix = new RadixSort();                      
        
        int size = myMenuList.size();                   
        
        ArrayList<Recipe> newMyMenuList = radix.sort(myMenuList, size);
        
        JSONObject newUserJson = createJsonUser(email, name, lastName, age, password, photo, newMyMenuList, followers, followed, chef);
        
        user.setMyMenuList(newMyMenuList);
        
        user.setLastSort("RadixSort");

        writeJson(newUserJson, email, false);

    }
        
    public static void insertFollowers(String email) {
        
        User user = binaryTree.getUser(email);

        String name = user.getName();
        String lastName = user.getLastName();
        int age = user.getAge();
        String password = user.getPassword();
        String photo = user.getPhoto();
        ArrayList<Recipe> myMenuList = user.getMyMenuList();
        int followers = user.getFollowers();
        int followed = user.getFollowed();
        boolean chef = user.getChef();
                
        followers ++;
                        
        JSONObject newUserJson = createJsonUser(email, name, lastName, age, password, photo, myMenuList, followers, followed, chef);

        user.setFollowers(followers);

        writeJson(newUserJson, email, false);

    }
    
    public static void insertFollowed(String email) {

        User user = binaryTree.getUser(email);

        String name = user.getName();
        String lastName = user.getLastName();
        int age = user.getAge();
        String password = user.getPassword();
        String photo = user.getPhoto();
        ArrayList<Recipe> myMenuList = user.getMyMenuList();
        int followers = user.getFollowers();
        int followed = user.getFollowed();
        boolean chef = user.getChef();
                
        followed ++;
                        
        JSONObject newUserJson = createJsonUser(email, name, lastName, age, password, photo, myMenuList, followers, followed, chef);

        user.setFollowed(followed);

        writeJson(newUserJson, email, false);

    }
        
    public static ArrayList<ArrayList<Recipe>> getUsersMyMenuList(ArrayList<String> array) {
        
        ArrayList<ArrayList<Recipe>> finalArray = new ArrayList<ArrayList<Recipe>>();
        
        for (int i = 0; i < array.size(); i ++) {
            
            User user = binaryTree.getUser(array.get(i));
            
            ArrayList<Recipe> myMenuList = user.getMyMenuList();
            
            finalArray.add(myMenuList);
            
        }
        
        return finalArray;
        
    }
    
    private static JSONObject createJsonUser(String email, String name, String lastName, int age, String password, String photo,
                                             ArrayList<Recipe> myMenuList, int followers, int followed, boolean chef) {
        
        JSONObject userJson = new JSONObject();

        userJson.put("email", email);
        userJson.put("name", name);
        userJson.put("lastName", lastName);
        userJson.put("age", age);
        userJson.put("password", password);
        userJson.put("photo", photo);
        userJson.put("myMenuList", myMenuList);
        userJson.put("followers", followers);
        userJson.put("followed", followed);
        userJson.put("chef", chef);
        
        return userJson;
        
    }
        
    private static int searchIndex(JSONArray array, String email) {               
        
        int index = 0;
                    
        for (int i = 0; i < array.size(); i++) {

            JSONObject object = (JSONObject) array.get(i);
            
            String objectEmail = (String) object.get("email");
            
            if (objectEmail.compareTo(email) == 0) {
                
                return i;

            }

        }
        
        return index;
        
    }
    
    private static void writeJson(JSONObject newUserJson, String email, boolean indicator) {
        
        JSONParser parser = new JSONParser();

        try {
            
            Object jsonFile = parser.parse(new FileReader(directionJson));
                                  
            JSONArray userList = (JSONArray) jsonFile;
            
            if (indicator == false) {
                
                userList.remove(searchIndex(userList, email));
                
            } 
            
            userList.add(newUserJson);
            
            FileWriter file = new FileWriter(directionJson);                       
            
            file.write(userList.toJSONString());   
            
            file.close();
            
        } catch (Exception e) {

            e.printStackTrace();

        }
                
    }
               
}

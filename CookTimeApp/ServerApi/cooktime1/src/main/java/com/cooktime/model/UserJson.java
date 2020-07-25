package com.cooktime.model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.codehaus.jettison.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Class in charge of writing int the users json file.
 */
public class UserJson {
    
    private static final BinaryTree binaryTree = BinaryTree.getInstance();
    private static final AVLTree avlTree = AVLTree.getInstance();
    private static final String directionJson = "C:\\Users\\ExtremeTech\\Documents\\NetBeansProjects\\CookTime-RestApi\\cooktime1\\users.json";
    
    /**
     * Constructor of this class.
     * @param email String email of the user.
     * @param name String name of the user.
     * @param lastName String lastName of the user.
     * @param age int age of the user.
     * @param password String password of the user.
     * @param photo String photo of the user.
     * @param chef boolean chef of the user.
     * @throws org.codehaus.jettison.json.JSONException
     * @throws java.io.IOException
     */
    public static void insert(String email, String name, String lastName, int age, String password, String photo,
                               boolean chef) throws JSONException, IOException {
        
        binaryTree.insert(email, name, lastName, age, password, photo, chef);
        
        ArrayList<Recipe> myMenuList = new ArrayList<Recipe>();
        int followers = 0;
        int followed = 0;
        String followedNames = "";
        
        JSONObject newUserJson = createJsonUser(email, name, lastName, age, password, photo,myMenuList, followers, followed, followedNames, chef);
                
        writeJson(newUserJson, email, true);
        
    }
    
    /**
     * Method that inserts chefs in the json file.
     * @param email String email of the user.
     */
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
        String followedNames = user.getFollowedNames();
                                
        JSONObject newUserJson = createJsonUser(email, name, lastName, age, password, photo, myMenuList, followers, followed, followedNames, true);
        
        user.setChef(true);

        writeJson(newUserJson, email, false);
        
    }
    
    /**
     * Method that inserts myMenuList in the json file.
     * @param email String email of the user.
     * @param newRecipe String newRecipe to insert.
     */
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
        String followedNames = user.getFollowedNames();
        boolean chef = user.getChef();
        
        myMenuList.add(avlTree.getRecipe(newRecipe));        
        
        InsertionSort insertionSort = new InsertionSort();
        
        insertionSort.sort(myMenuList, user.getLastSort());
        
        JSONObject newUserJson = createJsonUser(email, name, lastName, age, password, photo, myMenuList, followers, followed, followedNames, chef);

        user.setMyMenuList(myMenuList);

        writeJson(newUserJson, email, false);

    }
        
    /**
     * Method that bubblesorts the myMenuList of the user in the json file.
     * @param email String email of the user.
     */
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
        String followedNames = user.getFollowedNames();
        boolean chef = user.getChef();
                
        BubbleSort bubbleSort = new BubbleSort();
        
        bubbleSort.sort(myMenuList);

        JSONObject newUserJson = createJsonUser(email, name, lastName, age, password, photo, myMenuList, followers, followed, followedNames, chef);

        user.setMyMenuList(myMenuList);
        
        user.setLastSort("BubbleSort");

        writeJson(newUserJson, email, false);

    }
        
    /**
     * Method that quicksorts the myMenuList of the user in the json file.
     * @param email String email of the user.
     */
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
        String followedNames = user.getFollowedNames();
        boolean chef = user.getChef();   
                               
        int minIndex = 0;
        int maxIndex = myMenuList.size() - 1;
        
        QuickSort quickSort = new QuickSort();
        
        quickSort.sort(myMenuList, minIndex, maxIndex);
        
        JSONObject newUserJson = createJsonUser(email, name, lastName, age, password, photo, myMenuList, followers, followed, followedNames, chef);

        user.setMyMenuList(myMenuList);
        
        user.setLastSort("QuickSort");

        writeJson(newUserJson, email, false);

    }
        
    /**
     * Method that radixsorts the myMenuList of the user in the json file.
     * @param email String email of the user.
     */
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
        String followedNames = user.getFollowedNames();
        boolean chef = user.getChef();        

        RadixSort radix = new RadixSort();                      
        
        int size = myMenuList.size();                   
        
        ArrayList<Recipe> newMyMenuList = radix.sort(myMenuList, size);
        
        JSONObject newUserJson = createJsonUser(email, name, lastName, age, password, photo, newMyMenuList, followers, followed, followedNames, chef);
        
        user.setMyMenuList(newMyMenuList);
        
        user.setLastSort("RadixSort");

        writeJson(newUserJson, email, false);

    }
        
    /**
     * Method that inserts followers in the json file.
     * @param email String email of the user.
     */
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
        String followedNames = user.getFollowedNames();
        boolean chef = user.getChef();
                
        followers ++;
                        
        JSONObject newUserJson = createJsonUser(email, name, lastName, age, password, photo, myMenuList, followers, followed, followedNames, chef);

        user.setFollowers(followers);

        writeJson(newUserJson, email, false);

    }
    
    /**
     * Method that inserts followed in the json file.
     * @param email String email of the user.
     * @param follwedEmail String follwedName of the new followed.
     */
    public static void insertFollowed(String email, String follwedEmail) {

        User user = binaryTree.getUser(email);

        String name = user.getName();
        String lastName = user.getLastName();
        int age = user.getAge();
        String password = user.getPassword();
        String photo = user.getPhoto();
        ArrayList<Recipe> myMenuList = user.getMyMenuList();
        int followers = user.getFollowers();
        int followed = user.getFollowed();
        String followedNames = user.getFollowedNames();
        boolean chef = user.getChef();
                
        followed ++;
        
        if (followedNames == "") {
            
            followedNames += follwedEmail;
            
        } else {
            
            followedNames += "," + follwedEmail;
            
        }
                                        
        JSONObject newUserJson = createJsonUser(email, name, lastName, age, password, photo, myMenuList, followers, followed, followedNames, chef);

        user.setFollowed(followed);
        
        user.setFollowedNames(followedNames);

        writeJson(newUserJson, email, false);

    }
        
    /**
     * Method that inserts califications in the json file.
     * @param array ArrayList array of users.
     * @return ArrayList.
     */
    public static ArrayList<Recipe> getUsersMyMenuList(ArrayList<String> array) {
        
        ArrayList<Recipe> finalArray = new ArrayList<Recipe>();
        
        for (int i = 0; i < array.size(); i ++) {
            
            User user = binaryTree.getUser(array.get(i));
            
            ArrayList<Recipe> myMenuList = user.getMyMenuList();
            
            for (int j = 0; j < myMenuList.size(); j ++) {
                
                finalArray.add(myMenuList.get(j));
                
            }
                        
        }
        
        return finalArray;
        
    }
    
    /**
     * Method that creates users json objects.
     * @param email String email of the user.
     * @param name String name of the user.
     * @param lastName String lastName of the user.
     * @param age int age of the user.
     * @param password String password of the user.
     * @param photo String photo of the user.
     * @param myMenuList ArrayList<Recipe> myMenuList of the user.
     * @param followers int followers of the user.
     * @param followed int followed of the user
     * @param chef boolean chef of the user.
     * @return JSONObject
     */
    private static JSONObject createJsonUser(String email, String name, String lastName, int age, String password, String photo,
                                             ArrayList<Recipe> myMenuList, int followers, int followed, String followedNames,
                                             boolean chef) {
        
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
        userJson.put("followedNames", followedNames);
        userJson.put("chef", chef);
        
        return userJson;
        
    }
        
    /**
     * Method that searches user index in the array.
     * @param array JSONArray array of users.
     * @param email String email of the user.
     * @return int
     */
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
    
    /**
     * Method that inserts users in the json file.
     * @param newUserJson JSONObject newUserJson to insert in the json file.
     * @param email String email of the user.
     * @param indicator boolean indicator to check it is the first insertion.
     */
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

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
 * Class in charge of writing int the enterprises json file.
 */
public class EnterpriseJson {
    
    private static final SplayTree splayTree = SplayTree.getInstance();
    private static final AVLTree avlTree = AVLTree.getInstance();
    private static final String directionJson = "C:\\Users\\ExtremeTech\\Documents\\NetBeansProjects\\CookTime-RestApi\\cooktime1\\enterprises.json";
    
    /**
     * Method that inserts enterpises in the json file.
     * @param name String name of the enterprise.
     * @param logo String logo of the enterprise.
     * @param contact String contact of the enterprise.
     * @param schedule String schedule of the enterprise.
     * @param direction String direction of the enterprise.
     * @param members ArrayList members of the enterprise.
     * @throws org.codehaus.jettison.json.JSONException
     * @throws java.io.IOException
     */
    public static void insert(String name, String logo, String contact, String schedule,
                              String direction, ArrayList<String> members) throws JSONException,
                              IOException {
        
        splayTree.insert(name, logo, contact, schedule, direction, members);
        
        int calification = 0;
        int followers = 0;
        ArrayList<Recipe> myMenuList = new ArrayList<Recipe>();
        
        JSONObject newEnterpriseJson = createJsonEnterprise(name, logo, contact, schedule, direction, calification, followers, members, myMenuList);
                
        writeJson(newEnterpriseJson, name, true);
                
    }  
    
    /**
     * Method that inserts califications in the json file.
     * @param name String name of the enterprise.
     * @param newCalification int newCalification of the enterprise.
     */
    public static void insertCalification(String name, int newCalification) {         
            
        Enterprise enterprise = splayTree.getEnterprise(name);
        
        String logo = enterprise.getLogo();
        String contact = enterprise.getContact();
        String schedule = enterprise.getSchedule();
        String direction = enterprise.getDirection();
        int calification = enterprise.getCalification();
        int followers = enterprise.getFollowers();
        ArrayList<String> members = enterprise.getMembers();
        ArrayList<Recipe> myMenuList = enterprise.getMyMenuList();
                
        JSONObject newEnterpriseJson = createJsonEnterprise(name, logo, contact, schedule, direction, calification + newCalification, followers, members, myMenuList);
                        
        enterprise.setCalification(calification + newCalification);
        
        writeJson(newEnterpriseJson, name, false);

    }
        
    /**
     * Method that inserts followers in the json file.
     * @param name String name of the enterprise.
     */
    public static void insertFollowers(String name) {
        
        Enterprise enterprise = splayTree.getEnterprise(name);
        
        String logo = enterprise.getLogo();
        String contact = enterprise.getContact();
        String schedule = enterprise.getSchedule();
        String direction = enterprise.getDirection();
        int calification = enterprise.getCalification();
        int followers = enterprise.getFollowers();
        ArrayList<String> members = enterprise.getMembers();
        ArrayList<Recipe> myMenuList = enterprise.getMyMenuList();
                
        followers ++;
        
        JSONObject newEnterpriseJson = createJsonEnterprise(name, logo, contact, schedule, direction, calification, followers, members, myMenuList);
                
        enterprise.setFollowers(followers);

        writeJson(newEnterpriseJson, name, false);

    }
    
    /**
     * Method that inserts myMenuList in the json file.
     * @param name String name of the enterprise.
     * @param newRecipe String newRecipe to insert.
     */
    public static void insertMyMenuList(String name, String newRecipe) {
        
        Enterprise enterprise = splayTree.getEnterprise(name);
        
        String logo = enterprise.getLogo();
        String contact = enterprise.getContact();
        String schedule = enterprise.getSchedule();
        String direction = enterprise.getDirection();
        int calification = enterprise.getCalification();
        int followers = enterprise.getFollowers();
        ArrayList<String> members = enterprise.getMembers();
        ArrayList<Recipe> myMenuList = enterprise.getMyMenuList();
                
        myMenuList.add(avlTree.getRecipe(newRecipe));
        
        JSONObject newEnterpriseJson = createJsonEnterprise(name, logo, contact, schedule, direction, calification, followers, members, myMenuList);
        
        enterprise.setMyMenuList(myMenuList);
        
        writeJson(newEnterpriseJson, name, false);

    }       
        
    /**
     * Method that creates enterpises json objects.
     * @param name String name of the enterprise.
     * @param logo String logo of the enterprise.
     * @param contact String contact of the enterprise.
     * @param schedule String schedule of the enterprise.
     * @param direction String direction of the enterprise.
     * @param calification int calification of the enterprise.
     * @param followers int followers of the enterprise.
     * @param members ArrayList<String> members of the enterprise.
     * @param myMenuList ArrayList<Recipe> myMenuList of the enterprise.
     * @return JSONObject
     */
    private static JSONObject createJsonEnterprise(String name, String logo, String contact, String schedule, String direction, int calification, int followers,
                                                   ArrayList<String> members, ArrayList<Recipe> myMenuList) {
        
        JSONObject enterpriseJson = new JSONObject();

        enterpriseJson.put("name", name);
        enterpriseJson.put("logo", logo);
        enterpriseJson.put("contact", contact);
        enterpriseJson.put("schedule", schedule);
        enterpriseJson.put("direction", direction);        
        enterpriseJson.put("calification", calification);
        enterpriseJson.put("followers", followers);        
        enterpriseJson.put("members", members);        
        enterpriseJson.put("myMenuList", myMenuList);
        
        return enterpriseJson;
        
    }
    
    /**
     * Method that searches enterprise index in the array.
     * @param array JSONArray array of enterprises.
     * @param name String name of the enterprise.
     * @return int
     */
    private static int searchIndex(JSONArray array, String name) {               
        
        int index = 0;
                    
        for (int i = 0; i < array.size(); i++) {

            JSONObject object = (JSONObject) array.get(i);
            
            String objectName = (String) object.get("name");
            
            if (objectName.compareTo(name) == 0) {
                
                return i;

            }

        }
        
        return index;
        
    }
    
    /**
     * Method that inserts enterpises in the json file.
     * @param newEnterpriseJson JSONObject newEnterpriseJson to insert in the json file.
     * @param name String name of the enterprise.
     * @param indicator boolean indicator to check it is the first insertion.
     */
    private static void writeJson(JSONObject newEnterpriseJson, String name, boolean indicator) {
        
        JSONParser parser = new JSONParser();

        try {
            
            Object jsonFile = parser.parse(new FileReader(directionJson));
                                  
            JSONArray enterpriseList = (JSONArray) jsonFile;
            
            if (indicator == false) {
                
                enterpriseList.remove(searchIndex(enterpriseList, name));
                
            }                      
                        
            enterpriseList.add(newEnterpriseJson);
            
            FileWriter file = new FileWriter(directionJson);                       
            
            file.write(enterpriseList.toJSONString());   
            
            file.close();
            
        } catch (Exception e) {

            e.printStackTrace();

        }
                
    }
            
}

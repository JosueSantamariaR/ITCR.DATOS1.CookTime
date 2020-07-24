package com.cooktime.model;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Class in charge of writing int the recipes json file.
 */
public class RecipeJson {

    private static final AVLTree aVLTree = AVLTree.getInstance();
    private static final String directionJson = "C:\\Users\\ExtremeTech\\Documents\\NetBeansProjects\\CookTime-RestApi\\cooktime1\\recipes.json";

    /**
     * Method that inserts recipes in the json file.
     * @param name String name of the recipe.
     * @param author String author of the recipe.
     * @param type String type of the recipe.
     * @param portions String portions of the recipe.
     * @param duration int duration of the recipe.
     * @param time String time of the recipe.
     * @param difficulty  difficulty of the recipe.
     * @param dietTag String dietTag of the recipe.
     * @param photo String photo of the recipe.
     * @param ingredients String ingredients of the recipe.
     * @param steps String steps of the recipe.
     * @param price int price of the recipe.
     * @param day int day of the recipe.
     * @param month int month of the recipe.
     * @param year  int  year of the recipe.
     */
    public static void insert(String name, String author, String type, int portions, int duration,
                              String time, int difficulty, String dietTag, String photo, String ingredients,
                              String steps, int price, int day, int month, int year) {

        aVLTree.insert(name, author, type, portions, duration, time, difficulty, dietTag, photo, ingredients,
                        steps, price, day, month, year);
        
        int calification = 0;
        ArrayList<String> commentary = new ArrayList<String>();        

        JSONObject newRecipeJson = createJsonRecipe(name, author, type, portions, duration, time, difficulty, dietTag, photo, ingredients,
                                                    steps, price, calification, day, month, year, commentary);               
                
        writeJson(newRecipeJson, name, true);

    }
    
    /**
     * Method that inserts califications in the json file.
     * @param name String name of the recipe.
     * @param newCalification int newCalification of the recipe.
     */
    public static void insertCalification(String name, int newCalification) {         
            
        Recipe recipe = aVLTree.getRecipe(name);
        
        String author = recipe.getAuthor();
        String type = recipe.getType();
        int portions = recipe.getPortions();
        int duration = recipe.getDuration();
        String time = recipe.getTime();
        int difficulty = recipe.getDifficulty();
        String dietTag = recipe.getDietTag();
        String photo = recipe.getPhoto();
        String ingredients = recipe.getIngredients();
        String steps = recipe.getSteps();
        int price = recipe.getPrice();
        int calification = recipe.getCalification()  + newCalification;
        int day = recipe.getDay();
        int month = recipe.getMonth();
        int year = recipe.getYear();
        ArrayList<String> commentary = recipe.getCommentary();   
                
        JSONObject newRecipeJson = createJsonRecipe(name, author, type, portions, duration, time, difficulty, dietTag, photo, ingredients,
                                                    steps, price, calification, day, month, year, commentary); 
                
        recipe.setCalification(calification);
        
        writeJson(newRecipeJson, name, false);

    }
    
    /**
     * Method that inserts califications in the json file.
     * @param name String name of the recipe.
     * @param newCommentary String newCommentary of the recipe.
     */
    public static void insertCommentary(String name, String newCommentary) {         
            
        Recipe recipe = aVLTree.getRecipe(name);
        
        String author = recipe.getAuthor();
        String type = recipe.getType();
        int portions = recipe.getPortions();
        int duration = recipe.getDuration();
        String time = recipe.getTime();
        int difficulty = recipe.getDifficulty();
        String dietTag = recipe.getDietTag();
        String photo = recipe.getPhoto();
        String ingredients = recipe.getIngredients();
        String steps = recipe.getSteps();
        int price = recipe.getPrice();
        int calification = recipe.getCalification();
        int day = recipe.getDay();
        int month = recipe.getMonth();
        int year = recipe.getYear();
        ArrayList<String> commentary = recipe.getCommentary();               
        
        commentary.add(newCommentary);
        
        JSONObject newRecipeJson = createJsonRecipe(name, author, type, portions, duration, time, difficulty, dietTag, photo, ingredients,
                                                    steps, price, calification, day, month, year, commentary); 
        
        recipe.setCommentary(commentary);
                
        writeJson(newRecipeJson, name, false);

    }
    
    /**
     * Method that creates recipes json objects.
     * @param name String name of the recipe.
     * @param author String author of the recipe.
     * @param type String type of the recipe.
     * @param portions String portions of the recipe.
     * @param duration int duration of the recipe.
     * @param time String time of the recipe.
     * @param difficulty  difficulty of the recipe.
     * @param dietTag String dietTag of the recipe.
     * @param photo String photo of the recipe.
     * @param ingredients String ingredients of the recipe.
     * @param steps String steps of the recipe.
     * @param price int price of the recipe.
     * @param calification int calification of the recipe.
     * @param day int day of the recipe.
     * @param month int month of the recipe.
     * @param year  int  year of the recipe.
     * @param commentary StrArrayList<String> commentary list of the recipe.
     * @return JSONObject
     */
    private static JSONObject createJsonRecipe(String name, String author, String type, int portions, int duration, String time,
                                               int difficulty, String dietTag, String photo, String ingredients, String steps,
                                               int price, int calification, int day, int month, int year, ArrayList<String> commentary) {
        
        JSONObject recipeJson = new JSONObject();

        recipeJson.put("name", name);
        recipeJson.put("author", author);
        recipeJson.put("type", type);
        recipeJson.put("portions", portions);
        recipeJson.put("duration", duration);
        recipeJson.put("time", time);
        recipeJson.put("difficulty", difficulty);
        recipeJson.put("dietTag", dietTag);
        recipeJson.put("photo", photo);
        recipeJson.put("ingredients", ingredients);
        recipeJson.put("steps", steps);
        recipeJson.put("price", price);
        recipeJson.put("calification", calification);
        recipeJson.put("day", day);
        recipeJson.put("month", month);
        recipeJson.put("year", year);
        recipeJson.put("commentary", commentary);
        
        return recipeJson;
        
    }
    
    /**
     * Method that searches recipe index in the array.
     * @param array JSONArray array of recipes.
     * @param name String name of the recipe.
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
     * Method that inserts recipes in the json file.
     * @param newRecipeJson JSONObject newRecipeJson to insert in the json file.
     * @param name String name of the recipe.
     * @param indicator boolean indicator to check it is the first insertion.
     */
    private static void writeJson(JSONObject newRecipeJson, String name, boolean indicator) {
        
        JSONParser parser = new JSONParser();

        try {
            
            Object jsonFile = parser.parse(new FileReader(directionJson));
                                  
            JSONArray recipeList = (JSONArray) jsonFile;
            
            if (indicator == false) {
                
                recipeList.remove(searchIndex(recipeList, name));
                
            }  
            
            recipeList.add(newRecipeJson);
            
            FileWriter file = new FileWriter(directionJson);                       
            
            file.write(recipeList.toJSONString());   
            
            file.close();
            
        } catch (Exception e) {

            e.printStackTrace();

        }
                
    }
    
}

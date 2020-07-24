package com.cooktime.model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.codehaus.jettison.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class MainPrueBA {
    
    private static final String directionJson = "C:\\Users\\ExtremeTech\\Documents\\NetBeansProjects\\API2\\cooktime1\\enterprises.json";
    
    public static void main() throws JSONException, IOException {
        
        /*
        ArrayList<String> list = new ArrayList<String>();
        list.add("Nacho1");
        list.add("Nacho2");               
        
        EnterpriseJson.insert("Berenjena222", "logo.png", "Nacho", "24 horas", "Alajuela", list);
        
        /*
        
        JSONParser parser = new JSONParser();
                                
        try {
            
            Object jsonFile = parser.parse(new FileReader(directionJson));
                                  
            JSONArray enterpriseList = (JSONArray) jsonFile;
            
            //System.out.println(searchIndex(enterpriseList, "Berenjena777"));
            
            //enterpriseList.remove(0);
            
            FileWriter file = new FileWriter(directionJson);                       
            
            file.write(enterpriseList.toJSONString());   
            
            file.close();

            
                                                            
        } catch (Exception e) {
            
            e.printStackTrace();
            
        }   

        */
        /*
        
        String hola = "Hamburguesa";
        
        System.out.println("lenght " + hola.length());
        
        String nuevo = hola.substring(5, hola.length());
        
        System.out.println("nuevo " + nuevo);
        
        */
        
        
    }
    
    
    
    
    private static int searchIndex(JSONArray array, String name) {               
        
        int index = 0;
                    
        for (int i = 0; i < array.size(); i++) {

            JSONObject obj = (JSONObject) array.get(i);
            
            String n = (String) obj.get("name");
            
            if (n.compareTo(name) == 0) {
                
                return i;

            }

        }
        
        return index;
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

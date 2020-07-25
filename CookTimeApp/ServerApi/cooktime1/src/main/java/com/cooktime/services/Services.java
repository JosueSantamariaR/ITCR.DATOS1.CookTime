package com.cooktime.services;

import com.cooktime.model.AVLTree;
import com.cooktime.model.BinaryTree;
import com.cooktime.model.EnterpriseJson;
import com.cooktime.model.RecipeJson;
import com.cooktime.model.SplayTree;
import com.cooktime.model.UserJson;
import java.io.IOException;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jettison.json.JSONException;
import org.json.simple.parser.ParseException;

/**
 * Class in charge of creating the services of the REST API.
 */
@Path("services")
public class Services {
    
    private final BinaryTree binaryTree = BinaryTree.getInstance();
    private final AVLTree avltree = AVLTree.getInstance();
    private final SplayTree splayTree = SplayTree.getInstance();
    
    /**
     * Method that gets all users of the tree.
     * @return Response.
     * @throws org.codehaus.jettison.json.JSONException
     * @throws java.io.IOException
     */
    @GET
    @Path("/getAllUsers/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() throws JSONException, IOException {
                                
        return Response.ok(binaryTree.inOrder()).build();
        
    }    
    
    /**
     * Method that gets a user of the tree.
     * @param email String email of the user.
     * @return Response.
     * @throws org.codehaus.jettison.json.JSONException
     * @throws java.io.IOException
     */
    @GET
    @Path("/getUser/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("email") String email) throws JSONException, IOException {
                                
        if (binaryTree.contains(email)) {
            
            return Response.ok(binaryTree.getUser(email)).build();                              
                                                
        }
        
        return Response.status(Response.Status.NOT_FOUND).build();
        
    }
    
    /**
     * Method that gets a user myMenuList of the tree.
     * @param email String email of the user.
     * @return Response.
     * @throws org.codehaus.jettison.json.JSONException
     * @throws java.io.IOException
     */
    @GET
    @Path("/getUserMyMenuList/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserMyMenuList(@PathParam("email") String email) throws JSONException, IOException {
                                
        if (binaryTree.contains(email)) {
            
            return Response.ok(binaryTree.getUser(email).getMyMenuList()).build();                              
                                                
        }
        
        return Response.status(Response.Status.NOT_FOUND).build();
        
    }
    
    /**
     * Method that gets users myMenuList of the tree.
     * @param users String users of the user.
     * @return Response.
     * @throws org.codehaus.jettison.json.JSONException
     * @throws java.io.IOException
     */
    @GET
    @Path("/getUsersMyMenuList/{users}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsersMyMenuList(@PathParam("users") String users) throws JSONException, IOException {
        
        String newUsers[] = users.split(",");
            
        ArrayList<String> finalUsers = new ArrayList<String>();

        for (int i = 0; i < newUsers.length; i++) {

            finalUsers.add(newUsers[i]);

        }
                
        return Response.ok(UserJson.getUsersMyMenuList(finalUsers)).build();                              
                                                        
    }
            
    /**
     * Method that gets user matches in the tree.
     * @param name String name of the user.
     * @return Response.
     * @throws org.codehaus.jettison.json.JSONException
     * @throws java.io.IOException
     */
    @GET
    @Path("/getUserMatch/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserMatch(@PathParam("name") String name) throws JSONException, IOException {
        
        int size = name.length();
        
        return Response.ok(binaryTree.matches(name, size)).build();                              
                            
    }
        
    @GET
    @Path("/getUserFollowedName/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserFollowedName(@PathParam("email") String email) throws JSONException, IOException {
                
        return Response.ok(binaryTree.getUser(email).getFollowedNames()).build();                              
                            
    }       
    
    /**
     * Method that posts a user in the tree.
     * @param email String email of the user.
     * @param name String name of the user.
     * @param lastName String lastName of the user.
     * @param age String age of the user.
     * @param password String password of the user.
     * @param photo String photo of the user.
     * @param chef String chef of the user.
     * @return Response.
     * @throws org.codehaus.jettison.json.JSONException
     * @throws java.io.IOException
     * @throws org.json.simple.parser.ParseException
     */
    @POST
    @Path("/postUser/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postUser(@QueryParam("email") String email,
                             @QueryParam("name") String name,
                             @QueryParam("lastName") String lastName,
                             @QueryParam("age") String age,
                             @QueryParam("password") String password,
                             @QueryParam("photo") String photo,
                             @QueryParam("chef") boolean chef) throws
                             JSONException, IOException, ParseException {
        
        int newAge = Integer.parseInt(age);
                               
        if (!binaryTree.contains(email)) {               
                        
            UserJson.insert(email, name, lastName, newAge, password, photo, chef);
            
            return Response.status(Response.Status.CREATED).entity(binaryTree.getUser(email)).build();                          
                                                
        }
        
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
      
    }  
        
    /**
     * Method that posts a chef in the tree.
     * @param email String email of the user.
     * @return Response.
     * @throws org.codehaus.jettison.json.JSONException
     * @throws java.io.IOException
     * @throws org.json.simple.parser.ParseException
     */
    @POST
    @Path("/postChef/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postChef(@QueryParam("email") String email) throws
                             JSONException, IOException, ParseException {
                               
        if (binaryTree.contains(email)) {   
            
            UserJson.insertChef(email);
            
            return Response.status(Response.Status.CREATED).entity(binaryTree.getUser(email)).build();                          
                                              
        }
        
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
      
    }    
        
    /**
     * Method that posts a myMenuList in the tree.
     * @param email String email of the user.
     * @param newRecipe String newRecipe of the user.
     * @return Response.
     * @throws org.codehaus.jettison.json.JSONException
     * @throws java.io.IOException
     * @throws org.json.simple.parser.ParseException
     */
    @POST
    @Path("/postUserMyMenuList/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postUserMyMenuList(@QueryParam("email") String email,
                                       @QueryParam("newRecipe") String newRecipe)
                                       throws JSONException, IOException, ParseException {
              
        if (binaryTree.contains(email)) {
            
            UserJson.insertMyMenuList(email, newRecipe);
            
            return Response.status(Response.Status.CREATED).entity(binaryTree.getUser(email).getMyMenuList()).build();                          
                                              
        }
        
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
      
    }
    
    /**
     * Method that bubblesorts the myMenuList of the user in the tree.
     * @param email String email of the user.
     * @return Response.
     * @throws org.codehaus.jettison.json.JSONException
     * @throws java.io.IOException
     * @throws org.json.simple.parser.ParseException
     */
    @POST
    @Path("/postUserBubbleSort/{email}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postUserBubbleSort(@PathParam("email") String email) throws JSONException, IOException, ParseException {
              
        if (binaryTree.contains(email)) {

            UserJson.insertBubbleSort(email);
            
            return Response.status(Response.Status.CREATED).entity(binaryTree.getUser(email).getMyMenuList()).build();                          
                                              
        }
        
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
      
    }
    
    /**
     * Method that quicksorts the myMenuList of the user in the tree.
     * @param email String email of the user.
     * @return Response.
     * @throws org.codehaus.jettison.json.JSONException
     * @throws java.io.IOException
     * @throws org.json.simple.parser.ParseException
     */
    @POST
    @Path("/postUserQuickSort/{email}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postUserQuickSort(@PathParam("email") String email) throws JSONException, IOException, ParseException {
              
        if (binaryTree.contains(email)) {

            UserJson.insertQuickSort(email);
            
            return Response.status(Response.Status.CREATED).entity(binaryTree.getUser(email).getMyMenuList()).build();                          
                                              
        }
        
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
      
    }
    
    /**
     * Method that radixsorts the myMenuList of the user in the tree.
     * @param email String email of the user.
     * @return Response.
     * @throws org.codehaus.jettison.json.JSONException
     * @throws java.io.IOException
     * @throws org.json.simple.parser.ParseException
     */
    @POST
    @Path("/postUserRadixSort/{email}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postUserRadixSort(@PathParam("email") String email) throws JSONException, IOException, ParseException {
              
        if (binaryTree.contains(email)) {
            
            UserJson.insertRadixSort(email);
            
            return Response.status(Response.Status.CREATED).entity(binaryTree.getUser(email).getMyMenuList()).build();                          
                                              
        }
        
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
      
    }
    
    /**
     * Method that posts followers in the tree.
     * @param email String email of the user.
     * @return Response.
     * @throws org.codehaus.jettison.json.JSONException
     * @throws java.io.IOException
     * @throws org.json.simple.parser.ParseException
     */
    @POST
    @Path("/postUserFollowers/{email}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postUserFollowers(@PathParam("email") String email) throws JSONException, IOException, ParseException {
                               
        if (binaryTree.contains(email)) {
            
            UserJson.insertFollowers(email);
            
            return Response.status(Response.Status.CREATED).entity(binaryTree.getUser(email).getFollowers()).build();                          
                                              
        }
        
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
      
    }
    
    /**
     * Method that posts followeed in the tree.
     * @param email String email of the user.
     * @param follwedEmail String follwedEmail of the followed.
     * @return Response.
     * @throws org.codehaus.jettison.json.JSONException
     * @throws java.io.IOException
     * @throws org.json.simple.parser.ParseException
     */
    @POST
    @Path("/postUserFollowed/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postUserFollowed(@QueryParam("email") String email,
                                     @QueryParam("follwedEmail") String follwedEmail)
                                     throws JSONException, IOException, ParseException {
                               
        if (binaryTree.contains(email)) {

            UserJson.insertFollowed(email, follwedEmail);
            
            return Response.status(Response.Status.CREATED).entity(binaryTree.getUser(email).getFollowed()).build();                          
                                              
        }
        
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
      
    }
    
    // --------------------------------------------------------------------------------------------------------------------------------
       
    /**
     * Method that gets all recipes of the tree.
     * @return Response.
     * @throws org.codehaus.jettison.json.JSONException
     * @throws java.io.IOException
     */
    @GET
    @Path("/getAllRecipes/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllRecipes() throws JSONException, IOException {
                                
        return Response.ok(avltree.inOrder()).build();
        
    }        
    
    /**
     * Method that gets a user of the tree.
     * @param name String name of the recipe.
     * @return Response.
     * @throws org.codehaus.jettison.json.JSONException
     * @throws java.io.IOException
     */
    @GET
    @Path("/getRecipe/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecipe(@PathParam("name") String name) throws JSONException, IOException {
                                
        if (avltree.contains(name)) {
            
            return Response.ok(avltree.getRecipe(name)).build();                              
                                                
        }
        
        return Response.status(Response.Status.NOT_FOUND).build();
        
    }
    
    /**
     * Method that gets recipe matches in the tree.
     * @param name String name of the recipe.
     * @return Response.
     * @throws org.codehaus.jettison.json.JSONException
     * @throws java.io.IOException
     */
    @GET
    @Path("/getRecipeMatch/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecipeMatch(@PathParam("name") String name) throws JSONException, IOException {
        
        int size = name.length();
        
        return Response.ok(avltree.matches(name, size)).build();                              
                            
    }
    
    /**
     * Method that gets recipes using the filter.
     * @param type String type filter.
     * @return Response.
     * @throws org.codehaus.jettison.json.JSONException
     * @throws java.io.IOException
     */
    @GET
    @Path("/getRecipeTypeFilter/{type}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecipeTypeFilter(@PathParam("type") String type) throws JSONException, IOException {
                
        return Response.ok(avltree.typeFilter(type)).build();                              
                            
    }
    
    /**
     * Method that gets recipes using the filter.
     * @param time String time filter.
     * @return Response.
     * @throws org.codehaus.jettison.json.JSONException
     * @throws java.io.IOException
     */
    @GET
    @Path("/getRecipeTimeFilter/{time}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecipeTimeFilter(@PathParam("time") String time) throws JSONException, IOException {
        
        return Response.ok(avltree.timeFilter(time)).build();                                
                            
    }
    
    /**
     * Method that gets recipes using the filter.
     * @param dietTag String dietTag filter.
     * @return Response.
     * @throws org.codehaus.jettison.json.JSONException
     * @throws java.io.IOException
     */
    @GET
    @Path("/getRecipeDietTagFilter/{dietTag}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecipeDietTagFilter(@PathParam("dietTag") String dietTag) throws JSONException, IOException {
        
        return Response.ok(avltree.dietTagFilter(dietTag)).build();                              
                            
    }   
           
    /**
     * Method that posts a recipe in the tree.
     * @param name String name of the recipe.
     * @param author String author of the recipe.
     * @param type String type of the recipe.
     * @param portions String portions of the recipe.
     * @param duration String duration of the recipe.
     * @param time String time of the recipe.
     * @param difficulty String difficulty of the recipe.
     * @param dietTag String dietTag of the recipe.
     * @param ingredients String ingredients of the recipe.
     * @param steps String steps of the recipe.
     * @param price String price of the recipe.
     * @param publication String publication of the recipe.
     * @param photo String photo of the recipe.
     * @return Response.
     * @throws org.codehaus.jettison.json.JSONException
     * @throws java.io.IOException
     */
    @POST
    @Path("/postRecipe/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postRecipe(@QueryParam("name") String name,
                               @QueryParam("author") String author,
                               @QueryParam("type") String type,
                               @QueryParam("portions") String portions,
                               @QueryParam("duration") String duration,
                               @QueryParam("time") String time,
                               @QueryParam("difficulty") String difficulty,
                               @QueryParam("dietTag") String dietTag,
                               @QueryParam("photo") String photo,
                               @QueryParam("ingredients") String ingredients,
                               @QueryParam("steps") String steps,
                               @QueryParam("price") String price,
                               @QueryParam("publication") String publication)                               
                               throws JSONException, IOException {
        
        int newPortions = Integer.parseInt(portions);
        int newDuration = Integer.parseInt(duration);
        int newDifficulty = Integer.parseInt(difficulty);
        int newPrice = Integer.parseInt(price);
        
        String newPublication[] = publication.split("/");
        
        int day = Integer.parseInt(newPublication[0]);
        int month = Integer.parseInt(newPublication[1]);
        int year = Integer.parseInt(newPublication[2]);            
          
        if (!avltree.contains(name)) {
            
            RecipeJson.insert(name, author, type, newPortions, newDuration, time, newDifficulty, dietTag,
                              photo, ingredients, steps, newPrice, day, month, year);
                    
            return Response.status(Response.Status.CREATED).entity(avltree.getRecipe(name)).build();                          
                                                
        }
        
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
      
    }
    
    /**
     * Method that posts califications in the tree.
     * @param name String name of the recipe.
     * @param calification String calification of the recipe.
     * @return Response.
     * @throws org.codehaus.jettison.json.JSONException
     * @throws java.io.IOException
     */
    @POST
    @Path("/postRecipeCalification/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postRecipeCalification(@QueryParam("name") String name,
                                           @QueryParam("calification") String calification)                               
                                           throws JSONException, IOException {
        
        int newCalification = Integer.parseInt(calification);       
          
        if (avltree.contains(name)) {
            
            RecipeJson.insertCalification(name, newCalification);
                    
            return Response.status(Response.Status.CREATED).entity(avltree.getRecipe(name)).build();                          
                                                
        }
        
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
      
    }
    
    /**
     * Method that posts commentary in the tree.
     * @param name String name of the recipe.
     * @param commentary String commentary of the recipe.
     * @return Response.
     * @throws org.codehaus.jettison.json.JSONException
     * @throws java.io.IOException
     */
    @POST
    @Path("/postRecipeCommentary/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postRecipeCommentary(@QueryParam("name") String name,
                                         @QueryParam("commentary") String commentary)                               
                                         throws JSONException, IOException {        
          
        if (avltree.contains(name)) {
            
            RecipeJson.insertCommentary(name, commentary);
                    
            return Response.status(Response.Status.CREATED).entity(avltree.getRecipe(name)).build();                          
                                                
        }
        
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
      
    }
    
    // --------------------------------------------------------------------------------------------------------------------------------    
    
    /**
     * Method that gets all recipes of the tree.
     * @return Response.
     * @throws org.codehaus.jettison.json.JSONException
     * @throws java.io.IOException
     */
    @GET
    @Path("/getAllEnterprises/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEnterprises() throws JSONException, IOException {
                                
        return Response.ok(splayTree.inOrder()).build();
        
    } 
    
    /**
     * Method that gets a enterprise of the tree.
     * @param name String name of the enterprise.
     * @return Response.
     * @throws org.codehaus.jettison.json.JSONException
     * @throws java.io.IOException
     */
    @GET
    @Path("/getEnterprise/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEnterprise(@PathParam("name") String name) throws JSONException, IOException {
                                
        if (splayTree.contains(name)) {
            
            return Response.ok(splayTree.getEnterprise(name)).build();                              
                                                
        }
        
        return Response.status(Response.Status.NOT_FOUND).build();
        
    }
    
    /**
     * Method that gets enterprise matches in the tree.
     * @param name String name of the enterprise.
     * @return Response.
     * @throws org.codehaus.jettison.json.JSONException
     * @throws java.io.IOException
     */
    @GET
    @Path("/getEnterpriseMatch/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEnterpriseMatch(@PathParam("name") String name) throws JSONException, IOException {
        
        int size = name.length();
        
        return Response.ok(splayTree.matches(name, size)).build();                              
                            
    }
    
     /**
     * Method that posts a enterprise in the tree.
     * @param name String name of the enterprise.
     * @param logo String logo of the enterprise.
     * @param contact String contact of the enterprise.
     * @param schedule String schedule of the enterprise.
     * @param direction String direction of the enterprise.
     * @param members String members of the enterprise.
     * @return Response.
     * @throws org.codehaus.jettison.json.JSONException
     * @throws java.io.IOException
     * @throws org.json.simple.parser.ParseException
     */
    @POST
    @Path("/postEnterprise/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postEnterprise(@QueryParam("name") String name,
                                   @QueryParam("logo") String logo,
                                   @QueryParam("contact") String contact,
                                   @QueryParam("schedule") String schedule,
                                   @QueryParam("direction") String direction,
                                   @QueryParam("members") String members)
                                   throws JSONException, IOException,
                                   ParseException {
                                       
        if (!splayTree.contains(name)) {
            
            String newMembers[] = members.split(",");
            
            ArrayList<String> finalMembers = new ArrayList<String>();
            
            for (int i = 0; i < newMembers.length; i ++) {
                
                finalMembers.add(newMembers[i]);                
                
            }        
            
            EnterpriseJson.insert(name, logo, contact, schedule, direction, finalMembers);
            
            return Response.status(Response.Status.CREATED).entity(splayTree.getEnterprise(name)).build();                           
                                               
        }
        
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();                
      
    }
    
    /**
     * Method that posts califications in the tree.
     * @param name String name of the enterprise.
     * @param calification String calification of the enterprise.
     * @return Response.
     * @throws org.codehaus.jettison.json.JSONException
     * @throws java.io.IOException
     */
    @POST
    @Path("/postEnterpriseCalification/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postEnterpriseCalification(@QueryParam("name") String name,
                                               @QueryParam("calification") String calification)                               
                                               throws JSONException, IOException {
        
        int newCalification = Integer.parseInt(calification);       
          
        if (splayTree.contains(name)) {
            
            EnterpriseJson.insertCalification(name, newCalification);
                    
            return Response.status(Response.Status.CREATED).entity(splayTree.getEnterprise(name)).build();                          
                                                
        }
        
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
      
    }
    
    /**
     * Method that posts followers in the tree.
     * @param name String name of the enterprise.
     * @return Response.
     * @throws org.codehaus.jettison.json.JSONException
     * @throws java.io.IOException
     * @throws org.json.simple.parser.ParseException
     */
    @POST
    @Path("/postEnterpriseFollowers/{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postEnterpriseFollowers(@PathParam("name") String name) throws JSONException, IOException, ParseException {
                               
        if (splayTree.contains(name)) {
            
            EnterpriseJson.insertFollowers(name);
            
            return Response.status(Response.Status.CREATED).entity(splayTree.getEnterprise(name).getFollowers()).build();                          
                                              
        }
        
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
      
    }
    
    /**
     * Method that posts a myMenuList in the tree.
     * @param name String name of the enterprise.
     * @param newRecipe String newRecipe of the user.
     * @return Response.
     * @throws org.codehaus.jettison.json.JSONException
     * @throws java.io.IOException
     * @throws org.json.simple.parser.ParseException
     */
    @POST
    @Path("/postEnterpriseMyMenuList/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postEnterpriseMyMenuList(@QueryParam("name") String name,
                                             @QueryParam("newRecipe") String newRecipe)
                                             throws JSONException, IOException, ParseException {
              
        if (splayTree.contains(name)) {
            
            EnterpriseJson.insertMyMenuList(name, newRecipe);
            
            return Response.status(Response.Status.CREATED).entity(splayTree.getEnterprise(name).getMyMenuList()).build();                          
                                              
        }
        
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
      
    }
    
}

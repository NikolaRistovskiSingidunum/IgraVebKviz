/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controllers.Controller;
import Controllers.PlayerController;
import Controllers.TestController;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import javafx.util.Pair;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nikola
 */
public class Router {
    
    
    private static HashMap<String,Pair<Class,String>> urlMapping  = new HashMap<>() ;
    
    public static void init()
    {
        
        addNewRoute("/post/PlayerController/startGame", PlayerController.class , "startGame");
        addNewRoute("/post/PlayerController/endGame", PlayerController.class , "endGame");
        addNewRoute("/post/TestController/endGame", TestController.class , "endGame");
        addNewRoute("/post/PlayerController/mainLine", PlayerController.class , "mainLine");
        addNewRoute("/post/PlayerController/openField", PlayerController.class , "openField");
        //urlMapping.put("/startGame",new Pair(PlayerController.class, "startGame") );
    }
    private static void addNewRoute(String url, Class  controllerClass, String methodName)
    {
        urlMapping.put(url,new Pair(controllerClass, methodName) );
        
    }
    
    public static void callRoute(String url, HttpServletRequest request, HttpServletResponse response)
            throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        for (String s: urlMapping.keySet() )
        {
            if( s.equals(url) )
            {
                Class ControllerClass = urlMapping.get(s).getKey();
                String methodName = urlMapping.get(s).getValue();
                Controller controller = 
                        (Controller)(ControllerClass.getConstructor(HttpServletRequest.class,HttpServletResponse.class).newInstance(request,response));
                if(controller!=null)
                {
                    Method method = ControllerClass.getMethod(methodName);
                    if( method != null)
                    {
                        method.invoke(controller);
                        
                    }
                }
                //System.out.println(""+s);
                break;
            }
        }
    }
}

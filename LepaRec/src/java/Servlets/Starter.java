package Servlets;


import igra.Game;
import igra.Player;
import igra.PrimitiveJSON;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nikola
 */
public class Starter extends HttpServlet{
    
    
    public int i =0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("trazi sledece" + request.getPathInfo());
        System.out.println("servlet path" + request.getServletPath());
        try {
            System.out.println("trazi sledece" + request.getRequestURI());
            //System.out.println("trazi sledece" + request.toString());
            //        i++;
//         response.setContentType("text/html;charset=UTF-8");
//         response.addHeader("text/html", "charset-UTF8");
//         PrintWriter w = response.getWriter();
//        
//         if(request.getCookies()==null)
//         response.addCookie(new Cookie("aaa",""+i));
//        try{
//            //response.
//            System.out.println("koji kurac");
//            w.print("AAAAAAAAAAAAAAAAAAAAAAAA"+i);
//            w.print(request.getPathInfo());
//        }
//        finally{
//            System.out.println("koji kurac");
//        }

Router.callRoute(request.getServletPath(), request, response);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Starter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Starter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Starter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Starter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Starter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        
        
        try {

            Router.callRoute(request.getServletPath(), request, response);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Starter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Starter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Starter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Starter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Starter.class.getName()).log(Level.SEVERE, null, ex);
        }
    
  
         
    }
  @Override
  public void init(ServletConfig servletconfig)
    throws ServletException
{
   initTimerLoop();
   
   Router.init();
}
    
    public void initTimerLoop() {
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Player.updateTime(100);
                Game.startAllGames();
            }
        }, 0, 100, TimeUnit.MILLISECONDS);
    }

    
}

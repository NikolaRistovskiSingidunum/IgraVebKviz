
import igra.Game;
import igra.Player;
import igra.PrimitiveJSON;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
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
public class MyServlet extends HttpServlet{
    
    
    public int i =0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        i++;
         response.setContentType("text/html;charset=UTF-8");
         response.addHeader("text/html", "charset-UTF8");
         PrintWriter w = response.getWriter();
        
         if(request.getCookies()==null)
         response.addCookie(new Cookie("aaa",""+i));
        try{
            //response.
            System.out.println("koji kurac");
            w.print("AAAAAAAAAAAAAAAAAAAAAAAA"+i);
        }
        finally{
            System.out.println("koji kurac");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
           Player.handlePlayer(request, response, new PrimitiveJSON());
           Game.startAllGames();
//        response.setContentType("text/html;charset=UTF-8");
//         response.addHeader("text/html", "charset-UTF8");
        
//         try{
//             response.setContentType("text/html;charset=UTF-8");
//         PrintWriter w = response.getWriter();
////         w.print("\n");
//         w.print(new PrimitiveJSON().addKeyValue("da", "1").addKeyValue("gg", "ada").toString());
//         System.out.println(new PrimitiveJSON().addKeyValue("da", "1").addKeyValue("gg", "ada").toString());
//         //request.
//         System.out.println("GGGG"+request.getParameterMap());
//         System.out.println("GGGG"+request.getParameter("fname"));
//         System.out.println(request.toString());
//         response.setCharacterEncoding("UTF-8");
//             //System.out.println(request.);
//         }
//         catch(Exception e)
//         {
//             System.out.println(e);
//             System.out.println("aaaaaaaaaaaaaaaaaa");
//         }
         
    }
  @Override
  public void init(ServletConfig servletconfig)
    throws ServletException
{
   initTimerLoop();
}
    
    public void initTimerLoop() {
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Player.updateTime(100);
            }
        }, 0, 100, TimeUnit.MILLISECONDS);
    }

    
}


import java.io.IOException;
import java.io.PrintWriter;
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
    
}

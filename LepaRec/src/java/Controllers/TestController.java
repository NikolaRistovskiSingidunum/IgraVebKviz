/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nikola
 */
public class TestController extends Controller{
    
    public TestController(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }
    
    public void endGame() throws IOException {
        HttpServletResponse response = getResponse();
        HttpServletRequest request = getRequest();

        response.setContentType("text/html;charset=UTF-8");
        response.addHeader("text/html", "charset-UTF8");
        PrintWriter w = response.getWriter();

        w.print("pozdrav iz TestControllera endGame");

    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import igra.Game;
import igra.Player;
import igra.PrimitiveJSON;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nikola
 */
public class PlayerController extends Controller{
    
    public PlayerController(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }
    
    synchronized public void startGame() throws IOException
    {
        HttpServletResponse response = getResponse();
        HttpServletRequest request = getRequest();
        Cookie currentCookie = getCurrentCookie();
     
       
        
        String cookieValue = currentCookie.getValue();
        
        Player player = Player.getPlayer(cookieValue);
        boolean status = player.startMatching();
        
        
        
        PrintWriter w = response.getWriter();

            
        w.print(new PrimitiveJSON().addKeyValue("gameStarted",""+status ));

        System.out.println(cookieValue);
        
    
    }
    
    synchronized public void endGame() throws IOException
    {
        HttpServletResponse response = getResponse();
        HttpServletRequest request = getRequest();
        
        response.setContentType("text/html;charset=UTF-8");
        response.addHeader("text/html", "charset-UTF8");
        PrintWriter w = response.getWriter();

        w.print("pozdrav iz PlayerControllera endGame");
 
    }
    //ovaj metod svakih 0.1 sekudnu dostavlja informacije o trenutnoj igri
    synchronized public void mainLine() throws IOException
    {
        HttpServletResponse response = getResponse();
        HttpServletRequest request = getRequest();
        
        PrimitiveJSON outJSON = new PrimitiveJSON();
        
        Cookie currentCookie = getCurrentCookie();
        
        Player currentPlayer = Player.getPlayer(currentCookie.getValue());
        Game currentGame = currentPlayer.getCurrentGame();
        if (currentGame != null) {
//            System.out.println("player1" + currentGame.player1.cookie  );
//            System.out.println("player2" + currentGame.player2.cookie  );
            Player opponent = currentPlayer.getCurrentGame().getOpponent(currentPlayer);
            outJSON.addKeyValue("player1", currentPlayer.getCookie());
            outJSON.addKeyValue("player2", opponent.getCookie());
            outJSON.addKeyValue("p1id", currentPlayer.id);
            outJSON.addKeyValue("p2id", opponent.id);
            outJSON.addKeyValue("time1", Integer.toString((int) (currentPlayer.getTime() / 1000.0)));
            outJSON.addKeyValue("time2", Integer.toString((int) (opponent.getTime() / 1000.0)));
            
            currentGame.response(outJSON);
        }
        
        
        PrintWriter w = response.getWriter();

        w.print(outJSON);
    }
    synchronized public void openField() throws IOException
    {
        HttpServletResponse response = getResponse();
        HttpServletRequest request = getRequest();
        
        PrimitiveJSON outJSON = new PrimitiveJSON();
        
        Cookie currentCookie = getCurrentCookie();
        
        Player currentPlayer = Player.getPlayer(currentCookie.getValue());
        Game currentGame = currentPlayer.getCurrentGame();
        
        if(currentGame != null)
        {
            currentGame.react(request, currentPlayer);
        }
        
        PrintWriter w = response.getWriter();

        w.print("dobra ruta");
        
        System.out.println("dobra ruta");
    }
    
    synchronized private Cookie getCurrentCookie() {
        HttpServletResponse response = getResponse();
        HttpServletRequest request = getRequest();
        Cookie currentCookie;
        if (request.getCookies() == null) {
            currentCookie = new Cookie("slagalica", Player.generateSession());
            response.addCookie(currentCookie);

        } else {
            currentCookie = request.getCookies()[0];
        }

        return currentCookie;
    }
    
    
}

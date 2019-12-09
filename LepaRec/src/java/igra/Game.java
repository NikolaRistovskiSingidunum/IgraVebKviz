/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package igra;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Nikola
 */
public class Game {
    
    private Player player1, player2;
    
    private ArrayList<Level> levels = new ArrayList<Level>();
    
    private Level currentLevel;
    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }
    
    private static ArrayList<Game> games = new ArrayList<Game>();
    
    //pokusava da spari jednu igru 
    public static void startAllGames()
    {
        while( startOneGame())
        {
            
        }
    }
    //pokusava da spari jednu igru
    private static boolean startOneGame()
    {
        int i = 0;
        Player p1 = null, p2 = null;
        for (Player p : Player.players) {
            if(p.canStartTheGame() && i == 0)
            {
                i=1;
                p1 = p;
                continue;
            }
            if(p.canStartTheGame() && i==1)
            {
                p2 = p;
                new Game(p1,p2);
                return true;
            }
        }
        
        return false;
    }
    private Game(Player player1, Player player2)
    {
        if(player1 == null || player2 == null)
        {
            System.out.println("player1 == null || player2 == null");
            return;
        }
        
        this.player1 = player1;
        this.player2 = player2;
        
        player1.setInGame();
        player2.setInGame();
                
        player1.setCurrentGame(this);
        player2.setCurrentGame(this);
        
        generateLevels();
        
        this.player1.bCanPlay = true;
        this.player2.bCanPlay = false;
        
        games.add(this);
    }
    
    private void generateLevels()
    {
        currentLevel = new Asocijacija();
        levels.add(currentLevel);
    }
    
    public boolean react(HttpServletRequest request, Player currentPlayer)
    {
        if(currentLevel!=null)
        {
            boolean successfulMove = currentLevel.react(request, currentPlayer);
        
            if(successfulMove)
            {
                currentPlayer.bCanPlay = false;
                Player opponent = getOpponent(currentPlayer);
                opponent.bCanPlay = true;
                opponent.setTime(currentLevel.timeForMove);
                currentPlayer.setTime(100.0f);
            }
        }
        return false;
    }
    public Player getOpponent(Player p1)
    {
        if(player1 == p1)
            return player2;
        
        return player1;
    }
    public void response(PrimitiveJSON response)
    {
        if(currentLevel !=null)
        {
            currentLevel.response(response);
        }
    }
}

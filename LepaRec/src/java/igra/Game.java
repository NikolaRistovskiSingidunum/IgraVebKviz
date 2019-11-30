/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package igra;

import java.util.ArrayList;

/**
 *
 * @author Nikola
 */
public class Game {
    
    Player player1, player2;
    
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
        games.add(this);
    }
    
    
}

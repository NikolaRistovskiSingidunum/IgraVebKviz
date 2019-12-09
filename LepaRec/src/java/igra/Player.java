/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package igra;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nikola
 */
enum PlayerStatus {
    /*WaitingToPlay - znaci da igrac ceka da se pokrene igra
        InGame - znaci da igrac igra igra,
      Znaci da je igrac na vezi i da ne igra
     */
    ReadyToPlay, WaitingToPlay, InGame, DoesNothing;
}

public class Player {

    //svi igraci
    public boolean bCanPlay = false;

    public boolean playMove() {
        if (bCanPlay == false) {
            return false;
        }

        bCanPlay = true;
        return true;
    }

    public boolean canPlay() {
        return bCanPlay;
    }

    public static void updateTime(float elapsedTime) {

        for (Player p : players) {
            p.setTime(p.getTime() - elapsedTime);
            //p.time -= elapsedTime;
        }
    }
    private float time = 30;

    synchronized public float getTime() {
        return time;
    }

    synchronized public void setTime(float time) {
        this.time = time;
        //System.out.println(time);

    }

    public static ArrayList<Player> players = new ArrayList<Player>();

    /*cookie se korisit za identifikaciju, medjutim jednom igracu nece biti poslat cookie drugog igraca jer bi tako moglo da se vara
    bice mu poslati id, putem id, moguce da sazna info o drugom igracu, npr. da dovuce sliku, uname, broj poena
     */
    private String cookie;
    public String id;

    public String getCookie() {
        return cookie;
    }

    private Game currentGame;

    public Game getCurrentGame() {
        return currentGame;
    }

    public void setCurrentGame(Game currentGame) {
        this.currentGame = currentGame;
    }

    private PlayerStatus playerStatus = PlayerStatus.DoesNothing;

    public static Player getPlayer(String cookie) {

        for (Player player : players) {

            if (player.cookie.equals(cookie)) {
                return player;
            }
        }

        return new Player(cookie);
    }

    //public static 
    private Player(String cookie) {
        this.cookie = cookie;
        this.id = generateSession();
        players.add(this);
    }

    //ako je igrac bio slobodan posle ove funkcije dolazi u stanje da je spreman za igru
    public boolean startMatching() {
        if (playerStatus == PlayerStatus.DoesNothing) {
            playerStatus = PlayerStatus.WaitingToPlay;
            return true;
        } else {
            return false;
        }
    }

    //stavlja igraca u igru ako je bio u stanju cekanja
    public boolean setInGame() {
        if (playerStatus == PlayerStatus.WaitingToPlay) {
            playerStatus = PlayerStatus.InGame;
            return true;
        }
        return false;
    }

    public boolean canStartTheGame() {
        return playerStatus == PlayerStatus.WaitingToPlay;
    }

    public static void handlePlayer(HttpServletRequest request, HttpServletResponse response, PrimitiveJSON output) {
        //ako nema sesssiju
        if (request.getCookies() == null) {
            response.addCookie(new Cookie("slagalica", generateSession()));

        }

        String cookie = request.getCookies()[0].getValue();
        Player currentPlayer = getPlayer(cookie);

        String wantsToStart = request.getParameter("wantsToStart");
        //System.out.println("wantsToStart:" + wantsToStart);
        //System.out.println(cookie);

        currentPlayer.startMatching();

        Game currentGame = currentPlayer.getCurrentGame();

//        if(currentGame!=null)
//        {
////            System.out.println("player1" + currentGame.player1.cookie  );
////            System.out.println("player2" + currentGame.player2.cookie  );
//            output.addKeyValue("player1", currentGame.player1.cookie);
//            output.addKeyValue("player2", currentGame.player2.cookie);
//            output.addKeyValue("time1",Integer.toString((int) (currentGame.player1.time / 1000)));
//            output.addKeyValue("time2",Integer.toString((int) (currentGame.player2.time / 1000))) ;
//        }
        //Integer testTime
        //ispisi izlaz
        response.setContentType("text/html;charset=UTF-8");
        try {
            PrintWriter w = response.getWriter();
            w.write(output.toString());
            //System.out.println("opet nesto ne radi");
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String generateSession() {
        int n = 32;
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb 
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

}

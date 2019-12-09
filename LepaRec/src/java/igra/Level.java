/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package igra;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nikola
 */
public abstract class Level {
    
   
    
    
    public float timeForMove; // in ms
    public int levelId;
    //prihvata igracev upit i reaguje na njega
    public abstract boolean react(HttpServletRequest request, Player currentPlayer);
    
    //odgovor, celokupno stanje levela
    public abstract void response(PrimitiveJSON response);
    
    
}

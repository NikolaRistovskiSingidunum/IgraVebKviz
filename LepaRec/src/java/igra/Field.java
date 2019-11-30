/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package igra;

/**
 *
 * @author Nikola
 * 
 * Field klasa se odnosi na jedno polje asocijacije.
 * FieldPosition se odnosi na ocekivani raspored polja na tabli
 * Preporucen metod za otvaranje polja je openField
 * Nekad treba proveriti da li je polje otvoreno i u tu svrhu treba korisiti isOpened()
 */
enum FieldPosition
{
    A1,A2,A3,A4,B1,B2,B3,B4,C1,C2,C3,C4,D1,D2,D3,D4,ASolution,BSolution,CSolution,DSolution, WholeSolution;
}
public class Field {
    
    private boolean bOpen = false;
    private String value;
    private FieldPosition key;
    
    public Field(String value, FieldPosition key)
    {
        this.value = value;
        this.key = key;
    }
    public boolean isOpened()
    {
        return bOpen;
    }
    public String openField()
    {
        bOpen = true;
        return value;
    }

    public FieldPosition getKey() {
        return key;
    }
    
    public boolean checkFieldPosition(FieldPosition key)
    {
        return this.key==key;
    }
    
    
   
    
    
}

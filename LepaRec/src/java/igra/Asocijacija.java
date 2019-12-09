/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package igra;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Nikola
 */
public class Asocijacija extends Level{
    
    private Field[] fields= new Field[16];
    private Field ASolution, BSolution, CSolution, DSolution, WholeSolution;
    public Asocijacija()
    {
        fields[0]= new Field("KucaA1", FieldPosition.A1);
        fields[1]= new Field("KucaA2", FieldPosition.A2);
        fields[2]= new Field("KucaA3", FieldPosition.A3);
        fields[3]= new Field("KucaA4", FieldPosition.A4);
        
        fields[4]= new Field("KucaB1", FieldPosition.B1);
        fields[5]= new Field("KucaB2", FieldPosition.B2);
        fields[6]= new Field("KucaB3", FieldPosition.B3);
        fields[7]= new Field("KucaB4", FieldPosition.B4);
        
        fields[8]= new Field("KucaC1", FieldPosition.C1);
        fields[9]= new Field("KucaC2", FieldPosition.C2);
        fields[10]= new Field("KucaC3", FieldPosition.C3);
        fields[11]= new Field("KucaC4", FieldPosition.C4);
        
        fields[12]= new Field("KucaD1", FieldPosition.D1);
        fields[13]= new Field("KucaD2", FieldPosition.D2);
        fields[14]= new Field("KucaD3", FieldPosition.D3);
        fields[15]= new Field("KucaD4", FieldPosition.D4);
        
        ASolution = new Field("ASolution", FieldPosition.ASolution);
        BSolution = new Field("BSolution", FieldPosition.BSolution);
        CSolution = new Field("CSolution", FieldPosition.CSolution);
        DSolution = new Field("DSolution", FieldPosition.DSolution);
        WholeSolution = new Field("WholeSolution", FieldPosition.WholeSolution);
        
        levelId = 1;
        timeForMove = 30*1000; //in ms
        
        
    }
    
    public Asocijacija(int levelId)
    {
    
        
        this.levelId = levelId;
       
    }

    public boolean openField(FieldPosition fp)
    {
        for (Field f : fields) 
        {
            if (f.checkFieldPosition(fp)) 
            {
                if (f.isOpened() == false) 
                {
                    f.openField();
                    return true;
                } else 
                {
                    return false;
                }
            }

        }

        return false;
    }
    @Override
    public boolean react(HttpServletRequest request, Player currentPlayer) {
        String key = request.getParameter("open");
        
        if( currentPlayer.canPlay() == false)
            return false;
        
        if(key != null )
        {
            FieldPosition fp = FieldPosition.valueOf(key);
            
            return openField(fp);
        }
        
        return false;
    }

    @Override
    public void response(PrimitiveJSON response) {
        
        response.addKeyValue("levelId", "" + this.levelId);
        
        for( Field f: fields)
        {
            if(f.isOpened())
            {
            String key = f.getKey().toString();
            String value = f.getValue();
            response.addKeyValue(key, value);
            }
        }
    }
}

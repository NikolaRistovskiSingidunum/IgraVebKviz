/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package igra;

import java.util.HashMap;

/**
 *
 * @author Nikola
 */
//kljuc vrednost klasa, primitivni json
public class PrimitiveJSON {
    
    public HashMap<String,String> map = new HashMap<String, String>();
    public PrimitiveJSON(String string)
    {
       String[] rowData =string.split(",");
       for (String s: rowData)
       {
           String data[] = s.split(":");
           if(data.length < 2)
               continue;
           
           String key = data[0].trim();
           String value = data[1].trim();
           addKeyValue(key, value);
       }
       
    }
    public PrimitiveJSON()
    {
        
    }
    public PrimitiveJSON addKeyValue(String key, String value)
    {
        map.put(key, value);
        return this;
    }
    
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        
        for( String key:map.keySet())
        {
            builder.append("\""+key+"\"");
            builder.append(":");
            builder.append("\""+map.get(key)+"\"");
            builder.append(",");
        }
        
        builder.append("\"g\":\"g\"");
        
        builder.append("}");
        return builder.toString();
    }
}

package edu.jsu.mcis.cs310.coursedb.dao;

import java.sql.*;
import com.github.cliftonlabs.json_simple.*;
import java.util.ArrayList;

public class DAOUtility {
    
    public static final int TERMID_FA25 = 1;
    
    public static String getResultSetAsJson(ResultSet rs) {
        
        JsonArray records = new JsonArray();
        
        try {
        
            if (rs != null) {
                while (rs.next()) {
                    JsonObject row = new JsonObject();
                    for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {                
                        row.put(rs.getMetaData().getColumnName(i), rs.getString(i));
                    }
                    records.add(row);
                }

            }
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return Jsoner.serialize(records);
        
    }
    
}

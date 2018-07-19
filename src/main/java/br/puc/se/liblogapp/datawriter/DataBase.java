package br.puc.se.liblogapp.datawriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DataBase {
   
   protected Connection conn = null;
   protected String url = null;
   public DataBase()
   {
       
   }
   
   public Boolean StartDataBase()
   {
       Boolean r = false;
       try
       {
            String sql = "CREATE TABLE IF NOT EXISTS TabLogger (\n"
                     + "	id integer PRIMARY KEY,\n"
                     + "	LOGTIME text NOT NULL,\n"
                     + "	LEVEL integer,\n"
                     + "	MESSAGE text NOT NULL\n"
                     + ");";
            this.OpenConnection();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            this.CloseConnection();
            r = true;
       }
       catch(Exception ex)
       {
           
       }
       return r;
   }

   protected Boolean OpenConnection()
   {
       Boolean r = false;
       try
       {
            conn = DriverManager.getConnection(url);           
       }
       catch(Exception ex)
       {
           
       }
       return r;
   }
   
   protected Boolean CloseConnection()
   {
       Boolean r = false;
       try
       {
            conn.close();           
       }
       catch(Exception ex)
       {
           
       }
       return r;
   }
 
   public Boolean InsertRegister(String sqlCommand)
   {
       Boolean r = false;
       try
       {
           this.OpenConnection();
           Statement stmt = conn.createStatement();
           stmt.executeQuery(sqlCommand);  
           this.CloseConnection();
           r = true;
       }
       catch(Exception ex)
       {
           
       }
       return r;
   }
}

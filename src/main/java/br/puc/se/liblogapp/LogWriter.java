/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.puc.se.liblogapp;

import br.puc.se.liblogapp.datawriter.DataBase;
import br.puc.se.liblogapp.datawriter.IOWriter;
import br.puc.se.liblogapp.datawriter.NetRequest;

public class LogWriter {
    
    private LogAux log;
    
    public LogWriter()
    {       
    }
    
    public Boolean LogWrite(LogAux log)
    {
        Boolean r = false;
        this.log = log;
        if(log.DESTINATION == LogDestination.CONSOLE)
        {
            r = this.WriteLogOnConsole();
        }
        else if(log.DESTINATION == LogDestination.DATABASE)
        {
            r = this.WriteLogOnDataBase();
        }
        else if(log.DESTINATION == LogDestination.HTTPLOG)
        {
            r = this.WriteLogOnHttpPost();
        }
        else if(log.DESTINATION == LogDestination.IOFILE)
        {
            r = this.WriteLogOnFile();
        }
        else
        {
            r = false;
        }
        return r;
    }
    
    protected Boolean WriteLogOnHttpPost()
    {
        Boolean r = false;
        NetRequest httpClient = new NetRequest();
        httpClient.SendRequest("url", log.toString());
        return r;
    }
    
    protected Boolean WriteLogOnConsole()
    {
        Boolean r = false;
        String result = log.toString();
        System.out.println(result);
        return r;
    }
    
    protected Boolean WriteLogOnDataBase()
    {
        Boolean r = false;
        DataBase db = new DataBase();
        String sqlTable = "CREATE TABLE IF NOT EXISTS TabLogger (\n"
                     + "	id integer PRIMARY KEY,\n"
                     + "	LOGTIME text NOT NULL,\n"
                     + "	LEVEL integer,\n"
                     + "	MESSAGE text NOT NULL\n"
                     + ");";;
        String sqlRegister = "INSERT INTO TabLogger ('LOGTIME','LEVEL','MESSAGE') VALUES('"+log.TIMESTAMP+"',"+log.LEVEL+",'"+log.MESSAGE+"')";
        db.StartDataBase();
        db.InsertRegister(sqlRegister);
        return r;
    }
    
    protected Boolean WriteLogOnFile()
    {
        Boolean r = false;
        r = new IOWriter().WriteFile(log.toString());
        return r;
    }
    
}

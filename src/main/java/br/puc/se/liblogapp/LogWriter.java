/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.puc.se.liblogapp;

import br.puc.se.liblogapp.datawriter.DataBase;
import br.puc.se.liblogapp.datawriter.IOWriter;
import br.puc.se.liblogapp.datawriter.NetRequest;
import java.util.Date;

public class LogWriter {
    
    private LogAux log;
    
    public LogWriter()
    {       
        this.log = new LogAux();
    }
    
    public void log(String message, int level)
    {
        this.log.MESSAGE = message;
        this.log.LEVEL = level;
        this.log.TIMESTAMP = new Date().toString();
    }
    
    public Boolean WriteLogOnHttpPost(String url)
    {
        Boolean r = false;
        NetRequest httpClient = new NetRequest();
        this.log.DESTINATION = LogDestination.HTTPLOG;
        httpClient.SendRequest(url, log.toString());
        return r;
    }
    
    public Boolean WriteLogOnConsole()
    {
        Boolean r = false;
        String result = log.toString();
        this.log.DESTINATION = LogDestination.CONSOLE;
        System.out.println(result);
        return r;
    }
    
    public Boolean WriteLogOnDataBase()
    {
        Boolean r = false;
        DataBase db = new DataBase();
        this.log.DESTINATION = LogDestination.DATABASE;
        String sqlRegister = "INSERT INTO TabLogger ('LOGTIME','LEVEL','MESSAGE') VALUES('"+log.TIMESTAMP+"',"+log.LEVEL+",'"+log.MESSAGE+"')";
        db.StartDataBase();
        db.InsertRegister(sqlRegister);
        return r;
    }
    
    public Boolean WriteLogOnFile(String name)
    {
        Boolean r = false;
        this.log.DESTINATION = LogDestination.IOFILE;
        r = new IOWriter().WriteFile(log.toString());
        return r;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.puc.se.liblogapp;

public class LogAux {
    
    public String TIMESTAMP = "";
    public int LEVEL = 0;
    public String MESSAGE = "";
    public String DESTINATION = "";
    public String LOGGERNAME = "";
    
    public LogAux()
    {
    }
    
    @Override
    public String toString()
    {
        String result = null;
        result = "Time:" + this.TIMESTAMP + "\n";
        result += "Level:" + String.valueOf(this.LEVEL) + "\n";
        result += "Message:" + this.MESSAGE + "\n";
        return result;
    }
}


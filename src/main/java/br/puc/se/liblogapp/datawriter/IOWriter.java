/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.puc.se.liblogapp.datawriter;

import br.puc.se.liblogapp.LogWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IOWriter {
    
    public IOWriter()
    {
    }
    
    public Boolean WriteFile(String content)
    {
        Boolean r = false;
        String result = null;
        BufferedWriter file;
        try {
            file = new BufferedWriter(new FileWriter("temp.txt"));
            file.write(content);
            file.close();
            file.flush();
            r = true;
        } catch (IOException ex) {
            Logger.getLogger(LogWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.puc.se.liblogapp;

import java.time.LocalDateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author darwin22
 */
public class LogWriterTest {
    
    public LogWriter instance;
    
    public LogWriterTest() {
        instance = new LogWriter();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of LogWrite method, of class LogWriter.
     */
    @DisplayName("Test LogWrite for Console Output...")
    @Test
    public void testLogWrite() {
        String message = "The tests result is completed and successful...";
        int level = 1;
        Boolean expResult = false;
        instance.log(message,level);
        Boolean result = instance.WriteLogOnConsole();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
        System.out.println("LogWrite to Console is successful...");
    }
    
    @DisplayName("Ex2: Can I use the LibLogApp to write to File[temp.txt]?")
    @Test
    public void testLogWritteToFile() {
        String message = "The tests result is completed and successful...";
        int level = 1;
        Boolean expResult = false;
        instance.log(message,level);
        Boolean result = instance.WriteLogOnFile("log.txt");
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
        System.out.println("LogWrite to File is successful...");
    }
    
    @DisplayName("Ex2: Can I use the LibLogApp to write to Database?")
    @Test
    public void testLogWritteToDatabase() {
        String message = "The tests result is completed and successful...";
        int level = 1;
        Boolean expResult = false;
        instance.log(message,level);
        Boolean result = instance.WriteLogOnDataBase();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
        System.out.println("LogWrite to Database is successful...");
    }
    
    @DisplayName("Ex2: Can I use the LibLogApp to write to Http Webservice?")
    @Test
    public void testLogWritteToHttpService() {
        String message = "The tests result is completed and successful...";
        int level = 1;
        Boolean expResult = false;
        instance.log(message,level);
        Boolean result = instance.WriteLogOnHttpPost("url");
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
        System.out.println("LogWrite to Http Webservice is successful...");
    }
    
}

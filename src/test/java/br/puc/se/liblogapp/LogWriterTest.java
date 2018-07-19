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
    
    public LogWriterTest() {
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
        LogAux log = new LogAux();
        log.MESSAGE = "The tests result is completed and successful...";
        log.LEVEL = "1";
        log.TIMESTAMP = LocalDateTime.now().toString();
        log.DESTINATION = LogDestination.CONSOLE;
        LogWriter instance = new LogWriter();
        Boolean expResult = false;
        Boolean result = instance.LogWrite(log);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
        System.out.println("LogWrite to Console is successful...");
    }
    
    @DisplayName("Ex2: Can I use the LibLogApp to write to File[temp.txt]?")
    @Test
    public void testLogWritteToFile() {
        LogAux log = new LogAux();
        log.MESSAGE = "The tests result is completed and successful...";
        log.LEVEL = "1";
        log.TIMESTAMP = LocalDateTime.now().toString();
        log.DESTINATION = LogDestination.IOFILE;
        LogWriter instance = new LogWriter();
        Boolean expResult = false;
        Boolean result = instance.LogWrite(log);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
        System.out.println("LogWrite to File is successful...");
    }
    
    @DisplayName("Ex2: Can I use the LibLogApp to write to Database?")
    @Test
    public void testLogWritteToDatabase() {
        LogAux log = new LogAux();
        log.MESSAGE = "The tests result is completed and succefuly.";
        log.LEVEL = "1";
        log.TIMESTAMP = LocalDateTime.now().toString();
        log.DESTINATION = LogDestination.DATABASE;
        LogWriter instance = new LogWriter();
        Boolean expResult = false;
        Boolean result = instance.LogWrite(log);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
        System.out.println("LogWrite to Database is successful...");
    }
    
    @DisplayName("Ex2: Can I use the LibLogApp to write to Http Webservice?")
    @Test
    public void testLogWritteToHttpService() {
        LogAux log = new LogAux();
        log.MESSAGE = "The tests result is completed and succefuly.";
        log.LEVEL = "1";
        log.TIMESTAMP = LocalDateTime.now().toString();
        log.DESTINATION = LogDestination.HTTPLOG;
        LogWriter instance = new LogWriter();
        Boolean expResult = false;
        Boolean result = instance.LogWrite(log);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
        System.out.println("LogWrite to Http Webservice is successful...");
    }
    
}

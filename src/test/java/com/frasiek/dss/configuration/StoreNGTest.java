/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frasiek.dss.configuration;

import static org.testng.Assert.*;

/**
 *
 * @author frasiek
 */
public class StoreNGTest {
    
    public StoreNGTest() {
    }

    @org.testng.annotations.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.testng.annotations.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.testng.annotations.BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @org.testng.annotations.AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of getInstance method, of class Store.
     */
    @org.testng.annotations.Test
    public void testGetInstance() throws Exception {
        Store result = Store.getInstance();
        assertEquals(result, Store.getInstance());
        assertTrue(result instanceof Store);
    }
    
}

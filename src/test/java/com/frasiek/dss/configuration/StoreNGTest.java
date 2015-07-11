/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frasiek.dss.configuration;

import com.frasiek.dss.connection.Connection;
import com.frasiek.dss.connection.Direct;
import java.io.File;
import java.util.Set;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author frasiek
 */
public class StoreNGTest {

    private Connection testConnection;
    private Store instance;

    public StoreNGTest() throws StoreException {
        testConnection = new Direct("test", "test", "1");
        instance = Store.getInstance();
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
        System.out.println("getInstance");
        Store result = Store.getInstance();
        assertEquals(result, Store.getInstance());
        assertTrue(result instanceof Store);
    }

    /**
     * Test of addConnection method, of class Store.
     */
    @Test
    public void testAddConnection() throws Exception {
        System.out.println("addConnection");
        instance.addConnection(testConnection);
        assertEquals(1, instance.getStoredConnections().size());
    }

    /**
     * Test of removeConnection method, of class Store.
     */
    @Test(dependsOnMethods = {"testAddConnection"})
    public void testRemoveConnection() {
        System.out.println("removeConnection");
        instance.removeConnection(testConnection);
        assertEquals(0, instance.getStoredConnections().size());
    }

    /**
     * Test of saveStoredData method, of class Store.
     */
    @Test
    public void testSaveStoredData() throws Exception {
        System.out.println("saveStoredData");
        instance.saveStoredData();
        File f = new File(Store.class.getClassLoader().getResource("store.data").getPath());
        assertTrue(f.isFile());
    }

    /**
     * Test of hashCode method, of class Store.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        int expResult = 7;
        int result = instance.hashCode();
        assertEquals(result, expResult);
    }

    /**
     * Test of equals method, of class Store.
     */
    @Test
    public void testEquals() throws StoreException {
        System.out.println("equals");
        boolean expResult = false;
        boolean result = instance.equals(new Object());
        assertEquals(result, expResult);

        assertEquals(instance.equals(Store.getInstance()), true);
    }

    /**
     * Test of getStoredConnections method, of class Store.
     */
    @Test(dependsOnMethods = {"testAddConnection"})
    public void testGetStoredConnections() {
        System.out.println("getStoredConnections");
        instance.addConnection(testConnection);
        Set result = instance.getStoredConnections();
        assertTrue(result.contains(testConnection));
    }

}

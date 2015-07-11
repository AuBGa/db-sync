/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frasiek.dss.configuration;

import com.frasiek.dss.connection.Connection;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author frasiek
 */
public class Store {

    private static Store instance = null;
    private Logger logger = null;
    private HashSet<Connection> connections = null;

    public static Store getInstance() throws StoreException {
        if (Store.instance == null) {
            Store.instance = new Store();
        }

        return Store.instance;
    }

    private Store() throws StoreException {
        logger = LoggerFactory.getLogger(Store.class);
        connections = new HashSet<>();
        loadStoredData();
    }

    private void loadStoredData() throws StoreException {
        String location = getStoredDataLocation();
        try (FileInputStream saveFile = new FileInputStream(location);
                ObjectInputStream save = new ObjectInputStream(saveFile);) {
            Object saved = null;
            while ((saved = save.readObject()) != null) {
                this.connections.add((Connection) saved);
            }
        } catch (EOFException | FileNotFoundException ex){
            logger.error(ex.getMessage());
            //nic nie rob nie ma pliku nie ma co wczytywac
        } catch (IOException | ClassNotFoundException ex) {
            logger.error(ex.getMessage());
            throw new StoreException(ex);
        }
    }

    public void addConnection(Connection c) {
        this.connections.add(c);
    }

    public void removeConnection(Connection c) {
        this.connections.remove(c);
    }
    
    public Set<Connection> getStoredConnections(){
        return this.connections;
    }

    public void saveStoredData() throws StoreException {
        String location = getStoredDataLocation();
        try (FileOutputStream saveFile = new FileOutputStream(location);
                ObjectOutputStream save = new ObjectOutputStream(saveFile);) {
            for (Connection c : this.connections) {
                save.writeObject(c);
            }
        } catch (FileNotFoundException ex) {
            logger.error(ex.getMessage());
            throw new StoreException(ex);
        } catch (IOException ex) {
            logger.error(ex.getMessage());
            throw new StoreException(ex);
        }
    }

    private String getStoredDataLocation() {
        URL storeUrl = Store.class.getClassLoader().getResource("/store.data");
        if (storeUrl == null) {
            try {
                storeUrl = new URL(getClass().getProtectionDomain().getCodeSource().getLocation() + "store.data");
            } catch (MalformedURLException ex) {
                logger.equals(ex.getMessage());
            }
        }
        String dataPath = storeUrl.getPath();
        logger.trace("store.data found in: " + dataPath);
        return dataPath;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return true;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frasiek.dss.connection;

import com.frasiek.dss.Connection;
import com.frasiek.dss.DBStructure;
import com.frasiek.dss.DBStructureChanges;

/**
 *
 * @author frasiek
 */
public class PhpProxy implements Connection {

    private String host;
    private String username;
    private String password;
    private Integer port;

    public PhpProxy(String host, String username, String password) {
        this.host = host;
        this.username = username;
        this.password = password;
        this.port = 3306; //default mysql port
    }

    public PhpProxy(String host, String username, String password, Integer port) {
        this.host = host;
        this.username = username;
        this.password = password;
        this.port = port;
    }

    @Override
    public Boolean isConnectionOK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DBStructure getStructure() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNewStructure(DBStructureChanges dbChanges) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

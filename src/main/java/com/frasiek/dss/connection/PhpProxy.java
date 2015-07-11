/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frasiek.dss.connection;

import com.frasiek.dss.DBStructure;
import com.frasiek.dss.DBStructureChanges;
import com.frasiek.dss.structure.Database;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author frasiek
 */
public class PhpProxy implements Connection, Serializable {

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

    public List<Database> getDatabases() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.host);
        hash = 79 * hash + Objects.hashCode(this.username);
        hash = 79 * hash + Objects.hashCode(this.password);
        hash = 79 * hash + Objects.hashCode(this.port);
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
        final PhpProxy other = (PhpProxy) obj;
        if (!Objects.equals(this.host, other.host)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.port, other.port)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.username + "@" + this.host + ":" + this.port;
    }

    @Override
    public String getHost() {
        return host;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Integer getPort() {
        return port;
    }

}

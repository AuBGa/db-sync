/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frasiek.dss.connection;

import com.frasiek.dss.DBStructure;
import com.frasiek.dss.DBStructureChanges;
import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import org.slf4j.LoggerFactory;

/**
 *
 * @author frasiek
 */
public class Direct implements Connection, Serializable {

        private String host;
        private String username;
        private String password;
        private Integer port;
        private java.sql.Connection c = null;

        public Direct(String host, String username, String password) {
            this.host = host;
            this.username = username;
            this.password = password;
            this.port = 3306; //default mysql port
        }

        public Direct(String host, String username, String password, Integer port) {
            this.host = host;
            this.username = username;
            this.password = password;
            this.port = port;
        }

    @Override
    public Boolean isConnectionOK() {
        if (connect()) {
            try {
                c.createStatement().executeQuery("SHOW DATABASES;");
            } catch (SQLException ex) {
                LoggerFactory.getLogger(Direct.class).error(ex.getMessage());
                return false;
            } finally {
                try {
                    c.close();
                } catch (Exception ex) {
                }
            }
            return true;
        }
        return false;
    }

    private Boolean connect() {
        try {
            c = DriverManager.getConnection("jdbc:mysql://"+host+":"+port.toString()+"/information_schema?"
                    + "user="+username+"&password="+password);
        } catch (SQLException ex) {
            LoggerFactory.getLogger(Direct.class).error(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public DBStructure getStructure() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNewStructure(DBStructureChanges dbChanges) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.host);
        hash = 83 * hash + Objects.hashCode(this.username);
        hash = 83 * hash + Objects.hashCode(this.password);
        hash = 83 * hash + Objects.hashCode(this.port);
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
        final Direct other = (Direct) obj;
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
    
    

}

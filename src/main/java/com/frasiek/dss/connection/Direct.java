/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frasiek.dss.connection;

import com.frasiek.dss.DBStructure;
import com.frasiek.dss.DBStructureChanges;
import com.frasiek.dss.structure.Database;
import com.frasiek.dss.structure.Index;
import com.frasiek.dss.structure.Query;
import com.frasiek.dss.structure.QueryIterator;
import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
    private transient java.sql.Connection c = null;

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
                LoggerFactory.getLogger(Direct.class).error(ex.toString());
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
            c = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port.toString() + "/information_schema?"
                    + "user=" + username + "&password=" + password);
        } catch (SQLException ex) {
            LoggerFactory.getLogger(Direct.class).error(ex.toString());
            return false;
        }
        return true;
    }

    @Override
    public DBStructure getStructure(Database database) {
        try {
            if (connect() == false) {
                return null;
            }
            ResultSet rs = c.createStatement().executeQuery(Query.getTables(database.getName()));
            QueryIterator qi = new QueryIterator(rs);

            DBStructure structure = new DBStructure(Query.getTablesMap(qi));
            for (String table : structure.getTables().keySet()) {
                rs = c.createStatement().executeQuery(Query.getFields(database.getName(), table));
                qi = new QueryIterator(rs);
                structure.setField(table, Query.getFieldsMap(qi));
                
                rs = c.createStatement().executeQuery(Query.getIndexes(database.getName(), table));
                qi = new QueryIterator(rs);
                ArrayList<Index> indexes = Query.getIndexList(qi);
                structure.getTable(table).setIndexes(indexes);
            }

            return structure;
        } catch (SQLException ex) {
            LoggerFactory.getLogger(Direct.class).error(ex.toString());
            return null;
        } finally {
            try {
                c.close();
            } catch (Exception ex) {
            }
        }
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

    @Override
    public List<Database> getDatabases() {
        if (connect() == false) {
            return null;
        }

        List<Database> databases = new ArrayList<>();

        try {
            Statement smt = c.createStatement();
            ResultSet rs = smt.executeQuery(Query.getDatabases());
            while (rs.next()) {
                Database d = new Database(rs.getString(1));
                databases.add(d);
            }
            return databases;
        } catch (SQLException ex) {
            LoggerFactory.getLogger(Direct.class).error(ex.toString());
            return null;
        } finally {
            try {
                c.close();
            } catch (Exception ex) {
            }
        }
    }
}

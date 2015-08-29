/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frasiek.dss;

import com.frasiek.dss.structure.Field;
import com.frasiek.dss.structure.Table;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;

/**
 *
 * @author frasiek
 */
public class DBStructure {

    private HashMap<String, Table> tables;
    private String databaseName;

    public DBStructure() {

    }

    public DBStructure(String databaseName, HashMap<String, Table> tables) {
        this.tables = tables;
        this.databaseName = databaseName;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }
    
    

    public HashMap<String, Table> getTables() {
        return tables;
    }
    
    public Table getTable(String tableName){
        return tables.get(tableName);
    }

    public void setTables(HashMap<String, Table> tables) {
        this.tables = tables;
    }
    
    public void setField(String table, LinkedHashMap<String, Field> fields){
        this.tables.get(table).setFields(fields);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.tables);
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
        final DBStructure other = (DBStructure) obj;
        if (!Objects.equals(this.tables, other.tables)) {
            return false;
        }
        return true;
    }
    
    

}

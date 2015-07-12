/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frasiek.dss;

import com.frasiek.dss.structure.Field;
import com.frasiek.dss.structure.Table;
import java.util.HashMap;
import java.util.Objects;

/**
 *
 * @author frasiek
 */
public class DBStructure {

    private HashMap<String, Table> tables;

    public DBStructure() {

    }

    public DBStructure(HashMap<String, Table> tables) {
        this.tables = tables;
    }

    public HashMap<String, Table> getTables() {
        return tables;
    }

    public void setTables(HashMap<String, Table> tables) {
        this.tables = tables;
    }
    
    public void setField(String table, HashMap<String, Field> fields){
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

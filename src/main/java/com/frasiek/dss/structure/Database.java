/**
 * @author Michał Fraś
 */
package com.frasiek.dss.structure;

import java.util.HashMap;

/**
 *
 * 
 */
public class Database {
    
    private String name;
    private HashMap<String, Table> tables = new HashMap<>();

    public Database(String name) {
        this.name = name;
    }
    
    public void addTable(String name, Table table){
        tables.put(name, table);
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }
    
    
    
    
}

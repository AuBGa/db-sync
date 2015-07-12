/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frasiek.dss.structure;

import java.util.HashMap;

/**
 *
 * @author frasiek
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

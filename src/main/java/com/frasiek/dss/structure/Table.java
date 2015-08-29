/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frasiek.dss.structure;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Objects;

/**
 *
 * @author frasiek
 */
public class Table {

    private String name;
    private String engine;
    private String collation;

    private LinkedHashMap<String, Field> fields;
    private ArrayList<Index> indexes;

    public Table(String name, String engine, String collation) {
        this.name = name;
        this.engine = engine;
        this.collation = collation;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.engine);
        hash = 79 * hash + Objects.hashCode(this.collation);
        hash = 79 * hash + Objects.hashCode(this.fields);
        hash = 79 * hash + Objects.hashCode(this.indexes);
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
        final Table other = (Table) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.engine, other.engine)) {
            return false;
        }
        if (!Objects.equals(this.collation, other.collation)) {
            return false;
        }
        if (!Objects.equals(this.fields, other.fields)) {
            return false;
        }
        if (!Objects.equals(this.indexes, other.indexes)) {
            return false;
        }
        return true;
    }

    public void setFields(LinkedHashMap<String, Field> fields) {
        this.fields = fields;
    }

    public void setIndexes(ArrayList<Index> indexes) {
        this.indexes = indexes;
    }

    public String getName() {
        return name;
    }

    public String getEngine() {
        return engine;
    }

    public String getCollation() {
        return collation;
    }

    public LinkedHashMap<String, Field> getFields() {
        return fields;
    }

    public ArrayList<Index> getIndexes() {
        return indexes;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frasiek.dss.structure;

import java.util.HashMap;
import java.util.Objects;

/**
 *
 * @author frasiek
 */
public class Table {

    private String name;
    private String engine;
    private String collation;

    private HashMap<String, Field> fields;
    private HashMap<String, Index> indexes;
    private HashMap<String, PK> pks;

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
        hash = 79 * hash + Objects.hashCode(this.pks);
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
        if (!Objects.equals(this.pks, other.pks)) {
            return false;
        }
        return true;
    }

    public void setFields(HashMap<String, Field> fields) {
        this.fields = fields;
    }

    public void setIndexes(HashMap<String, Index> indexes) {
        this.indexes = indexes;
    }

    public void setPks(HashMap<String, PK> pks) {
        this.pks = pks;
    }

}

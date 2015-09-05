/**
 * @author Michał Fraś
 */
package com.frasiek.dss.structure;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Objects;
import org.slf4j.LoggerFactory;

/**
 *
 * 
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
            LoggerFactory.getLogger(Table.class).error("this.name != other.name: "+this.name+" != "+other.name);
            return false;
        }
        if (!Objects.equals(this.engine, other.engine)) {
            LoggerFactory.getLogger(Table.class).error("this.name != other.name: "+this.engine+" != "+other.engine);
            return false;
        }
        if (!Objects.equals(this.collation, other.collation)) {
            LoggerFactory.getLogger(Table.class).error("this.name != other.name: "+this.collation+" != "+other.collation);
            return false;
        }
        if (!Objects.equals(this.fields, other.fields)) {
            LoggerFactory.getLogger(Table.class).error("this.name != other.name: "+this.fields+" != "+other.fields);
            return false;
        }
        if (!Objects.equals(this.indexes, other.indexes)) {
            LoggerFactory.getLogger(Table.class).error("this.name != other.name: "+this.indexes+" != "+other.indexes);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frasiek.dss.structure;

import java.util.Objects;

/**
 *
 * @author frasiek
 */
public class Index {

    private String tableName;
    private Boolean nonUniq;
    private String keyName;
    private String colName;

    public Index(String tableName, Boolean nonUniq, String keyName, String colName) {
        this.tableName = tableName;
        this.nonUniq = nonUniq;
        this.keyName = keyName;
        this.colName = "`" + colName + "`";
    }

    public Index(String tableName, String nonUniq, String keyName, String colName) {
        this(tableName, nonUniq.equals("1"), keyName, colName);
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Boolean getNonUniq() {
        return nonUniq;
    }

    public void setNonUniq(Boolean nonUniq) {
        this.nonUniq = nonUniq;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.tableName);
        hash = 29 * hash + Objects.hashCode(this.nonUniq);
        hash = 29 * hash + Objects.hashCode(this.keyName);
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
        final Index other = (Index) obj;
        if (!Objects.equals(this.tableName, other.tableName)) {
            return false;
        }
        if (!Objects.equals(this.nonUniq, other.nonUniq)) {
            return false;
        }
        if (!Objects.equals(this.keyName, other.keyName)) {
            return false;
        }
        return true;
    }

    public void addFieldName(String fieldName) {
        this.colName += ", " + fieldName;
    }

    @Override
    public String toString() {
        String ret = this.prefix();
        if(isPrimary().equals(false)){
            ret += " `"+this.getKeyName()+"`";
        }
        ret += " ("+this.getColName()+")";
        return  ret;
    }

    private String prefix() {
        if (isPrimary()) {
            return "PRIMARY KEY";
        }
        if (this.getNonUniq()) {
            return "INDEX";
        }
        return "UNIQUE INDEX";
    }

    public Boolean isPrimary(){
        return this.getKeyName().equals("PRIMARY");
    }
}

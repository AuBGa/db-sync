/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frasiek.dss.structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *
 * @author frasiek
 */
public class Query {

    public static String getTables(String database) {
        return "select t.TABLE_NAME, t.`ENGINE`, t.TABLE_COLLATION from `TABLES` t where t.TABLE_SCHEMA = '" + database + "'";
    }
    
    public static String getDatabases(){
        return "select distinct SCHEMA_NAME from SCHEMATA;";
    }

    public static HashMap<String, Table> getTablesMap(QueryIterator qi) {
        HashMap<String, Table> tables = new HashMap<>();
        for (QueryRow row : qi) {
            tables.put(row.getAt(0), new Table(row.getAt(0), row.getAt(1), row.getAt(2)));
        }
        return tables;
    }
    
    public static String getFields(String database, String table) {
        return "select t.COLUMN_NAME, t.`IS_NULLABLE`, t.`CHARACTER_SET_NAME`, t.`COLLATION_NAME`, t.`COLUMN_TYPE`, t.`EXTRA`, t.`COLUMN_DEFAULT` from `COLUMNS` t where t.TABLE_SCHEMA = '" + database + "' and `TABLE_NAME` = '"+table+"' order by `ORDINAL_POSITION`";
    }
    
    public static LinkedHashMap<String, Field> getFieldsMap(QueryIterator qi) {
        LinkedHashMap<String, Field> fields = new LinkedHashMap<>();
        for (QueryRow row : qi) {
            fields.put(row.getAt(0), new Field(row.getAt(0), row.getAt(1), row.getAt(2), row.getAt(3), row.getAt(4), row.getAt(5), row.getAt(6)));
        }
        return fields;
    }
    
    public static String getIndexes(String database, String table){
        return "SHOW INDEX FROM `"+database+"`.`"+table+"`;";
    }
    
    public static ArrayList<Index> getIndexList(QueryIterator qi){
        ArrayList<Index> indexes = new ArrayList<>();
        for (QueryRow row : qi) {
            Index i = new Index(row.getAt(0), row.getAt(1), row.getAt(2), row.getAt(4));
            if(indexes.contains(i)){
                indexes.get(indexes.indexOf(i)).addFieldName(i.getColName());
            } else {
                indexes.add(i);
            }
        }
        return indexes;
    }
    
    
    
}

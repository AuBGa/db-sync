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
        return "select t.COLUMN_NAME, t.`IS_NULLABLE`, t.`CHARACTER_SET_NAME`, t.`COLLATION_NAME`, t.`COLUMN_TYPE`, t.`EXTRA` from `COLUMNS` t where t.TABLE_SCHEMA = '" + database + "' and `TABLE_NAME` = '"+table+"' order by `ORDINAL_POSITION`";
    }
    
    public static HashMap<String, Field> getFieldsMap(QueryIterator qi) {
        HashMap<String, Field> fields = new HashMap<>();
        for (QueryRow row : qi) {
            fields.put(row.getAt(0), new Field(row.getAt(0), row.getAt(1), row.getAt(2), row.getAt(3), row.getAt(4), row.getAt(5)));
        }
        return fields;
    }
    
}

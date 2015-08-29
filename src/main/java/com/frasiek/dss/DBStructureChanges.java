/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frasiek.dss;

import com.frasiek.dss.configuration.SqlGenerator;
import com.frasiek.dss.structure.Field;
import com.frasiek.dss.structure.Table;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author frasiek
 */
public class DBStructureChanges {

    private DBStructure source;
    private DBStructure destination;
    private String sql;

    public DBStructureChanges(DBStructure source, DBStructure destination) {
        this.source = source;
        this.destination = destination;
        this.calculateSyncSQL();
    }

    public String getSyncSQL() {
        return sql;
    }

    private void calculateSyncSQL() {
        sql = "";

        Map<String, Table> sourceTables = source.getTables();
        Map<String, Table> destTables = destination.getTables();
        for (String sourceTableName : sourceTables.keySet()) {
            if (destTables.containsKey(sourceTableName) == false) {
                //table is missing need to append createTable sql
                sql += SqlGenerator.createTable(sourceTables.get(sourceTableName)) + "\r\n";
                continue;
            }

            Table destTable = destTables.get(sourceTableName);
            Table sourceTable = sourceTables.get(sourceTableName);
            if (destTable.equals(sourceTable) == false) {
                //fields in table are not equal

                HashMap<String, Field> sourceFields = sourceTable.getFields();
                HashMap<String, Field> destFields = destTable.getFields();
                for (String sourceFieldName : sourceFields.keySet()) {
                    if (destFields.containsKey(sourceFieldName) == false) {
                        sql += SqlGenerator.createField(destTable, sourceFields.get(sourceFieldName)) + "\r\n";
                        continue;
                    }
                    if (destFields.get(sourceFieldName).equals(sourceFields.get(sourceFieldName)) == false) {
                        sql += SqlGenerator.updateField(destTable, sourceFields.get(sourceFieldName)) + "\r\n";
                    }
                }

                Map<String, Field> toDelete = (Map<String, Field>) destFields.clone();
                Set<String> keys = toDelete.keySet();
                if (keys.removeAll(sourceFields.keySet())) {
                    for (String toDeleteFieldName : keys) {
                        sql += SqlGenerator.removeField(destTable, toDeleteFieldName) + "\r\n";
                    }
                }
                
                if(destTable.getCollation().equals(sourceTable.getCollation()) == false){
                    sql += SqlGenerator.changeCollationOfTable(destTable, sourceTable.getCollation()) + "\r\n";
                }
                
                if(destTable.getIndexes().equals(sourceTable.getIndexes()) == false){
                    sql += SqlGenerator.changeIndexesOfTable(destTable, sourceTable.getIndexes()) + "\r\n";
                }
            }
        }
        Set<String> tables = new HashSet<String>(destTables.keySet());
        if (tables.removeAll(sourceTables.keySet())) {
            for (String tableName : tables) {
                sql += SqlGenerator.removeTable(tableName) + "\r\n";
            }
        }
    }

}

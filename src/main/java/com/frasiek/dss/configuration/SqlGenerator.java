/**
 * @author Michał Fraś
 */
package com.frasiek.dss.configuration;

import com.frasiek.dss.structure.Field;
import com.frasiek.dss.structure.Index;
import com.frasiek.dss.structure.Table;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * 
 */
public class SqlGenerator {

    public static String createTable(Table table) {
        String sql = "CREATE TABLE `" + table.getName() + "` (\r\n";
        sql += SqlGenerator.getFielsDefinitions(table);
        for (Index inx : table.getIndexes()) {
            sql += "," + inx.toString() + "\r\n";
        }
        sql += ")\r\nCOLLATE='" + table.getCollation() + "'\r\nENGINE=" + table.getEngine() + ";\r\n";
        return sql;
    }

    public static String createField(Table table, Field field) {
        return "ALTER TABLE `" + table.getName() + "` ADD COLUMN " + field.toString() + ";\r\n";
    }

    public static String updateField(Table table, Field field) {
        return "ALTER TABLE `" + table.getName() + "` CHANGE COLUMN `" + field.getName() + "` " + field.toString() + ";\r\n";
    }

    public static String removeField(Table table, String fieldName) {
        return "ALTER TABLE `" + table.getName() + "` DROP COLUMN `" + fieldName + "`;\r\n";
    }

    public static String removeTable(String tableName) {
        return "DROP TABLE `" + tableName + "`;\r\n";
    }

    private static String getFielsDefinitions(Table table) {
        LinkedHashMap<String, Field> fields = table.getFields();
        String sql = "";
        for (Field field : fields.values()) {
            sql += field.toString() + ",\r\n";
        }
        return sql.trim().substring(0, sql.length() - 3);
    }

    public static String changeCollationOfTable(Table table, String collation) {
        return "ALTER TABLE `" + table.getName() + "` COLLATE='" + collation + "';";
    }

    public static String changeIndexesOfTable(Table table, List<Index> indexes) {
        String toDrop = "";
        for (Index inx : table.getIndexes()) {
            toDrop += ", DROP " + (inx.isPrimary() ? "PRIMARY KEY" : "INDEX `" + inx.getKeyName() + "` ")+"\r\n";
        }
        toDrop = toDrop.substring(1);
        
        String toAdd = "";
        for (Index inx : indexes) {
            toAdd += ", ADD " + inx.toString()+"\r\n";
        }
        toAdd = toAdd.substring(1);

        if(toDrop.contains("DROP")){
            toAdd = " , "+toAdd;
        }
        
        return "ALTER TABLE `" + table.getName() + "` "+toDrop+toAdd+";\r\n";
    }

}

/**
 * @author Michał Fraś
 */
package com.frasiek.dss.structure;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.LoggerFactory;

/**
 *
 * 
 */
public class QueryRow {

    private ArrayList<String> row = new ArrayList<>();

    public QueryRow(ResultSet rs) {
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                row.add(rs.getString(i));
            }
        } catch (SQLException ex) {
            LoggerFactory.getLogger(QueryRow.class).error(ex.toString());
        }
    }

    public QueryRow(JSONObject rs, JSONArray header) {
        try {
            for (int i = 0; i < header.length(); i++) {
                String value = rs.getString(header.getString(i));
                if(value.toLowerCase().equals("null")){
                    row.add(null);
                } else {
                    row.add(value);
                }
                
            }
        } catch (JSONException ex) {
            LoggerFactory.getLogger(QueryRow.class).error(ex.toString());
        }
    }

    public String getAt(int i) {
        return row.get(i);
    }

}

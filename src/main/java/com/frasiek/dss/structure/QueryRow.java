/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frasiek.dss.structure;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.LoggerFactory;

/**
 *
 * @author frasiek
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

    public QueryRow(JSONObject rs) {
        try {
            JSONArray names = rs.names();
            for (int i = 0; i < names.length(); i++) {
                row.add(rs.getString(names.getString(i)));
            }
        } catch (JSONException ex) {
            LoggerFactory.getLogger(QueryRow.class).error(ex.toString());
        }
    }

    public String getAt(int i) {
        return row.get(i);
    }

}

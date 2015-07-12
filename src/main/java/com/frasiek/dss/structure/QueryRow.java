/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frasiek.dss.structure;

import com.frasiek.dss.connection.Direct;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
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
            for (int i = 0; i < rsmd.getColumnCount(); i++) {
                row.add(rs.getString(i));
            }
        } catch (SQLException ex) {
            LoggerFactory.getLogger(Direct.class).error(ex.toString());
        }
    }

    public String getAt(int i) {
        return row.get(i);
    }

}

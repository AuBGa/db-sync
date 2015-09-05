/**
 * @author Michał Fraś
 */
package com.frasiek.dss.structure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.LoggerFactory;

/**
 *
 * 
 */
public class QueryResult implements Iterable<QueryRow> {

    private ArrayList<QueryRow> rows = new ArrayList<>();

    public QueryResult(ResultSet rs) {
        try {
            while (rs.next()) {
                QueryRow qr = new QueryRow(rs);
                rows.add(qr);
            }
        } catch (SQLException ex) {
            LoggerFactory.getLogger(QueryResult.class).error(ex.toString());
        }
    }

    public QueryResult(JSONObject rs) {
        try {
            if (rs.getString("status").equals("OK") == false) {
                throw new SQLException("status is not ok");
            }
            JSONArray array = rs.getJSONArray("data");
            for (int i = 0; i < array.length(); i++) {
                QueryRow qr = new QueryRow(array.getJSONObject(i), rs.getJSONArray("header"));
                rows.add(qr);
            }
        } catch (SQLException ex) {
            LoggerFactory.getLogger(QueryResult.class).error(ex.toString());
        } catch (JSONException ex) {
            LoggerFactory.getLogger(QueryResult.class.getName()).error(ex.toString());
        }
    }

    @Override
    public Iterator<QueryRow> iterator() {
        return rows.iterator();
    }

}

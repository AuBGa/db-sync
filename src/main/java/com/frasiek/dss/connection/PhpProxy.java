/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frasiek.dss.connection;

import com.frasiek.dss.DBStructure;
import com.frasiek.dss.Http;
import com.frasiek.dss.structure.Database;
import com.frasiek.dss.structure.Index;
import com.frasiek.dss.structure.Query;
import com.frasiek.dss.structure.QueryIterator;
import com.frasiek.dss.structure.QueryRow;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.LoggerFactory;

/**
 *
 * @author frasiek
 */
public class PhpProxy implements Connection, Serializable {

    private String host;
    private String username;
    private String password;
    private Integer port;

    public PhpProxy(String host, String username, String password) {
        this.host = host;
        this.username = username;
        this.password = password;
        this.port = 3306; //default mysql port
    }

    public PhpProxy(String host, String username, String password, Integer port) {
        this.host = host;
        this.username = username;
        this.password = password;
        this.port = port;
    }

    @Override
    public Boolean isConnectionOK() {
        try {
            JSONObject json = this.sendQuery("SHOW DATABASES;", true);
            QueryIterator qi = new QueryIterator(json);
            return qi.iterator().hasNext();
        } catch (JSONException ex) {
            LoggerFactory.getLogger(Direct.class).error(ex.toString());
        }
        return false;
    }

    @Override
    public DBStructure getStructure(Database database) {
        try {
            JSONObject rs = this.sendQuery(Query.getTables(database.getName()));
            QueryIterator qi = new QueryIterator(rs);

            DBStructure structure = new DBStructure(database.getName(), Query.getTablesMap(qi));
            for (String table : structure.getTables().keySet()) {
                rs = sendQuery(Query.getFields(database.getName(), table));
                qi = new QueryIterator(rs);
                structure.setField(table, Query.getFieldsMap(qi));

                rs = sendQuery(Query.getIndexes(database.getName(), table));
                qi = new QueryIterator(rs);
                ArrayList<Index> indexes = Query.getIndexList(qi);
                structure.getTable(table).setIndexes(indexes);
            }

            return structure;
        } catch (JSONException ex) {
            LoggerFactory.getLogger(Direct.class).error(ex.toString());
            return null;
        }
    }

    public List<Database> getDatabases() {
        List<Database> databases = new ArrayList<>();
        try {
            JSONObject rs = this.sendQuery(Query.getDatabases());
            QueryIterator qi = new QueryIterator(rs);
            Iterator it = qi.iterator();
            while (it.hasNext()) {
                QueryRow qr = (QueryRow) it.next();
                Database d = new Database(qr.getAt(0));
                databases.add(d);
            }
            return databases;
        } catch (JSONException ex) {
            LoggerFactory.getLogger(Direct.class).error(ex.toString());
            return null;
        }
    }

    @Override
    public Boolean applyChanges(String sql) {
        String[] queries = sql.split(";");

        for (String query : queries) {
            if (query.trim().equals("")) {
                continue;
            }
            try {
                sendQuery(query.replaceAll("\r\n", " "), false);
            } catch (JSONException ex) {
                LoggerFactory.getLogger(Direct.class).error(ex.toString());
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.host);
        hash = 79 * hash + Objects.hashCode(this.username);
        hash = 79 * hash + Objects.hashCode(this.password);
        hash = 79 * hash + Objects.hashCode(this.port);
        return hash;
    }

    @Override
    public boolean equals(Object obj
    ) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PhpProxy other = (PhpProxy) obj;
        if (!Objects.equals(this.host, other.host)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.port, other.port)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.username + "@" + this.host + ":" + this.port;
    }

    @Override
    public String getHost() {
        return host;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Integer getPort() {
        return port;
    }

    private JSONObject sendQuery(String query) throws JSONException {
        return sendQuery(query, Boolean.TRUE);
    }

    private JSONObject sendQuery(String query, Boolean returnResult) throws JSONException {
        HashMap<String, Object> params = new HashMap<>();
        params.put("host", "localhost");
        params.put("login", this.getUsername());
        params.put("password", this.getPassword());
        params.put("port", this.getPort().toString());
        params.put("sql", query);
        params.put("return", (returnResult ? "1" : "0"));
        String response = Http.sendPost(this.getHost(), params);
        LoggerFactory.getLogger(Direct.class).debug(response);
        try {
            JSONObject jsonObj = new JSONObject(response);
            return jsonObj;
        } catch (JSONException ex) {
            LoggerFactory.getLogger(Direct.class).error(ex.toString());
            throw ex;
        }
    }

}

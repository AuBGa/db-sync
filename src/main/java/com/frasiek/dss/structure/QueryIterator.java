/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frasiek.dss.structure;

import com.frasiek.dss.connection.Direct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.collections.iterators.ArrayListIterator;
import org.slf4j.LoggerFactory;

/**
 *
 * @author frasiek
 */
public class QueryIterator implements Iterable<QueryRow>{

    private ArrayList<QueryRow> rows = new ArrayList<>();

    public QueryIterator(ResultSet rs) {
        try {
            while(rs.next()){
                QueryRow qr = new QueryRow(rs);
                rows.add(qr);
            }
        } catch (SQLException ex) {
            LoggerFactory.getLogger(Direct.class).error(ex.toString());
        }
    }
    
    @Override
    public Iterator<QueryRow> iterator() {
        return new ArrayListIterator(rows);
    }
    
    
    
    
}

/**
 * @author Michał Fraś
 */
package com.frasiek.dss.connection;

import com.frasiek.dss.DBStructure;
import com.frasiek.dss.structure.Database;
import java.util.List;

/**
 *
 * 
 */
public interface Connection {

    public Boolean isConnectionOK();

    public DBStructure getStructure(Database database);

    @Override
    public String toString();

    public String getHost();

    public String getUsername();

    public String getPassword();

    public Integer getPort();
    
    public List<Database> getDatabases();
    
    public Boolean applyChanges(String sql);

}

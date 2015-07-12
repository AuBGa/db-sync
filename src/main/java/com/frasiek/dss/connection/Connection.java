/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frasiek.dss.connection;

import com.frasiek.dss.DBStructure;
import com.frasiek.dss.DBStructureChanges;
import com.frasiek.dss.structure.Database;
import java.util.List;

/**
 *
 * @author frasiek
 */
public interface Connection {

    public Boolean isConnectionOK();

    public DBStructure getStructure(Database database);

    public void setNewStructure(DBStructureChanges dbChanges);

    @Override
    public String toString();

    public String getHost();

    public String getUsername();

    public String getPassword();

    public Integer getPort();
    
    public List<Database> getDatabases();

}

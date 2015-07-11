/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frasiek.dss;

/**
 *
 * @author frasiek
 */
public interface Connection {
    
    public Boolean isConnectionOK();
    
    public DBStructure getStructure();
    
    public void setNewStructure(DBStructureChanges dbChanges);
    
}

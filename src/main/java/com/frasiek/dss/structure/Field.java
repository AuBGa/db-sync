/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frasiek.dss.structure;

import java.util.Objects;

/**
 *
 * @author frasiek
 */
public class Field {

    private String name;
    private String nullable;
    private String characters;
    private String collation;
    private String type;
    private String extra;

    public Field(String name, String nullable, String characters, String collation, String type, String extra) {
        this.name = name;
        this.nullable = nullable;
        this.characters = characters;
        this.collation = collation;
        this.type = type;
        this.extra = extra;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.nullable);
        hash = 97 * hash + Objects.hashCode(this.characters);
        hash = 97 * hash + Objects.hashCode(this.collation);
        hash = 97 * hash + Objects.hashCode(this.type);
        hash = 97 * hash + Objects.hashCode(this.extra);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Field other = (Field) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.nullable, other.nullable)) {
            return false;
        }
        if (!Objects.equals(this.characters, other.characters)) {
            return false;
        }
        if (!Objects.equals(this.collation, other.collation)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.extra, other.extra)) {
            return false;
        }
        return true;
    }

}

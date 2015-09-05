/**
 * @author Michał Fraś
 */
package com.frasiek.dss.structure;

import java.util.Objects;
import org.slf4j.LoggerFactory;

/**
 *
 * 
 */
public class Field {

    private String name;
    private String nullable;
    private String characters;
    private String collation;
    private String type;
    private String extra;
    private String columnDefault;

    public Field(String name, String nullable, String characters, String collation, String type, String extra, String columnDefault) {
        this.name = name;
        this.nullable = nullable;
        this.characters = characters;
        this.collation = collation;
        this.type = type;
        this.extra = extra;
        this.columnDefault = columnDefault;
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
        hash = 97 * hash + Objects.hashCode(this.columnDefault);
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
            LoggerFactory.getLogger(Field.class).error("this.name != other.name: "+this.name+" != "+other.name);
            return false;
        }
        if (!Objects.equals(this.nullable, other.nullable)) {
            LoggerFactory.getLogger(Field.class).error("this.name != other.name: "+this.nullable+" != "+other.nullable);
            return false;
        }
        if (!Objects.equals(this.characters, other.characters)) {
            LoggerFactory.getLogger(Field.class).error("this.name != other.name: "+this.characters+" != "+other.characters);
            return false;
        }
        if (!Objects.equals(this.collation, other.collation)) {
            LoggerFactory.getLogger(Field.class).error("this.name != other.name: "+this.collation+" != "+other.collation);
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            LoggerFactory.getLogger(Field.class).error("this.name != other.name: "+this.type+" != "+other.type);
            return false;
        }
        if (!Objects.equals(this.extra, other.extra)) {
            LoggerFactory.getLogger(Field.class).error("this.name != other.name: "+this.extra+" != "+other.extra);
            return false;
        }
        if (!Objects.equals(this.columnDefault, other.columnDefault)) {
            LoggerFactory.getLogger(Field.class).error("this.name != other.name: "+this.columnDefault+" != "+other.columnDefault);
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public String getNullable() {
        return nullable;
    }

    public String getCharacters() {
        return characters;
    }

    public String getCollation() {
        return collation;
    }

    public String getType() {
        return type;
    }

    public String getExtra() {
        return extra;
    }

    public String getColumnDefault() {
        return columnDefault;
    }

    public void setColumnDefault(String columnDefault) {
        this.columnDefault = columnDefault;
    }
    
    
    
    @Override
    public String toString(){
        String nullVal = (this.getNullable().equals("NO")? "NOT NULL": "NULL");
        String def = (this.getColumnDefault() != null)?" DEFAULT "+this.getColumnDefault():"";
        String collation = ((this.getCollation() != null)?" COLLATE "+this.getCollation():"");
        return "`"+this.getName()+"` "+this.getType()+" "+nullVal+def+" "+this.getExtra()+collation;
    }
    

}

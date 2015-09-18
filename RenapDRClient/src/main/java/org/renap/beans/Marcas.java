// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Marcas.java

package org.renap.beans;

import java.io.Serializable;

public class Marcas
    implements Serializable
{

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getNombreComercial()
    {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial)
    {
        this.nombreComercial = nombreComercial;
    }

    public int hashCode()
    {
        int hash = 0;
        hash += id == null ? 0 : id.hashCode();
        return hash;
    }

    public boolean equals(Object object)
    {
        if(!(object instanceof Marcas))
            return false;
        Marcas other = (Marcas)object;
        return (id != null || other.id == null) && (id == null || id.equals(other.id));
    }

    public String toString()
    {
        return (new StringBuilder()).append("org.renap.orm.activosorm.Marcas[ id=").append(id).append(" ]").toString();
    }

    public Marcas()
    {
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    private Integer id;
    private String nombre;
    private String nombreComercial;
}

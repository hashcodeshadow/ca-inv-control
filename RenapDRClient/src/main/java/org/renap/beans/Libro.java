// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Libro.java

package org.renap.beans;

import java.io.Serializable;
import java.util.Date;

public class Libro
    implements Serializable
{

    public Libro()
    {
    }

    public Integer getIdlibro()
    {
        return idlibro;
    }

    public String getNoLibro()
    {
        return noLibro;
    }

    public Integer getIdUso()
    {
        return idUso;
    }

    public String getUsuario()
    {
        return usuario;
    }

    public Date getFecha()
    {
        return fecha;
    }

    public void setIdlibro(Integer idlibro)
    {
        this.idlibro = idlibro;
    }

    public void setNoLibro(String noLibro)
    {
        this.noLibro = noLibro;
    }

    public void setIdUso(Integer idUso)
    {
        this.idUso = idUso;
    }

    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }

    public void setFecha(Date fecha)
    {
        this.fecha = fecha;
    }

    public boolean equals(Object o)
    {
        if(o == this)
            return true;
        if(!(o instanceof Libro))
            return false;
        Libro other = (Libro)o;
        if(!other.canEqual(this))
            return false;
        Object this$idlibro = getIdlibro();
        Object other$idlibro = other.getIdlibro();
        if(this$idlibro != null ? !this$idlibro.equals(other$idlibro) : other$idlibro != null)
            return false;
        Object this$noLibro = getNoLibro();
        Object other$noLibro = other.getNoLibro();
        if(this$noLibro != null ? !this$noLibro.equals(other$noLibro) : other$noLibro != null)
            return false;
        Object this$idUso = getIdUso();
        Object other$idUso = other.getIdUso();
        if(this$idUso != null ? !this$idUso.equals(other$idUso) : other$idUso != null)
            return false;
        Object this$usuario = getUsuario();
        Object other$usuario = other.getUsuario();
        if(this$usuario != null ? !this$usuario.equals(other$usuario) : other$usuario != null)
            return false;
        Object this$fecha = getFecha();
        Object other$fecha = other.getFecha();
        return this$fecha != null ? this$fecha.equals(other$fecha) : other$fecha == null;
    }

    protected boolean canEqual(Object other)
    {
        return other instanceof Libro;
    }

    public int hashCode()
    {
        int PRIME = 59;
        int result = 1;
        Object $idlibro = getIdlibro();
        result = result * 59 + ($idlibro != null ? $idlibro.hashCode() : 0);
        Object $noLibro = getNoLibro();
        result = result * 59 + ($noLibro != null ? $noLibro.hashCode() : 0);
        Object $idUso = getIdUso();
        result = result * 59 + ($idUso != null ? $idUso.hashCode() : 0);
        Object $usuario = getUsuario();
        result = result * 59 + ($usuario != null ? $usuario.hashCode() : 0);
        Object $fecha = getFecha();
        result = result * 59 + ($fecha != null ? $fecha.hashCode() : 0);
        return result;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Libro(idlibro=").append(getIdlibro()).append(", noLibro=").append(getNoLibro()).append(", idUso=").append(getIdUso()).append(", usuario=").append(getUsuario()).append(", fecha=").append(getFecha()).append(")").toString();
    }

    private Integer idlibro;
    private String noLibro;
    private Integer idUso;
    private String usuario;
    private Date fecha;
}

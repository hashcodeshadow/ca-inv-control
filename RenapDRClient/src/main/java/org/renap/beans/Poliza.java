// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Poliza.java

package org.renap.beans;

import java.io.Serializable;
import java.util.Date;
import org.springframework.hateoas.ResourceSupport;

public class Poliza extends ResourceSupport
    implements Serializable
{

    public Poliza()
    {
    }

    public Integer getIdpoliza()
    {
        return idpoliza;
    }

    public String getNumero()
    {
        return numero;
    }

    public String getCertificado()
    {
        return certificado;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getAseguradora()
    {
        return aseguradora;
    }

    public String getUsuario()
    {
        return usuario;
    }

    public Date getFecha()
    {
        return fecha;
    }

    public void setIdpoliza(Integer idpoliza)
    {
        this.idpoliza = idpoliza;
    }

    public void setNumero(String numero)
    {
        this.numero = numero;
    }

    public void setCertificado(String certificado)
    {
        this.certificado = certificado;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public void setAseguradora(String aseguradora)
    {
        this.aseguradora = aseguradora;
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
        if(!(o instanceof Poliza))
            return false;
        Poliza other = (Poliza)o;
        if(!other.canEqual(this))
            return false;
        Object this$idpoliza = getIdpoliza();
        Object other$idpoliza = other.getIdpoliza();
        if(this$idpoliza != null ? !this$idpoliza.equals(other$idpoliza) : other$idpoliza != null)
            return false;
        Object this$numero = getNumero();
        Object other$numero = other.getNumero();
        if(this$numero != null ? !this$numero.equals(other$numero) : other$numero != null)
            return false;
        Object this$certificado = getCertificado();
        Object other$certificado = other.getCertificado();
        if(this$certificado != null ? !this$certificado.equals(other$certificado) : other$certificado != null)
            return false;
        Object this$nombre = getNombre();
        Object other$nombre = other.getNombre();
        if(this$nombre != null ? !this$nombre.equals(other$nombre) : other$nombre != null)
            return false;
        Object this$aseguradora = getAseguradora();
        Object other$aseguradora = other.getAseguradora();
        if(this$aseguradora != null ? !this$aseguradora.equals(other$aseguradora) : other$aseguradora != null)
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
        return other instanceof Poliza;
    }

    public int hashCode()
    {
        int PRIME = 59;
        int result = 1;
        Object $idpoliza = getIdpoliza();
        result = result * 59 + ($idpoliza != null ? $idpoliza.hashCode() : 0);
        Object $numero = getNumero();
        result = result * 59 + ($numero != null ? $numero.hashCode() : 0);
        Object $certificado = getCertificado();
        result = result * 59 + ($certificado != null ? $certificado.hashCode() : 0);
        Object $nombre = getNombre();
        result = result * 59 + ($nombre != null ? $nombre.hashCode() : 0);
        Object $aseguradora = getAseguradora();
        result = result * 59 + ($aseguradora != null ? $aseguradora.hashCode() : 0);
        Object $usuario = getUsuario();
        result = result * 59 + ($usuario != null ? $usuario.hashCode() : 0);
        Object $fecha = getFecha();
        result = result * 59 + ($fecha != null ? $fecha.hashCode() : 0);
        return result;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Poliza(idpoliza=").append(getIdpoliza()).append(", numero=").append(getNumero()).append(", certificado=").append(getCertificado()).append(", nombre=").append(getNombre()).append(", aseguradora=").append(getAseguradora()).append(", usuario=").append(getUsuario()).append(", fecha=").append(getFecha()).append(")").toString();
    }

    private Integer idpoliza;
    private String numero;
    private String certificado;
    private String nombre;
    private String aseguradora;
    private String usuario;
    private Date fecha;
}

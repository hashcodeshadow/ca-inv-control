// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ActivoInformatica.java

package org.renap.beans;

import java.io.Serializable;

public class ActivoInformatica
    implements Serializable
{

    public ActivoInformatica()
    {
    }

    public Integer getId()
    {
        return id;
    }

    public String getCui()
    {
        return cui;
    }

    public String getDepartamento()
    {
        return departamento;
    }

    public String getPerfilUsuario()
    {
        return perfilUsuario;
    }

    public String getPuesto()
    {
        return puesto;
    }

    public String getNombreUsuario()
    {
        return nombreUsuario;
    }

    public String getOficina()
    {
        return oficina;
    }

    public String getNombreEquipo()
    {
        return nombreEquipo;
    }

    public String getIp()
    {
        return ip;
    }

    public String getTipoEquipo()
    {
        return tipoEquipo;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public void setCui(String cui)
    {
        this.cui = cui;
    }

    public void setDepartamento(String departamento)
    {
        this.departamento = departamento;
    }

    public void setPerfilUsuario(String perfilUsuario)
    {
        this.perfilUsuario = perfilUsuario;
    }

    public void setPuesto(String puesto)
    {
        this.puesto = puesto;
    }

    public void setNombreUsuario(String nombreUsuario)
    {
        this.nombreUsuario = nombreUsuario;
    }

    public void setOficina(String oficina)
    {
        this.oficina = oficina;
    }

    public void setNombreEquipo(String nombreEquipo)
    {
        this.nombreEquipo = nombreEquipo;
    }

    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public void setTipoEquipo(String tipoEquipo)
    {
        this.tipoEquipo = tipoEquipo;
    }

    public boolean equals(Object o)
    {
        if(o == this)
            return true;
        if(!(o instanceof ActivoInformatica))
            return false;
        ActivoInformatica other = (ActivoInformatica)o;
        if(!other.canEqual(this))
            return false;
        Object this$id = getId();
        Object other$id = other.getId();
        if(this$id != null ? !this$id.equals(other$id) : other$id != null)
            return false;
        Object this$cui = getCui();
        Object other$cui = other.getCui();
        if(this$cui != null ? !this$cui.equals(other$cui) : other$cui != null)
            return false;
        Object this$departamento = getDepartamento();
        Object other$departamento = other.getDepartamento();
        if(this$departamento != null ? !this$departamento.equals(other$departamento) : other$departamento != null)
            return false;
        Object this$perfilUsuario = getPerfilUsuario();
        Object other$perfilUsuario = other.getPerfilUsuario();
        if(this$perfilUsuario != null ? !this$perfilUsuario.equals(other$perfilUsuario) : other$perfilUsuario != null)
            return false;
        Object this$puesto = getPuesto();
        Object other$puesto = other.getPuesto();
        if(this$puesto != null ? !this$puesto.equals(other$puesto) : other$puesto != null)
            return false;
        Object this$nombreUsuario = getNombreUsuario();
        Object other$nombreUsuario = other.getNombreUsuario();
        if(this$nombreUsuario != null ? !this$nombreUsuario.equals(other$nombreUsuario) : other$nombreUsuario != null)
            return false;
        Object this$oficina = getOficina();
        Object other$oficina = other.getOficina();
        if(this$oficina != null ? !this$oficina.equals(other$oficina) : other$oficina != null)
            return false;
        Object this$nombreEquipo = getNombreEquipo();
        Object other$nombreEquipo = other.getNombreEquipo();
        if(this$nombreEquipo != null ? !this$nombreEquipo.equals(other$nombreEquipo) : other$nombreEquipo != null)
            return false;
        Object this$ip = getIp();
        Object other$ip = other.getIp();
        if(this$ip != null ? !this$ip.equals(other$ip) : other$ip != null)
            return false;
        Object this$tipoEquipo = getTipoEquipo();
        Object other$tipoEquipo = other.getTipoEquipo();
        return this$tipoEquipo != null ? this$tipoEquipo.equals(other$tipoEquipo) : other$tipoEquipo == null;
    }

    protected boolean canEqual(Object other)
    {
        return other instanceof ActivoInformatica;
    }

    public int hashCode()
    {
        int PRIME = 59;
        int result = 1;
        Object $id = getId();
        result = result * 59 + ($id != null ? $id.hashCode() : 0);
        Object $cui = getCui();
        result = result * 59 + ($cui != null ? $cui.hashCode() : 0);
        Object $departamento = getDepartamento();
        result = result * 59 + ($departamento != null ? $departamento.hashCode() : 0);
        Object $perfilUsuario = getPerfilUsuario();
        result = result * 59 + ($perfilUsuario != null ? $perfilUsuario.hashCode() : 0);
        Object $puesto = getPuesto();
        result = result * 59 + ($puesto != null ? $puesto.hashCode() : 0);
        Object $nombreUsuario = getNombreUsuario();
        result = result * 59 + ($nombreUsuario != null ? $nombreUsuario.hashCode() : 0);
        Object $oficina = getOficina();
        result = result * 59 + ($oficina != null ? $oficina.hashCode() : 0);
        Object $nombreEquipo = getNombreEquipo();
        result = result * 59 + ($nombreEquipo != null ? $nombreEquipo.hashCode() : 0);
        Object $ip = getIp();
        result = result * 59 + ($ip != null ? $ip.hashCode() : 0);
        Object $tipoEquipo = getTipoEquipo();
        result = result * 59 + ($tipoEquipo != null ? $tipoEquipo.hashCode() : 0);
        return result;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ActivoInformatica(id=").append(getId()).append(", cui=").append(getCui()).append(", departamento=").append(getDepartamento()).append(", perfilUsuario=").append(getPerfilUsuario()).append(", puesto=").append(getPuesto()).append(", nombreUsuario=").append(getNombreUsuario()).append(", oficina=").append(getOficina()).append(", nombreEquipo=").append(getNombreEquipo()).append(", ip=").append(getIp()).append(", tipoEquipo=").append(getTipoEquipo()).append(")").toString();
    }

    private Integer id;
    private String cui;
    private String departamento;
    private String perfilUsuario;
    private String puesto;
    private String nombreUsuario;
    private String oficina;
    private String nombreEquipo;
    private String ip;
    private String tipoEquipo;
}

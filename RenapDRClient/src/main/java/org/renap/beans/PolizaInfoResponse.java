// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PolizaInfoResponse.java

package org.renap.beans;

import java.io.Serializable;
import java.util.List;

public class PolizaInfoResponse
    implements Serializable
{

    public PolizaInfoResponse()
    {
    }

    public List getPolizas()
    {
        return polizas;
    }

    public void setPolizas(List polizas)
    {
        this.polizas = polizas;
    }

    public boolean equals(Object o)
    {
        if(o == this)
            return true;
        if(!(o instanceof PolizaInfoResponse))
            return false;
        PolizaInfoResponse other = (PolizaInfoResponse)o;
        if(!other.canEqual(this))
            return false;
        Object this$polizas = getPolizas();
        Object other$polizas = other.getPolizas();
        return this$polizas != null ? this$polizas.equals(other$polizas) : other$polizas == null;
    }

    protected boolean canEqual(Object other)
    {
        return other instanceof PolizaInfoResponse;
    }

    public int hashCode()
    {
        int PRIME = 59;
        int result = 1;
        Object $polizas = getPolizas();
        result = result * 59 + ($polizas != null ? $polizas.hashCode() : 0);
        return result;
    }

    public String toString()
    {
        return (new StringBuilder()).append("PolizaInfoResponse(polizas=").append(getPolizas()).append(")").toString();
    }

    private List polizas;
}

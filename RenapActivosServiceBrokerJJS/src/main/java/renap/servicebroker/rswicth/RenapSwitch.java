// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RenapSwitch.java

package renap.servicebroker.rswicth;

import com.google.gson.Gson;
import com.renap.code.renap_esapi.impl.ESAPI_Impl;
import java.io.PrintStream;
import java.util.List;

public class RenapSwitch extends ESAPI_Impl
{

    public RenapSwitch()
    {
    }

    public void test()
    {
        List dep = getDepartamentos("320");
        System.out.println((new StringBuilder()).append("DEPARTAMENTOS LIST ").append(dep.size()).toString());
        System.out.println((new StringBuilder()).append("DEPARTAMENTOS LIST ").append(dep).toString());
    }

    public Object getDepartamentos()
    {
        List dep = getDepartamentos("320");
        System.out.println((new StringBuilder()).append("DEPARTAMENTOS LIST ").append(dep.size()).toString());
        System.out.println((new StringBuilder()).append("DEPARTAMENTOS LIST ").append(dep).toString());
        Object json = (new Gson()).toJson(dep);
        return json;
    }
}

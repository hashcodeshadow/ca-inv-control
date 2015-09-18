// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BeanToJson.java

package org.renap.util;

import java.io.IOException;
import java.io.PrintStream;
import org.codehaus.jackson.map.ObjectMapper;

public class BeanToJson
{

    public BeanToJson()
    {
    }

    public static String toJson(Object o)
    {
        String json = "";
        try
        {
            ObjectMapper maper = new ObjectMapper();
            json = maper.writeValueAsString(o);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return json;
    }

    public static Object jsonToBean(String json, String className)
    {
        className = className.substring(0, 1).toUpperCase().concat(className.substring(1));
        ObjectMapper mapper = new ObjectMapper();
        Object someClazz = null;
        try
        {
            String clazz = "org.renap.beans.".concat(className);
            someClazz = Class.forName(clazz).newInstance();
            return mapper.readValue(json, someClazz.getClass());
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println((new StringBuilder()).append(" ClassNotFoundException not foud ").append(className).append(" ").append(ex.getMessage()).toString());
        }
        catch(InstantiationException ex)
        {
            System.out.println((new StringBuilder()).append(" InstantiationException ").append(className).append(" ").append(ex.getMessage()).toString());
        }
        catch(IllegalAccessException ex)
        {
            System.out.println((new StringBuilder()).append(" IllegalAccessException ").append(className).append(" ").append(ex.getMessage()).toString());
        }
        catch(IOException ex)
        {
            System.out.println((new StringBuilder()).append("IOException ").append(className).append(" ").append(ex.getMessage()).toString());
        }
        return null;
    }

    private static final String PACKAGE = "org.renap.beans.";
}

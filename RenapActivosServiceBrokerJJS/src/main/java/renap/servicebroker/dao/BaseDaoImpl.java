// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BaseDaoImpl.java

package renap.servicebroker.dao;

import org.renap.dao.MarcaDao;
import org.renap.dao.GenDaoImpl;
import org.renap.dao.ActivoInformaticaDaoImpl;
import org.renap.dao.MarcaDaoImpl;
import java.io.PrintStream;
import org.renap.beans.ActivoInformatica;
import org.renap.beans.ActivoTecnologia;
import org.renap.beans.Marcas;
import org.renap.dao.*;
import org.renap.util.BeanToJson;

public class BaseDaoImpl
{

    public BaseDaoImpl()
    {
    }

    public String save(Object ob, String entityName)
    {
        System.out.println((new StringBuilder()).append("DOING SAVE IN BASEDAOIMPL!! MAPEAR ENTIDAD ").append(ob.toString()).append(" --").toString());
        
        
        System.out.println("ENTITY NAME "+entityName.equals("activotecnologia"));
        System.out.println("ACTIVOTECNOLOGIA "+entityName.equals("activotecnologia"));
        System.out.println("Ob "+ob);
        System.out.println("Ob "+ob.toString());
        if(entityName.trim().equals("activotecnologia"))
        {
            String json = ob.toString();
            System.out.println(" BaseDaoImpl JSON Object"+json);

            ActivoTecnologia actTecnologia = (ActivoTecnologia)BeanToJson.jsonToBean(json, "ActivoTecnologia");
            System.out.println((new StringBuilder()).append(" **** ").append(actTecnologia).toString());
            System.out.println((new StringBuilder()).append("ACTIVO TECNOLOGIA OBJECT ").append(actTecnologia instanceof ActivoTecnologia).toString());
            String result = new ActivoTecnologiaDaoImp().save(actTecnologia);
            System.out.println(" Result from data respository "+result);
            return result;
        } else
        if(entityName.equals("activoinformatica"))
        {
            ActivoInformaticaDao actDao = new ActivoInformaticaDaoImpl();
            String json = ob.toString();
            System.out.println((new StringBuilder()).append(" OB STRING ").append(ob.toString()).toString());
            System.out.println((new StringBuilder()).append(" OB STRING ").append(json).toString());
            json = json.replaceAll("\"json\":", "");
            json = json.substring(1, json.length());
            System.out.println((new StringBuilder()).append(" NEW OB STRING ").append(json).toString());
            ActivoInformatica actInformatica = (ActivoInformatica)BeanToJson.jsonToBean(json, "ActivoInformatica");
            System.out.println((new StringBuilder()).append(" **** ").append(actInformatica).toString());
            System.out.println((new StringBuilder()).append("ACTIVO INFORMATICA OBJECT ").append(actInformatica instanceof ActivoInformatica).toString());
            actDao.save(actInformatica);
        } else
        if(entityName.equals("marcas"))
        {
            MarcaDao marcaDao = new MarcaDaoImpl();
            Marcas marca = (Marcas)BeanToJson.jsonToBean(ob.toString(), entityName);
            System.out.println((new StringBuilder()).append("MARCA OBJECT ").append(marca instanceof Marcas).toString());
            marcaDao.save(marca);
        } else
        {
            System.out.println((new StringBuilder()).append("*** EJECUTANDO SAVE GENERICO **** ENTITYNAME").append(entityName).toString());
            GenDaoImpl dao = new GenDaoImpl(entityName);
            System.out.println((new StringBuilder()).append("*** EJECUTANDO SAVE GENERICO **** ENTITYNAME").append(ob).toString());
            dao.save(ob);
            System.out.println((new StringBuilder()).append("FINISH SAVE ENTITY ").append(entityName).toString());
        }
        
        return "VACIO";
    }

    public static void main(String args[])
    {
        String word = "{\"json\":{\"cui\":\"asdf\",\"departamento\":\"AK\",\"perfilUsuario\":\"asdf\",\"puesto\":\"AUI\",\"nombreUsuario\":\"asdf\",\"oficina\":\"asdf\",\"nombreEquipo\":\"adf\",\"ip\":";
        System.out.println(word);
        word = word.replaceAll("\"json\":", "");
        System.out.println(word);
        word = word.substring(1, word.length());
        System.out.println(word);
    }
}

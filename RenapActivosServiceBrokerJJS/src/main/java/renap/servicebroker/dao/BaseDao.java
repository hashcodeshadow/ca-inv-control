// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BaseDao.java

package renap.servicebroker.dao;

import java.util.List;

public interface BaseDao
{

    public abstract void save(Object obj, String s);

    public abstract void update(Object obj);

    public abstract void delete(Object obj);

    public abstract List findById(Object obj);

    public abstract String findAll();

    public abstract List findAllByProperty(String s, Object obj);
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GenDao.java

package org.renap.dao;

import java.util.List;

public interface GenDao
{

    public abstract void save(Object obj);

    public abstract void update(Object obj, Integer integer);

    public abstract void delete(Object obj, Integer integer);

    public abstract List findById(Object obj);

    public abstract String findAll();

    public abstract List findAllByProperty(String s, Object obj);
}

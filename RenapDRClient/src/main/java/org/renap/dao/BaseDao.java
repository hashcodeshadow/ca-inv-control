// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BaseDao.java

package org.renap.dao;

import java.util.List;


public interface BaseDao<E, PK > {
     public String save(E ob);

    public void update(E ob,PK id);

    public void delete(E ob,PK id);

    public E findById(E ob,PK id);

    public List<E> findAll();

    public List<E> findAllByProperty(String propertyName, Object value);
    
}

//public interface BaseDao<E>
//{
//
//    public abstract Object save(E obj);
//
//    public abstract void update(Object obj, Object obj1);
//
//    public abstract void delete(Object obj, Object obj1);
//
//    public abstract Object findById(Object obj, Object obj1);
//
//    public abstract String findAll();
//
//    public abstract List findAllByProperty(String s, Object obj);
//}

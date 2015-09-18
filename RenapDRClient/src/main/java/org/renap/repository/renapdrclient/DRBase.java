// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DRBase.java

package org.renap.repository.renapdrclient;

import java.io.Serializable;
import java.util.List;

public interface DRBase
{

    public abstract Serializable save(Object obj);

    public abstract void update(Object obj);

    public abstract void delete(Object obj);

    public abstract Object findById(Serializable serializable);

    public abstract Object findById(String s, Serializable serializable);

    public abstract List findAll();
}

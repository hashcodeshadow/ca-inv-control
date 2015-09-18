// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DataRepositoryClient.java

package org.renap.repository.renapdrclient;

import java.io.PrintStream;
import org.renap.beans.Poliza;
import org.renap.beans.Poliza;
import org.springframework.web.client.RestTemplate;

public class DataRepositoryClient
{

    public DataRepositoryClient()
    {
        restTemplate = new RestTemplate();
        baseUrl = "http://localhost:8090/";
    }

    public static DataRepositoryClient getInsClient()
    {
        return client != null ? client : (client = new DataRepositoryClient());
    }

    public void request(Object ob)
    {
        String requestName = ob.getClass().getName().toLowerCase();
        String url = String.format("%s%s", new Object[] {
            getBaseUrl(), requestName
        });
        System.out.print((new StringBuilder()).append("<<<<<<URL>>>>>").append(url).toString());
        Object poliza = getRestTemplate().getForObject(url, ob.getClass(), new Object[0]);
        System.out.println(poliza.toString());
    }

//    public void requestById(Integer ob)
//    {
//        String requestName = org/renap/beans/Poliza.getName().toLowerCase();
//        String url = String.format("%s%s", new Object[] {
//            getBaseUrl(), requestName
//        });
//        System.out.print((new StringBuilder()).append("<<<<<<URL>>>>>").append(url).toString());
//        Poliza poliza = (Poliza)getRestTemplate().getForObject(url, org/renap/beans/Poliza, new Object[0]);
//        System.out.println(poliza.toString());
//    }

    public void requestAll(Object ob)
    {
        Object poliza = getRestTemplate().getForObject("http://localhost:8090/poliza/1", ob.getClass(), new Object[0]);
        System.out.println(poliza.toString());
    }

    public RestTemplate getRestTemplate()
    {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    public String getBaseUrl()
    {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl)
    {
        this.baseUrl = baseUrl;
    }

    private static DataRepositoryClient client;
    protected RestTemplate restTemplate;
    private String baseUrl;
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GenDaoImpl.java

package org.renap.dao;

import com.google.gson.Gson;
import java.io.PrintStream;
import java.util.Arrays;
import org.renap.repository.renapdrclient.DataRepositoryClient;
import org.renap.util.BeanToJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class GenDaoImpl
{

    public GenDaoImpl(String entityName)
    {
        restTemplate = DataRepositoryClient.getInsClient().getRestTemplate();
        this.entityName = entityName;
        getUrl();
    }

    public void getUrl()
    {
        url = String.format("%s%s", new Object[] {
            DataRepositoryClient.getInsClient().getBaseUrl(), entityName
        });
        url = url.concat("/");
    }

    public void save(Object ob)
    {
        try
        {
            System.out.println((new StringBuilder()).append(" <<<<<<URL>>>>> ").append(url).append(" -------- ").toString());
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setAccept(Arrays.asList(new MediaType[] {
                MediaType.APPLICATION_JSON
            }));
            String json = BeanToJson.toJson(ob);
            String json2 = (new Gson()).toJson(ob);
            json = json.replace('\\', ' ');
            HttpEntity entity = new HttpEntity(json, headers);
//            restTemplate.exchange(url, HttpMethod.POST, entity, java/lang/String, new Object[0]);
            restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    private HttpEntity getEntityJsonHeader(Object ob)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String json = BeanToJson.toJson(ob);
        String json2 = (new Gson()).toJson(ob);
        System.out.println((new StringBuilder()).append("ENTITY HEADER ").append(json).toString());
        System.out.println((new StringBuilder()).append("ENTITY HEADER GSON ").append(json2).toString());
        HttpEntity entity = new HttpEntity(json, headers);
        return entity;
    }

//    private static final Logger log = LoggerFactory.getLogger(org/renap/dao/GenDaoImpl);
    private static final Logger log = LoggerFactory.getLogger(GenDaoImpl.class);
    protected String url;
    RestTemplate restTemplate;
    String entityName;

}

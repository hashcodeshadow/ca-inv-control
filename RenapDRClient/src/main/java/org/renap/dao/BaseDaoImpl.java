// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BaseDaoImpl.java
package org.renap.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.lang.reflect.ParameterizedType;
import java.util.*;
import org.renap.repository.renapdrclient.DataRepositoryClient;
import org.renap.util.BeanToJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

// Referenced classes of package org.renap.dao:
//            BaseDao
//public class BaseDaoImpl<E>
//        implements BaseDao<E> {
    //    private static final Logger log = LoggerFactory.getLogger(org/renap/dao/BaseDaoImpl);

public class BaseDaoImpl<E,PK > implements BaseDao<E,PK> {

    private static final Logger log = LoggerFactory.getLogger(BaseDaoImpl.class);
    
    protected Class<E> entityClass;
    protected String url;
    RestTemplate restTemplate= DataRepositoryClient.getInsClient().getRestTemplate();
    
    public BaseDaoImpl(){
        this.entityClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        getUrl();
    }
    
    @Override
    public String save(E ob) {
        System.out.println(" <<<<<<URL>>>>> "+url+" -------- ");
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String json = BeanToJson.toJson(ob);
        HttpEntity<String> entity = new HttpEntity<String>(json,headers);
        
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        System.out.println("Save Response data parsear PK "+response);
        System.out.println(" response.getStatusCode() "+response.getStatusCode());
        return response.getStatusCode().equals(HttpStatus.CREATED)?"OK":"ERROR";
    }

    @Override
    public void update(E ob,PK id) {
        String urlf = String.format("%s/%s", url,id);
        System.out.print(" <<<<<<URL>>>>> "+urlf );
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String json = BeanToJson.toJson(ob);
        HttpEntity<String> entity = new HttpEntity<String>(json,headers);
        
        ResponseEntity<String> response = restTemplate.exchange(urlf, HttpMethod.PUT, entity, String.class);
        System.out.println("UPDATE RESPONSE PK "+response);

    }

    @Override
    public void delete(E ob,PK id) {
        String urlf = String.format("%s/%s", url,id);
        System.out.println(" <<<<<<URL>>>>> "+urlf );
        
//        E e = restTemplate.getForObject(urlf, this.getEntityClass());
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String json = BeanToJson.toJson(ob);
        HttpEntity<String> entity = new HttpEntity<String>(json,headers);
        
        ResponseEntity<String> response = restTemplate.exchange(urlf, HttpMethod.DELETE, entity, String.class);
//        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, entity, String.class);
        System.out.println("DELETE Response data parsear PK "+response);
        
    }

    @Override
    public E findById(E ob,PK id) {
        String urlf = String.format("%s/%s", url,id);
        System.out.print(" <<<<<<URL>>>>> "+urlf );
        E e = restTemplate.getForObject(urlf, this.getEntityClass());
        return e;
    }

    @Override
    public List<E> findAll() {
        
        System.out.println(" <<<<<<URL>>>>> "+url+"   ---");
        E e = restTemplate.getForObject(url, this.getEntityClass());
        
        System.out.println(" RESULT TO FIND ALL ");
        System.out.println(e.toString());
//        System.out.print(" <<<<<<URL>>>>> "+url );
//        
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
////        String json = BeanToJson.toJson();
//        HttpEntity<String> entity = new HttpEntity<String>(null,headers);
//        
//        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
////        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, entity, String.class);
//        System.out.println("DELETE Response data parsear PK "+response);
        
        return null;
    }

    @Override
    public List<E> findAllByProperty(String propertyName, Object value) {
        System.out.print(" <<<<<<URL>>>>> "+url);
        throw new UnsupportedOperationException("Not supported implemented yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Class<E> getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class<E> entityClass) {
        this.entityClass = entityClass;
    }
    /**
     * 
     * @return 
     */
    private void getUrl(){
        String entity = getEntityClass().getSimpleName();
        String requestName = entity.toLowerCase();
         url = String.format("%s%s", DataRepositoryClient.getInsClient().getBaseUrl(),requestName);
         url = url.concat("/");
    }
    
    
    
    /*private static final Logger log = LoggerFactory.getLogger(BaseDaoImpl.class);
    protected Class entityClass;
    protected String url;
    RestTemplate restTemplate;

    public BaseDaoImpl() {
        restTemplate = DataRepositoryClient.getInsClient().getRestTemplate();
        entityClass = (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        System.out.println("ENTITY CLASS "+entityClass);
        getUrl();
    }

    public Object save(Object ob) {
        System.out.println((new StringBuilder()).append(" <<<<<<URL>>>>> ").append(url).append(" -------- ").toString());
        HttpEntity entity = getEntityJsonHeader(ob);
//        ResponseEntity response = restTemplate.exchange(url, HttpMethod.POST, entity, java/lang/String, new Object[0]);
        ResponseEntity response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        System.out.println((new StringBuilder()).append("Save Response data parsear PK ").append(response).toString());
        System.out.println(" RETURNING DATA QUEMADA CON NULL ");
        return null;
    }

    public void update(Object ob, Object id) {
        String urlf = String.format("%s/%s", new Object[]{
            url, id
        });
        System.out.print((new StringBuilder()).append(" <<<<<<URL>>>>> ").append(urlf).toString());
        HttpEntity entity = getEntityJsonHeader(ob);
//        ResponseEntity response = restTemplate.exchange(urlf, HttpMethod.PUT, entity, java/lang/String, new Object[0]);
        ResponseEntity response = restTemplate.exchange(urlf, HttpMethod.PUT, entity, String.class);
        System.out.println((new StringBuilder()).append("UPDATE RESPONSE PK ").append(response).toString());
    }

    public void delete(Object ob, Object id) {
        String urlf = String.format("%s/%s", new Object[]{
            url, id
        });
        System.out.println((new StringBuilder()).append(" <<<<<<URL>>>>> ").append(urlf).toString());
        HttpEntity entity = getEntityJsonHeader(ob);
//        ResponseEntity response = restTemplate.exchange(urlf, HttpMethod.DELETE, entity, java/lang/String, new Object[0]);
        ResponseEntity response = restTemplate.exchange(urlf, HttpMethod.DELETE, entity, String.class);
        System.out.println((new StringBuilder()).append("DELETE Response data parsear PK ").append(response).toString());
    }

    private HttpEntity getEntityJsonHeader(Object ob) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String json = BeanToJson.toJson(ob);
        String json2 = (new Gson()).toJson(ob);
        json = json.replace('\\', ' ');
        System.out.println((new StringBuilder()).append("ENTITY HEADER ").append(json).toString());
        System.out.println((new StringBuilder()).append("ENTITY HEADER GSON ").append(json2).toString());
        HttpEntity entity = new HttpEntity(json, headers);
        return entity;
    }

    public Object findById(Object ob, Object id) {
        String urlf = String.format("%s/%s", new Object[]{
            url, id
        });
        System.out.print((new StringBuilder()).append(" <<<<<<URL>>>>> ").append(urlf).toString());
        Object e = restTemplate.getForObject(urlf, getEntityClass(), new Object[0]);
        return e;
    }

    public String findAll() {
        System.out.println(" FIND ALL ");
        System.out.println((new StringBuilder()).append(" <<<<<<URL>>>>> ").append(url).append("   ---").toString());
        restTemplate = getRestTemplateWithHalMessageConverter();
        getHalMessageConverter();
//        ResponseEntity response = restTemplate.exchange(url, HttpMethod.GET, null, java/lang/String, new Object[0]);
        ResponseEntity response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        System.out.println((new StringBuilder()).append("FIND ALL Response  ").append(response).toString());
        System.out.println(" RETURNING DATA QUEMADA CON NULL ");
        return response.toString();
    }

    protected RestTemplate getRestTemplateWithHalMessageConverter() {
        List existingConverters = restTemplate.getMessageConverters();
        List newConverters = new ArrayList();
        newConverters.add(getHalMessageConverter());
        newConverters.addAll(existingConverters);
        restTemplate.setMessageConverters(newConverters);
        return restTemplate;
    }

    protected HttpMessageConverter getHalMessageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new Jackson2HalModule());
//        MappingJackson2HttpMessageConverter halConverter = new TypeConstrainedMappingJackson2HttpMessageConverter(org/springframework/hateoas/ResourceSupport);
        MappingJackson2HttpMessageConverter halConverter = null;//new TypeConstrainedMappingJackson2HttpMessageConverter(ResourceSupport);
        halConverter.setSupportedMediaTypes(Arrays.asList(new MediaType[]{
            MediaTypes.HAL_JSON
        }));
        halConverter.setObjectMapper(objectMapper);
        return halConverter;
    }

    public List findAllByProperty(String propertyName, Object value) {
        System.out.print((new StringBuilder()).append(" <<<<<<URL>>>>> ").append(url).toString());
        throw new UnsupportedOperationException("Not supported implemented yet.");
    }

    public Class getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class entityClass) {
        this.entityClass = entityClass;
    }

    private void getUrl() {
        String entity = getEntityClass().getSimpleName();
        String requestName = entity.toLowerCase();
        url = String.format("%s%s", new Object[]{
            DataRepositoryClient.getInsClient().getBaseUrl(), requestName
        });
        url = url.concat("/");
    }
*/
}

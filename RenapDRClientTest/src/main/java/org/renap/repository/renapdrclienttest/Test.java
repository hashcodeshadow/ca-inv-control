/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.repository.renapdrclienttest;

import java.util.List;
import org.renap.beans.Poliza;
import org.renap.dao.GenDaoImpl;
import org.renap.dao.PolizaDao;
import org.renap.dao.PolizaDaoImpl;
import org.renap.util.BeanToJson;

/**
 *
 * @author 1808236120101
 */
public class Test {
    
    public static void main(String ... args){
//        System.out.println("INGRESANDO AL MAIN");
//        RestTemplate restTemplate = new RestTemplate();
//        Poliza poliza = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Poliza.class);
//        Poliza poliza = restTemplate.getForObject("http://localhost:8090/poliza/1", Poliza.class);
        
//        System.out.println(poliza.toString());
//        
        PolizaDao dao = new PolizaDaoImpl();
        
//        new PolizaDaoImpl().findById(new Poliza(), 1);
        Poliza r=dao.findById(new Poliza(), 3);
        System.out.println(r.toString());
        System.out.println(BeanToJson.toJson(r));
//        
//        System.out.println(" ------- save --------");
////        String json = "{\"numero\":\"1111222\",\"1111certificado\":\"a\",\"nombre\":\"gyt\",\"aseguradora\":\"la general\",\"usuario\":\"1\",\"fecha\":null}";
        r.setNumero("55566");
        r.setNombre("NUEVO NOMBRE---");
        dao.save(r);
//        System.out.println("-----------------");
//
//        System.out.println("----DELETE ---");
//        //delete 1 by ID
//        
//        System.out.println("-------UPDATE----------");
//        r.setNombre("UPDATE REGISTRO");
//        r.setNumero("777777");
//        dao.update(r,11);
//        System.out.println("----------");
//        
//         System.out.println("------DELETE -------");
//        dao.delete(r,10);
        
//        dao.findAll();
        
//        GenDaoImpl dao= new GenDaoImpl("marcas");
//        String ob = "{\"nombre\":\"1111\",\"nombreComercial\":\"22222\"}";
//        dao.save(ob);
        
        
    }
}

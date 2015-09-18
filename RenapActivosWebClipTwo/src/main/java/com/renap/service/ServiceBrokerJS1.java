package com.renap.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleScriptContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 1808236120101
 * https://docs.oracle.com/javase/8/docs/technotes/guides/scripting/prog_guide/api.html
 */
public class ServiceBrokerJS1 extends HttpServlet {

    String path;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {
            System.out.println("DO GET");

//            saveDaoObj();
//            execFileJs(request);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        System.out.println("DO -----POST");
        PrintWriter out = response.getWriter();
        out.println("<h1>POST</h1>");
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
        } catch (Exception e) { /*report an error*/ }
        String json = jb.toString();
        System.out.println("DATA READ" + json);
        execFileJs(request, json);

//  try {
//      JsonObject jsonObject = JsonObject.fromObject(jb.toString());
//  } catch (ParseException e) {
//    // crash and burn
//    throw new IOException("Error parsing JSON request string");
//  }
  // Work with the data using methods like...
        // int someInt = jsonObject.getInt("intParamName");
        // String someString = jsonObject.getString("stringParamName");
        // JSONObject nestedObj = jsonObject.getJSONObject("nestedObjName");
        // JSONArray arr = jsonObject.getJSONArray("arrayParamName");
        // etc...
    }
    
    public void execFileJs(HttpServletRequest request,String json) {
        try{    
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("nashorn");
            engine.put("jsondata", json);
            //PUT DATA IN ENVOIREMNT FOR JS
            
            // define a different script context
            ScriptContext newContext = new SimpleScriptContext();
            newContext.setBindings(engine.createBindings(), ScriptContext.ENGINE_SCOPE);
            Bindings engineScope = newContext.getBindings(ScriptContext.ENGINE_SCOPE);
            engineScope.put("jsondata", json);
            
            path = request.getServletContext().getRealPath("/js/nashorn/polizaBroker.js");
            System.out.println(" PATH " + path);
            engine.eval(new java.io.FileReader(path),engineScope);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void saveDaoObj() {
        try {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("nashorn");

            engine.eval("var obj = new Object() ");
            engine.eval("obj.test = function() { print('obj.test() method called successfull') }");

            // expose object defined in the script to the Java application
            Object obj = engine.get("obj");

            // create an Invocable object by casting the script engine object
            Invocable inv = (Invocable) engine;

            // get Runnable interface object
            // get Runnable interface object
//            BaseDaoTest r = inv.getInterface(obj, BaseDaoTest.class);
//            System.out.println("Implemts interface. from js"+r);
//            r.test();
//            start a new thread that runs the script
//            Thread th = new Thread(r);
//            th.start();
//            th.join();
            //IMPLEMENTACION DE OBJECTOS JAVA EN JS
            engine.eval(" var ArrayList = Java.type(\"java.util.ArrayList\")");
            engine.eval(" var a = new ArrayList;");
            engine.eval("print(\"Type acts as target of instanceof: \" + (a instanceof ArrayList))");

            engine.eval(" var BaseDaoImpl = Java.type(\"renap.servicebroker.dao.BaseDaoImpl\")");
            engine.eval(" var a = new BaseDaoImpl;");
            engine.eval("print(\"Type acts as target of instanceof: \" + (a instanceof ArrayList))");
            engine.eval("print(\"Type acts as target of instanceof: \" + (a instanceof BaseDaoImpl))");

            //poliza
//            engine.eval("var Poliza = Java.type(\"renap.servicebroker.dto.Poliza\")");
//            engine.eval("var pol = Poliza");
            engine.eval("a.save({idpoliza:'idpoliza',numero:12321,certificado:'121a',nombre:'gyt'});");

            System.out.println("TERMINO ###");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void testScriptObj() {
        try {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("nashorn");

// evaluate JavaScript code that defines a function with one parameter
            engine.eval("var obj = new Object()");
            engine.eval("obj.run = function() { print('obj.run() method called') }");

            // expose object defined in the script to the Java application
            Object obj = engine.get("obj");

            // create an Invocable object by casting the script engine object
            Invocable inv = (Invocable) engine;

            // get Runnable interface object
            Runnable r = inv.getInterface(obj, Runnable.class);

            // start a new thread that runs the script
            Thread th = new Thread(r);
            th.start();
            th.join();

            System.out.println("TERMINO !!!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    class TestThread implements Runnable {

        @Override
        public void run() {
            int i = 0;
            while (i < 10) {
                System.out.println(" RUNNING " + i);
            }
        }

    }

    public void EvalFile() {
        try {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("nashorn");
            engine.eval(new java.io.FileReader("script.js"));

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}

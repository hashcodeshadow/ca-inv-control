package com.renap.service;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.SimpleBindings;
import javax.script.SimpleScriptContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 1808236120101
 * https://docs.oracle.com/javase/8/docs/technotes/guides/scripting/prog_guide/api.html
 * http://stackoverflow.com/questions/23089938/how-to-unbox-values-returned-by-javascript-nashorn-in-java-object
 */
public class ServiceBrokerJS extends HttpServlet {

    String path;
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {
            System.out.println("DO GET");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
        } catch (Exception e) { /*report an error*/ }
        String json = jb.toString();
        
        System.out.println(" JSON OBJECT SERVLET "+json);
        
        String action;
        String entity;
        
        Gson gson =new Gson();
        FormData f = gson.fromJson(json, FormData.class);
        
        System.out.println("FORM DATA "+f.getEntity());
        System.out.println("FORM DATA "+f.getAction());
        
        entity = f.getEntity();
        action = f.getAction();
 
        System.out.println(json+" ENTITY entity "+entity+" -- "+action);
//        execFileJs(request, json,"marcas");
        
        String result = execByFuc2(request,json,action,entity);
        response.getOutputStream().print(result);
        
    }
    
    public String execByFuc2(HttpServletRequest request,String json,String action,String entity){
        try {
//            String statement = "function fetch(value, count) { count++ ; return {'value': value,'count' : count} }; } ; ";
            //obtener entidad desde json y eliminar en persistencia.
            System.out.println("---- "+json+" --- "+entity);
//            ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
//            ScriptContext newContext = new SimpleScriptContext();
//            newContext.setBindings(engine.createBindings(), ScriptContext.ENGINE_SCOPE);
//            Bindings engineScope = newContext.getBindings(ScriptContext.ENGINE_SCOPE);
            
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("nashorn");
            
            ScriptContext newContext = new SimpleScriptContext();
            newContext.setBindings(engine.createBindings(), ScriptContext.ENGINE_SCOPE);
            Bindings engineScope = newContext.getBindings(ScriptContext.ENGINE_SCOPE);
            
//            engineScope.put("jsondata", json);
            engineScope.put("result", json);
            engine.put("result", "RESULT INIT");
            
            path = request.getServletContext().getRealPath("/STANDARD/assets/js/nashorn/genBrokerFunc.js");
            engine.eval(new java.io.FileReader(path));
            ((Invocable) engine).invokeFunction(action, json,entity);
            
            Object result = engine.get("result");
            
            return String.valueOf(result);
        }   
        catch (Exception ex ) {
            ex.printStackTrace();
            String version = System.getProperty("java.version");
            System.out.println(version);
        }
        return "ERROR IN EXECFUNC ";
    }
    
    public void execByFuc1(HttpServletRequest request,String json){
        System.out.println("SAVE BY DINAMIC FUNCTION execByFuc1-----------------");
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine e = sem.getEngineByName("nashorn");  
        Invocable invocable = (Invocable)e;
        ScriptEngineFactory f = e.getFactory();
        Object result;
        try {
//            String statement = "function fetch(value, count) { count++ ; return {'value': value,'count' : count} }; } ; ";
            path = request.getServletContext().getRealPath("/STANDARD/assets/js/nashorn/genBrokerFunc.js");
            CompiledScript cs = ((Compilable)e).compile(new java.io.FileReader(path));
            cs.eval();
            result = invocable.invokeFunction("saveMarcas", json);
            
        }   
        catch (Exception se ) {
            String version = System.getProperty("java.version");
            System.out.println(version);
            result = "script exception ";
        }
    }
    
    public void execByFuc(HttpServletRequest request,String json){
        try{
            System.out.println("EXEC FUNCTION "+json);
            
            ScriptEngine engine = new ScriptEngineManager().getEngineByMimeType("text/javascript");
            // Compile common functions once
            path = request.getServletContext().getRealPath("/STANDARD/assets/js/nashorn/genBrokerFunc.js");
    //            engine.eval(new java.io.FileReader(path));

            CompiledScript compiled = ((Compilable) engine).compile(new java.io.FileReader(path));
            Object genBroker = compiled.eval();

            // Load users' script each time
            SimpleBindings global = new SimpleBindings();
            global.put("jsondata", json);
            global.put("saveMarcas", genBroker);
            String script = "saveMarcas()";
            System.out.println(engine.eval(script, global));
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void execFileJs(HttpServletRequest request,String json,String entityName) {
        try{    
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("nashorn");
//            engine.put("jsondata", json);
            //PUT DATA IN ENVOIREMNT FOR JS
            
            // define a different script context
            ScriptContext newContext = new SimpleScriptContext();
            newContext.setBindings(engine.createBindings(), ScriptContext.ENGINE_SCOPE);
            Bindings engineScope = newContext.getBindings(ScriptContext.ENGINE_SCOPE);
            
            engineScope.put("jsondata", json);
            engineScope.put("entity", entityName);
            
            path = request.getServletContext().getRealPath("/STANDARD/assets/js/nashorn/genBroker.js");
            engine.eval(new java.io.FileReader(path),engineScope);
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void execSwitchJs(HttpServletRequest request,String json) {
        try{    
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("nashorn");

            ScriptContext newContext = new SimpleScriptContext();
            newContext.setBindings(engine.createBindings(), ScriptContext.ENGINE_SCOPE);
            Bindings engineScope = newContext.getBindings(ScriptContext.ENGINE_SCOPE);
            
            engineScope.put("jsondata", json);
            
            path = request.getServletContext().getRealPath("/STANDARD/assets/js/nashorn/switchRenap.js");
            
            engine.eval(new java.io.FileReader(path),engineScope);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



}

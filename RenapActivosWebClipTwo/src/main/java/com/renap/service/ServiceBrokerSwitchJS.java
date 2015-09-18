package com.renap.service;

import java.io.BufferedReader;
import java.io.IOException;
import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleBindings;
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
public class ServiceBrokerSwitchJS extends HttpServlet {

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
        
        String action = request.getParameter("action");
        String entity = request.getParameter("entity");
        
        String result= execSwitchJs(request,json);
        response.getOutputStream().print(result);
        
    }
    
    public String execSwitchJs(HttpServletRequest request,String json) {
        try{    
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("nashorn");
            
            ScriptContext newContext = new SimpleScriptContext();
            newContext.setBindings(engine.createBindings(), ScriptContext.ENGINE_SCOPE);
            Bindings engineScope = newContext.getBindings(ScriptContext.ENGINE_SCOPE);
            
            engineScope.put("jsondata", json);
            engine.put("result", "RESULT INIT");
            
//            engineScope.put("codpais", "320");
            path = request.getServletContext().getRealPath("/STANDARD/assets/js/nashorn/switchRenap.js");
//            engine.eval(new java.io.FileReader(path),engineScope);
            engine.eval(new java.io.FileReader(path));
            ((Invocable) engine).invokeFunction("getDeptos");
            
            Object result = engine.get("result");
            System.out.println("RESULT SWITCH "+result);
            return String.valueOf(result);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public void execByFuc2(HttpServletRequest request,String json,String action,String entity){
        System.out.println("SAVE BY DINAMIC FUNCTION execByFuc2-----------------");
        
        try {
//            String statement = "function fetch(value, count) { count++ ; return {'value': value,'count' : count} }; } ; ";
            //obtener entidad desde json y eliminar en persistencia.
            
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
            engine.put("result", "RESULT");
            path = request.getServletContext().getRealPath("/STANDARD/assets/js/nashorn/genBrokerFunc.js");
            engine.eval(new java.io.FileReader(path));
            ((Invocable) engine).invokeFunction("save", json,"marcas");
            System.out.println(engine.get("result"));
        }   
        catch (Exception ex ) {
            ex.printStackTrace();
            String version = System.getProperty("java.version");
            System.out.println(version);
            
        }
    }



}

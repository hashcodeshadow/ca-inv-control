/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.beans;

import java.util.Date;

/**
 *
 * @author 1808236120101
 */

public class ActivoTecnologia extends BaseBean{
    
     private Integer id;
     private String nombre_mac;
     private String ip;
     private String marca;


    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nombreMac
     */
    public String getNombre_mac() {
        return nombre_mac;
    }

    /**
     * @param nombreMac the nombreMac to set
     */
    public void setNombre_mac(String nombreMac) {
        this.nombre_mac = nombreMac;
    }

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

     
}

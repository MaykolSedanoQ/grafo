/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.umanizales.grafo.domain.model.dto;

import java.io.Serializable;

/**
 *
 * @author mayko
 */
public class RespuestasDto implements Serializable{
    
    
    private int codigo;
    private String mensaje;
    private Object result;

    public RespuestasDto(int codigo, String mensaje, Object result) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.result = result;
    }

    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
    
    
}

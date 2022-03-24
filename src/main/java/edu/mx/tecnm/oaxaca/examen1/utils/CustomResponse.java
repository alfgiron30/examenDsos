/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.mx.tecnm.oaxaca.examen1.utils;

import java.util.LinkedList;

/**
 *
 * @author Alfredo
 */
public class CustomResponse {
    private Integer httpcode;
    private Object data;
    private String message;

    public CustomResponse(){
        this.httpcode = 200;
        this.data = new LinkedList();
        this.message = "Ok";
    }
    
    public Integer getHttpcode() {
        return httpcode;
    }

    public void setHttpcode(Integer httpcode) {
        this.httpcode = httpcode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}

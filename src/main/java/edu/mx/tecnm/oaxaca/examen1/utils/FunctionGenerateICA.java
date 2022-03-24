/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.mx.tecnm.oaxaca.examen1.utils;

import org.springframework.stereotype.Component;

/**
 *
 * @author Alfredo
 */
@Component
public class FunctionGenerateICA {
    Double ica;
    String nivel;
    
    
    public void calcularIca(Double cintura, Double altura){
        this.ica = cintura/altura;
    }
    
    public void determinarNivel(char genero){
        if(ica<.34){
            this.nivel = "Delgadez severa";
        }else if((ica>=.35 && ica<=.42 && genero=='H') || (ica>=.35 && ica<=.41 && genero=='M')){
            this.nivel =  "Delgadez leve";
        }else if((ica>=.43 && ica<=.52 && genero=='H') || (ica>=.42 && ica<=.48 && genero=='M')){
            this.nivel = "Peso normal";
        }else if((ica>=.53 && ica<=.57 && genero=='H') || (ica>=.49 && ica<=.53 && genero=='M')){
            this.nivel = "Sobrepeso";
        }else if((ica>=.58 && ica<=.62 && genero=='H') || (ica>=.54 && ica<=.57 && genero=='M')){
            this.nivel = "Sobrepeso elevado";
        }else{
            this.nivel = "Obesidad mórbida";
        }
    }

    public Double getIca() {
        return ica;
    }

    public void setIca(Double ica) {
        this.ica = ica;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    
    
}

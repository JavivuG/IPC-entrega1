/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entrega1.modelo;

/**
 *
 * @author javivu
 */
public class ReferenciaLibro {
    private String referencia;
    
    public ReferenciaLibro(String isbn, String titulo){
        this.referencia=titulo+":"+isbn;
    }
    
    public String getReferencia(){
        return referencia;
    }
    
    public String getTitulo(){
        return referencia.split(":")[0];
    }
    
    public String getISBN(){
        return referencia.split(":")[1];
    }
    
    public boolean tituloCorrecto(){
        return getTitulo().length()>=1 && getTitulo().length()<=20;
    }
    
    public boolean isbnCorrecto(){
        return getISBN().length()>=1 && getISBN().length()<=13;
    }
    
    @Override
    public String toString(){
        return "Titulo:"+getTitulo()+" ISBN:"+getISBN();
    }
    
    @Override
    public boolean equals(Object o){
        if (o instanceof ReferenciaLibro){
            String tituloOtroLibro= ((ReferenciaLibro) o).getTitulo();
            String isbnOtroLibro = ((ReferenciaLibro) o).getISBN();
            if (getTitulo().equals(tituloOtroLibro) && getISBN().equals(isbnOtroLibro)){
                return true;
            }
            else {
                return false;
            }
        }
        else{
            return false;
        }
    }
}

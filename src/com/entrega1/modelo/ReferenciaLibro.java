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
    private String titulo;
    private final String ISBN;
    private String descripcion;
    private int unidades;
    private int decimales;
    private String estado;
    private boolean leido;
    
    public ReferenciaLibro(String titulo, String descripcion, String isbn, 
            String estado, int unidades, int decimales, boolean leido){
        this.titulo = titulo;
        ISBN = isbn;
        this.descripcion = descripcion;
        this.estado = estado;
        this.leido = leido;
        this.unidades = unidades;
        this.decimales = decimales;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public String getISBN(){
        return ISBN;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public int getUnidades(){
        return unidades;
    }
    
    public int getDecimales(){
        return decimales;
    }
    
    public String getEstado(){
        return estado;
    }
    
    public boolean getLeido(){
        return leido;
    }
    
    public void setTitulo(String nTitulo){
        titulo = nTitulo;
    }
    
    public void setDescripcion(String nDescripcion){
        descripcion = nDescripcion;
    }
    
    public void setUnidades(int nUnidades){
        unidades = nUnidades;
    }
    
    public void setDecimales(int nDecimales){
        decimales = nDecimales;
    }
    
    public void setEstado (String nEstado){
        estado = nEstado;
    }
    
    public void setLeido (boolean nLeido){
        leido = nLeido;
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

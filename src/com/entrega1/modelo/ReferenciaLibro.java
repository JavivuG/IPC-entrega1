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
    private String isbn;
    private String descripcion;
    private int unidades;
    private int decimales;
    private String estado;
    private boolean leido;
    
    public ReferenciaLibro(String titulo, String descripcion, String isbn, String estado, int unidades, int decimales, boolean leido){
        this.isbn = isbn;
        setTitulo(titulo);
        setDescripcion(descripcion);
        setLeido(leido);
        setUnidades(unidades);
        setDecimales(decimales);
        setEstado(estado);
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public String getISBN(){
        return isbn;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public int getUnidadesLibro(){
        return unidades;
    }
    
    public int getDecimalesLibro(){
        return decimales;
    }
    
    public double getPrecio(){
        return getUnidadesLibro() + (getDecimalesLibro()/ 10.0f);
    }
    
    public String getEstado(){
        return estado;
    }
    
    public boolean isLeido(){
        return leido;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    public void setUnidades(int unidades){
        this.unidades=unidades;
    }
    
    public void setDecimales(int decimales){
        this.decimales=decimales;
    }
    
    public void setEstado(String estado){
        this.estado = estado;
    }
    
    public void setLeido(boolean leido){
        this.leido = leido;
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

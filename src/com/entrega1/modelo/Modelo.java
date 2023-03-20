/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entrega1.modelo;

import java.util.ArrayList;

/**
 * Clase que representa el modelo de la aplicacion almacena el arraylist de libros
 * @author jagarci
 */
public class Modelo {
    private ArrayList<ReferenciaLibro> listaLibros;
    
    /**
     * Constructor del modelo
     */
    public Modelo(){
        listaLibros=new ArrayList<>();
    }
    
    /**
     * Añade un libro a la lista
     * @param libro Libro que se desea añadir
     */
    public void addLibro(ReferenciaLibro libro){
       listaLibros.add(libro);
    }
    
    /**
     * Devuelve la lista de los libros
     * @return lista de libros
     */
    public ArrayList<ReferenciaLibro> getListaLibros(){
        return listaLibros;
    }
    
    /**
     * Reemplaza un libro dado en el indice dado
     * @param libro Libro nuevo que se quiere introducir
     * @param indice Indice en el que se quiere introducir el nuevo libro
     */
    public void reemplazarLibro(ReferenciaLibro libro, int indice){
        listaLibros.set(indice, libro);
    }
}

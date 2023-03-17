/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entrega1.vista;

import com.entrega1.modelo.Modelo;
import com.entrega1.modelo.ReferenciaLibro;

/**
 *
 * @author jagarci
 */
public class Controlador {
    private Modelo miModelo;
    private Vista miVista;
    
    public Controlador(Vista vista){
        this.miVista=vista;
        this.miModelo=new Modelo();
    }
    
    public void procesarEventoGuardar(){
        String titulo = miVista.getTituloLibro();
        String isbn = miVista.getISBNLibro();
        int unidades = miVista.getUnidadesLibro();
        int decimales = miVista.getDecimalesLibro();
        
        if (compruebaLibro(titulo, isbn, unidades, decimales)){ // Comprueba que los caracteres son los que corresponden para el libro y el isbn
            ReferenciaLibro libro = new ReferenciaLibro(titulo, miVista.getDescripcionLibro(),
                isbn, miVista.getEstadoLibro(), unidades, decimales, miVista.getLeidoLibro());
            miModelo.addLibro(libro);
            miVista.actualizaListaLibros(miModelo.getListaLibros());
        }
        
    }
    
    private boolean compruebaLibro(String titulo, String isbn, int unidades, int decimales){
        boolean guardarLibro = true;
        String error = "";
        if (titulo == null || titulo.length() > 20){
            error = error + "El titulo del libro debe tener entre 1 y 20 caracteres. ";
        }
        if (isbn == null || isbn.length() > 13){
            error = error + "El isbn del libro debe tener entre 1 y 13 caracteres. ";
        }
        if (unidades < 0){
            error = error + "Los euros no pueden ser negativos. ";
        }
        if (decimales < 0){
            error = error + "Los centimos no pueden ser negativos. ";
        }
        if (!error.equals("")){
            guardarLibro = false;
            miVista.mostrarMensajeError(error);
        }
        return guardarLibro;
    }
}

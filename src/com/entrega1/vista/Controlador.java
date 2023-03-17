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
        String titulo=miVista.getTituloLibro();
        String isbn = miVista.getISBNLibro();
        ReferenciaLibro libro=new ReferenciaLibro(isbn, titulo);
        if (compruebaLibro(libro)){ // Comprueba que los caracteres son los que corresponden para el libro y el isbn
            miModelo.addLibro(libro);
            miVista.actualizaListaLibros(miModelo.getListaLibros());
        }
        
    }
    
    private boolean compruebaLibro(ReferenciaLibro libro){
        boolean guardarLibro=false;
        if (!libro.isbnCorrecto() && !libro.tituloCorrecto()){
            miVista.mostrarMensajeError("El titulo del libro debe tener entre 1 y 20 caracteres, El isbn del libro debe tener entre 1 y 13 caracteres.");
        }
        else if (!libro.tituloCorrecto()){
            miVista.mostrarMensajeError("El titulo del libro debe tener entre 1 y 20 caracteres.");
        }
        else if (!libro.isbnCorrecto()){
            miVista.mostrarMensajeError("El isbn del libro debe tener entre 1 y 13 caracteres.");
        }
        else {
            guardarLibro=true;
            return guardarLibro;
        }
        return guardarLibro;
    }
}

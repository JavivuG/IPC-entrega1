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
        compruebaLibro(libro);
    }
    
    private void compruebaLibro(ReferenciaLibro libro){
        if (libro.isbnCorrecto()){
            if (libro.tituloCorrecto()){
                miModelo.addLibro(libro);
            }
            else {
                miVista.mostrarMensajeError("El titulo del libro debe tener entre 1 y 20 caracteres");
            }
        }
        else {
            miVista.mostrarMensajeError("El isbn debe tener entre 1 y 13 caracteres");
        }
    }
}

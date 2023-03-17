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
        String descripcion = miVista.getDescripcionLibro();
        String estado=miVista.getEstadoLibro();
        boolean leido=miVista.isLeidoLibro();
        int unidades = miVista.getUnidadesLibro();
        int decimales = miVista.getDecimalesLibro();
        double precio = unidades + (decimales/ 10.0f);
        
        boolean error=false;

        if (compruebaLibro(titulo, isbn, precio)){ // Comprueba que los caracteres son los que corresponden para el libro y el isbn
            ReferenciaLibro libro=new ReferenciaLibro(titulo, descripcion, isbn, estado, unidades, decimales, leido); // libro nuevo
            int indice = miVista.elementoListaSeleccionado();
            if (indice!=-1){
                if (!miModelo.getListaLibros().get(indice).getISBN().equals(libro.getISBN())){ // Si los isbn son iguales entonces puedo cambiar el libro
                    miVista.mostrarMensajeError("No puedes modificar el ISBN de un libro existente");
                    error=true;
                }
                else {
                    miModelo.reemplazarLibro(libro, indice);
                }
            }
            else {
                miModelo.addLibro(libro);
            }
            
            if (!error){
                miVista.actualizaListaLibros(miModelo.getListaLibros());
                miVista.limpiarCamposTexto();
            }  
        }     
    }
    
    private boolean compruebaLibro(String titulo, String isbn, double precio){
        boolean guardarLibro = true;
        String error = "";
        if (titulo == null || titulo.length() > 20){
            error = error + "El titulo del libro debe tener entre 1 y 20 caracteres. ";
        }
        if (isbn == null || isbn.length() > 13){
            error = error + "El isbn del libro debe tener entre 1 y 13 caracteres. ";
        }
        if (precio < 0){
            error = error + "Los euros no pueden ser negativos. ";
        }
        if (!error.equals("")){
            guardarLibro = false;
            miVista.mostrarMensajeError(error);
        }
        return guardarLibro;
    }
    
    public void procesarEventoEditar(){
        int indice=miVista.elementoListaSeleccionado();
        if (indice!=-1){ // Si hay elemento seleccionado
            miVista.editarLibro(miModelo.getListaLibros().get(indice));
        }
        else {
            miVista.mostrarMensajeError("Debe seleccionar un elemento de la lista");
        }
    }
    
    public void procesarEventoBorrar(){
        int indice=miVista.elementoListaSeleccionado();
        if (indice!=-1){
            miModelo.getListaLibros().remove(indice);
            miVista.actualizaListaLibros(miModelo.getListaLibros());
        }
        else {
            miVista.mostrarMensajeError("Debe seleccionar un elemento de la lista");
        }
    }
}

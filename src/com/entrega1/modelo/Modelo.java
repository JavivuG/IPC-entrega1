/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entrega1.modelo;

import java.util.ArrayList;

/**
 *
 * @author jagarci
 */
public class Modelo {
    private ArrayList<ReferenciaLibro> listaLibros;
    
    public Modelo(){
        listaLibros=new ArrayList<>();
    }
    
    public void addLibro(ReferenciaLibro libro){
       listaLibros.add(libro);
    }
    
    public ArrayList<ReferenciaLibro> getListaLibros(){
        return listaLibros;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t3_r1_ejercicio2;

/**
 *
 * @author Luis
 */
public class Paises {
    
    //Atributos
    private int id;
    private String nombrePais;
    
    //Constructores
    public Paises(){
        this.id = 0;
        this.nombrePais = "Default";
    }
    
    public Paises(int id, String nombrePaises){
        this.id = id;
        this.nombrePais = nombrePaises;
    }
    
    //getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    @Override
    public String toString() {
        String cadena =  "ID:" + this.id + ", Nombre:" + this.nombrePais;
        
        return cadena;
    }
    
    
    
}

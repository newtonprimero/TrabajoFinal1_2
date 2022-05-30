/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public class Distrito {
    int id_distrito;
    String nombreDistrito;
    boolean estado_activ;

    public Distrito() {
    }

    public Distrito(int id_distrito, String nombreDistrito, boolean estado_activ) {
        this.id_distrito = id_distrito;
        this.nombreDistrito = nombreDistrito;
        this.estado_activ = estado_activ;
    }

    
    
    public int getId_distrito() {
        return id_distrito;
    }

    public void setId_distrito(int id_distrito) {
        this.id_distrito = id_distrito;
    }

    public String getNombreDistrito() {
        return nombreDistrito;
    }

    public void setNombreDistrito(String nombreDistrito) {
        this.nombreDistrito = nombreDistrito;
    }

    public boolean isEstado_activ() {
        return estado_activ;
    }

    public void setEstado_activ(boolean estado_activ) {
        this.estado_activ = estado_activ;
    }
    
    
}

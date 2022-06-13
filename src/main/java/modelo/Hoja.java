/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public class Hoja {
    int id_hoja;
    Servicio servicio;
    boolean estado_activ;

    public Hoja() {
    }
    
    public int getId_hoja() {
        return id_hoja;
    }

    public void setId_hoja(int id_hoja) {
        this.id_hoja = id_hoja;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public boolean isEstado_activ() {
        return estado_activ;
    }

    public void setEstado_activ(boolean estado_activ) {
        this.estado_activ = estado_activ;
    }
    
    
}

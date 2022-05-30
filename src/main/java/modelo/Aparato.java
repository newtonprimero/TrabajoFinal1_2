/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public class Aparato {
    int id_aparato;
    String descAparato;
    Marca marca;
    String nroSerie;
    boolean estado_activ;

    public Aparato() {
    }

    public int getId_aparato() {
        return id_aparato;
    }

    public void setId_aparato(int id_aparato) {
        this.id_aparato = id_aparato;
    }

    public String getDescAparato() {
        return descAparato;
    }

    public void setDescAparato(String descAparato) {
        this.descAparato = descAparato;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getNroSerie() {
        return nroSerie;
    }

    public void setNroSerie(String nroSerie) {
        this.nroSerie = nroSerie;
    }
    
    

    public boolean isEstado_activ() {
        return estado_activ;
    }

    public void setEstado_activ(boolean estado_activ) {
        this.estado_activ = estado_activ;
    }
    
    
}

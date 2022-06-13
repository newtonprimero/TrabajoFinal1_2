/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public class Servicio {
    int id_servicio;
    Cita cita;
    int tipo;
    Tecnicos tenico;
    Persona persona;
    double total;
    boolean estado_activ;
    Horario horario;

    public Tecnicos getTenico() {
        return tenico;
    }

    public void setTenico(Tecnicos tenico) {
        this.tenico = tenico;
    }

    
    
    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
    
    

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isEstado_activ() {
        return estado_activ;
    }

    public void setEstado_activ(boolean estado_activ) {
        this.estado_activ = estado_activ;
    }
    
    
}

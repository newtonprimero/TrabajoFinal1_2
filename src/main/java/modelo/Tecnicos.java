/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public class Tecnicos {
    int id_tecn;
    String nombres;
    String apellidos;
    int dni;
    Distrito distrito;
    String direccion;
    String especialidad;
    Especialidad espe;
    int telefono1;
    int telefono2;
    String correo;
    String password;
    String fecha_hora;
    boolean estado_activ;

    public Tecnicos() {
    }

    public Tecnicos(int id_tecn, String nombres, String apellidos, int dni, String direccion, String especialidad, int telefono1, int telefono2, String correo, String fecha_hora, boolean estado_activ) {
        this.id_tecn = id_tecn;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.direccion = direccion;
        this.especialidad = especialidad;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.correo = correo;
        this.fecha_hora = fecha_hora;
        this.estado_activ = estado_activ;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public int getId_tecn() {
        return id_tecn;
    }

    public void setId_tecn(int id_tecn) {
        this.id_tecn = id_tecn;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(int telefono1) {
        this.telefono1 = telefono1;
    }

    public int getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(int telefono2) {
        this.telefono2 = telefono2;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public boolean isEstado_activ() {
        return estado_activ;
    }

    public void setEstado_activ(boolean estado_activ) {
        this.estado_activ = estado_activ;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public Especialidad getEspe() {
        return espe;
    }

    public void setEspe(Especialidad espe) {
        this.espe = espe;
    }
    
    
    
}

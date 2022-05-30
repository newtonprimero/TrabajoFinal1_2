/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class DaoTecnico {
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List<Tecnicos> mostrarTecnicos(){
        List<Tecnicos> lst = new ArrayList<Tecnicos>();
        String sql = "SELECT persona.id_persona, persona.nombres, persona.apellidos,persona.dni,persona.direccion, "
                + "persona.telefono1,persona.telefono2, usuario.correo, usuario.fecha_registro, usuario.estado_activ, especialidad.descripcion"
                + " FROM usuario INNER JOIN persona ON persona.id_persona=usuario.id_persona INNER JOIN especialidad "
                + "ON persona.id_especialidad=especialidad.id_especialidad WHERE usuario.id_rol=2";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Tecnicos tecn=new Tecnicos();
                tecn.setId_tecn(rs.getInt(1));
                tecn.setNombres(rs.getString(2));
                tecn.setApellidos(rs.getString(3));
                tecn.setDni(rs.getInt(4));
                tecn.setDireccion(rs.getString(5));
                tecn.setTelefono1(rs.getInt(6));
                tecn.setTelefono2(rs.getInt(7));
                tecn.setCorreo(rs.getString(8));
                tecn.setFecha_hora(rs.getString(9));
                tecn.setEstado_activ(rs.getBoolean(10));
                tecn.setEspecialidad(rs.getString(11));
                lst.add(tecn);
                System.out.println("el tecnente "+tecn.isEstado_activ());
            }
            
            con.close();
        } catch (Exception e) {
        }
        return lst;
    }
}

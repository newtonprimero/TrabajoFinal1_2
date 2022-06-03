/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class DaoEspecialidad {
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    public List<Especialidad> mostrarEspecialidades() throws SQLException{
        List<Especialidad> lst = new ArrayList<Especialidad>();
        String sql = "SELECT id_especialidad,descripcion FROM `especialidad`";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Especialidad distr=new Especialidad();
                distr.setId_especia(rs.getInt(1));
                distr.setDescrip(rs.getString(2));
                lst.add(distr);
            }
            con.close();
        } catch (Exception e) {
            con.close();
        }
        return lst;
    }
    
}

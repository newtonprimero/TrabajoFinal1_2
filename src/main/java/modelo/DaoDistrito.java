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
public class DaoDistrito {
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List<Distrito> mostrarDistritos() throws SQLException{
        List<Distrito> lst = new ArrayList<Distrito>();
        String sql = "SELECT id_distrito,nombre_distrito,estado_activ FROM `distrito`";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Distrito distr=new Distrito();
                distr.setId_distrito(rs.getInt(1));
                distr.setNombreDistrito(rs.getString(2));
                distr.setEstado_activ(rs.getBoolean(3));
                lst.add(distr);
                System.out.println("el repugado tiene nombre "+distr.getNombreDistrito());
            }
            con.close();
        } catch (Exception e) {
            con.close();
        }
        return lst;
    }
}

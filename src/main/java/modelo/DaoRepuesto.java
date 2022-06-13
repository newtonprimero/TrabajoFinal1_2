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
public class DaoRepuesto {
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List<Repuesto> mostrarRepuestos(){
        List<Repuesto> lst = new ArrayList<Repuesto>();
        String sql = "SELECT repuesto.id_repuesto, repuesto.nombre_repuesto, repuesto.cantidad, "
                + "repuesto.precio, repuesto.id_marca, marca_repuesto.descripcion, repuesto.estado_activ "
                + "FROM repuesto INNER JOIN marca_repuesto ON repuesto.id_marca=marca_repuesto.id_marca_rep;";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Repuesto repu=new Repuesto();
                repu.setId_repuesto(rs.getInt(1));
                repu.setNombre_repuesto(rs.getString(2));
                repu.setCantidad(rs.getInt(3));
                repu.setPrecio(rs.getDouble(4));
                repu.setId_marca(rs.getInt(5));
                repu.setNombre_marca(rs.getString(6));
                repu.setEstado_actv(rs.getBoolean(7));
                lst.add(repu);
                System.out.println("el repugado tiene nombre "+repu.isEstado_actv());
            }
            
            con.close();
        } catch (Exception e) {
        }
        return lst;
    }
    public Repuesto repuestoporID(int idr){
        Repuesto repu=new Repuesto();
        String sql="SELECT * FROM `repuesto` WHERE repuesto.id_repuesto LIKE "+idr;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                repu.setId_repuesto(rs.getInt(1));
                repu.setNombre_repuesto(rs.getString(2));
                repu.setCantidad(rs.getInt(3));
                repu.setId_marca(rs.getInt(4));
                repu.setPrecio(rs.getDouble(5));
                repu.setEstado_actv(rs.getBoolean(6));
                System.out.println("el repuesto tiene nombre "+repu.isEstado_actv());
            }
            con.close();
        } catch (Exception e) {
            System.out.println("---"+e);
        }
        return repu;
    }
}

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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class DaoServicio {
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int idapa=0;
    int ideper=0;
    
    public List<Marca> mostrarMarcas() throws SQLException{
        List<Marca> lst = new ArrayList<Marca>();
        String sql = "SELECT id_marca,descripcion FROM `marca`";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Marca marca=new Marca();
                marca.setId_marca(rs.getInt(1));
                marca.setDescripcion(rs.getString(2));
                lst.add(marca);
                System.out.println("el repugado tiene nombre "+marca.getDescripcion());
            }
            con.close();
        } catch (Exception e) {
            con.close();
        }
        return lst;
    }
    public void nuevoCita(Cita cita){
        nuevoAparato(cita);
        String sql = "INSERT INTO `cita` (`id_cita`, `id_persona`, `id_aparato`, `id_distrito`, `direccion`, "
                + "`fecha_hora`, `presupuesto`, `estado_activ`) "
                + "VALUES (NULL, '"+cita.getId_persona()+"', '"+idapa+"', '"+cita.getDiaDistrito().getId_distrito()
                +"', '"+cita.getDireccion()+"', '"+cita.getFecha_hora()+"', NULL, '1');";
        ideper=cita.getId_persona();
        try {
            con=cn.Conexion();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            con.commit();
            con.close();
            
        } catch (Exception e) {
            System.out.println("error es "+e);
        }
    }
    
    public void nuevoAparato(Cita cita){
        String sql = "INSERT INTO `aparato` (`id_aparato`, `descripcion`, `id_marca`, `nroSerie`, `estado_activ`) "
                + "VALUES (NULL, '"+ cita.getAparato().getDescAparato() +"', '"+cita.getAparato().getMarca().getId_marca()
                +"', '"+cita.getAparato().getNroSerie()+"', '1');";
        try {
            con=cn.Conexion();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            con.commit();
            con.close();
            
        } catch (Exception e) {
            System.out.println("error es "+e);
        }
        String sql2="SELECT id_aparato FROM aparato ORDER BY id_aparato DESC LIMIT 1";
        try {
            con=cn.Conexion();
            PreparedStatement stm2= con.prepareStatement(sql2);
            rs=stm2.executeQuery();
            while (rs.next()) {
                Aparato user=new Aparato();
                user.setId_aparato(rs.getInt(1));
                idapa=user.getId_aparato();
            }
            con.close();
        } catch (Exception e) {
            System.out.println("el error al insertar "+e);
        }
    }
    public List<Cita> misServicios(int idper){
        List<Cita> lst = new ArrayList<Cita>();
        ideper = idper;
        String sql = "select aparato.nroSerie, marca.descripcion, aparato.descripcion, "
                + "cita.fecha_hora, cita.estado_activ FROM cita INNER JOIN aparato ON "
                + "aparato.id_aparato=cita.id_aparato INNER JOIN marca ON marca.id_marca=aparato.id_marca "
                + "WHERE cita.id_persona="+ideper;
        try {
            System.out.println("el ide mara mostrar serv "+ideper);
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Cita cli=new Cita();
                Aparato apa=new Aparato();
                Marca mar=new Marca();
                apa.setNroSerie(rs.getString(1));
                mar.setDescripcion(rs.getString(2));
                apa.setDescAparato(rs.getString(3));
                apa.setMarca(mar);
                cli.setAparato(apa);
                cli.setFecha_hora(rs.getString(4));
                cli.setEstado_activ(rs.getBoolean(5));
                lst.add(cli);
                System.out.println("el cliente "+cli.isEstado_activ());
            }
            
            con.close();
        } catch (Exception e) {
        }
        return lst;
    }
    
    
    
}

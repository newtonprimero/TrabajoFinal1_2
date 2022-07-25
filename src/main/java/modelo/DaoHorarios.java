/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class DaoHorarios {
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    static int idper;
    
    public List<Horario> horarioHoy(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime actual = LocalDateTime.now();
        LocalDateTime mañana = actual.plusDays(2);
        String hoy = actual.format(dtf);
        String manana = mañana.format(dtf);
        List<Horario> lst = new ArrayList<Horario>();
        String sql="SELECT horarios.id_horario, persona.id_persona, persona.apellidos, persona.dni, horarios.fecha, horarios.hora_ini"
                + ",horarios.hora_fin, horarios.estado_activ FROM horarios "
                + "INNER JOIN persona ON horarios.id_persona LIKE persona.id_persona "
                + "WHERE horarios.fecha='"+hoy+"' ORDER BY horarios.fecha;";
        System.out.println(sql);
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                System.out.println("llega al while");
                Horario horario=new Horario();
                horario.setId_horario(rs.getInt(1));
                Tecnicos perso=new Tecnicos();
                perso.setId_tecn(rs.getInt(2));
                perso.setApellidos(rs.getString(3));
                perso.setDni(rs.getInt(4));
                horario.setTecnico(perso);
                horario.setFecha(rs.getString(5));
                horario.setHoraini(rs.getString(6));
                horario.setHorafin(rs.getString(7));
                horario.setEstado_activ(rs.getBoolean(8));
                lst.add(horario);
                System.out.println("el id del horario "+horario.getId_horario());
                System.out.println(horario.getFecha());
                idper=perso.getId_tecn();
            }con.close();
        } catch (Exception e) {
            System.out.println("el error al listar horarios "+e);
        }finally{
        }
        return lst;
    }
    
    public List<Horario> horarioMañana(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime actual = LocalDateTime.now();
        LocalDateTime mañana = actual.plusDays(1);
        String hoy = actual.format(dtf);
        String manana = mañana.format(dtf);
        List<Horario> lst = new ArrayList<Horario>();
        String sql="SELECT horarios.id_horario, persona.id_persona, persona.apellidos, persona.dni, horarios.fecha, horarios.hora_ini"
                + ",horarios.hora_fin, horarios.estado_activ FROM horarios "
                + "INNER JOIN persona ON horarios.id_persona LIKE persona.id_persona "
                + "WHERE horarios.fecha='"+manana+"' ORDER BY horarios.fecha;";
        System.out.println(sql);
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                System.out.println("llega al while");
                Horario horario=new Horario();
                horario.setId_horario(rs.getInt(1));
                Tecnicos perso=new Tecnicos();
                perso.setId_tecn(rs.getInt(2));
                perso.setApellidos(rs.getString(3));
                perso.setDni(rs.getInt(4));
                horario.setTecnico(perso);
                horario.setFecha(rs.getString(5));
                horario.setHoraini(rs.getString(6));
                horario.setHorafin(rs.getString(7));
                horario.setEstado_activ(rs.getBoolean(8));
                lst.add(horario);
                System.out.println("el id del horario "+horario.getId_horario());
                System.out.println(horario.getFecha());
                idper=perso.getId_tecn();
            }con.close();
        } catch (Exception e) {
            System.out.println("el error al listar horarios "+e);
        }finally{
        }
        return lst;
    }
    public List<Horario> horarioSemana(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime actual = LocalDateTime.now();
        LocalDateTime mañana = actual.plusDays(5);
        String hoy = actual.format(dtf);
        String manana = mañana.format(dtf);
        List<Horario> lst = new ArrayList<Horario>();
        String sql="SELECT horarios.id_horario, persona.id_persona, persona.apellidos, persona.dni, horarios.fecha, horarios.hora_ini"
                + ",horarios.hora_fin, horarios.estado_activ FROM horarios "
                + "INNER JOIN persona ON horarios.id_persona LIKE persona.id_persona "
                + "WHERE horarios.fecha BETWEEN'"+hoy+"'AND '"+manana+"' ORDER BY horarios.fecha;";
        System.out.println(sql);
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                System.out.println("llega al while");
                Horario horario=new Horario();
                horario.setId_horario(rs.getInt(1));
                Tecnicos perso=new Tecnicos();
                perso.setId_tecn(rs.getInt(2));
                perso.setApellidos(rs.getString(3));
                perso.setDni(rs.getInt(4));
                horario.setTecnico(perso);
                horario.setFecha(rs.getString(5));
                horario.setHoraini(rs.getString(6));
                horario.setHorafin(rs.getString(7));
                horario.setEstado_activ(rs.getBoolean(8));
                lst.add(horario);
                System.out.println("el id del horario "+horario.getId_horario());
                System.out.println(horario.getFecha());
                idper=perso.getId_tecn();
            }con.close();
        } catch (Exception e) {
            System.out.println("el error al listar horarios "+e);
        }finally{
        }
        return lst;
    }
}

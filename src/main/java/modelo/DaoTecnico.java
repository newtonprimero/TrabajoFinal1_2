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
    public List<Especialidad> listarEspecialidad(){
        List<Especialidad> lst = new ArrayList<Especialidad>();
        return lst;
    }
    
    public void nuevoTecnico(Tecnicos tecnico){
        String sql = "INSERT INTO `persona` (`id_persona`, `nombres`, `apellidos`, `dni`, `id_distrito`, "
                + "`direccion`, `id_especialidad`, `telefono1`, `telefono2`, `estado_activ`) VALUES "
                + "(NULL,'"+tecnico.getNombres()+"','"+ tecnico.getApellidos()+"','"+tecnico.getDni()+"', '"+tecnico.getDistrito().getId_distrito()+"', '"
                +tecnico.getDireccion()+"','"+tecnico.getEspe().getId_especia()+"','"+tecnico.getTelefono1()+"', '"+tecnico.getTelefono2()+"', '1')";
        try {
            con=cn.Conexion();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            con.commit();
            con.close();
            
        } catch (Exception e) {
            System.out.println("error es "+e);
        }crearusuariot(tecnico);
    }
    public void crearusuariot(Tecnicos tecnico){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime actual=LocalDateTime.now();
        String hora=actual.format(dtf);
        System.out.println(hora);
        int idper = 0;
        con=cn.Conexion();
        String sql2="SELECT id_persona FROM persona ORDER BY id_persona DESC LIMIT 1";
        try {
            PreparedStatement stm2= con.prepareStatement(sql2);
            rs=stm2.executeQuery();
            while (rs.next()) {
                Usuario user=new Usuario();
                user.setId_persona(rs.getInt(1));
                idper=user.getId_persona();
            }
        } catch (Exception e) {
            System.out.println("el error al insertar "+e);
        }
        String sql3="INSERT INTO `usuario` (`id_user`, `id_persona`, `id_rol`, `correo`, `contrasena`, `fecha_registro`, `estado_activ`) VALUES (NULL, '"+idper+"', '2', '"+ tecnico.getCorreo()+"', '"+tecnico.getPassword()+"', '"+hora+"', '1');";
        try {
            PreparedStatement stm3= con.prepareStatement(sql3);
            stm3.execute();
            con.commit();
            con.close();
        } catch (Exception e) {
            System.out.println("error al insertar usu "+e);
        }
        System.out.println("el id del ultimo "+idper);
    }
    public Tecnicos leerTecnico(Tecnicos tecnico) {
        Tecnicos cli=null;
        ResultSet rs=null;
        System.out.println(tecnico.getId_tecn());
        String sql="SELECT persona.id_persona, persona.nombres, persona.apellidos, persona.dni, persona.id_especialidad,"
                + "persona.id_distrito, persona.direccion, persona.telefono1,persona.telefono2, "
                + "persona.estado_activ, usuario.correo, usuario.contrasena,usuario.fecha_registro "
                + "FROM `persona` INNER JOIN usuario ON usuario.id_persona=persona.id_persona WHERE "
                + "persona.id_persona="+tecnico.getId_tecn()+";";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            System.out.println("envia sentencia para leer");
            if (rs.next()) {
                cli=new Tecnicos();
                cli.setId_tecn(rs.getInt(1));
                cli.setNombres(rs.getString(2));
                cli.setApellidos(rs.getString(3));
                cli.setDni(rs.getInt(4));
                Especialidad esp=new Especialidad();
                esp.setId_especia(rs.getInt(5));
                cli.setEspe(esp);
                System.out.println("espe "+cli.getEspe().getId_especia());
                Distrito distr=new Distrito();
                distr.setId_distrito(rs.getInt(6));
                cli.setDistrito(distr);
                cli.setDireccion(rs.getString(7));
                cli.setTelefono1(rs.getInt(8));
                cli.setTelefono2(rs.getInt(9));
                cli.setEstado_activ(rs.getBoolean(10));
                cli.setCorreo(rs.getString(11));
                cli.setPassword(rs.getString(12));
                cli.setFecha_hora(rs.getString(13));
                System.out.println("el tecnico "+cli.isEstado_activ());
            }
            
            con.close();
        } catch (Exception e) {
            System.out.println(" el error al buascar tec para editar "+e);
        }
        return cli;
    }
    public void actualizarTecnico(Tecnicos clien){
        String sql="UPDATE `persona` SET `nombres` = '"+clien.getNombres()+"', apellidos = '"+clien.getApellidos()
                +"',dni='"+clien.getDni()+"',id_distrito='"+clien.getDistrito().getId_distrito()+"',direccion='"
                +clien.getDireccion()+"',telefono1='"+clien.getTelefono1()+"', telefono2='"+clien.getTelefono2()
                +"', estado_activ="+(clien.isEstado_activ()==true ? "1":"0")+" WHERE `persona`.`id_persona` = "
                +clien.getId_tecn()+"";
        try {
            con=cn.Conexion();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            con.commit();
            con.close();
        } catch (Exception e) {
            System.out.println("el error al ACTUALIZAR tecn es "+e);
        }
        String sql2="UPDATE `usuario` SET `correo` = '"+clien.getCorreo()+"', `contrasena` = '"+clien.getPassword()+"' WHERE `usuario`.`id_user` = "+clien.getId_tecn()+";";
        try {
            con=cn.Conexion();
            PreparedStatement stm = con.prepareStatement(sql2);
            stm.execute();
            con.commit();
            con.close();
        } catch (Exception e) {
            System.out.println("el error al ACTUALIZAR USER tecn es "+e);
        }
    }
}

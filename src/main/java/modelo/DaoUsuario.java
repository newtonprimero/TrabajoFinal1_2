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

/**
 *
 * @author USUARIO
 */
public class DaoUsuario {
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int rol=0;
    int idper=0;
    static String nombreuser;
    
    public Usuario validar(Usuario user) throws Exception{
        Usuario us=null;
        
        String sql="select usuario.id_user, usuario.id_rol, usuario.id_persona, "
                + "usuario.correo, usuario.contrasena, persona.nombres, persona.apellidos "
                + "FROM usuario INNER JOIN persona ON persona.id_persona=usuario.id_persona where correo='"+user.getCorreo() +"' and contrasena='"+user.getContraseña()+"'";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                us=new Usuario();
                us.setId(rs.getInt("id_user"));
                us.setId_rol(rs.getInt("id_rol"));
                us.setId_persona(rs.getInt("id_persona"));
                us.setCorreo(rs.getString("correo"));
                us.setContraseña(rs.getString("contrasena"));
                us.setNombreUsuario(rs.getString("nombres"));
                us.setApellidos(rs.getString("apellidos"));
            }
            if(us!=null){
            rol=us.getId_rol();
            idper=us.getId_persona();
            System.out.println("el id persona dentro de if"+idper);
            System.out.println(us.getCorreo());
            }
        } catch (Exception e) {
            System.out.println("el problema al validar es "+e);
        }
        finally{
            con.close();
        }if(us!=null){
        encontrar(idper);}
        System.out.println("el id persona validar "+idper);
        System.out.println(rol);
        System.out.println("usuario "+ us);
        return us;
        
    }
    public Persona encontrar(int idper){
        Persona per=new Persona();
        String sql="select * from persona where id_persona=?";
        System.out.println(sql);
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, idper);
            rs=ps.executeQuery();
            while (rs.next()) {
                per.setNombres(rs.getString("nombres"));
                per.setApellidos(rs.getString("apellidos"));
                per.setTelefono(rs.getString("telefono1"));
            }
            nombreuser=per.getNombres();
            System.out.println(per.getNombres());
            con.close();
        } catch (Exception e) {
            System.out.println("no entro");
        }
    return per;
    }
    public String nombreUser(){
        return nombreuser;
    }
    public void insertarUser(Cliente cliente){
        String sql = "INSERT INTO `usuario` (`id_user`, `id_persona`, `id_rol`, `correo`, `contrasena`, `fecha_registro`, `estado_activ`) VALUES (NULL, ?, ?, ?, ?, ?, ?);";   
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            Cliente cli=new Cliente();
            rs.next();
            cli.setId_client(rs.getInt("id_persona"));
            cli.setNombres(rs.getString("nombres"));
            cli.setApellidos(rs.getString("apellidos"));
            cli.setDni(rs.getInt("dni"));
            cli.setDireccion(rs.getString("direccion"));
            cli.setTelefono1(rs.getInt("telefono1"));
            cli.setTelefono2(rs.getInt("telefono2"));
            cli.setCorreo(rs.getString("correo"));
            cli.setFecha_hora(rs.getString("fecha_registro"));
            cliente=cli;
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }finally{
        }
    }
}

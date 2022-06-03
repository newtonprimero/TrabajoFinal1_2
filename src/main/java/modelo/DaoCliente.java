/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class DaoCliente {
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    public List<Cliente> mostrarClientes(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime actual=LocalDateTime.now();
        LocalDateTime mañana=actual.plusDays(20);
        String hoy=actual.format(dtf);
        String manana=mañana.format(dtf);
        
        System.out.println("fechas "+hoy+" - "+manana);
        List<Cliente> lst = new ArrayList<Cliente>();
        String sql = "SELECT persona.id_persona, persona.nombres, persona.apellidos,persona.dni,persona.direccion, "
                + "persona.telefono1,persona.telefono2, usuario.correo, usuario.fecha_registro, usuario.estado_activ"
                + " FROM usuario INNER JOIN persona ON persona.id_persona=usuario.id_persona WHERE usuario.id_rol=3";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Cliente cli=new Cliente();
                cli.setId_client(rs.getInt(1));
                cli.setNombres(rs.getString(2));
                cli.setApellidos(rs.getString(3));
                cli.setDni(rs.getInt(4));
                cli.setDireccion(rs.getString(5));
                cli.setTelefono1(rs.getInt(6));
                cli.setTelefono2(rs.getInt(7));
                cli.setCorreo(rs.getString(8));
                cli.setFecha_hora(rs.getString(9));
                cli.setEstado_activ(rs.getBoolean(10));
                lst.add(cli);
                System.out.println("el cliente "+cli.getEstado_activ());
            }
            
            con.close();
        } catch (Exception e) {
        }
        return lst;
    }
    
    public Cliente buscar(Cliente cliente){
        String sql = "SELECT persona.id_persona, persona.nombres, persona.apellidos,persona.dni,persona.direccion, "
                + "persona.telefono1,persona.telefono2, usuario.correo, usuario.fecha_registro"
                + " FROM usuario INNER JOIN persona ON persona.id_persona=usuario.id_persona WHERE usuario.id_persona=?";   
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, cliente.getId_client());
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
            System.out.println(cliente);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }finally{
        }
        return cliente;
    }
    public int insertarCliente(Cliente cliente){
        String sql = "INSERT INTO `persona` (`id_persona`, `nombres`, `apellidos`, `dni`, `id_distrito`, `direccion`, `id_especialidad`, `telefono1`, `telefono2`, `estado_activ`) VALUES (NULL, ?, ?, ?, '4', ?, '3', ?, ?, '1')";   
        int rows=0;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, cliente.getNombres());
            ps.setString(2, cliente.getApellidos());
            ps.setInt(3, cliente.getDni());
            ps.setString(4, cliente.getDireccion());
            ps.setInt(5, cliente.getTelefono1());
            ps.setInt(6, cliente.getTelefono2());
            rows=ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }finally{
        }
        return rows;
    }
    public void nuevoCliente(Cliente cliente){
        String sql = "INSERT INTO `persona` (`id_persona`, `nombres`, `apellidos`, `dni`, `id_distrito`, "
                + "`direccion`, `id_especialidad`, `telefono1`, `telefono2`, `estado_activ`) VALUES "
                + "(NULL,'"+cliente.getNombres()+"','"+ cliente.getApellidos()+"','"+cliente.getDni()+"', '"+cliente.getDistrit().getId_distrito()+"', '"
                +cliente.getDireccion()+"','3','"+cliente.getTelefono1()+"', '"+cliente.getTelefono2()+"', '1')";
        String sql2="SELECT id_persona FROM persona ORDER BY id_persona DESC LIMIT 1";
        try {
            con=cn.Conexion();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            con.commit();
            con.close();
            
        } catch (Exception e) {
            System.out.println("error es "+e);
        }crearusuario(cliente);
    }
    public void crearusuario(Cliente cliente){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime actual=LocalDateTime.now();
        LocalDateTime mañana=actual.plusDays(20);
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
        String sql3="INSERT INTO `usuario` (`id_user`, `id_persona`, `id_rol`, `correo`, `contrasena`, `fecha_registro`, `estado_activ`) VALUES (NULL, '"+idper+"', '3', '"+ cliente.getCorreo()+"', '"+cliente.getPassword()+"', '"+hora+"', '1');";
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
    public Cliente leerCliente(Cliente cliente) {
        Cliente cli=null;
        ResultSet rs=null;
        String sql="SELECT persona.id_persona, persona.nombres, persona.apellidos, persona.dni, "
                + "persona.id_distrito, persona.direccion, persona.telefono1,persona.telefono2, "
                + "persona.estado_activ, usuario.correo, usuario.contrasena,usuario.fecha_registro "
                + "FROM `persona` INNER JOIN usuario ON usuario.id_persona=persona.id_persona WHERE "
                + "persona.id_persona="+cliente.getId_client()+";";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            if (rs.next()) {
                cli=new Cliente();
                cli.setId_client(rs.getInt(1));
                cli.setNombres(rs.getString(2));
                cli.setApellidos(rs.getString(3));
                cli.setDni(rs.getInt(4));
                Distrito distr=new Distrito();
                distr.setId_distrito(rs.getInt(5));
                cli.setDistrit(distr);
                cli.setDireccion(rs.getString(6));
                cli.setTelefono1(rs.getInt(7));
                cli.setTelefono2(rs.getInt(8));
                cli.setCorreo(rs.getString(10));
                cli.setPassword(rs.getString(11));
                cli.setFecha_hora(rs.getString(12));
                cli.setEstado_activ(rs.getBoolean(9));
                System.out.println("el cliente "+cli.getEstado_activ());
            }
            
            con.close();
        } catch (Exception e) {
            System.out.println(" el error aal buascar cli para editar");
        }
        return cli;
    }
    public void actualizarCliente(Cliente clien){
        String sql="UPDATE `persona` SET `nombres` = '"+clien.getNombres()+"', apellidos = '"+clien.getApellidos()
                +"',dni='"+clien.getDni()+"',id_distrito='"+clien.getDistrit().getId_distrito()+"',direccion='"
                +clien.getDireccion()+"',telefono1='"+clien.getTelefono1()+"', telefono2='"+clien.getTelefono2()
                +"', estado_activ="+(clien.getEstado_activ()==true ? "1":"0")+" WHERE `persona`.`id_persona` = "
                +clien.getId_client()+"";
        try {
            con=cn.Conexion();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            con.commit();
            con.close();
        } catch (Exception e) {
            System.out.println("el error al actualizar tecn es "+e);
        }
        String sql2="UPDATE `usuario` SET `correo` = '"+clien.getCorreo()+"', `contrasena` = '"+clien.getPassword()+"' WHERE `usuario`.`id_user` = "+clien.getId_client()+";";
        try {
            con=cn.Conexion();
            PreparedStatement stm = con.prepareStatement(sql2);
            stm.execute();
            con.commit();
            con.close();
        } catch (Exception e) {
            System.out.println("el error al ACTUALIZAR USER client es "+e);
        }
    }
}

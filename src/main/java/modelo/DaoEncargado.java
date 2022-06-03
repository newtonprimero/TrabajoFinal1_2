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
public class DaoEncargado {
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    static int idper;
    
    public List<Encargado> mostrarEncargados(){
        List<Encargado> lst = new ArrayList<Encargado>();
        String sql = "SELECT persona.id_persona, persona.nombres, persona.apellidos,persona.dni,persona.direccion, "
                + "persona.telefono1,persona.telefono2, usuario.correo, usuario.fecha_registro, usuario.estado_activ, especialidad.descripcion"
                + " FROM usuario INNER JOIN persona ON persona.id_persona=usuario.id_persona INNER JOIN especialidad "
                + "ON persona.id_especialidad=especialidad.id_especialidad WHERE usuario.id_rol=1";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Encargado encar=new Encargado();
                encar.setId_encar(rs.getInt(1));
                encar.setNombres(rs.getString(2));
                encar.setApellidos(rs.getString(3));
                encar.setDni(rs.getInt(4));
                encar.setDireccion(rs.getString(5));
                encar.setTelefono1(rs.getInt(6));
                encar.setTelefono2(rs.getInt(7));
                encar.setCorreo(rs.getString(8));
                encar.setFecha_hora(rs.getString(9));
                encar.setEstado_activ(rs.getBoolean(10));
                encar.setEspecialidad(rs.getString(11));
                lst.add(encar);
                System.out.println("el encargado tiene nombre "+encar.getNombres());
            }
            
            con.close();
        } catch (Exception e) {
        }
        return lst;
    }
    public List<Horario> horarioPorTecnico(Persona per){
        List<Horario> lst = new ArrayList<Horario>();
        String sql="SELECT horarios.id_horario, persona.id_persona, persona.apellidos, persona.dni, horarios.fecha, horarios.hora_ini"
                + ",horarios.hora_fin, horarios.estado_activ FROM horarios "
                + "INNER JOIN persona ON horarios.id_persona LIKE persona.id_persona "
                + "WHERE persona.dni='"+per.getDni()+"';";
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
    public void ingresarHorario(Horario hora){
        int estado=0;
        if(hora.isEstado_activ()==false)
        {
            estado=0;
        }else{
            estado=1;
        }
        System.out.println("el id de la parsona es" +idper);
        String sql = "INSERT INTO `horarios` (`id_horario`, `id_persona`, `fecha`,"
                + " `hora_ini`, `hora_fin`, `estado_activ`) VALUES (NULL, '"+idper+"', '"+hora.getFecha()+"',"
                + " '"+hora.getHoraini()+"', '"+hora.getHorafin()+"', '"+ estado+"');";
        try {
            con=cn.Conexion();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            con.commit();
            con.close();
            System.out.println("se proceso el horario");
            
        } catch (Exception e) {
            System.out.println("error es "+e);
        }
    }
}

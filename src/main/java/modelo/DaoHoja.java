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
public class DaoHoja {
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    public List<Hoja> mostrarHojasDomicilio(){
        List<Hoja> lst=new ArrayList<Hoja>();
        String sql="SELECT hoja_servicio_domi.id_hoja, servicio_domicilio.id_servicio_domi, persona.nombres,persona.apellidos , horarios.fecha, servicio_domicilio.total FROM `hoja_servicio_domi` INNER JOIN servicio_domicilio ON servicio_domicilio.id_servicio_domi=hoja_servicio_domi.id_servicio INNER JOIN horarios ON horarios.id_horario=servicio_domicilio.id_horario INNER JOIN cita ON cita.id_cita=servicio_domicilio.id_cita INNER JOIN persona ON horarios.id_persona=persona.id_persona;";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Hoja hoja=new Hoja();
                hoja.setId_hoja(rs.getInt(1));
                Servicio servi=new Servicio();
                servi.setId_servicio(rs.getInt(2));
                Tecnicos tecni=new Tecnicos();
                tecni.setNombres(rs.getString(3));
                tecni.setApellidos(rs.getString(4));
                Horario hora=new Horario();
                hora.setFecha(rs.getString(5));
                servi.setTotal(rs.getDouble(6));
                servi.setHorario(hora);
                servi.setTenico(tecni);
                hoja.setServicio(servi);
                lst.add(hoja);
                
            }
            con.close();
        }catch(Exception e){
            System.out.println("---e---"+e);
        }
     return lst;
    }

    public Hoja leerHoja(Hoja hr) {
        Hoja hojaselec=new Hoja();
        String sql="SELECT servicio_domicilio.id_servicio_domi, persona.nombres, persona.apellidos, "
                + "cita.direccion, persona.telefono1, persona.telefono2, marca.descripcion,aparato.nroSerie, "
                + "aparato.descripcion, horarios.fecha, horarios.hora_ini,horarios.hora_fin, servicio_domicilio.total "
                + "FROM `servicio_domicilio` INNER JOIN cita ON cita.id_cita=servicio_domicilio.id_cita INNER JOIN persona "
                + "ON persona.id_persona=cita.id_persona INNER JOIN horarios ON horarios.id_horario=servicio_domicilio.id_horario "
                + "INNER JOIN aparato ON aparato.id_aparato=cita.id_aparato INNER JOIN marca ON marca.id_marca=aparato.id_marca "
                + "INNER JOIN hoja_servicio_domi ON hoja_servicio_domi.id_servicio=servicio_domicilio.id_servicio_domi "
                + "WHERE servicio_domicilio.id_servicio_domi="+hr.getId_hoja();
        return hojaselec;
    }
    public Servicio leerServicio(Servicio serv) {
        Servicio servicio=null;
        Hoja hojaselec=new Hoja();
        String sql="SELECT servicio_domicilio.id_servicio_domi, persona.nombres, persona.apellidos, "
                + "cita.direccion, persona.telefono1, persona.telefono2, marca.descripcion,aparato.nroSerie, "
                + "aparato.descripcion, horarios.fecha, horarios.hora_ini,horarios.hora_fin, servicio_domicilio.total "
                + "FROM `servicio_domicilio` INNER JOIN cita ON cita.id_cita=servicio_domicilio.id_cita INNER JOIN persona "
                + "ON persona.id_persona=cita.id_persona INNER JOIN horarios ON horarios.id_horario=servicio_domicilio.id_horario "
                + "INNER JOIN aparato ON aparato.id_aparato=cita.id_aparato INNER JOIN marca ON marca.id_marca=aparato.id_marca "
                + "INNER JOIN hoja_servicio_domi ON hoja_servicio_domi.id_servicio=servicio_domicilio.id_servicio_domi "
                + "WHERE servicio_domicilio.id_servicio_domi="+serv.getId_servicio();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            if (rs.next()) {
            servicio = new Servicio();
            servicio.setId_servicio(rs.getInt(1));
            Cita cit=new Cita();
            Persona perso=new Persona();
            perso.setNombres(rs.getString(2));
            perso.setApellidos(rs.getString(3));
            cit.setDireccion(rs.getString(4));
            perso.setTelefono(rs.getString(5));
            perso.setTelefono2(rs.getString(6));
            Marca marc=new Marca();
            marc.setDescripcion(rs.getString(7));
            Aparato apa=new Aparato();
            apa.setNroSerie(rs.getString(8));
            apa.setDescAparato(rs.getString(9));
                System.out.println("---"+apa.getDescAparato());
            Horario hor=new Horario();
            hor.setFecha(rs.getString(10));
            hor.setHoraini(rs.getString(11));
            hor.setHorafin(rs.getString(12));
            servicio.setTotal(rs.getDouble(13));
            apa.setMarca(marc);
            cit.setPerso(perso);
            cit.setAparato(apa);
            servicio.setHorario(hor);
            servicio.setCita(cit);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(" el error al buascar servi para editar-"+e);
        }
        return servicio;
    }
}

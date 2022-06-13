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
}

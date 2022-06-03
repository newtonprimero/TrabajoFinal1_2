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
    int idtec=0;
    
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
            System.out.println("error es de aparato "+e);
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
    
    public List<Cita> misServiciosconhoraio(int idper){
        List<Cita> lst = new ArrayList<Cita>();
        ideper = idper;
        String sql = "SELECT persona.nombres, persona.apellidos, aparato.descripcion, "
                + "horarios.fecha,horarios.hora_ini, horarios.hora_fin , servicio.estado_activ, "
                + "servicio.total,servicio.id_servicio FROM servicio INNER JOIN cita on "
                + "cita.id_cita=servicio.id_cita INNER JOIN persona ON persona.id_persona=servicio.id_tecnico "
                + "INNER JOIN aparato ON aparato.id_aparato=cita.id_aparato INNER JOIN horarios ON "
                + "horarios.id_persona=servicio.id_tecnico WHERE cita.id_persona="+ideper;
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
    
    public List<Horario> listarHorarios(){
        List<Horario> lst = new ArrayList<Horario>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime actual=LocalDateTime.now();
        LocalDateTime mañana=actual.plusDays(2);
        String hoy=actual.format(dtf);
        String manana=mañana.format(dtf);
        String sql="SELECT horarios.id_horario, horarios.id_persona, horarios.fecha, horarios.hora_ini, "
                + "horarios.hora_fin, persona.nombres,persona.apellidos, horarios.estado_activ FROM `horarios` INNER JOIN "
                + "persona ON persona.id_persona=horarios.id_persona WHERE horarios.fecha BETWEEN '"+ hoy +"' AND '"+ manana +"' AND horarios.estado_activ=1";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Horario hora=new Horario();
                Tecnicos perso=new Tecnicos();
                hora.setId_horario(rs.getInt(1));
                perso.setId_tecn(rs.getInt(2));
                hora.setFecha(rs.getString(3));
                hora.setHoraini(rs.getString(4));
                hora.setHorafin(rs.getString(5));
                perso.setNombres(rs.getString(6));
                perso.setApellidos(rs.getString(7));
                hora.setEstado_activ(rs.getBoolean(8));
                hora.setTecnico(perso);
                lst.add(hora);
                System.out.println("Nombre tecnico "+perso.getNombres()+" "+ perso.getApellidos());
            }
            con.close();
        } catch (Exception e) {
            System.out.println("el error al mostrar "+e);
        }
        return lst;
    }
    public Horario leerHorario(Horario horarios) {
        Horario cli=null;
        ResultSet rs=null;
        System.out.println(horarios.getId_horario());
        String sql="SELECT horarios.id_horario, horarios.id_persona,horarios.fecha,horarios.hora_ini,"
                + "horarios.hora_fin,horarios.estado_activ,persona.nombres,persona.apellidos,persona.dni "
                + "FROM `horarios` INNER JOIN persona ON persona.id_persona=horarios.id_persona "
                + "WHERE horarios.id_horario="+horarios.getId_horario()+";";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            System.out.println("envia sentencia para leer");
            if (rs.next()) {
                cli=new Horario();
                cli.setId_horario(rs.getInt(1));
                Tecnicos tec=new Tecnicos();
                tec.setId_tecn(rs.getInt(2));
                cli.setFecha(rs.getString(3));
                cli.setHoraini(rs.getString(4));
                cli.setHorafin(rs.getString(5));
                cli.setEstado_activ(rs.getBoolean(6));
                tec.setNombres(rs.getString(7));
                tec.setApellidos(rs.getString(8));
                tec.setDni(rs.getInt(9));
                cli.setTecnico(tec);
                idtec=cli.getTecnico().getId_tecn();
                System.out.println("el horario "+cli.isEstado_activ());
            }
            
            con.close();
        } catch (Exception e) {
            System.out.println(" el error al buascar hora para servicio "+e);
        }
        return cli;
    }
    public void generarServicio(Cita cita,Horario hor){
        int idci=0;
        String sql2="SELECT cita.id_cita FROM `cita` ORDER BY id_aparato DESC LIMIT 1";
        try {
            con=cn.Conexion();
            PreparedStatement stm2= con.prepareStatement(sql2);
            rs=stm2.executeQuery();
            while (rs.next()) {
                idci=rs.getInt(1);
                System.out.println("el ide de la ultima cita es "+idci);
            }
            con.close();
        } catch (Exception e) {
            System.out.println("el error al idci "+e);
        }
        String sql = "INSERT INTO `servicio` (`id_servicio`, `id_cita`, `id_tipo`,"
                + " `id_tecnico`, `total`, `estado_activ`) VALUES (NULL, '"+idci+"', '2',"
                + " '"+hor.getTecnico().getId_tecn()+"', NULL, '1');";
        try {
            con=cn.Conexion();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            con.commit();
            con.close();
            
        } catch (Exception e) {
            System.out.println("error del insert servicio "+e);
        }
        String sql3="UPDATE `horarios` SET `estado_activ` = '0' WHERE `horarios`.`id_horario` = "+hor.getId_horario()+";";
        try {
            con=cn.Conexion();
            PreparedStatement stm = con.prepareStatement(sql3);
            stm.execute();
            con.commit();
            con.close();
        } catch (Exception e) {
            System.out.println("el error al ACTUALIZAR horario es "+e);
        }
    }
    public void nuevoCitaHorario(Cita cita,Horario hour){
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
        generarServicio(cita, hour);
    }
}

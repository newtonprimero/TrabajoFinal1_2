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
    
    public List<Servicio> misServiciosconhoraio(int idper){
        List<Servicio> lst = new ArrayList<Servicio>();
        ideper = idper;
        String sql = "SELECT servicio_domicilio.id_servicio_domi, horarios.fecha, horarios.hora_ini, "
                + "horarios.hora_fin,persona.id_persona,persona.nombres, persona.apellidos,"
                + "aparato.descripcion, marca.descripcion, servicio_domicilio.estado_activ FROM "
                + "`servicio_domicilio` INNER JOIN horarios ON horarios.id_horario=servicio_domicilio.id_horario "
                + "INNER JOIN persona ON persona.id_persona=horarios.id_persona INNER JOIN cita ON "
                + "cita.id_cita=servicio_domicilio.id_cita INNER JOIN aparato ON aparato."
                + "id_aparato=cita.id_aparato INNER JOIN marca ON marca.id_marca=aparato.id_marca "
                + "WHERE cita.id_persona="+ideper;
        try {
            System.out.println("el ide mara mostrar serv "+ideper);
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Servicio serv=new Servicio();
                serv.setId_servicio(rs.getInt(1));
                Horario hora=new Horario();
                hora.setFecha(rs.getString(2));
                hora.setHoraini(rs.getString(3));
                hora.setHorafin(rs.getString(4));
                Tecnicos tecni=new Tecnicos();
                tecni.setId_tecn(rs.getInt(5));
                tecni.setNombres(rs.getString(6));
                tecni.setApellidos(rs.getString(7));
                Aparato apa=new Aparato();
                apa.setDescAparato(rs.getString(8));
                Marca marc=new Marca();
                marc.setDescripcion(rs.getString(9));
                apa.setMarca(marc);
                serv.setEstado_activ(rs.getBoolean(10));
                Cita cit=new Cita();
                cit.setAparato(apa);
                serv.setCita(cit);
                serv.setHorario(hora);
                serv.setTenico(tecni);
                lst.add(serv);
                System.out.println("---" + serv.getTenico().getApellidos());
                System.out.println("el cliente "+serv.isEstado_activ());
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
    public void generarServicio2(Cita cita,Horario hor){
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
        String sql = "INSERT INTO `servicio_domicilio` (`id_servicio_domi`, `id_cita`, `id_tipo`,"
                + " `id_horario`, `total`, `estado_activ`) VALUES (NULL, '"+idci+"', '2',"
                + " '"+hor.getId_horario()+"', NULL, '1');";
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
        generarServicio2(cita, hour);
    }
    public List<Servicio> mostrarTodosServicios(){
        List<Servicio> lst = new ArrayList<Servicio>();
        String sql="SELECT servicio.id_servicio, cita.id_cita, persona.nombres, persona.apellidos, cita.fecha_hora, aparato.descripcion,marca.descripcion, servicio.estado_activ, servicio.total FROM `servicio` INNER JOIN cita ON cita.id_cita LIKE servicio.id_cita INNER JOIN persona ON persona.id_persona= servicio.id_tecnico INNER JOIN aparato ON aparato.id_aparato=cita.id_aparato INNER JOIN marca ON marca.id_marca=aparato.id_marca;";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Servicio serv=new Servicio();
                serv.setId_servicio(rs.getInt(1));
                Cita cita=new Cita();
                cita.setId_cita(rs.getInt(2));
                Persona persona=new Persona();
                persona.setNombres(rs.getString(3));
                persona.setApellidos(rs.getString(4));
                cita.setFecha_hora(rs.getString(5));
                Aparato aparato=new Aparato();
                aparato.setDescAparato(rs.getString(6));
                Marca marc=new Marca();
                marc.setDescripcion(rs.getString(7));
                serv.setEstado_activ(rs.getBoolean(8));
                serv.setTotal(rs.getDouble(9));
                aparato.setMarca(marc);
                cita.setAparato(aparato);
                cita.setPerso(persona);
                serv.setPersona(persona);
                serv.setCita(cita);
                lst.add(serv);
                System.out.println("el tecnente "+serv.isEstado_activ());
                System.out.println("");
            }
            
            con.close();
        } catch (Exception e) {
            System.out.println("error mostrar servi "+e);
        }
        return lst;
    }

    public Servicio leerServicio(Servicio serv) {
        Servicio servi=null;
        ResultSet rs=null;
        String sql="SELECT * FROM `servicio` WHERE servicio.id_servicio=;"+serv.getId_servicio();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            if (rs.next()) {
                servi=new Servicio();
                servi.setId_servicio(rs.getInt(1));
                Cita cita=new Cita();
                cita.setId_cita(rs.getInt(2));
                servi.setCita(cita);
                servi.setTipo(rs.getInt(3));
                Persona perso=new Persona();
                perso.setId_persona(rs.getInt(4));
                servi.setPersona(perso);
                servi.setTotal(rs.getDouble(5));
                servi.setEstado_activ(rs.getBoolean(6));
            }
            con.close();
        } catch (Exception e) {
            System.out.println("error al buscar servicio "+e);
        }
        return serv;
    }
    
    public void registrarDetalles(Detalles detalle){
        String sql="INSERT INTO `detalles_servicio`(`id_detalles`,`id_servicio`,`id_repuesto`,`costo`,`cantidad`,`sub_total`)"
                + "VALUES (NULL, '"+detalle.getId_servicio()+"','"+detalle.getId_repuesto()+"','"+detalle.getCosto()
                +"','"+detalle.getCatidad()+"','"+detalle.getSubTotal()+"')";
        try {
            con=cn.Conexion();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            con.commit();
            con.close();
            
        } catch (Exception e) {
            System.out.println("error es --"+e);
        }
    }
    public void registrarDetallesDomi(Detalles detalle){
        String sql="INSERT INTO `detalles_servicio_domi`(`id_detalles_domi`,`id_servicio`,`id_repuesto`,`costo`,`cantidad`,`sub_total`)"
                + "VALUES (NULL, '"+detalle.getId_servicio()+"','"+detalle.getId_repuesto()+"','"+detalle.getCosto()
                +"','"+detalle.getCatidad()+"','"+detalle.getSubTotal()+"')";
        try {
            con=cn.Conexion();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            con.commit();
            con.close();
            
        } catch (Exception e) {
            System.out.println("error es --"+e);
        }
    }
    
    public void completarServicio(int id,double total){
        System.out.println("-0-"+id);
        String sql="UPDATE `servicio` SET `total`="+total+", `estado_activ`='0' WHERE `servicio`.`id_servicio`="+id+"" ;
        try {
            con=cn.Conexion();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            con.commit();
            con.close();
        } catch (Exception e) {
            System.out.println("el error al ACTUALIZAR servivio es "+e);
        }
    }
    public void completarServicioDomi(int id,double total){
        System.out.println("-0-"+id);
        String sql="UPDATE `servicio_domicilio` SET `total`="+total+", `estado_activ`='0' WHERE `servicio_domicilio`.`id_servicio_domi`="+id+"" ;
        try {
            con=cn.Conexion();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            con.commit();
            con.close();
        } catch (Exception e) {
            System.out.println("el error al ACTUALIZAR servivio es "+e);
        }
        String sql2="INSERT INTO `hoja_servicio_domi` (`id_hoja`, `id_servicio`, `estado_activ`) VALUES (NULL, '"+id+"', '1');";
        try {
            con=cn.Conexion();
            PreparedStatement stm = con.prepareStatement(sql2);
            stm.execute();
            con.commit();
            con.close();
        } catch (Exception e) {
            System.out.println("el error al llenar hoja servivio es "+e);
        }
    }
    public void cambiarEstado(Servicio servicio){
        System.out.println("---"+servicio.isEstado_activ());
        String sql="UPDATE servicio SET estado_activ = "
                + (servicio.isEstado_activ()== true ? '1' : '0')
                + " WHERE id_servicio = " + servicio.getId_servicio();
        try {
            con=cn.Conexion();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            con.commit();
            con.close();
        } catch (Exception e) {
            System.out.println("e---"+e);
        }
    }
    
    public void cambiarEstadoDomi(Servicio servicio){
        System.out.println("---"+servicio.isEstado_activ());
        String sql="UPDATE servicio_domicilio SET estado_activ = "
                + (servicio.isEstado_activ()== true ? '1' : '0')
                + " WHERE id_servicio_domi = " + servicio.getId_servicio();
        try {
            con=cn.Conexion();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            con.commit();
            con.close();
        } catch (Exception e) {
            System.out.println("e---"+e);
        }
    }

    public List<Servicio> mostrarTodosServiciosDomicilio() {
        List<Servicio> lst = new ArrayList<Servicio>();
        String sql="SELECT servicio_domicilio.id_servicio_domi, cita.id_cita, persona.nombres, "
                + "persona.apellidos, horarios.fecha,horarios.hora_ini, horarios.hora_fin, "
                + "aparato.descripcion,marca.descripcion, servicio_domicilio.estado_activ, "
                + "servicio_domicilio.total FROM `servicio_domicilio` INNER JOIN cita ON cita.id_cita "
                + "LIKE servicio_domicilio.id_cita INNER JOIN horarios ON horarios.id_horario= "
                + "servicio_domicilio.id_horario INNER JOIN persona ON persona.id_persona=horarios.id_persona "
                + "INNER JOIN aparato ON aparato.id_aparato=cita.id_aparato INNER JOIN marca ON "
                + "marca.id_marca=aparato.id_marca;";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Servicio serv=new Servicio();
                serv.setId_servicio(rs.getInt(1));
                System.out.println("-"+serv.getId_servicio());
                Cita cita=new Cita();
                cita.setId_cita(rs.getInt(2));
                Tecnicos persona=new Tecnicos();
                persona.setNombres(rs.getString(3));
                persona.setApellidos(rs.getString(4));
                Horario horari=new Horario();
                horari.setFecha(rs.getString(5));
                horari.setHoraini(rs.getString(6));
                horari.setHorafin(rs.getString(7));
                Aparato aparato=new Aparato();
                aparato.setDescAparato(rs.getString(8));
                Marca marc=new Marca();
                marc.setDescripcion(rs.getString(9));
                serv.setEstado_activ(rs.getBoolean(10));
                serv.setTotal(rs.getDouble(11));
                aparato.setMarca(marc);
                cita.setAparato(aparato);
                horari.setTecnico(persona);
                serv.setHorario(horari);
                serv.setCita(cita);
                lst.add(serv);
                System.out.println("el servicio tiene "+serv.isEstado_activ());
                System.out.println("");
            }
            
            con.close();
        } catch (Exception e) {
            System.out.println("error mostrar servi "+e);
        }
        return lst;
    }
}

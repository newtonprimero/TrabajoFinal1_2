/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.*;
import java.util.*;
/**
 *
 * @author USUARIO
 */
public class Dao_login {
    private PreparedStatement ps;
    private ResultSet rs;
    int rol;
    String nombre;
    conexion2 c= new conexion2();
    Connection con() throws ClassNotFoundException, SQLException{
        Class.forName(c.getDrive());
        return DriverManager.getConnection(c.getUrl(),c.getUss(),c.getPas());
    };
    
    public boolean validar(String correo, String contraseña){
        try {
            ps=con().prepareStatement("select usuario.id_rol,persona.nombres from usuario INNER JOIN persona ON persona.id_persona=usuario.id_persona where correo=? and contraseña=?");
            ps.setString(1, correo);
            ps.setString(2, contraseña);
            rs=ps.executeQuery();
            while (rs.next()) {
                rol=rs.getInt(1);
                nombre=rs.getString(2);
                return true;
            }
        } catch (Exception e) {
            
        }
        return false;
    }
}

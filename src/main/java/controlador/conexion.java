/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author USUARIO
 */
public class conexion {
    String drive;
    String url;
    String uss;
    String pas;
    public conexion() {
        drive="com.mysql.jdbc.Drive";
        url="jdbc:mysql://localhost:3306/taller_utp?zeroDateTimeBehavior=CONVERT_TO_NULL [root on Default schema]";
        uss="root";
        pas="";
    }
    public int loguer(String usuario,String pass) throws ClassNotFoundException{
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        int rol=0;
        String nombre;
        String sql="select usuario.id_rol,persona.nombres from usuario INNER JOIN persona ON persona.id_persona=usuario.id_persona where correo='"+usuario+"' and contraseña='"+pass+"'";
        try{
            Class.forName(this.drive);
            con=DriverManager.getConnection(
                this.url,
                this.uss,
                this.pas);
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            System.out.println(rs);
            while(rs.next()){
                rol=rs.getInt(2);
                nombre=rs.getString(1);
            }
            con.close();
        }catch (Exception e){
            
        }
        return rol;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import javax.mail.*;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author USUARIO
 */
public class Correo {
    public void enviarCorreo(String correodestino){
        String remitente ="tallerutpcorreo@gmail.com";
        String clave="bzzauzjemxybzlxz";
        String destino=correodestino;
        
        System.out.println("se enviara a "+ destino);
        
        Properties properties=new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.imap.ssl.enable", "true");
        properties.put("mail.imap.auth.mechanisms", "XOAUTH2");
        
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.user", remitente);
        properties.put("mail.smtp.clave", clave);

        Session session = Session.getDefaultInstance(properties);
        
        MimeMessage mensaje= new MimeMessage(session);
        
        try {
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
            
            mensaje.setSubject("Se ha generado su cita TALLER UTP");
            
            BodyPart textoC =new MimeBodyPart();
            textoC.setContent("Se ha generado tú cita correctamente podras visualizarla en nuestra plataforma ", "text/html");
            
            BodyPart archivo =new MimeBodyPart();
            archivo.setDataHandler(new DataHandler(new FileDataSource("D:\\reporte.pdf")));
            archivo.setFileName("reporte.pdf");
            MimeMultipart c= new MimeMultipart();
            
            c.addBodyPart(textoC);
            c.addBodyPart(archivo);
            mensaje.setContent(c);
            
            Transport transporte=session.getTransport("smtp");
            transporte.connect("smtp.gmail.com", remitente,clave);
            transporte.sendMessage(mensaje, mensaje.getAllRecipients());
            transporte.close();
            
            System.out.println("se envio correctamente");
            
        } catch (Exception e) {
            System.out.println("erro correo "+e);
        }
    }
}

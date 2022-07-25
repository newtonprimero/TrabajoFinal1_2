/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import modelo.*;

/**
 *
 * @author USUARIO
 */
//@WebServlet(name = "ServletValidar", urlPatterns = {"/ServletValidar"})
public class ServletHorarios extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion=request.getParameter("btnBuscar");
        switch (accion) {
            case "horariosHoy":
                mostrarHoraiosHoy(request,response);
                break;
            case "horariosManana":
                mostrarHoraiosManana(request,response);
                break;
            case "horariosTodosSemana":
                mostrarHoraiosSemana(request,response);
                break;
            default:
                throw new AssertionError();
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void mostrarHoraiosHoy(HttpServletRequest request, HttpServletResponse response) {
        DaoHorarios daoh = new DaoHorarios();
        List<Horario> hour = null;
        try {
            hour = daoh.horarioHoy();
            request.setAttribute("listaHorarios", hour);
            System.out.println("lista horaios");
            System.out.println(hour);
        } catch (Exception e) {
            System.out.println("problema dispacher " + e);
            request.setAttribute("msje", "no se puedo listar");
        } finally {
            daoh = null;
        }
        try {
            System.out.println("entro en redireccion");
            this.getServletConfig().getServletContext().getRequestDispatcher("/mostrarHorarios.jsp").forward(request, response);
        } catch (Exception e) {
        }
    }

    private void mostrarHoraiosManana(HttpServletRequest request, HttpServletResponse response) {
        DaoHorarios daoh = new DaoHorarios();
        List<Horario> hour = null;
        try {
            hour = daoh.horarioMañana();
            request.setAttribute("listaHorarios", hour);
            System.out.println("lista horaios");
            System.out.println(hour);
        } catch (Exception e) {
            System.out.println("problema dispacher " + e);
            request.setAttribute("msje", "no se puedo listar");
        } finally {
            daoh = null;
        }
        try {
            System.out.println("entro en redireccion");
            this.getServletConfig().getServletContext().getRequestDispatcher("/mostrarHorarios.jsp").forward(request, response);
        } catch (Exception e) {
        }
    }

    private void mostrarHoraiosSemana(HttpServletRequest request, HttpServletResponse response) {
        DaoHorarios daoh = new DaoHorarios();
        List<Horario> hour = null;
        try {
            hour = daoh.horarioSemana();
            request.setAttribute("listaHorarios", hour);
            System.out.println("lista horaios");
            System.out.println(hour);
        } catch (Exception e) {
            System.out.println("problema dispacher " + e);
            request.setAttribute("msje", "no se puedo listar");
        } finally {
            daoh = null;
        }
        try {
            System.out.println("entro en redireccion");
            this.getServletConfig().getServletContext().getRequestDispatcher("/mostrarHorarios.jsp").forward(request, response);
        } catch (Exception e) {
        }
    }

}

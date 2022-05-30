/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Cliente;
import modelo.DaoCliente;
import modelo.DaoUsuario;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "ServletCliente", urlPatterns = {"/ServletCliente"})
public class ServletCliente extends HttpServlet {
    DaoUsuario daou=new DaoUsuario();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        String accion=request.getParameter("accion");
        System.out.println("leega al process mostrar");
        try {
            if(accion!=null){
                switch (accion) {
                    case "listar":
                        listarClientes(request, response);
                    case "cerrar":
                        editarCliente(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }
                
            }
            else{
                response.sendRedirect("/login.jsp");
            }
        } catch (Exception e) {
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
       /* 
       List <Cliente> clientes=new DaoCliente().mostrarClientes();
       daou.nombreUser();
        System.out.println(daou.nombreUser());
       request.setAttribute("listaClientes", clientes);
       request.getRequestDispatcher("mostrarClientes.jsp").forward(request, response);
    */
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

    private void listarClientes(HttpServletRequest request, HttpServletResponse response) {
        DaoCliente daoc=new DaoCliente();
        List<Cliente> cli=null;
        try {
            cli=daoc.mostrarClientes();
            request.setAttribute("listaClientes", cli);
            System.out.println("listo clientes");
        } catch (Exception e) {
            request.setAttribute("msje", "no se puedo listar");
        }
        finally{
            daoc=null;
        }
        try {
            System.out.println("entro en redireccion");
            this.getServletConfig().getServletContext().getRequestDispatcher("/mostrarClientes.jsp").forward(request, response);
        } catch (Exception e) {
        }
    }

    private void editarCliente(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

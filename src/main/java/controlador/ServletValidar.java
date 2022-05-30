/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Aparato;
import modelo.Cita;
import modelo.Cliente;
import modelo.DaoCliente;
import modelo.DaoDistrito;
import modelo.DaoEncargado;
import modelo.DaoRepuesto;
import modelo.DaoServicio;
import modelo.DaoTecnico;
import modelo.DaoUsuario;
import modelo.Distrito;
import modelo.Encargado;
import modelo.Horario;
import modelo.Marca;
import modelo.Persona;
import modelo.Repuesto;
import modelo.Tecnicos;
import modelo.Usuario;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "ServletValidar", urlPatterns = {"/ServletValidar"})
public class ServletValidar extends HttpServlet {

    DaoUsuario daou = new DaoUsuario();
    Usuario us;
    int ideper;

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
        String accion = request.getParameter("accion");
        String shear = request.getParameter("shear");
        System.out.println("leega al process");
        try {
            if (accion != null) {
                switch (accion) {
                    case "verificar":
                        verificar(request, response);
                    case "cerrar":
                        cerrasession(request, response);
                        break;
                    case "listarclientes":
                        System.out.println("entro a validar");
                        listarClientes(request, response);
                        break;
                    case "listartecnicos":
                        listarTecnicos(request, response);
                        break;
                    case "listarencargados":
                        listarEncargados(request, response);
                        break;
                    case "listarrepuestos":
                        listarRepuestos(request, response);
                        break;
                    case "registrarcliente":
                        formRegistrarCliente(request, response);
                        break;
                    case "registrarnuevocliente":
                        registrarCliente(request, response);
                        break;
                    case "mostrarformcita":
                        formRegistrarCita(request,response);
                        break;
                    case "registrarcita":
                        registrarCita(request, response);
                        break;
                    case "misservicios":
                        listarMisServicios(request, response);
                        break;
                    case "buscardni":
                        System.out.println("llegar a buscar tec");
                        if(shear.equals("sheardni")){
                            listarHorariosDni(request, response);
                        }else if(shear.equals("shearIngresarH")){
                            insertarHorario(request, response);
                        }
                        break;
                    default:
                        this.getServletConfig().getServletContext().getRequestDispatcher("./login.jsp").forward(request, response);
                        break;
                }

            } else {
                response.sendRedirect("./login.jsp");
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
        /*
        if (accion.equalsIgnoreCase("btnIngresar")) {
            String user=request.getParameter("txtemail");
            String pass=request.getParameter("txtpassword");
            us=daou.validar(user, pass);
            
            switch (us.getId_rol()) {
                case 1:
                    request.setAttribute("usuario", daou);
                    request.getRequestDispatcher("servletControl?btnIngresar=Principal").forward(request, response);
                    System.out.println("entra aqui");
                    request.getRequestDispatcher("servletControl?btnIngresar=Principal").forward(request, response);
                    break;
                case 2:
                    sesion =request.getSession();
                    request.setAttribute("usuario", daou);
                    request.getRequestDispatcher("servletControl?btnIngresar=Segundo").forward(request, response);
                    break;
                case 3:
                    sesion =request.getSession();
                    request.setAttribute("usuario", daou);
                    request.getRequestDispatcher("servletControl?btnIngresar=Tercero").forward(request, response);
                    break;
                default:
                    request.getRequestDispatcher("index.jsp").forward(request, response);
            } 
        }
        else{
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }*/
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

    private void verificar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession sesion;
        Usuario usu;
        usu = this.obtenerUsuario(request);
        usu = daou.validar(usu);
        System.out.println("el usuario en verificar es "+usu);
        /*if (usu!=null) {
            switch (usu.getId_rol()) {
            case 1:
                sesion = request.getSession();
                sesion.setAttribute("usuario", usu);
                request.setAttribute("usuariohome", daou);
                System.out.println("llega aqui ahora");
                this.getServletConfig().getServletContext().getRequestDispatcher("/homeEncargado.jsp").forward(request, response);
                break;
            case 2:    
                sesion = request.getSession();
                sesion.setAttribute("usuario", usu);
                request.setAttribute("usuario", daou);
                System.out.println("llega aqui redireccion homeEncargado "+usu.getNombreUsuario());
                this.getServletConfig().getServletContext().getRequestDispatcher("/homeEncargado.jsp").forward(request, response);
                break;
            case 3:
                sesion = request.getSession();
                sesion.setAttribute("usuario", usu);
                request.setAttribute("usuario", daou);
                this.getServletConfig().getServletContext().getRequestDispatcher("/homeCliente.jsp").forward(request, response);
                break;
            default:
                request.setAttribute("msj", "Credenciales Incorrectas");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }else{
            request.setAttribute("msj", "Credenciales Incorrectas");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
        }*/
        
        if (usu!=null && usu.getId_rol() == 1) {
            sesion = request.getSession();
            sesion.setAttribute("usuario", usu);
            request.setAttribute("usuariohome", daou);
            this.getServletConfig().getServletContext().getRequestDispatcher("/homeEncargado.jsp").forward(request, response);
        }else if ( usu!=null && usu.getId_rol() == 2) {
            sesion = request.getSession();
            sesion.setAttribute("usuario", usu);
            this.getServletConfig().getServletContext().getRequestDispatcher("/homeTecnico.jsp").forward(request, response);
        }else if ( usu!=null && usu.getId_rol() == 3) {
            sesion = request.getSession();
            sesion.setAttribute("usuario", usu);
            this.getServletConfig().getServletContext().getRequestDispatcher("/homeCliente.jsp").forward(request, response);
        }else{
            System.out.println("llega mas aca");
            request.setAttribute("msj", "Credenciales Incorrectas");
            request.getRequestDispatcher("./login.jsp").forward(request, response);
        }
        
    }

    private void cerrasession(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
    }

    private void listarClientes(HttpServletRequest request, HttpServletResponse response) {
        DaoCliente daoc = new DaoCliente();
        List<Cliente> cli = null;
        try {
            cli = daoc.mostrarClientes();
            request.setAttribute("listaClientes", cli);
            System.out.println("lista clientes");
        } catch (Exception e) {
            request.setAttribute("msje", "no se puedo listar");
        } finally {
            daoc = null;
        }
        try {
            System.out.println("entro en redireccion");
            this.getServletConfig().getServletContext().getRequestDispatcher("/mostrarClientes.jsp").forward(request, response);
        } catch (Exception e) {
        }
    }

    private Usuario obtenerUsuario(HttpServletRequest request) {
        us = new Usuario();
        if(request.getParameter("txtemail")!= null &&request.getParameter("txtpassword")!=null){
        us.setCorreo(request.getParameter("txtemail"));
        us.setContraseña(request.getParameter("txtpassword"));}
        return us;
    }

    private void listarTecnicos(HttpServletRequest request, HttpServletResponse response) {
        DaoTecnico daot = new DaoTecnico();
        List<Tecnicos> tecn = null;
        try {
            tecn = daot.mostrarTecnicos();
            request.setAttribute("listaTecnico", tecn);
            System.out.println("lista tecnicos");
        } catch (Exception e) {
            request.setAttribute("msje", "no se puedo listar");
        } finally {
            daot = null;
        }
        try {
            System.out.println("entro en redireccion");
            this.getServletConfig().getServletContext().getRequestDispatcher("/mostrarTecnicos.jsp").forward(request, response);
        } catch (Exception e) {
        }
    }

    private void listarEncargados(HttpServletRequest request, HttpServletResponse response) {
        DaoEncargado daoe = new DaoEncargado();
        List<Encargado> encar = null;
        try {
            encar = daoe.mostrarEncargados();
            request.setAttribute("listaEncargado", encar);
            System.out.println("lista encaricos");
        } catch (Exception e) {
            request.setAttribute("msje", "no se puedo listar");
        } finally {
            daoe = null;
        }
        try {
            System.out.println("entro en redireccion encargados");
            this.getServletConfig().getServletContext().getRequestDispatcher("/mostrarEncargados.jsp").forward(request, response);
        } catch (Exception e) {
        }
    }

    private void listarRepuestos(HttpServletRequest request, HttpServletResponse response) {
        DaoRepuesto daor = new DaoRepuesto();
        List<Repuesto> repue = null;
        try {
            repue = daor.mostrarRepuestos();
            request.setAttribute("listarRepuestos", repue);
            System.out.println("lista repuestos");
        } catch (Exception e) {
            request.setAttribute("msje", "no se puedo listar");
        } finally {
            daor = null;
        }
        try {
            System.out.println("entro en redireccion encargados");
            this.getServletConfig().getServletContext().getRequestDispatcher("/mostrarRepuestos.jsp").forward(request, response);
        } catch (Exception e) {
        }
    }
    private void distritos(HttpServletRequest request) {
        DaoDistrito daoc=new DaoDistrito();
        List<Distrito> distr = null;
        try {
            distr = daoc.mostrarDistritos();
            request.setAttribute("distritos", distr);
        } catch (SQLException e) {
            request.setAttribute("msje", e);
        }finally{
            distr=null;
            daoc=null;
        }
    }
    private void marcas(HttpServletRequest request) {
        DaoServicio daoS=new DaoServicio();
        List<Marca> marc = null;
        try {
            marc = daoS.mostrarMarcas();
            request.setAttribute("marcas", marc);
        } catch (SQLException e) {
            request.setAttribute("msje", e);
        }finally{
            marc=null;
            daoS=null;
        }
    }

    private void formRegistrarCliente(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.distritos(request);
            this.getServletConfig().getServletContext()
                    .getRequestDispatcher("/insertarCliente.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msje", e);
        }
    }
    
    private void registrarCliente (HttpServletRequest request, HttpServletResponse response){
        DaoCliente daoc;
        Cliente cli=null;
        Distrito dis;
        if(request.getParameter("txtnombres") != null && request.getParameter("txtapellidos") !=null 
                && request.getParameter("txtdni") !=null && request.getParameter("txttelefono1") !=null 
                && request.getParameter("txtemail") !=null && request.getParameter("cbodistrito") !=null
                && request.getParameter("txtdireccion") !=null&& request.getParameter("txtpassword") !=null){
            cli=new Cliente();
            cli.setNombres(request.getParameter("txtnombres"));
            cli.setApellidos(request.getParameter("txtapellidos"));
            cli.setDni(Integer.parseInt(request.getParameter("txtdni")));
            dis=new Distrito();
            dis.setId_distrito(Integer.parseInt(request.getParameter("cbodistrito")));
            cli.setDistrit(dis);
            cli.setDireccion(request.getParameter("txtdireccion"));
            cli.setTelefono1(Integer.parseInt(request.getParameter("txttelefono1")));
            cli.setTelefono2(Integer.parseInt(request.getParameter("txttelefono2")));
            cli.setCorreo(request.getParameter("txtemail"));
            cli.setPassword(request.getParameter("txtpassword"));
            
            try {
                daoc=new DaoCliente();
                daoc.nuevoCliente(cli);
                response.sendRedirect("ServletValidar?accion=registrarcliente");
            } catch (Exception e) {
                System.out.println("error al registrar "+e);
            }
        }
    }

    private void formRegistrarCita(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.marcas(request);
            this.distritos(request);
            this.getServletConfig().getServletContext()
                    .getRequestDispatcher("/solicitarCita.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msje", e);
        }
    }
    
    private void registrarCita (HttpServletRequest request, HttpServletResponse response){
        DaoServicio daose;
        Cita ci=null;
        Distrito dis;
        Marca mar;
        Aparato apa;
        if(request.getParameter("txridper") != null && request.getParameter("cbomarca") !=null 
                && request.getParameter("txtnroserie") !=null && request.getParameter("txtdescripcion") !=null 
                && request.getParameter("cbodistrito") !=null && request.getParameter("txtdireccion") !=null
                && request.getParameter("inputfecha") !=null){
            ci=new Cita();
            ci.setId_persona(Integer.parseInt(request.getParameter("txridper")));
            mar=new Marca();
            mar.setId_marca(Integer.parseInt(request.getParameter("cbomarca")));
            apa=new Aparato();
            apa.setNroSerie(request.getParameter("txtnroserie"));
            apa.setDescAparato(request.getParameter("txtdescripcion"));
            apa.setMarca(mar);
            ci.setAparato(apa);
            dis=new Distrito();
            dis.setId_distrito(Integer.parseInt(request.getParameter("cbodistrito")));
            ci.setDiaDistrito(dis);
            ci.setDireccion(request.getParameter("txtdireccion"));
            ci.setFecha_hora(request.getParameter("inputfecha"));
            try {
                daose=new DaoServicio();
                daose.nuevoCita(ci);
                response.sendRedirect("/homeClientes.jsp");
            } catch (Exception e) {
                System.out.println("error al registrar "+e);
            }
        }
    }

    private void listarMisServicios(HttpServletRequest request, HttpServletResponse response) {
        DaoServicio daoc = new DaoServicio();
        List<Cita> cita = null;
        String i=request.getParameter("txtidper");
        System.out.println("el ip de mis servicio "+i);
        try {
            cita = daoc.misServicios(Integer.parseInt(i));
            request.setAttribute("listaServicios", cita);
            System.out.println("lista servicios");
        } catch (Exception e) {
            System.out.println(e);
            request.setAttribute("msje", "no se puedo listar");
        } finally {
            daoc = null;
        }
        try {
            System.out.println("entro en redireccion");
            this.getServletConfig().getServletContext().getRequestDispatcher("/mostrarMisServicios.jsp").forward(request, response);
        } catch (Exception e) {
        }
    }
    
    private void ipPersona(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("entra en id persona");
        DaoServicio daoc;
        Cita ci;
        try {
            ci=new Cita();
            daoc =new DaoServicio();
            System.out.println(request.getParameter("txtidper"));
            ci.setId_persona(Integer.parseInt(request.getParameter("txtidper")));
            listarMisServicios(request, response);
        } catch (Exception e) {
            System.out.println("el error es id pers"+e);
        }
        
    }
    private void listarHorariosDni(HttpServletRequest request, HttpServletResponse response) {
        DaoEncargado daoc = new DaoEncargado();
        Persona per =new Persona();
        List<Horario> hour = null;
        try {
            per.setDni(request.getParameter("txtdnishear"));
            System.out.println(per.getDni());
            hour = daoc.horarioPorTecnico(per);
            request.setAttribute("listaHorarios", hour);
            System.out.println("lista horaios");
            System.out.println(hour);
        } catch (Exception e) {
            System.out.println("problema dispacher "+e);
            request.setAttribute("msje", "no se puedo listar");
        } finally {
            daoc = null;
        }
        try {
            System.out.println("entro en redireccion");
            this.getServletConfig().getServletContext().getRequestDispatcher("/asignacionHorarios.jsp").forward(request, response);
        } catch (Exception e) {
        }
        
    }
    private void insertarHorario (HttpServletRequest request, HttpServletResponse response){
        DaoEncargado daoc;
        Horario cli=null;
        Distrito dis;
        if(request.getParameter("selecEstado") != null && request.getParameter("inputfecha") !=null 
                && request.getParameter("inputHIni") !=null && request.getParameter("inputHFin") !=null){
            cli=new Horario();
            cli.setEstado_activ(Boolean.parseBoolean(request.getParameter("selecEstado")));
            cli.setFecha(request.getParameter("inputfecha"));
            cli.setHoraini(request.getParameter("inputHIni"));
            cli.setHorafin(request.getParameter("inputHFin"));
            try {
                daoc=new DaoEncargado();
                daoc.ingresarHorario(cli);
                System.out.println(cli.isEstado_activ());
                this.getServletConfig().getServletContext().getRequestDispatcher("/asignacionHorarios.jsp").forward(request, response);
            } catch (Exception e) {
                System.out.println("error al registrar "+e);
            }
        }
    }

}

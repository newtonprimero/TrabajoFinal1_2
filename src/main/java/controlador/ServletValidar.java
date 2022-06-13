/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
import modelo.DaoEspecialidad;
import modelo.DaoRepuesto;
import modelo.DaoServicio;
import modelo.DaoTecnico;
import modelo.DaoUsuario;
import modelo.Detalles;
import modelo.Distrito;
import modelo.Encargado;
import modelo.Especialidad;
import modelo.Horario;
import modelo.Marca;
import modelo.Persona;
import modelo.Repuesto;
import modelo.Servicio;
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
    static int ideper;
    Repuesto repuest = new Repuesto();
    Detalles detalle;
    List<Detalles> lista = new ArrayList<>();
    static int idservicio;
        double total = 0.0;

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
                    case "listarhoraiosservi":
                        listarHrariosServi(request, response);
                        break;
                    case "mosrtrarfomrCitaSelcet":
                        leerSchedule(request, response);
                        mostrarformCitasinFecha(request, response);
                        break;
                    case "leerHorario":
                        leerSchedule(request, response);
                        break;
                    case "registrarcliente":
                        formRegistrarCliente(request, response);
                        break;
                    case "registrarnuevocliente":
                        registrarCliente(request, response);
                        break;
                    case "mostrarformcita":
                        formRegistrarCita(request, response);
                        break;
                    case "registrarcita":
                        registrarCita(request, response);
                        break;
                    case "registrarcita2":
                        System.out.println("llegar a case");
                        registrarCitasinhora(request, response);
                        break;
                    case "misservicios":
                        if (shear.equals("citas")) {
                            listarMisServicios(request, response);
                        }else if(shear.equals("misServi")){
                            mostrarMisServicios(request, response);
                        }
                        
                        break;
                    case "buscardni":
                        System.out.println("llegar a buscar tec");
                        if (shear.equals("sheardni")) {
                            listarHorariosDni(request, response);
                        } else if (shear.equals("shearIngresarH")) {
                            insertarHorario(request, response);
                        }
                        break;
                    case "formRegisTecnico":
                        formRegistrarTecnico(request, response);
                        break;
                    case "registrarTecnico":
                        registrarTecnico(request, response);
                        break;
                    case "leerCliente":
                        leerClient(request, response);
                        break;
                    case "actualizarCliente":
                        actualizarClient(request, response);
                    case "leerTecnico":
                        leerTecnic(request, response);
                        break;
                    case "actualizarTecnico":
                        actualizarTecnic(request, response);
                        break;
                    case "listarTodosServicios":
                        listarTodosServicios(request, response);
                        break;
                    case "listarServiciosDomicilio":
                        System.out.println("llega aca");
                        listarTodosServiciosDomicilio(request, response);
                        break;
                    case "listarServiciosCompletos":
                        listarServiciosComple(request, response);
                        break;
                    case "listarServiciosEspera":
                        listarTodosEspera(request, response);
                        break;
                    case "completarservicio":
                        formCarritoServ(request, response);
                        break;
                    case "completarservicioDomi":
                        formCarritoServDom(request, response);
                        break;
                    case "nuevoRepuesto":
                        this.repuestos(request);
                        if (shear.equals("buscarRepuesto")) {
                            request.setAttribute("lista", lista);
                            if (request.getParameter("txtidrepuesto") != "") {
                                int id = Integer.parseInt(request.getParameter("txtidrepuesto"));
                                DaoRepuesto daor = new DaoRepuesto();
                                repuest = daor.repuestoporID(id);
                                request.setAttribute("repuesto", repuest);
                            }else {
                                request.getRequestDispatcher("./detallerServicio.jsp").forward(request, response);}
                        } else if (shear.equals("agregarRepuesto")) {
                            agregarCarrito(request);
                        } else if (shear.equals("procesar")){
                            registrarDetallesServicio(request, response);
                        } 
                        request.getRequestDispatcher("./detallerServicio.jsp").forward(request, response);
                        break;
                    case "nuevoRepuestoDomi":
                        this.repuestos(request);
                        if (shear.equals("buscarRepuesto")) {
                            request.setAttribute("lista", lista);
                            if (request.getParameter("txtidrepuesto") != "") {
                                int id = Integer.parseInt(request.getParameter("txtidrepuesto"));
                                DaoRepuesto daor = new DaoRepuesto();
                                repuest = daor.repuestoporID(id);
                                request.setAttribute("repuesto", repuest);
                            }else {
                                request.getRequestDispatcher("./detallesServicioDomi.jsp").forward(request, response);}
                        } else if (shear.equals("agregarRepuesto")) {
                            agregarCarrito(request);
                        } else if (shear.equals("procesar")){
                            registrarDetallesServicioDomi(request, response);
                        } 
                        request.getRequestDispatcher("./detallesServicioDomi.jsp").forward(request, response);
                        break;
                    case "leerServicio":
                        leerServicio(request, response);
                        break;
                    case "leerServicioDomi":
                        leerServicioDomi(request, response);
                        break;
                    case "registrardetallesServicio":
                        registrarDetallesServicio(request, response);
                        break;
                    case "mostrarmisServicios":
                        mostrarMisServicios(request, response);
                        break;
                    case "mostrarMisHorarios":
                        mostrarMisHorarios(request, response);
                    default:
                        this.getServletConfig().getServletContext().getRequestDispatcher("./login.jsp").forward(request, response);
                        break;
                }

            } else if(request.getParameter("cambiar") != null){
                cambiarEstado(request, response);
            }else if(request.getParameter("cambiar2") != null){
                cambiarEstadoDomi(request, response);}
            else{
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
        ideper=usu.getId();
        System.out.println("el usuario en verificar es " + usu);
        if (usu != null && usu.getId_rol() == 1) {
            sesion = request.getSession();
            sesion.setAttribute("usuario", usu);
            request.setAttribute("usuariohome", daou);
            this.getServletConfig().getServletContext().getRequestDispatcher("/homeEncargado.jsp").forward(request, response);
        } else if (usu != null && usu.getId_rol() == 2) {
            sesion = request.getSession();
            sesion.setAttribute("usuario", usu);
            this.getServletConfig().getServletContext().getRequestDispatcher("/homeTecnico.jsp").forward(request, response);
        } else if (usu != null && usu.getId_rol() == 3) {
            sesion = request.getSession();
            sesion.setAttribute("usuario", usu);
            this.getServletConfig().getServletContext().getRequestDispatcher("/homeCliente.jsp").forward(request, response);
        } else {
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
        if (request.getParameter("txtemail") != null && request.getParameter("txtpassword") != null) {
            us.setCorreo(request.getParameter("txtemail"));
            us.setContraseña(request.getParameter("txtpassword"));
        }
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
        DaoDistrito daoc = new DaoDistrito();
        List<Distrito> distr = null;
        try {
            distr = daoc.mostrarDistritos();
            request.setAttribute("distritos", distr);
        } catch (SQLException e) {
            request.setAttribute("msje", e);
        } finally {
            distr = null;
            daoc = null;
        }
    }

    private void marcas(HttpServletRequest request) {
        DaoServicio daoS = new DaoServicio();
        List<Marca> marc = null;
        try {
            marc = daoS.mostrarMarcas();
            request.setAttribute("marcas", marc);
        } catch (SQLException e) {
            request.setAttribute("msje", e);
        } finally {
            marc = null;
            daoS = null;
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

    private void registrarCliente(HttpServletRequest request, HttpServletResponse response) {
        DaoCliente daoc;
        Cliente cli = null;
        Distrito dis;
        if (request.getParameter("txtnombres") != null && request.getParameter("txtapellidos") != null
                && request.getParameter("txtdni") != null && request.getParameter("txttelefono1") != null
                && request.getParameter("txtemail") != null && request.getParameter("cbodistrito") != null
                && request.getParameter("txtdireccion") != null && request.getParameter("txtpassword") != null) {
            cli = new Cliente();
            cli.setNombres(request.getParameter("txtnombres"));
            cli.setApellidos(request.getParameter("txtapellidos"));
            cli.setDni(Integer.parseInt(request.getParameter("txtdni")));
            dis = new Distrito();
            dis.setId_distrito(Integer.parseInt(request.getParameter("cbodistrito")));
            cli.setDistrit(dis);
            cli.setDireccion(request.getParameter("txtdireccion"));
            cli.setTelefono1(Integer.parseInt(request.getParameter("txttelefono1")));
            cli.setTelefono2(Integer.parseInt(request.getParameter("txttelefono2")));
            cli.setCorreo(request.getParameter("txtemail"));
            cli.setPassword(request.getParameter("txtpassword"));

            try {
                daoc = new DaoCliente();
                daoc.nuevoCliente(cli);
                response.sendRedirect("ServletValidar?accion=registrarcliente");
            } catch (Exception e) {
                System.out.println("error al registrar " + e);
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

    private void registrarCita(HttpServletRequest request, HttpServletResponse response) {
        DaoServicio daose;
        Cita ci = null;
        Distrito dis;
        Marca mar;
        Aparato apa;
        if (request.getParameter("inputfecha") != null) {
            if (request.getParameter("txridper") != null && request.getParameter("cbomarca") != null
                    && request.getParameter("txtnroserie") != null && request.getParameter("txtdescripcion") != null
                    && request.getParameter("cbodistrito") != null && request.getParameter("txtdireccion") != null
                    && request.getParameter("inputfecha") != null) {
                ci = new Cita();
                ci.setId_persona(Integer.parseInt(request.getParameter("txridper")));
                mar = new Marca();
                mar.setId_marca(Integer.parseInt(request.getParameter("cbomarca")));
                apa = new Aparato();
                apa.setNroSerie(request.getParameter("txtnroserie"));
                apa.setDescAparato(request.getParameter("txtdescripcion"));
                apa.setMarca(mar);
                ci.setAparato(apa);
                dis = new Distrito();
                dis.setId_distrito(Integer.parseInt(request.getParameter("cbodistrito")));
                ci.setDiaDistrito(dis);
                ci.setDireccion(request.getParameter("txtdireccion"));
                ci.setFecha_hora(request.getParameter("inputfecha"));
                try {
                    System.out.println("entro al if de cita");
                    daose = new DaoServicio();
                    daose.nuevoCita(ci);
                    this.getServletConfig().getServletContext().getRequestDispatcher("/homeCliente.jsp").forward(request, response);
                } catch (Exception e) {
                    System.out.println("error al registrar " + e);
                }
            }
        } else {
            if (request.getParameter("txridper") != null && request.getParameter("cbomarca") != null
                    && request.getParameter("txtnroserie") != null && request.getParameter("txtdescripcion") != null
                    && request.getParameter("cbodistrito") != null && request.getParameter("txtdireccion") != null) {
                ci = new Cita();
                ci.setId_persona(Integer.parseInt(request.getParameter("txridper")));
                mar = new Marca();
                mar.setId_marca(Integer.parseInt(request.getParameter("cbomarca")));
                apa = new Aparato();
                apa.setNroSerie(request.getParameter("txtnroserie"));
                apa.setDescAparato(request.getParameter("txtdescripcion"));
                apa.setMarca(mar);
                ci.setAparato(apa);
                dis = new Distrito();
                dis.setId_distrito(Integer.parseInt(request.getParameter("cbodistrito")));
                ci.setDiaDistrito(dis);
                ci.setDireccion(request.getParameter("txtdireccion"));
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime actual = LocalDateTime.now();
                String hora = actual.format(dtf);
                ci.setFecha_hora(hora);
                Horario horaa = new Horario();
                horaa.setId_horario(Integer.parseInt(request.getParameter("txridhora")));
                System.out.println("el id horario es " + horaa.getId_horario());
                try {
                    System.out.println("entro en el else");
                    daose = new DaoServicio();
                    daose.nuevoCitaHorario(ci, horaa);
                    this.getServletConfig().getServletContext().getRequestDispatcher("/homeCliente.jsp").forward(request, response);
                } catch (Exception e) {
                    System.out.println("error al registrar " + e);
                }
            }
        }
    }

    private void registrarCitasinhora(HttpServletRequest request, HttpServletResponse response) {
        DaoServicio daose;
        Cita ci = null;
        Distrito dis;
        Marca mar;
        Aparato apa;
        if (request.getParameter("txridper") != null && request.getParameter("cbomarca") != null
                && request.getParameter("txtnroserie") != null && request.getParameter("txtdescripcion") != null
                && request.getParameter("cbodistrito") != null && request.getParameter("txtdireccion") != null) {
            ci = new Cita();
            ci.setId_persona(Integer.parseInt(request.getParameter("txridper")));
            System.out.println("ci id" + ci.getId_persona());
            mar = new Marca();
            mar.setId_marca(Integer.parseInt(request.getParameter("cbomarca")));
            apa = new Aparato();
            apa.setNroSerie(request.getParameter("txtnroserie"));
            apa.setDescAparato(request.getParameter("txtdescripcion"));
            apa.setMarca(mar);
            ci.setAparato(apa);
            dis = new Distrito();
            dis.setId_distrito(Integer.parseInt(request.getParameter("cbodistrito")));
            ci.setDiaDistrito(dis);
            ci.setDireccion(request.getParameter("txtdireccion"));
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime actual = LocalDateTime.now();
            String hora = actual.format(dtf);
            ci.setFecha_hora(hora);
            Horario horaa = new Horario();
            Tecnicos tecni = new Tecnicos();
            tecni.setId_tecn(Integer.parseInt(request.getParameter("txridtec")));
            System.out.println("llega aca registrarCitasinhora");
            horaa.setId_horario(Integer.parseInt(request.getParameter("txridhora")));
            horaa.setTecnico(tecni);
            System.out.println("el id horario es " + horaa.getId_horario());
            try {
                System.out.println("entro en el else");
                daose = new DaoServicio();
                daose.nuevoCitaHorario(ci, horaa);
                this.getServletConfig().getServletContext().getRequestDispatcher("/homeCliente.jsp").forward(request, response);
            } catch (Exception e) {
                System.out.println("error al registrar " + e);
            }
        } else {
            System.out.println("no entro al if");
        }
    }

    private void listarMisServicios(HttpServletRequest request, HttpServletResponse response) {
        DaoServicio daoc = new DaoServicio();
        List<Cita> cita = null;
        String i = request.getParameter("txtidper");
        System.out.println("el ip de mis servicio " + i);
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
            ci = new Cita();
            daoc = new DaoServicio();
            System.out.println(request.getParameter("txtidper"));
            ci.setId_persona(Integer.parseInt(request.getParameter("txtidper")));
            listarMisServicios(request, response);
        } catch (Exception e) {
            System.out.println("el error es id pers" + e);
        }

    }

    private void listarHorariosDni(HttpServletRequest request, HttpServletResponse response) {
        DaoEncargado daoc = new DaoEncargado();
        Persona per = new Persona();
        List<Horario> hour = null;
        try {
            per.setDni(request.getParameter("txtdnishear"));
            System.out.println(per.getDni());
            hour = daoc.horarioPorTecnico(per);
            request.setAttribute("listaHorarios", hour);
            System.out.println("lista horaios");
            System.out.println(hour);
        } catch (Exception e) {
            System.out.println("problema dispacher " + e);
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

    private void insertarHorario(HttpServletRequest request, HttpServletResponse response) {
        DaoEncargado daoc;
        Horario cli = null;
        Distrito dis;
        if (request.getParameter("selecEstado") != null && request.getParameter("inputfecha") != null
                && request.getParameter("inputHIni") != null && request.getParameter("inputHFin") != null) {
            cli = new Horario();
            cli.setEstado_activ(Boolean.parseBoolean(request.getParameter("selecEstado")));
            cli.setFecha(request.getParameter("inputfecha"));
            cli.setHoraini(request.getParameter("inputHIni"));
            cli.setHorafin(request.getParameter("inputHFin"));
            try {
                daoc = new DaoEncargado();
                daoc.ingresarHorario(cli);
                System.out.println("el estado cita " + cli.isEstado_activ());
                this.getServletConfig().getServletContext().getRequestDispatcher("/asignacionHorarios.jsp").forward(request, response);
            } catch (Exception e) {
                System.out.println("error al registrar " + e);
            }
        }
    }

    private void mostrarEspecialidad(HttpServletRequest request) {
        DaoEspecialidad daoS = new DaoEspecialidad();
        List<Especialidad> marc = null;
        try {
            marc = daoS.mostrarEspecialidades();
            request.setAttribute("especialidades", marc);
        } catch (SQLException e) {
            request.setAttribute("msje", e);
        } finally {
            marc = null;
            daoS = null;
        }
    }

    private void formRegistrarTecnico(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.distritos(request);
            this.mostrarEspecialidad(request);
            this.getServletConfig().getServletContext()
                    .getRequestDispatcher("/insertarTecnico.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msje", e);
        }
    }

    private void registrarTecnico(HttpServletRequest request, HttpServletResponse response) {
        DaoTecnico daot;
        Tecnicos tec = null;
        Distrito dis;
        Especialidad esp;
        if (request.getParameter("txtnombres") != null && request.getParameter("txtapellidos") != null
                && request.getParameter("txtdni") != null && request.getParameter("txttelefono1") != null
                && request.getParameter("txtemail") != null && request.getParameter("cbodistrito") != null
                && request.getParameter("txtdireccion") != null && request.getParameter("txtpassword") != null) {
            tec = new Tecnicos();
            tec.setNombres(request.getParameter("txtnombres"));
            tec.setApellidos(request.getParameter("txtapellidos"));
            tec.setDni(Integer.parseInt(request.getParameter("txtdni")));
            esp = new Especialidad();
            esp.setId_especia(Integer.parseInt(request.getParameter("cboespecia")));
            tec.setEspe(esp);
            dis = new Distrito();
            dis.setId_distrito(Integer.parseInt(request.getParameter("cbodistrito")));
            tec.setDistrito(dis);
            tec.setDireccion(request.getParameter("txtdireccion"));
            tec.setTelefono1(Integer.parseInt(request.getParameter("txttelefono1")));
            tec.setTelefono2(Integer.parseInt(request.getParameter("txttelefono2")));
            tec.setCorreo(request.getParameter("txtemail"));
            tec.setPassword(request.getParameter("txtpassword"));

            try {
                daot = new DaoTecnico();
                daot.nuevoTecnico(tec);
                response.sendRedirect("ServletValidar?accion=formRegisTecnico");
            } catch (Exception e) {
                System.out.println("error al registrar " + e);
            }
        } else {
            System.out.println("ocurrui un error");
        }
    }

    private void actualizarClient(HttpServletRequest request, HttpServletResponse response) {
        DaoCliente daoc;
        Cliente cli = null;
        Distrito dis;
        if (request.getParameter("txtnombres") != null && request.getParameter("txtapellidos") != null
                && request.getParameter("txtdni") != null && request.getParameter("txttelefono1") != null
                && request.getParameter("txtemail") != null && request.getParameter("cbodistrito") != null
                && request.getParameter("txtdireccion") != null && request.getParameter("txtpassword") != null) {
            cli = new Cliente();
            cli.setId_client(Integer.parseInt(request.getParameter("txtipcli")));
            cli.setNombres(request.getParameter("txtnombres"));
            cli.setApellidos(request.getParameter("txtapellidos"));
            cli.setDni(Integer.parseInt(request.getParameter("txtdni")));
            dis = new Distrito();
            dis.setId_distrito(Integer.parseInt(request.getParameter("cbodistrito")));
            cli.setDistrit(dis);
            cli.setDireccion(request.getParameter("txtdireccion"));
            cli.setTelefono1(Integer.parseInt(request.getParameter("txttelefono1")));
            cli.setTelefono2(Integer.parseInt(request.getParameter("txttelefono2")));
            cli.setCorreo(request.getParameter("txtemail"));
            cli.setPassword(request.getParameter("txtpassword"));

            try {
                daoc = new DaoCliente();
                daoc.actualizarCliente(cli);
                response.sendRedirect("ServletValidar?accion=listarclientes");
            } catch (Exception e) {
                System.out.println("error al registrar " + e);
            }
        }
    }

    private void leerClient(HttpServletRequest request, HttpServletResponse response) {
        DaoCliente daoc;
        Cliente cli;
        if (request.getParameter("idcliente") != null) {
            cli = new Cliente();
            cli.setId_client(Integer.parseInt(request.getParameter("idcliente")));
            daoc = new DaoCliente();
            try {
                cli = daoc.leerCliente(cli);
                if (cli != null) {
                    request.setAttribute("cliente", cli);
                } else {
                    request.setAttribute("msje", "No se encontro el Cliente");
                }
            } catch (Exception e) {
                System.out.println("el error al encontrar el cliente es " + e);
            }
        } else {
            request.setAttribute("msje", "No tiene el parametro necesario");
        }
        try {
            this.distritos(request);
            this.getServletConfig().getServletContext().getRequestDispatcher("/editar/editarCliente.jsp").forward(request, response);
            System.out.println("se envio a edita");
        } catch (Exception e) {
            System.out.println("erro de obtener cliente " + e);
        }
    }

    private void leerTecnic(HttpServletRequest request, HttpServletResponse response) {
        DaoTecnico daoc;
        Tecnicos cli;
        if (request.getParameter("idtecnico") != null) {
            cli = new Tecnicos();
            cli.setId_tecn(Integer.parseInt(request.getParameter("idtecnico")));
            System.out.println("id tecn " + cli.getId_tecn());
            daoc = new DaoTecnico();
            try {
                cli = daoc.leerTecnico(cli);
                if (cli != null) {
                    request.setAttribute("tecnico", cli);
                } else {
                    request.setAttribute("msje", "No se encontro el Tecnico");
                }
            } catch (Exception e) {
                System.out.println("el error al encontrar el tecnico es " + e);
            }
        } else {
            request.setAttribute("msje", "No tiene el parametro necesario");
        }
        try {
            this.distritos(request);
            this.mostrarEspecialidad(request);
            this.getServletConfig().getServletContext().getRequestDispatcher("/editar/editarTecnico.jsp").forward(request, response);
            System.out.println("se envio a edita");
        } catch (Exception e) {
            System.out.println("erro de obtener cliente " + e);
        }
    }

    private void actualizarTecnic(HttpServletRequest request, HttpServletResponse response) {
        DaoTecnico daot;
        Tecnicos tec = null;
        Distrito dis;
        Especialidad esp;
        if (request.getParameter("txtnombres") != null && request.getParameter("txtapellidos") != null
                && request.getParameter("txtdni") != null && request.getParameter("txttelefono1") != null
                && request.getParameter("txtemail") != null && request.getParameter("cbodistrito") != null
                && request.getParameter("txtdireccion") != null && request.getParameter("txtpassword") != null) {
            tec = new Tecnicos();
            tec.setId_tecn(Integer.parseInt(request.getParameter("txtiptecnic")));
            tec.setNombres(request.getParameter("txtnombres"));
            tec.setApellidos(request.getParameter("txtapellidos"));
            tec.setDni(Integer.parseInt(request.getParameter("txtdni")));
            esp = new Especialidad();
            esp.setId_especia(Integer.parseInt(request.getParameter("cboespecia")));
            tec.setEspe(esp);
            dis = new Distrito();
            dis.setId_distrito(Integer.parseInt(request.getParameter("cbodistrito")));
            tec.setDistrito(dis);
            tec.setDireccion(request.getParameter("txtdireccion"));
            tec.setTelefono1(Integer.parseInt(request.getParameter("txttelefono1")));
            tec.setTelefono2(Integer.parseInt(request.getParameter("txttelefono2")));
            tec.setCorreo(request.getParameter("txtemail"));
            tec.setPassword(request.getParameter("txtpassword"));

            try {
                daot = new DaoTecnico();
                daot.actualizarTecnico(tec);
                response.sendRedirect("ServletValidar?accion=formRegisTecnico");
            } catch (Exception e) {
                System.out.println("error al registrar " + e);
            }
        } else {
            System.out.println("ocurrui un error");
        }
    }

    private void listarHrariosServi(HttpServletRequest request, HttpServletResponse response) {
        DaoServicio daoh = new DaoServicio();
        List<Horario> selch;
        try {
            selch = daoh.listarHorarios();
            request.setAttribute("listahoraselct", selch);
            System.out.println("lista horarios servicio" + selch);
        } catch (Exception e) {
            request.setAttribute("msje", "no se puedo listar");
            System.out.println("eerro " + e);
        } finally {
            daoh = null;
        }
        try {
            System.out.println("entro en redireccion");
            this.getServletConfig().getServletContext().getRequestDispatcher("/seleccionarHorarios.jsp").forward(request, response);
        } catch (Exception e) {
        }
    }

    private void mostrarformCitasinFecha(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.marcas(request);
            this.distritos(request);

            this.getServletConfig().getServletContext()
                    .getRequestDispatcher("/citas/solicitarCitaSinH.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("--" + e);
            request.setAttribute("msje", e);
        }
    }

    private void leerSchedule(HttpServletRequest request, HttpServletResponse response) {
        DaoServicio daos;
        Horario hr;
        if (request.getParameter("idhorario") != null) {
            hr = new Horario();
            hr.setId_horario(Integer.parseInt(request.getParameter("idhorario")));
            System.out.println("id horario " + hr.getId_horario());
            daos = new DaoServicio();
            try {
                hr = daos.leerHorario(hr);
                if (hr != null) {
                    request.setAttribute("horario", hr);
                } else {
                    request.setAttribute("msje", "No se encontro el horario");
                }
            } catch (Exception e) {
                System.out.println("el error al encontrar el horaio es " + e);
            }
        } else {
            request.setAttribute("msje", "No tiene el parametro necesario");
        }
        try {
            this.distritos(request);
            this.marcas(request);
            this.mostrarEspecialidad(request);
            this.getServletConfig().getServletContext().getRequestDispatcher("/citas/solicitarCitaSinH.jsp").forward(request, response);
            System.out.println("se envio a edita");
        } catch (Exception e) {
            System.out.println("erro de obtener cliente " + e);
        }
    }

    private void listarTodosServicios(HttpServletRequest request, HttpServletResponse response) {
        DaoServicio daos = new DaoServicio();
        List<Servicio> serv = null;
        try {
            serv = daos.mostrarTodosServicios();
            request.setAttribute("listaServicios", serv);
            System.out.println("lista todos los servicios" + serv);
        } catch (Exception e) {
            request.setAttribute("msje", "no se puedo listar");
        } finally {
            daos = null;
        }
        try {
            System.out.println("entro en redireccion");
            this.getServletConfig().getServletContext().getRequestDispatcher("/mostrarServicios.jsp").forward(request, response);
        } catch (Exception e) {
        }
    }
    private void listarTodosServiciosDomicilio(HttpServletRequest request, HttpServletResponse response) {
        DaoServicio daos = new DaoServicio();
        List<Servicio> serv = null;
        try {
            serv = daos.mostrarTodosServiciosDomicilio();
            request.setAttribute("listaServicios", serv);
            System.out.println("lista todos los servicios-" + serv);
        } catch (Exception e) {
            request.setAttribute("msje", "no se puedo listar");
        } finally {
            daos = null;
        }
        try {
            System.out.println("entro en redireccion");
            this.getServletConfig().getServletContext().getRequestDispatcher("/mostrarServiciosDomicilio.jsp").forward(request, response);
        } catch (Exception e) {
        }
    }

    private void listarServiciosComple(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void listarTodosEspera(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void repuestos(HttpServletRequest request) {
        DaoRepuesto daor = new DaoRepuesto();
        List<Repuesto> repu = null;
        repu = daor.mostrarRepuestos();
        request.setAttribute("listarRepuestos", repu);
        repu = null;
        daor = null;
    }

    private void formCarritoServ(HttpServletRequest request, HttpServletResponse response) {
        try {
            lista = new ArrayList<>();
            request.setAttribute("lista", lista);
            this.repuestos(request);
            this.getServletConfig().getServletContext()
                    .getRequestDispatcher("/detallerServicio.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msje", e);
        }
    }
    
    private void formCarritoServDom(HttpServletRequest request, HttpServletResponse response) {
        try {
            lista = new ArrayList<>();
            request.setAttribute("lista", lista);
            this.repuestos(request);
            this.getServletConfig().getServletContext()
                    .getRequestDispatcher("/detallesServicioDomi.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msje", e);
        }
    }

    private void agregarCarrito(HttpServletRequest request) {
        int item = 0;
        int idr;
        int ids;
        String descrip;
        double costo = 0;
        int cantidad;
        double subtotal;
        item = item + 1;
        idr = Integer.parseInt(request.getParameter("txtidrepuesto2"));
        ids = idservicio;
        costo = Double.parseDouble(request.getParameter("txtcosto"));
        descrip = request.getParameter("txtdescripcion");
        cantidad = Integer.parseInt(request.getParameter("txtcantidad"));
        System.out.println(cantidad);
        subtotal = cantidad * costo;
        detalle = new Detalles();
        detalle.setId_repuesto(idr);
        detalle.setId_servicio(ids);
        detalle.setCosto(costo);
        detalle.setDescripcion(descrip);
        detalle.setCatidad(cantidad);
        detalle.setSubTotal(subtotal);
        lista.add(detalle);
        for (int i = 0; i < lista.size(); i++) {
            total = total + lista.get(i).getSubTotal();
        }
        System.out.println("id " + idservicio);
        request.setAttribute("totalpagar", total);
        request.setAttribute("lista", lista);
    }

    private void leerServicio(HttpServletRequest request, HttpServletResponse response) {
        DaoServicio daos;
        Servicio serv;
        if (request.getParameter("idservicio") != null) {
            serv = new Servicio();
            serv.setId_servicio(Integer.parseInt(request.getParameter("idservicio")));
            daos = new DaoServicio();
            try {
                serv = daos.leerServicio(serv);
                if (serv != null) {
                    request.setAttribute("servicio", serv);
                } else {
                    request.setAttribute("msje", "No se encontro el Servicio");
                }
            } catch (Exception e) {
                System.out.println("el error al encontrar el Servicio es " + e);
            }
        } else {
            request.setAttribute("msje", "No tiene el parametro necesario");
        }
        idservicio = Integer.parseInt(request.getParameter("idservicio"));
        System.out.println("id " + idservicio);
        try {
            this.getServletConfig().getServletContext().getRequestDispatcher("/detallerServicio.jsp").forward(request, response);
            System.out.println("se envio a edita");
        } catch (Exception e) {
            System.out.println("erro de obtener cliente " + e);
        }
    }
    
    private void leerServicioDomi(HttpServletRequest request, HttpServletResponse response) {
        DaoServicio daos;
        Servicio serv;
        if (request.getParameter("idservicio") != null) {
            serv = new Servicio();
            serv.setId_servicio(Integer.parseInt(request.getParameter("idservicio")));
            daos = new DaoServicio();
            try {
                serv = daos.leerServicio(serv);
                if (serv != null) {
                    request.setAttribute("servicio", serv);
                } else {
                    request.setAttribute("msje", "No se encontro el Servicio");
                }
            } catch (Exception e) {
                System.out.println("el error al encontrar el Servicio es " + e);
            }
        } else {
            request.setAttribute("msje", "No tiene el parametro necesario");
        }
        idservicio = Integer.parseInt(request.getParameter("idservicio"));
        System.out.println("id " + idservicio);
        try {
            this.getServletConfig().getServletContext().getRequestDispatcher("/detallesServicioDomi.jsp").forward(request, response);
            System.out.println("se envio a edita");
        } catch (Exception e) {
            System.out.println("erro de obtener cliente " + e);
        }
    }

    private void registrarDetallesServicio(HttpServletRequest request, HttpServletResponse response) {
        int idserv=idservicio;
        System.out.println("-----"+ idserv);
        double totald=total;
        detalle.setTotal(total);
        detalle.setEstado(false);
        DaoServicio daos=new DaoServicio();
        daos.completarServicio(idserv, totald);
        for (int i = 0; i < lista.size(); i++) {
            detalle=new Detalles();
            detalle.setId_repuesto(lista.get(i).getId_repuesto());
            detalle.setId_servicio(lista.get(i).getId_servicio());
            detalle.setCosto(lista.get(i).getCosto());
            detalle.setCatidad(lista.get(i).getCatidad());
            detalle.setSubTotal(lista.get(i).getSubTotal());
            daos.registrarDetalles(detalle);
        }
    }
    
    private void registrarDetallesServicioDomi(HttpServletRequest request, HttpServletResponse response) {
        int idserv=idservicio;
        System.out.println("-----"+ idserv);
        double totald=total;
        detalle.setTotal(total);
        detalle.setEstado(false);
        DaoServicio daos=new DaoServicio();
        daos.completarServicioDomi(idserv, totald);
        for (int i = 0; i < lista.size(); i++) {
            detalle=new Detalles();
            detalle.setId_repuesto(lista.get(i).getId_repuesto());
            detalle.setId_servicio(lista.get(i).getId_servicio());
            detalle.setCosto(lista.get(i).getCosto());
            detalle.setCatidad(lista.get(i).getCatidad());
            detalle.setSubTotal(lista.get(i).getSubTotal());
            daos.registrarDetallesDomi(detalle);
        }
    }

    private void cambiarEstado(HttpServletRequest request, HttpServletResponse response) {
        DaoServicio dao;
        Servicio servicio;
        try {
            dao = new DaoServicio();
            servicio = new Servicio();

            if (request.getParameter("cambiar").equals("activar")) {
                servicio.setEstado_activ(true);
            } else {
                servicio.setEstado_activ(false);
            }

            if (request.getParameter("cod") != null) {
                servicio.setId_servicio(Integer.parseInt(request.getParameter("cod")));
                dao.cambiarEstado(servicio);
            } else {
                request.setAttribute("msje", "No se obtuvo el id del usuario");
            }

        } catch (Exception e) {
            request.setAttribute("msje", e.getMessage());
        }
        this.listarTodosServicios(request, response);
    }
    
    private void cambiarEstadoDomi(HttpServletRequest request, HttpServletResponse response) {
        DaoServicio dao;
        Servicio servicio;
        try {
            dao = new DaoServicio();
            servicio = new Servicio();

            if (request.getParameter("cambiar2").equals("activar")) {
                servicio.setEstado_activ(true);
            } else {
                servicio.setEstado_activ(false);
            }

            if (request.getParameter("cod") != null) {
                servicio.setId_servicio(Integer.parseInt(request.getParameter("cod")));
                dao.cambiarEstadoDomi(servicio);
            } else {
                request.setAttribute("msje", "No se obtuvo el id del usuario");
            }

        } catch (Exception e) {
            request.setAttribute("msje", e.getMessage());
        }
        this.listarTodosServiciosDomicilio(request, response);
    }

    private void mostrarMisServicios(HttpServletRequest request, HttpServletResponse response) {
        DaoServicio daoc = new DaoServicio();
        List<Servicio> servicios = null;
        String i = request.getParameter("txtidper");
        System.out.println("el ip de mis servicio i" + i);
        try {
            servicios = daoc.misServiciosconhoraio(Integer.parseInt(i));
            request.setAttribute("listaServicios", servicios);
            System.out.println("lista servicios");
        } catch (Exception e) {
            System.out.println(e);
            request.setAttribute("msje", "no se puedo listar");
        } finally {
            daoc = null;
        }
        try {
            System.out.println("entro en redireccion");
            this.getServletConfig().getServletContext().getRequestDispatcher("/misServicios.jsp").forward(request, response);
        } catch (Exception e) {
        }
    }

    private void mostrarMisHorarios(HttpServletRequest request, HttpServletResponse response) {
        DaoTecnico daoh = new DaoTecnico();
        List<Servicio> selch;
        try {
            selch = daoh.listarMisHorarios(ideper);
            request.setAttribute("listahoraselct", selch);
            System.out.println("lista horarios servicio" + selch);
        } catch (Exception e) {
            request.setAttribute("msje", "no se puedo listar");
            System.out.println("eerro " + e);
        } finally {
            daoh = null;
        }
        try {
            System.out.println("entro en redireccion");
            this.getServletConfig().getServletContext().getRequestDispatcher("/seleccionarHorarios.jsp").forward(request, response);
        } catch (Exception e) {
        }
    }
}

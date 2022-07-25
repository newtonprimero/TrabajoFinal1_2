/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import config.Conexion;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;
import modelo.DaoCliente;
import modelo.DaoServicio;
import modelo.DaoTecnico;
import modelo.Detalles;
import modelo.Servicio;
import modelo.Tecnicos;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author USUARIO
 */
public class ServletGenerarReportes extends HttpServlet {

    Conexion cn = new Conexion();
    Connection con = cn.Conexion();
    static String idc;
    static String idt;
    static String inicio;
    static String fin; 
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
        String accion = request.getParameter("btnIngresar");
        switch (accion) {
            case "leerclientereporte":
                leerClient(request, response);
                        try {
                            System.out.println("entro en redireccion");
                            this.getServletConfig().getServletContext().getRequestDispatcher("/reporteClienteFiltros.jsp").forward(request, response);
                        } catch (Exception e) {
                        }
                break;
            case "leertecnicoreporte":
                leerTecnico(request, response);
                        try {
                            System.out.println("entro en redireccion");
                            this.getServletConfig().getServletContext().getRequestDispatcher("/reporteTecnicosFiltros.jsp").forward(request, response);
                        } catch (Exception e) {
                        }
                break;
            case "mostrarResulFiltros":
                fitroCliente(request, response);
                break;
            case "mostrarResulFiltrosTecnico":
                fitroTecnico(request, response);
                break;
            case "reporteporClienteFiltro":
                reporteporClienteFiltro(request,response);
                break;
            case "reporteporTecnicoFiltro":
                reporteporTecnicoFiltro(request, response);
                break;
            case "ReporteTecnico":
                this.reporteTecnico(request, response);
                break;
            case "ReporteCliente":
                this.reporteCliente(request, response);
                break;
            case "ReporteCita":
                this.reporteCita(request, response);
                request.getRequestDispatcher("homeCliente.jsp").forward(request, response);
                break;
            case "hojaServiciosTaller":
                this.reporteHojaTaller(request, response);
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

    private void reporteTecnico(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        ServletOutputStream out = response.getOutputStream();
        JasperReport report;
        String path = "C:\\Users\\USUARIO\\JaspersoftWorkspace\\MyReports\\Reportes\\reporteTecnicos.jasper";

        try {
            report = (JasperReport) JRLoader.loadObjectFromFile(path);
            InputStream logoEmpresa = this.getServletConfig()
                    .getServletContext()
                    .getResourceAsStream("D:\\Netbeans\\TrabajoFinal1_2\\src\\main\\webapp\\reportesJasper\\img\\logo_utp.png");

            Map parameters = new HashMap();
            parameters.put("logoEmpresa", logoEmpresa);

            JasperPrint jprint = JasperFillManager.fillReport(report, parameters, con);
            JasperExportManager.exportReportToPdfStream(jprint, out);
            out.flush();
            out.close();

        } catch (Exception e) {

        }
    }

    private void reporteCliente(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        ServletOutputStream out = response.getOutputStream();
        JasperReport report;
        String path = "C:\\Users\\USUARIO\\JaspersoftWorkspace\\MyReports\\Reportes\\reporteClientes2.jasper";

        try {
            report = (JasperReport) JRLoader.loadObjectFromFile(path);
            InputStream logoEmpresa = this.getServletConfig()
                    .getServletContext()
                    .getResourceAsStream("D:\\Netbeans\\TrabajoFinal1_2\\src\\main\\webapp\\reportesJasper\\img\\logo_utp.png");

            Map parameters = new HashMap();
            parameters.put("logoEmpresa", logoEmpresa);

            JasperPrint jprint = JasperFillManager.fillReport(report, parameters, con);
            JasperExportManager.exportReportToPdfStream(jprint, out);
            out.flush();
            out.close();

        } catch (Exception e) {

        }
    }

    private void reporteCita(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        ServletOutputStream out = response.getOutputStream();
        try {
            InputStream logoEmpresa = this.getServletConfig()
                    .getServletContext()
                    .getResourceAsStream("../reportesJasper/img/logo_utp.png"),
                    reporteEmpleado = this.getServletConfig()
                            .getServletContext()
                            .getResourceAsStream("reportesJasper/ReporteHojaServicioDomi.jasper");
            if (logoEmpresa != null && reporteEmpleado != null) {
                String jsonEmpleados = request.getParameter("lista"); //OJO
                Gson gson = new Gson();
                List<Detalles> reportesEmpleados = new ArrayList<>();
                List<Detalles> reportesEmpleados2 = new ArrayList<>();

                reportesEmpleados.add(new Detalles());
                reportesEmpleados2 = gson.fromJson(jsonEmpleados, new TypeToken<List<Detalles>>() {
                }.getType());
                reportesEmpleados.addAll(reportesEmpleados2);

                JasperReport report = (JasperReport) JRLoader.loadObject(reporteEmpleado);
                JRBeanArrayDataSource ds = new JRBeanArrayDataSource(reportesEmpleados.toArray());

                Map<String, Object> parameters = new HashMap();
                parameters.put("ds", ds);
                parameters.put("logoEmpresa", logoEmpresa);
                response.setContentType("application/pdf");
                response.addHeader("Content-disposition", "inline; filename=ReportesHojaServi.pdf");
                JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, ds);
                JasperExportManager.exportReportToPdfStream(jasperPrint, out);
                out.flush();
                out.close();
            } else {
                response.setContentType("text/plain");
                out.println("no se pudo generar el reporte");
                out.println("esto puede debrse a que la lista de datos no fue recibida o el archivo plantilla del reporte no se ha encontrado");
                out.println("contacte a soporte");
            }
        } catch (Exception e) {
            response.setContentType("text/plain");
            out.print("ocurrió un error al intentar generar el reporte:" + e.getMessage());
            e.printStackTrace();
        }
    }

    private void reporteHojaTaller(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletOutputStream out = response.getOutputStream();
        JasperReport report;
        String path = "C:\\Users\\USUARIO\\JaspersoftWorkspace\\MyReports\\ReporteHojaServcicio.jasper";
        String idServi=request.getParameter("idhoja");
        //String idServi="3";
        try {
            report = (JasperReport) JRLoader.loadObjectFromFile(path);
            InputStream logoEmpresa = this.getServletConfig()
                    .getServletContext()
                    .getResourceAsStream("D:\\Netbeans\\TrabajoFinal1_2\\src\\main\\webapp\\reportesJasper\\img\\logo_utp.png");
            Map parameters = new HashMap();
            parameters.put("paraIdServicio", idServi);

            JasperPrint jprint = JasperFillManager.fillReport(path, parameters, con);
            JasperExportManager.exportReportToPdfStream(jprint, out);
            out.flush();
            out.close();

        } catch (Exception e) {
            System.out.println("---"+e);
        }
        
    }
    private void leerClient(HttpServletRequest request, HttpServletResponse response) {
        DaoCliente daoc;
        Cliente cli;
        idc=request.getParameter("idcliente");
        System.out.println("id --"+idc);
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

    }
    private void fitroCliente(HttpServletRequest request, HttpServletResponse response){
        String ini=request.getParameter("inputfechaini");
        String fini=request.getParameter("inputfechafin");
        inicio=""+ini+"%";
        fin=""+fini+"%";
        System.out.println("ini"+inicio);
        String id=idc;
        
        
        DaoServicio daos=new DaoServicio();
        
        List<Servicio> serv = null;
        try {
            serv = daos.listaFiltros(ini, fini, id);
            request.setAttribute("listaServicios", serv);
            System.out.println("lista todos los servicios-" + serv);
            this.getServletConfig().getServletContext().getRequestDispatcher("/reporteClienteFiltros.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msje", "no se puedo listar");
        } finally {
            daos = null;
        }
        
        }

    private void reporteporClienteFiltro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletOutputStream out = response.getOutputStream();
        JasperReport report;
        String path = "C:\\Users\\USUARIO\\JaspersoftWorkspace\\MyReports\\Reportes\\reporteFiltrosClientes.jasper";
        String idServi=request.getParameter("idhoja");
        //String idServi="3";
        try {
            report = (JasperReport) JRLoader.loadObjectFromFile(path);
            InputStream logoEmpresa = this.getServletConfig()
                    .getServletContext()
                    .getResourceAsStream("D:\\Netbeans\\TrabajoFinal1_2\\src\\main\\webapp\\reportesJasper\\img\\logo_utp.png");
            Map parameters = new HashMap();
            parameters.put("paraIdCliente", idc);
            parameters.put("paraIni", inicio);
            parameters.put("paraFin", fin);

            JasperPrint jprint = JasperFillManager.fillReport(path, parameters, con);
            JasperExportManager.exportReportToPdfStream(jprint, out);
            out.flush();
            out.close();

        } catch (Exception e) {
            System.out.println("---"+e);
        }
    }
    private void leerTecnico(HttpServletRequest request, HttpServletResponse response) {
        DaoTecnico daoc;
        Tecnicos cli;
            idt=request.getParameter("idtecnico");
            
        System.out.println("id --"+idt);
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

    }
    private void fitroTecnico(HttpServletRequest request, HttpServletResponse response){
        String ini=request.getParameter("inputfechaini");
        String fini=request.getParameter("inputfechafin");
        inicio=""+ini+"%";
        fin=""+fini+"%";
        String id=idt;
        
        DaoServicio daos=new DaoServicio();
        
        List<Servicio> serv = null;
        try {
            serv = daos.listaFiltrosTecnico(ini, fini, id);
            request.setAttribute("listaServicios", serv);
            System.out.println("lista todos los servicios-" + serv);
            this.getServletConfig().getServletContext().getRequestDispatcher("/reporteTecnicosFiltros.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msje", "no se puedo listar");
        } finally {
            daos = null;
        }
        
        }

    private void reporteporTecnicoFiltro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletOutputStream out = response.getOutputStream();
        JasperReport report;
        String path = "C:\\Users\\USUARIO\\JaspersoftWorkspace\\MyReports\\Reportes\\reporteFiltrosporTecnicos.jasper";
        //String idServi="3";
        try {
            report = (JasperReport) JRLoader.loadObjectFromFile(path);
            InputStream logoEmpresa = this.getServletConfig()
                    .getServletContext()
                    .getResourceAsStream("D:\\Netbeans\\TrabajoFinal1_2\\src\\main\\webapp\\reportesJasper\\img\\logo_utp.png");
            Map parameters = new HashMap();
            System.out.println("ini "+inicio);
            
        System.out.println("++"+idt);
            parameters.put("paraIdTecnico", idt);
            parameters.put("paraIni", inicio);
            parameters.put("paraFin", fin);

            JasperPrint jprint = JasperFillManager.fillReport(path, parameters, con);
            JasperExportManager.exportReportToPdfStream(jprint, out);
            out.flush();
            out.close();

        } catch (Exception e) {
            System.out.println("---"+e);
        }
    }

}

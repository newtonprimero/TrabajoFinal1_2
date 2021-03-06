<%-- 
    Document   : mostrarClientes
    Created on : 22 may. 2022, 19:58:55
    Author     : USUARIO
--%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("usuario") != null) {
        System.out.println("stamos en mostrar jsp");
%>
<html lang="en">

    <head>
        <title>Taller UTP</title>
        <!-- HTML5 Shim and Respond.js IE10 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 10]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
          <![endif]-->
        <!-- Meta -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="description"
              content="Mega Able Bootstrap admin template made using Bootstrap 4 and it has huge amount of ready made feature, UI components, pages which completely fulfills any dashboard needs." />
        <meta name="keywords"
              content="bootstrap, bootstrap admin template, admin theme, admin dashboard, dashboard template, admin template, responsive" />
        <meta name="author" content="codedthemes" />
        <!-- Favicon icon -->
        <link rel="icon" href="assets/images/favicon.ico" type="image/x-icon">
        <!-- Google font-->
        <link href="https://fonts.googleapis.com/css?family=Roboto:400,500" rel="stylesheet">
        <!-- waves.css -->
        <link rel="stylesheet" href="assets/pages/waves/css/waves.min.css" type="text/css" media="all">
        <!-- Required Fremwork -->
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap/css/bootstrap.min.css">
        <!-- waves.css -->
        <link rel="stylesheet" href="assets/pages/waves/css/waves.min.css" type="text/css" media="all">
        <!-- themify icon -->
        <link rel="stylesheet" type="text/css" href="assets/icon/themify-icons/themify-icons.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" type="text/css" href="assets/icon/font-awesome/css/font-awesome.min.css">
        <!-- scrollbar.css -->
        <link rel="stylesheet" type="text/css" href="assets/css/jquery.mCustomScrollbar.css">
        <!-- am chart export.css -->
        <link rel="stylesheet" href="https://www.amcharts.com/lib/3/plugins/export/export.css" type="text/css"
              media="all" />
        <!-- Style.css -->
        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    </head>

    <body>
        <!-- Pre-loader start -->
        <div class="theme-loader">
            <%@include file="preloader/preloader.jsp" %>
        </div>
        <!-- Pre-loader end -->
        <div id="pcoded" class="pcoded">
            <div class="pcoded-overlay-box"></div>
            <div class="pcoded-container navbar-wrapper">
                <%@include file="navbar/navbar.jsp" %>

                <div class="pcoded-main-container">
                    <div class="pcoded-wrapper">
                        <%@include file="navbar/navbar2.jsp" %>
                        <div class="pcoded-content">
                            <!-- Page-header start -->
                            <div class="page-header">
                                <div class="page-block">
                                    <div class="row align-items-center">
                                        <div class="col-md-8">
                                            <div class="page-header-title">
                                                <h5 class="m-b-10">Mantenimiento T??cnicos</h5>
                                                <p class="m-b-0">Bienvenidos al sistema Taller UTP</p>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <ul class="breadcrumb-title">
                                                <li class="breadcrumb-item">
                                                    <a href="index.html"> <i class="fa fa-home"></i> </a>
                                                </li>
                                                <li class="breadcrumb-item"><a href="#!">Dashboard</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Page-header end -->

                            <!-- Hover table card start -->
                            <div class="card">
                                <div class="card-header">
                                    <h5>Tecnicos</h5>
                                    <span>Mantenimiento de <code>tecnicos</code> del taller</span>
                                    <div class="card-header-right">
                                        <ul class="list-unstyled card-option">
                                            <li><i class="fa fa fa-wrench open-card-option"></i></li>
                                            <li><i class="fa fa-window-maximize full-card"></i></li>
                                            <li><i class="fa fa-minus minimize-card"></i></li>
                                            <li><i class="fa fa-refresh reload-card"></i></li>
                                            <li><i class="fa fa-trash close-card"></i></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="card-block">
                                    <a href="ServletGenerarReportes?btnIngresar=ReporteTecnico" target="_blank">
                                        <button type="button" class="btn btn-primary waves-effect waves-light fa fa-print" data-toggle="modal" data-target="#staticBackdrop"  title="Seleccionar" data-original-title="Seleccionar" style="background: #771A1A; border-color: #771A1A;"> Inprimir</button>
                                    </a>
                                </div>
                                <div class="card-block table-border-style">
                                    <div class="table-responsive">
                                        <table class="table table-hover ">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Nombres Apellidos</th>
                                                    <th>DNI</th>
                                                    <th>Direccion</th>
                                                    <th>Telefonos</th>
                                                    <th>Correo</th>
                                                    <th>Especialidad</th>
                                                    <th>Estado</th>
                                                    <th>Fecha registro</th>
                                                    <th>Acci??n</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="tenico" items="${listaTecnico}" varStatus="status">
                                                    <tr>
                                                        <td>${status.index + 1}</td>
                                                        <td>${tenico.nombres} ${tenico.apellidos}</td>
                                                        <td>${tenico.dni}</td>
                                                        <td>${tenico.direccion}</td>
                                                        <td>${tenico.telefono1} - ${tenico.telefono2}</td>
                                                        <td>${tenico.correo}</td>
                                                        <td>${tenico.especialidad}</td>
                                                        <c:if test="${tenico.estado_activ == true}">
                                                            <td><span class="badge bg-green active" style="color: #000;background: #198754">T??cnico Activo </span></td>
                                                        </c:if>
                                                        <c:if test="${tenico.estado_activ == false}">
                                                            <td><span class="badge bg-red active" style="color: #000;background: #dc3545">T??cnico Inagtivo </span></td>
                                                        </c:if>
                                                        <td>${tenico.fecha_hora}</td>

                                                        <td>
                                                            <button type="button" class="btn btn-primary fa fa-times" data-toggle="tooltip"  title="Desabilitar" data-original-title="Desabilitar" style="background: #771A1A; border-color: #771A1A"></button>
                                                            <a href="<c:url value="ServletValidar">
                                                                   <c:param name="accion" value="leerTecnico" />
                                                                   <c:param name="idtecnico" value="${tenico.id_tecn}" />
                                                               </c:url>"><button type="button" class="btn btn-primary fa fa-pencil" data-toggle="modal" data-target="#staticBackdrop"  title="Editar" data-original-title="Editar" style="background: #771A1A; border-color: #771A1A"></button>
                                                            </a>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <!-- Hover table card end -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>
<%
    } else {
        System.out.println("nos cierra");
        response.sendRedirect("login.jsp");
    }
%>
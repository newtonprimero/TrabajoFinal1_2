<%-- 
    Document   : mostrarServicios
    Created on : 10 jun. 2022, 12:59:36
    Author     : USUARIO
--%>

<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("usuario") != null) {
        System.out.println("Estamos en mostrar jsp mostrar");
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
                <%@include file="navbar/navbar.jsp"%>

                <div class="pcoded-main-container">
                    <div class="pcoded-wrapper">
                        <% System.out.println("analisis nav bar");%>
                        <%@include file="navbar/navbar2.jsp" %>
                        <div class="pcoded-content">
                            <!-- Page-header start -->
                            <div class="page-header">
                                <div class="page-block">
                                    <div class="row align-items-center">
                                        <div class="col-md-8">
                                            <div class="page-header-title">
                                                <h5 class="m-b-10">Home</h5>
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
                                    <h5>Mis Solicitudes</h5>
                                    <span>Vista de mis <code>solicitudes</code> de visita a domicilio.</span>
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
                                <div class="card-block table-border-style">
                                    <div class="table-responsive">
                                        <form action="ServletValidar?accion=misservicios" method="post">
                                            <input id="prodId" name="txtidper" type="hidden" value="${usuario.id_persona}" >
                                            <button class="btn btn-primary waves-effect waves-light" type="submit" name="btnVUS" value="BUSCAR"> Mostrar Servicios </button>
                                            <button class="btn btn-primary waves-effect waves-light" type="submit" name="btnVUS" value="BUSCAR">Servicios completos</button>
                                            <button class="btn btn-primary waves-effect waves-light" type="submit" name="btnVUS" value="BUSCAR">Servicios en Espera</button>
                                        </form>
                                        <table class="table table-hover">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Nro cita</th>
                                                    <th>Datos Tecnico</th>
                                                    <th>Fecha</th>
                                                    <th>Descripción</th>
                                                    <th>Marca</th>
                                                    <th>Estado</th>
                                                    <th>Total</th>
                                                    <th>Accion</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="servicio" items="${listaServicios}" varStatus="status">
                                                    <tr>
                                                        <td>${status.index + 1}</td>
                                                        <td>${servicio.getCita().getId_cita()}</td>
                                                        <td>${servicio.getCita().getPerso().getNombres()} ${servicio.getCita().getPerso().getApellidos()}</td>
                                                        <td>${servicio.getCita().getFecha_hora()}</td>
                                                        <td>${servicio.getCita().getAparato().getDescAparato()}</td>
                                                        <td>${servicio.getCita().getAparato().getMarca().getDescripcion()}</td>
                                                        <c:if test="${servicio.estado_activ == true}">
                                                            <td><span class="badge bg-red active" style="color: #000;background: #dc3545 ">Servicio en proceso</span></td>
                                                        </c:if>
                                                        <c:if test="${servicio.estado_activ == false}">
                                                            <td><span class="badge bg-red active" style="color: #000;background: #198754">Servicio Completado</span></td>
                                                        </c:if>
                                                        <td>${servicio.getTotal()}</td>

                                                        <td>
                                                            <c:choose>
                                                                <c:when test="${servicio.estado_activ == true}">
                                                                    <input type="hidden" id="item" value="${servicio.id_servicio}">
                                                                    <a id="desactivarUsuario" href="ServletValidar?cambiar=desactivar&cod=${servicio.id_servicio}" >
                                                                        <button class="btn btn-primary fa fa-check" data-toggle="tooltip"  title="Designar completo" data-original-title="Designar completo" style="background: #771A1A; border-color: #771A1A"></button></a>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                    <input type="hidden" id="item" value="${servicio.id_servicio}">
                                                                    <a id="activarUsuario" href="ServletValidar?cambiar=activar&cod=${servicio.id_servicio}">
                                                                        <button class="btn btn-primary fa fa-times" data-toggle="tooltip"  title="Designar en proceso" data-original-title="Designar en proceso" style="background: #771A1A; border-color: #771A1A"></button></a>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            <a href="<c:url value="ServletValidar">
                                                                   <c:param name="accion" value="leerServicio" />
                                                                   <c:param name="idservicio" value="${servicio.id_servicio}" />
                                                               </c:url>"><button type="button" class="btn btn-primary fa fa-money" data-toggle="tooltip"  title="Completar" data-original-title="Completar" style="background: #771A1A; border-color: #771A1A"></button></a> 
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
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
        <!-- Date tables sheart -->
        <link rel="stylesheet" href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap4.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap4.min.js"></script>
        <!-- Date tables end -->
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
                        <c:if test="${usuario.id_rol==1}">
                            <%@include file="navbar/navbar3.jsp" %>
                        </c:if>
                        <c:if test="${usuario.id_rol==2}">
                            <%@include file="navbar/navbarTecnico2.jsp" %>
                        </c:if>
                        <div class="pcoded-content">
                            <!-- Page-header start -->
                            <div class="page-header">
                                <div class="page-block">
                                    <div class="row align-items-center">
                                        <div class="col-md-8">
                                            <div class="page-header-title">
                                                <h5 class="m-b-10">Generar Reporte</h5>
                                                <p class="m-b-0">Reportes por Cliente</p>
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
                                    <h5>Seleccione el Cliente</h5>
                                    <span>Para poder generar el <code>Reporte</code> de reparaciones.</span>
                                </div>
                                <div class="card-block table-border-style">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered" id="examplerr">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Nombres Apellidos</th>
                                                    <th>DNI</th>
                                                    <th>Telefono</th>
                                                    <th>Acción</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="cliente" items="${listaClientes}" varStatus="status">
                                                    <tr>
                                                        <td>${status.index + 1}</td>
                                                        <td>${cliente.nombres} ${cliente.apellidos}</td>
                                                        <td>${cliente.dni}</td>
                                                        <td>${cliente.telefono1}</td>
                                                        <td>
                                                            <a href="<c:url value="ServletGenerarReportes">
                                                                   <c:param name="btnIngresar" value="leerclientereporte" />
                                                                   <c:param name="idcliente" value="${cliente.id_client}" />
                                                               </c:url>"><button type="button" class="btn btn-primary fa fa-check-circle" data-toggle="modal" data-target="#staticBackdrop"  title="Seleccionar" data-original-title="Seleccionar" style="background: #771A1A; border-color: #771A1A"></button>
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
        <script src="./js/tables.js"></script>
    </body>

</html>
<%
    } else {
        System.out.println("nos cierra");
        response.sendRedirect("login.jsp");
    }
%>
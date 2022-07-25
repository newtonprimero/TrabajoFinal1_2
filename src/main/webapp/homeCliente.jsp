<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    if (session.getAttribute("usuario") != null) {%>

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

                <!-- navbar coomienzo-->
                <%@include file="navbar/navbar.jsp" %>    
                <!-- navbar fin-->
                <div class="pcoded-main-container">
                    <div class="pcoded-wrapper">

                        <!-- navbar2 coomienzo-->
                        <%@include file="navbar/navbarCliente.jsp" %>
                        <!-- navbar2 fin-->

                        <div class="pcoded-content">
                            <!-- Page-header start -->

                            <%@include file="cabecera/cabecera.jsp" %>
                            <!-- Page-header end -->
                            <div class="card">
                                <div class="col-md-12">
                                    <div class="card-header">
                                        <h5>Mis Servicios</h5>
                                        <span>Visualice de<code> actividades</code> que he realizado.</span>
                                    </div>
                                    <div class="card-block table-border-style">
                                        <div class="table-responsive">
                                            <form action="ServletValidar?accion=misservicios" method="post">
                                                <input id="prodId" name="txtidper" type="hidden" value="${usuario.id_persona}" >
                                                <button class="btn btn-primary waves-effect waves-light" type="submit" name="shear" value="citas" style="background: #771A1A; border-color: #771A1A;"> Mostrar Ciras</button>
                                                <button class="btn btn-primary waves-effect waves-light" type="submit" name="shear" value="misServi" style="background: #771A1A; border-color: #771A1A;"> Mostrar Servicios</button>
                                                <a href="ServletValidar?accion=listarhoraiosservi"><button class="btn btn-primary waves-effect waves-light" type="button" name="shear" value="misServi" style="background: #771A1A; border-color: #771A1A;">Solicitar Visita</button></a>
                                            </form>
                                            <table class="table table-hover">
                                                <thead>
                                                    <tr>
                                                        <th>#</th>
                                                        <th>Nro Serie</th>
                                                        <th>Marca</th>
                                                        <th>Descripción</th>
                                                        <th>Estado</th>
                                                        <th>Fecha Hora</th>
                                                        <th>Accion</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="cliente" items="${listaServicios}" varStatus="status">
                                                        <tr>
                                                            <td>${status.index + 1}</td>
                                                            <td>${cliente.getAparato().getNroSerie()}</td>
                                                            <td>${cliente.getAparato().getMarca().descripcion}</td>
                                                            <td>${cliente.getAparato().descAparato}</td>
                                                            <c:if test="${cliente.estado_activ == true}">
                                                                <td><span class="badge bg-green active" style="color: #000;background: #198754">Servicio en proceso</span></td>
                                                            </c:if>
                                                            <c:if test="${cliente.estado_activ == false}">
                                                                <td><span class="badge bg-red active" style="color: #000;background: #dc3545">Servicio en hecho</span></td>
                                                            </c:if>
                                                            <td>${cliente.fecha_hora}</td>

                                                            <td>
                                                                <button type="button" class="btn btn-primary fa fa-times" data-toggle="tooltip"  title="Desabilitar" data-original-title="Desabilitar" style="background: #771A1A; border-color: #771A1A"></button>
                                                                <button type="button" class="btn btn-primary fa fa-pencil" data-toggle="tooltip"  title="Editar" data-original-title="Editar" style="background: #771A1A; border-color: #771A1A"></button>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>

                                </div>
                            </div>
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
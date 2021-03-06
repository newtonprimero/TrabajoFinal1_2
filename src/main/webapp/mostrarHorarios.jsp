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

                <!-- navbar coomienzo-->
                <%@include file="navbar/navbar.jsp" %>    
                <!-- navbar fin-->
                <div class="pcoded-main-container">
                    <div class="pcoded-wrapper">

                        <!-- navbar2 coomienzo-->
                        <%@include file="navbar/navbar3.jsp" %>
                        <!-- navbar2 fin-->
                        <div class="card">
                            <div class="pcoded-content">
                                <!-- Page-header start -->
                                <div class="page-header">
                                    <div class="page-block">
                                        <div class="row align-items-center">
                                            <div class="col-md-8">
                                                <div class="page-header-title">
                                                    <h5 class="m-b-10">Mostrar Horarios</h5>
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

                                <div class="col-md-12">
                                    <div class="container-fluid">
                                        <div class="row">
                                            <div class="card-block">
                                                <a href="ServletHorarios?btnBuscar=horariosHoy" >
                                                    <button type="button" class="btn btn-primary waves-effect waves-light fa fa-calendar" title="Seleccionar" data-original-title="Seleccionar" style="background: #771A1A; border-color: #771A1A;"> Hoy</button>
                                                </a>
                                                <a href="ServletHorarios?btnBuscar=horariosManana">
                                                    <button type="button" class="btn btn-primary waves-effect waves-light fa fa-calendar" data-toggle="modal" data-target="#staticBackdrop"  title="Seleccionar" data-original-title="Seleccionar" style="background: #771A1A; border-color: #771A1A;"> Ma??ana</button>
                                                </a>
                                                <a href="ServletHorarios?btnBuscar=horariosTodosSemana">
                                                    <button type="button" class="btn btn-primary waves-effect waves-light fa fa-calendar" data-toggle="modal" data-target="#staticBackdrop"  title="Seleccionar" data-original-title="Seleccionar" style="background: #771A1A; border-color: #771A1A;"> Todos</button>
                                                </a>
                                            </div>
                                            <!-- Hover table card start -->
                                            <div class="col-sm-10">
                                                <div class="card">
                                                    <div class="card-header">
                                                        <h5>Horario</h5>
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
                                                            <table class="table table-hover" >
                                                                <thead>
                                                                    <tr>
                                                                        <th>#</th>
                                                                        <th>Apellidos</th>
                                                                        <th>Dni</th>
                                                                        <th>Fecha</th>
                                                                        <th>Hora Inicio</th>
                                                                        <th>Hora Fin</th>
                                                                        <th>Estado</th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <c:forEach var="hoarios" items="${listaHorarios}" varStatus="status">
                                                                        <tr>
                                                                            <td>${status.index + 1}</td>
                                                                            <td>${hoarios.getTecnico().apellidos}</td>
                                                                            <td>${hoarios.getTecnico().dni}</td>
                                                                            <td>${hoarios.fecha}</td>
                                                                            <td>${hoarios.horaini}</td>
                                                                            <td>${hoarios.horafin}</td>
                                                                            <c:if test="${hoarios.estado_activ == true}">
                                                                                <td><span class="badge bg-green active" style="color: #fff;background: #198754">Activo </span></td>
                                                                            </c:if>
                                                                            <c:if test="${hoarios.estado_activ == false}">
                                                                                <td><span class="badge bg-red active" style="color: #000;background: #dc3545">Concluido </span></td>
                                                                            </c:if>
                                                                        </tr>
                                                                    </c:forEach>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Hover table card end -->
                                            <!-- end of col-sm-12 -->
                                        </div>
                                        <!-- end of row -->
                                    </div>

                                </div>

                            </div>
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
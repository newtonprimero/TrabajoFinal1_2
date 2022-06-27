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
        
        <style>
            @media print{
                .parte1{
                    display: none;
                }
                .pcoded-navbar{
                    display: none;
                }
            }
        </style>
    </head>

    <body>
        <!-- Pre-loader start -->
        <div class="theme-loader parte1">
            <%@include file="preloader/preloader.jsp" %>
        </div>
        <!-- Pre-loader end -->
        <div id="pcoded" class="pcoded">
            <div class="pcoded-overlay-box"></div>
            <div class="pcoded-container navbar-wrapper">
                <div class="parte1">
                <%@include file="navbar/navbar.jsp"%>
                </div>
                <div class="pcoded-main-container">
                    <div class="pcoded-wrapper">
                        <div class="parte1">
                        <% System.out.println("analisis nav bar");%>
                        <c:if test="${usuario.id_rol==1}">
                            <%@include file="navbar/navbar2.jsp" %>
                        </c:if>
                        <c:if test="${usuario.id_rol==2}">
                            <%@include file="navbar/navbarTecnico.jsp" %>
                        </c:if>
                        </div>
                        <div class="pcoded-content">
                            <!-- Page-header start -->
                            <div class="page-header parte1">
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
                            <div class="col-md-12">
                                <div class="container-fluid">
                                    <div class="row">
                                        <div class="col-sm-8">
                                            <form class="md-float-material form-material">

                                                <div class="auth-box card">
                                                    <div class="card-block">
                                                        <div class="row m-b-20">
                                                            <div class="col-md-12">
                                                                <h3 class="text-center txt-primary">Hoja de Servicios ${hoja.id_hoja}</h3>
                                                            </div>
                                                        </div>
                                                        <div class="form-group form-primary">
                                                            <strong><p class="text-left" style="font-size: 15px;">Datos Cliente</p></strong>
                                                        </div>
                                                        <div class="form-group form-primary">
                                                            <input type="text" name="user-name" class="form-control"
                                                                   required="" disabled value="${servicio.getCita().getPerso().nombres}">
                                                            <span class="form-bar">Nombres</span>
                                                            <label class="float-label"></label>
                                                        </div>
                                                        <div class="form-group form-primary">
                                                            <input type="text" name="user-name" class="form-control"
                                                                   required="" disabled value="${servicio.getCita().getPerso().apellidos}">
                                                            <span class="form-bar">Apellidos</span>
                                                            <label class="float-label"></label>
                                                        </div>
                                                        <div class="form-group form-primary">
                                                            <input type="text" name="user-name" class="form-control"
                                                                   required="" value="${servicio.getCita().direccion}">
                                                            <span class="form-bar"></span>
                                                            <label class="float-label">Direccion</label>
                                                        </div>
                                                        <div class="form-group form-primary row">
                                                            <div class="form-group col-sm-6" >
                                                                <input type="text" name="user-name" class="form-control"
                                                                       required="" disabled value="${servicio.getCita().getPerso().telefono}">
                                                                <span class="form-bar">Telefono</span>
                                                                <label class="float-label" style="margin-left:15px ;"></label>   
                                                            </div>
                                                            <div class="form-group col-sm-6" >
                                                                <input type="text" name="user-name" class="form-control"
                                                                       required="" disabled value="${servicio.getCita().getPerso().telefono2}">
                                                                <span class="form-bar">Telefono Opcional</span>
                                                                <label class="float-label" style="margin-left:15px ;"></label>   
                                                            </div>
                                                        </div>
                                                        <div class="form-group form-primary">
                                                            <strong><p class="text-left" style="font-size: 15px;">Datos Electrodomestico</p></strong>
                                                        </div>
                                                        <div class="form-group form-primary row">
                                                            <div class="form-group col-sm-6" >
                                                                <input type="text" name="user-name" class="form-control"
                                                                       required="" disabled value="${servicio.getCita().getAparato().getMarca().descripcion}">
                                                                <span class="form-bar">Marca</span>
                                                                <label class="float-label" style="margin-left:15px ;"></label>   
                                                            </div>
                                                            <div class="form-group col-sm-6" >
                                                                <input type="text" name="user-name" class="form-control"
                                                                       required="">
                                                                <span class="form-bar"></span>
                                                                <label class="float-label" style="margin-left:15px ;">Modelo</label>   
                                                            </div>
                                                        </div>
                                                        <div class="form-group form-primary row">
                                                            <div class="form-group col-sm-6" >
                                                                <input type="text" name="user-name" class="form-control"
                                                                       required="" disabled value="${servicio.getCita().getAparato().nroSerie}">
                                                                <span class="form-bar">Nro serie</span>
                                                                <label class="float-label" style="margin-left:15px ;"></label>   
                                                            </div>
                                                        </div>
                                                        <div class="form-group form-primary">
                                                            <strong><p class="text-left" style="font-size: 15px;">Datos del Servicio</p></strong>
                                                        </div>
                                                        <div class="form-group form-primary row">
                                                            <div class="form-group col-sm-6" >
                                                                <label class="col-sm-3" style="margin-left:15px ;">Fecha</label> 
                                                                <input type="date" name="txtFecha" class="form-control col-sm-6"
                                                                       required="" value="${servicio.getHorario().fecha}">
                                                                <span class="form-bar"></span>
                                                            </div>
                                                            <div class="form-group col-sm-6" >
                                                                <input type="text" name="txtTotal" class="form-control"
                                                                       required="" value="${servicio.getTotal()}">
                                                                <span class="form-bar"></span>
                                                                <label class="float-label" style="margin-left:15px ;">Monto</label>   
                                                            </div>
                                                        </div>
                                                        <div class="form-group form-primary">
                                                            <textarea type="text" name="user-name" class="form-control"
                                                                      required="" >${servicio.getCita().getAparato().getDescAparato()}</textarea>
                                                            <span class="form-bar"></span>
                                                            <label class="float-label">Descripción</label>
                                                        </div>
                                                        <div class="form-group form-primary">
                                                            <input type="text" name="user-name" class="form-control"
                                                                   required="">
                                                            <span class="form-bar"></span>
                                                            <label class="float-label">Repuestos usados</label>
                                                        </div>

                                                        <div class="row m-t-30">
                                                            <div class="col-md-4">
                                                                <a href="<c:url value="ServletValidar">
                                                                    <c:param name="accion" value="listarServiciosDomicilio" />
                                                                    </c:url>">
                                                                <button type="button" class="btn btn-primary btn-md btn-block waves-effect text-center m-b-20" data-dismiss="modal">Cancelar</button>
                                                                </a>
                                                            </div><div class="col-md-4">
                                                                <button type="button"
                                                                        class="btn btn-success btn-md btn-block waves-effect text-center m-b-20" onclick="print()">Guardar</button>
                                                            </div>
                                                        </div>
                                                        <hr />
                                                        <div class="row">
                                                            <div class="col-md-10">
                                                                <p class="text-inverse text-left m-b-0">Todas las hojas de servicio estan bajo revicion del encargado.</p>
                                                                <p class="text-inverse text-left"><a
                                                                        href="index.html"><b>Regresar a Inicio</b></a></p>
                                                            </div>
                                                            <div class="col-md-2">
                                                                <img src="assets/images/auth/Logo-small-bottom.png"
                                                                     alt="small-logo.png">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                        <!-- end of col-sm-12 -->
                                    </div>
                                    <!-- end of row -->
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
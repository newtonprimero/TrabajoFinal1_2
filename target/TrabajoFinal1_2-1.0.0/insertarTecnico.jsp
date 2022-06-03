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
            <%@include file="navbar/navbar.jsp" %>

            <div class="pcoded-main-container">
                <div class="pcoded-wrapper">
                        <c:if test="${usuario.id_rol==1}">
                            <%@include file="navbar/navbar2.jsp" %>
                        </c:if>
                        <c:if test="${usuario.id_rol==2}">
                            <%@include file="navbar/navbarTecnico.jsp" %>
                        </c:if>
                    <div class="pcoded-content">
                        <!-- Page-header start -->
                        <div class="page-header">
                            <div class="page-block">
                                <div class="row align-items-center">
                                    <div class="col-md-8">
                                        <div class="page-header-title">
                                            <h5 class="m-b-10">Registrar Tecnico</h5>
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
                                    <div class="col-sm-6">
                                        <form class="md-float-material form-material" action="ServletValidar?accion=registrarTecnico" method="post">

                                            <div class="auth-box card">
                                                <div class="card-block">
                                                    <div class="row m-b-20">
                                                        <div class="col-md-12">
                                                            <h3 class="text-center txt-primary">Registrar Técnico</h3>
                                                        </div>
                                                    </div>
                                                    <h4 class="sub-title">Datos Personales</h4>
                                                    <div class="form-group form-primary">
                                                        <input type="text" name="txtnombres" class="form-control"
                                                            required="">
                                                        <span class="form-bar"></span>
                                                        <label class="float-label">Nombres</label>
                                                    </div>
                                                    <div class="form-group form-primary">
                                                        <input type="text" name="txtapellidos" class="form-control"
                                                            required="">
                                                        <span class="form-bar"></span>
                                                        <label class="float-label">Apellidos</label>
                                                    </div>
                                                    <div class="form-group form-primary">
                                                        <input type="number" name="txtdni" class="form-control"
                                                            required="">
                                                        <span class="form-bar"></span>
                                                        <label class="float-label">DNI</label>
                                                    </div>
                                                    <h4 class="sub-title">Datos especialidad</h4>
                                                    <div class="form-group form-primary">
                                                        <input type="hidden" name="email" class="form-control"
                                                            >
                                                        <span class="form-bar">Seleccione Especialidad</span>
                                                        <select name="cboespecia" class="form-control" >
                                                            <option value="0">Seleccione Especialidad</option>
                                                            <c:forEach items="${especialidades}" var="marc">
                                                                <option value="${marc.id_especia}" 
                                                                    <c:if test="${marc.id_especia == 
                                                                      Tecnicos.especia.id_especia}">
                                                                    selected
                                                                    </c:if>>
                                                                    ${marc.descrip}
                                                                </option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <h4 class="sub-title">Datos de contacto</h4>
                                                    <div class="form-group form-primary row">
                                                        <div class="form-group col-sm-6" >
                                                            <input type="number" name="txttelefono1" class="form-control"
                                                                required="">
                                                            <span class="form-bar"></span>
                                                            <label class="float-label" style="margin-left:15px ;">Telefono</label>   
                                                        </div>
                                                        <div class="form-group col-sm-6" >
                                                            <input type="number" name="txttelefono2" class="form-control"
                                                                   required="" value="0">
                                                            <span class="form-bar"></span>
                                                            <label class="float-label" style="margin-left:15px ;">Telefono Opcional</label>   
                                                        </div>
                                                    </div>
                                                    <div class="form-group form-primary">
                                                        <input type="hidden" name="email" class="form-control"
                                                            >
                                                        <span class="form-bar">Seleccione distrito</span>
                                                        <select name="cbodistrito" class="form-control" >
                                                            <option value="0">Seleccione su distrito</option>
                                                            <c:forEach items="${distritos}" var="distr">
                                                                <option value="${distr.id_distrito}" 
                                                                    <c:if test="${distr.id_distrito == 
                                                                      cliente.distrit.id_distrito}">
                                                                    selected
                                                                    </c:if>>
                                                                    ${distr.nombreDistrito}
                                                                </option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <div class="form-group form-primary">
                                                        <input type="text" name="txtdireccion" class="form-control"
                                                            required="">
                                                        <span class="form-bar"></span>
                                                        <label class="float-label">Dirección</label>
                                                    </div>
                                                    <h4 class="sub-title">Datos Usuario</h4>
                                                    <div class="form-group form-primary">
                                                        <input type="email" name="txtemail" class="form-control"
                                                            required="">
                                                        <span class="form-bar"></span>
                                                        <label class="float-label">Email</label>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-sm-8">
                                                            <div class="form-group form-primary">
                                                                <input type="password" name="txtpassword"
                                                                    class="form-control" required="">
                                                                <span class="form-bar"></span>
                                                                <label class="float-label">Password</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-8">
                                                            <div class="form-group form-primary">
                                                                <input type="password" name="txtpassword2"
                                                                    class="form-control" required="">
                                                                <span class="form-bar"></span>
                                                                <label class="float-label">Confirmar Password</label>
                                                            </div>
                                                        </div>
                                                    </div>  

                                                    <div class="row m-t-30">
                                                        <div class="col-md-12">
                                                            <button type="submit"
                                                                class="btn btn-primary btn-md btn-block waves-effect text-center m-b-20" name="btnRegistrar" value="Registrar">Guardar</button>
                                                        </div>
                                                    </div>
                                                    <hr />
                                                </div>
                                            </div>
                                        </form>
                                    </div>
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
</body>
</html>
<%
    } else {
        System.out.println("nos cierra");
        response.sendRedirect("login.jsp");
    }
%>


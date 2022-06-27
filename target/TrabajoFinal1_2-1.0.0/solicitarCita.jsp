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

                            <%@include file="cabecera/cabeceraVisita.jsp" %>
                            <!-- Page-header end -->

                            <div class="col-md-12">
                                <div class="container-fluid">
                                    <div class="row">
                                        <div class="col-sm-7">
                                            <form class="md-float-material form-material" action="ServletValidar?accion=registrarcita" method="post">

                                                <div class="auth-box card">
                                                <div class="card-block">
                                                    <div class="row m-b-20">
                                                        <div class="col-md-12">
                                                            <h3 class="text-center txt-primary">Solicitar Visita</h3>
                                                        </div>
                                                    </div>
                                                    <div class="form-group form-static-label">
                                                        <input id="prodId" name="txridper" type="hidden" value="${usuario.id_persona}">
                                                        <input type="text" name="txtnombres" class="form-control"
                                                               required="" disabled value="${usuario.getNombreUsuario()}">
                                                        <span class="float-label"></span>
                                                        <label class="float-label">Nombres</label>
                                                    </div>
                                                    <div class="form-group form-static-label">
                                                        <input type="text" name="txtapellidos" class="form-control"
                                                               required="" value="${usuario.getApellidos()}" disabled>
                                                        <span class="form-bar"></span>
                                                        <label class="float-label">Apellidos</label>
                                                    </div>
                                                    <h4 class="sub-title">Datos Aparato</h4>
                                                    <div class="form-group form-primary">
                                                        <input type="hidden" name="email" class="form-control"
                                                            >
                                                        <span class="form-bar">Seleccione Marca</span>
                                                        <select name="cbomarca" class="form-control" >
                                                            <option value="0">Seleccione Marca</option>
                                                            <c:forEach items="${marcas}" var="marc">
                                                                <option value="${marc.id_marca}" 
                                                                    <c:if test="${distr.id_distrito == 
                                                                      cliente.distrit.id_distrito}">
                                                                    selected
                                                                    </c:if>>
                                                                    ${marc.descripcion}
                                                                </option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <div class="form-group form-primary row">
                                                        <div class="form-group col-sm-6" >
                                                            <input type="text" name="txtnroserie" class="form-control"
                                                                required="">
                                                            <span class="form-bar"></span>
                                                            <label class="float-label" style="margin-left:15px ;">nro Serie</label>   
                                                        </div>
                                                    </div>
                                                    <div class="form-group form-static-label">
                                                        <textarea class="form-control" id="id" name="txtdescripcion" rows="3" cols="10"></textarea>
                                                        <span class="float-label"></span>
                                                        <label class="float-label" style="font-size: 13px">Describa el problema del aparato</label>
                                                    </div>
                                                    <h4 class="sub-title">Datos Locación</h4>
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
                                                    <input type="hidden" name="txtpresupuesto" value="0.0">
                                                    <div class="form-group form-primary">
                                                        <input type="text" name="txtdireccion" class="form-control"
                                                            required="">
                                                        <span class="form-bar"></span>
                                                        <label class="float-label">Dirección</label>
                                                    </div>
                                                    <h4 class="sub-title">Seleccione de horaio visita</h4>
                                                    <div class="form-group form-primary">
                                                        <div class="form-group col-sm-10" >
                                                            <label class="col-sm-3" style="margin-left:15px ;">Fecha</label> 
                                                            <input type="datetime-local" name="inputfecha" class="form-control col-sm-6"
                                                                required="">
                                                            <span class="form-bar">La hora seleccionada se tomara como referencia para la visira.</span>
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

                                        <!-- Hover table card start -->
                                        
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

    </body>

</html>
<%
    } else {
        System.out.println("nos cierra");
        response.sendRedirect("login.jsp");
    }
%>

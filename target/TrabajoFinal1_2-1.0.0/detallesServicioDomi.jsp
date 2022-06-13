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

                        <div class="pcoded-content">
                            <!-- Page-header start -->

                            <%@include file="cabecera/cabeceradetalles.jsp" %>
                            <!-- Page-header end -->
                            <div class="pcoded-inner-content">
                                <!-- Main-body start -->
                                <div class="main-body">
                                    <div class="page-wrapper">
                                        <form action="ServletValidar?accion=nuevoRepuestoDomi" class="form-material" novalidate method="post">
                                            <!-- Page body start -->
                                            <div class="page-body">
                                                <div class="row">
                                                    <div class="col-md-5">
                                                        <div class="card">
                                                            <div class="card-header">
                                                                <h5>Agregar Repuesto al servicio</h5>
                                                                <!--<span>Add class of <code>.form-control</code> with <code>&lt;input&gt;</code> tag</span>-->
                                                            </div>
                                                            <div class="card-block">
                                                                <div class="form-group row">
                                                                    <div class="col-sm-8">
                                                                        <input type="hidden"  name="name">
                                                                        <div class="form-group form-default">
                                                                            <input type="hidden" name="txtidServi" value="${servicio.id_servicio}">
                                                                            <input type="text" name="txtidrepuesto" class="form-control" required="">
                                                                            <span class="form-bar"></span>
                                                                            <label class="float-label">ID Repuesto</label>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-sm-4">
                                                                        <button type="submit" name="shear" value="buscarRepuesto" class="btn waves-effect waves-light btn-primary btn-block">Buscar</button>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group form-default">
                                                                    <input type="hidden" name="txtidrepuesto2" class="form-control" value="${repuesto.id_repuesto}">
                                                                    <input type="hidden" name="txtdescripcion"  class="form-control" value="${repuesto.nombre_repuesto}">
                                                                    <input type="text" name="txtdescripcions" disabled class="form-control" value="${repuesto.nombre_repuesto}">
                                                                    <span class="form-bar">Descripción</span>
                                                                    <label class="float-label"></label>
                                                                </div>
                                                                <div class="form-group row">
                                                                    <div class="col-sm-6">
                                                                        <div class="form-group form-default">
                                                                            <input type="hidden" name="txtcosto" class="form-control" value="${repuesto.precio}">
                                                                            <input type="number" name="txtcostos" disabled class="form-control" value="${repuesto.precio}">
                                                                            <span class="form-bar">Costo</span>
                                                                            <label class="float-label"></label>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-sm-3">
                                                                        <div class="form-group form-default">
                                                                            <input type="number" name="txtcantidad" class="form-control" required="" value="1">
                                                                            <span class="form-bar"></span>
                                                                            <label class="float-label">Cantidad</label>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-sm-3">
                                                                        <div class="form-group form-default">
                                                                            <input type="number" name="txtstock" disabled class="form-control" value="${repuesto.cantidad}">
                                                                            <span class="form-bar">Stock</span>
                                                                            <label class="float-label"></label>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                                                                    <div class="col-sm-4">
                                                                        <button type="submit" name="shear" value="agregarRepuesto" class="btn waves-effect waves-light btn-primary btn-block col-sm-12" >Agregar</button>
                                                                    </div>

                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-7">
                                                        <div class="card">
                                                            <div class="card-header">
                                                                <h5>Detalles de Servicios</h5>
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
                                                                    <table class="table table-hover">
                                                                        <thead>
                                                                            <tr>
                                                                                <th>NRO</th>
                                                                                <th>Codigo</th>
                                                                                <th>Descripcion</th>
                                                                                <th>Monto</th>
                                                                                <th>Cantidad</th>
                                                                                <th>Subtotal</th>
                                                                                <th>Acción</th>
                                                                            </tr>
                                                                        </thead>
                                                                        <tbody>
                                                                            <c:forEach var="list" items="${lista}" varStatus="status">
                                                                            <tr>
                                                                                <td>${status.index+1}</td>
                                                                                <td>${list.id_repuesto}</td>
                                                                                <td>${list.descripcion}</td>
                                                                                <td>${list.costo}</td>
                                                                                <td>${list.catidad}</td>
                                                                                <td>${list.subTotal}</td>
                                                                                <td><button class="btn btn-primary fa fa-trash" style="background: #771A1A; border-color: #771A1A"></button></td>
                                                                            </tr>
                                                                            </c:forEach>
                                                                        </tbody>
                                                                    </table>
                                                                    <div class="row col-sm-12" style="text-align: right;">
                                                                        <p class="col-sm-10">Total:</p>
                                                                        <input type="hidden" name="txttotal" class="form-control col-sm-2" value="${totalpagar}" placeholder="col">
                                                                        <input type="text" class="form-control col-sm-2" value="${totalpagar}" placeholder="col" disabled>
                                                                    </div>
                                                                    <div class="d-grid gap-2 d-md-flex justify-content-md-end " style="margin-top: 4px;">
                                                                        <a href="ServletValidar?accion=listarServiciosDomicilio" class=" col align-self-end btn btn-danger col-sm-3">Procesar</a> 
                                                                        <a href="ServletValidar?accion=nuevoRepuestoDomi&shear=procesar" class=" col align-self-end btn btn-success col-sm-3">Procesar</a> 
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </form>
                                        <div class="col-sm-12">
                                            <div class="card">
                                                <div class="card-header">
                                                    <h5>Repuestos disponibles</h5>
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
                                                        <table class="table table-striped table-bordered" id="examplerr">
                                                            <thead>
                                                                <tr>
                                                                    <th>ID</th>
                                                                    <th>Nombre</th>
                                                                    <th>Cantidad</th>
                                                                    <th>Precio</th>
                                                                    <th>Marca</th>
                                                                    <th>Estado</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <c:forEach var="repuesto" items="${listarRepuestos}" varStatus="status">
                                                                    <tr>
                                                                        <td>${repuesto.id_repuesto}</td>
                                                                        <td>${repuesto.nombre_repuesto}</td>
                                                                        <td>${repuesto.cantidad}</td>
                                                                        <td>S/.${repuesto.precio}</td>
                                                                        <td>${repuesto.nombre_marca}</td>
                                                                        <c:if test="${repuesto.estado_actv == true}">
                                                                            <td><span class="badge bg-green active" style="color: #000;background: #198754">Repuesto Activo </span></td>
                                                                        </c:if>
                                                                        <c:if test="${repuesto.estado_actv == false}">
                                                                            <td><span class="badge bg-red active" style="color: #000;background: #dc3545">Repuesto Inagtivo </span></td>
                                                                        </c:if>
                                                                        
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
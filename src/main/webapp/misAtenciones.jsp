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
                        <%@include file="navbar/navbarTecnico2.jsp" %>
                        <!-- navbar2 fin-->

                        <div class="pcoded-content">
                            <!-- Page-header start -->

                            <%@include file="cabecera/cabecera.jsp" %>
                            <!-- Page-header end -->

                            <div class="card">
                                <div class="card-header">
                                    <h5>Mis Servicios Realizados</h5>
                                    <span>Visualice de<code> servicios</code> que he realizado.</span>
                                </div>
                                <div class="card-block">
                                    <a href="ServletValidar?accion=mostrarMisAtenciones" >
                                        <button type="button" class="btn btn-primary waves-effect waves-light" data-toggle="modal" data-target="#staticBackdrop"  title="Seleccionar" data-original-title="Seleccionar" style="background: #771A1A; border-color: #771A1A;">Todos Servicios</button>
                                    </a>
                                    <a href="ServletValidar?accion=mostrarMisAtencionesPen">
                                        <button type="button" class="btn btn-primary waves-effect waves-light" data-toggle="modal" data-target="#staticBackdrop"  title="Seleccionar" data-original-title="Seleccionar" style="background: #771A1A; border-color: #771A1A;">Servicios pendientes</button>
                                    </a>
                                    <a href="ServletValidar?accion=mostrarMisAtencionesCompl">
                                        <button type="button" class="btn btn-primary waves-effect waves-light" data-toggle="modal" data-target="#staticBackdrop"  title="Seleccionar" data-original-title="Seleccionar" style="background: #771A1A; border-color: #771A1A;">Servicios realizados</button>
                                    </a>
                                </div>
                                <div class="card-block table-border-style">
                                    <input type="hidden" name="txtidtec" value="${usuario.getId()}">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered" id="examplerr">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>DNI Cliente</th>
                                                    <th>Telefono cliente</th>
                                                    <th>Descripcion</th>
                                                    <th>Nro Serie</th>
                                                    <th>Marca</th>
                                                    <th>Presu.</th>
                                                    <th>Fecha-Hora</th>
                                                    <th>Total</th>
                                                    <th>Estado</th>
                                                    <th>Accion</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="hora" items="${listahoraselct}" varStatus="status">
                                                    <tr>
                                                        <td>${status.index + 1}</td>
                                                        <td>${hora.getCita().perso.dni}</td>
                                                        <td>${hora.getCita().telefono}</td>
                                                        <td>${hora.getCita().aparato.descAparato}</td>
                                                        <td>${hora.getCita().aparato.nroSerie}</td>
                                                        <td>${hora.getCita().aparato.marca.descripcion}</td>
                                                        <td>${hora.getCita().presupuesto}</td>
                                                        <td>${hora.getCita().fecha_hora}</td>
                                                        <td>${hora.total}</td>
                                                        <c:if test="${hora.estado_activ == true}">
                                                            <td><span class="badge bg-green active" style="color: #000;background: #dc3545">Pendiente</span></td>
                                                        </c:if>
                                                        <c:if test="${hora.estado_activ == false}">
                                                            <td><span class="badge bg-red active" style="color: #fff;background: #198754">Realizado</span></td>
                                                        </c:if>
                                                        <td>
                                                            <input type="hidden" class="domTextElement2" value="${hora.id_servicio}">
                                                            <input type="hidden" name="txtidCitaa" class="domTextElement" value="${hora.getCita().id_cita}">
                                                            <a href="<c:url value="ServletValidar">
                                                                   <c:param name="accion" value="leerServicioasig" />
                                                                   <c:param name="idservicio" value="${hora.id_servicio}" />
                                                               </c:url>"><button type="button" class="btn btn-primary fa fa-money" data-toggle="modal" data-target="#staticBackdrop"  title="Dar presupuesto" data-original-title="Dar presupuesto" style="background: #771A1A; border-color: #771A1A"></button>
                                                            </a>
                                                            <!-- <button type="button" class="btn btn-primary fa fa-money" onclick="getValueInput()" data-toggle="modal"  title="Dar presupuesto" data-original-title="Dar presupuesto" data-target="#exampleModal" style="background: #771A1A; border-color: #771A1A"></button>
                                                            --><button type="button" class="btn btn-primary fa fa-times" onclick="getValueInput2(${status.index})" data-toggle="modal" data-target="#exampleModal2"  title="Cancelar" data-original-title="Cancelar" style="background: #771A1A; border-color: #771A1A"></button>
                                                            <a href="<c:url value="ServletValidar">
                                                                   <c:param name="accion" value="leerServicio" />
                                                                   <c:param name="idservicio" value="${hora.id_servicio}" />
                                                               </c:url>"><button type="button" class="btn btn-primary fa fa-cart-plus" data-toggle="modal" data-target="#staticBackdrop"  title="Completar" data-original-title="Completar" style="background: #771A1A; border-color: #771A1A"></button>
                                                            </a>
                                                            <a target="_blank" href="<c:url value="ServletGenerarReportes" >
                                                                   <c:param name="btnIngresar" value="hojaServiciosTaller" />
                                                                   <c:param name="idhoja" value="${hora.id_servicio}" />
                                                               </c:url>"><button type="button" class="btn btn-primary fa fa-print" data-toggle="modal" data-target="#staticBackdrop"  title="Imprimir" data-original-title="Imprimir" style="background: #771A1A; border-color: #771A1A" ></button>
                                                            </a>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                        <!-- Modal -->
                                        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                            <div class="modal-dialog modal-lg" role="document">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title" id="exampleModalLabel">Asignacion de presupuesto</h5>
                                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                            <span aria-hidden="true">&times;</span>
                                                        </button>
                                                    </div>
                                                    <div class="col-sm-10">
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
                                                                                <th>Nombre</th>
                                                                                <th>Marca</th>
                                                                                <th>Accion</th>
                                                                            </tr>
                                                                        </thead>
                                                                        <tbody>
                                                                            <c:forEach var="repuesto" items="${listarRepuestos}" varStatus="status">
                                                                                <tr>
                                                                                    <td style="width: 10px; word-wrap: break-word;">${repuesto.nombre_repuesto}</td>
                                                                                    <td>${repuesto.nombre_marca}</td>
                                                                                    <td>
                                                                                        <a href="<c:url value="ServletValidar">
                                                                                               <c:param name="accion" value="agregarPresu" />
                                                                                               <c:param name="txtidrepuesto" value="${repuesto.id_repuesto}" />
                                                                                           </c:url>"><button type="button" name="shear" value="buscarRepuesto" class="btn btn-primary fa fa-cart-plus" data-toggle="modal" data-target="#staticBackdrop"  title="Agregar" data-original-title="Agregar" style="background: #771A1A; border-color: #771A1A"></button>
                                                                                        </a>
                                                                                    </td>
                                                                                </tr>
                                                                            </c:forEach>
                                                                        </tbody>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <input type="hidden" name="txtidrepuesto2" class="form-control" value="${repuesto.id_repuesto}">
                                                    <input type="hidden" name="txtdescripcion"  class="form-control" value="${repuesto.nombre_repuesto}">
                                                    <input type="hidden" name="txtcosto" class="form-control" value="${repuesto.precio}">
                                                    <input type="hidden" name="txtcantidad" class="form-control" required="" value="1">
                                                    <div class="col-md-10">
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
                                                                                <th>Acci??n</th>
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
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <form class="md-float-material form-material" action="ServletValidar?accion=agregarPresu" method="post">
                                                        <div class="modal-body">

                                                            <div class="form-group form-static-label">
                                                                <p id="valueInputt"> </p> 
                                                                <input type="hidden" name="txtidcita" id="valueInput">
                                                                <input type="number" step="0.01" name="txtpresupuesto" class="form-control"
                                                                       required="" placeholder="0.0">
                                                                <span class="form-bar"></span>
                                                                <label class="float-label" style="font-size: 15px">Ingrese Presupuesto</label>
                                                            </div>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                                            <button type="submit" class="btn btn-primary">Guardar</button>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>

                                        <!-- Modal -->
                                        <div class="modal fade" id="exampleModal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                            <div class="modal-dialog" role="document">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title" id="exampleModalLabel">Cancelar Servicio</h5>
                                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                            <span aria-hidden="true">&times;</span>
                                                        </button>
                                                    </div>
                                                    <form class="md-float-material form-material" action="ServletValidar?accion=cancelarServicioTaller" method="post">
                                                        <div class="modal-body">

                                                            <div class="form-group form-static-label">
                                                                <p id="valueInputt"> </p> 
                                                                <input type="hidden" name="txtidservi" id="valueInput2">
                                                                <input type="number" step="0.01" name="txttotal" class="form-control"
                                                                       required="" placeholder="0.0">
                                                                <span class="form-bar"></span>
                                                                <label class="float-label" style="font-size: 15px">Ingrese Costo de Revicion</label>
                                                            </div>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                                            <button type="submit" class="btn btn-primary">Guardar</button>
                                                        </div>
                                                    </form>
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
        <script>
            const getValueInput = (v) => {
                let inputValue = document.getElementsByClassName("domTextElement")[v].value;
                document.getElementById("valueInput").value = inputValue;
            };
            const getValueInput2 = (v) => {
                let inputValue = document.getElementsByClassName("domTextElement2")[v].value;
                document.getElementById("valueInput2").value = inputValue;
            };
            function PasarValor(v)
            {
                console.log(v);
                document.getElementById(`valueInputt`).value = document.getElementById(`domTextElement${v}`).value;
            }
        </script>
        <script src="./js/tables.js"></script>
    </body>

</html>
<%
    } else {
        System.out.println("nos cierra");
        response.sendRedirect("login.jsp");
    }
%>
<%-- 
    Document   : hojaServicios
    Created on : 20 may. 2022, 17:38:32
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                                            <h5 class="m-b-10">Hoja de Servicio</h5>
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
                                    <div class="col-sm-8">
                                        <form class="md-float-material form-material">

                                            <div class="auth-box card">
                                                <div class="card-block">
                                                    <div class="row m-b-20">
                                                        <div class="col-md-12">
                                                            <h3 class="text-center txt-primary">Registrar Hoja de Servicios</h3>
                                                        </div>
                                                    </div>
                                                    <div class="form-group form-primary">
                                                        <strong><p class="text-left" style="font-size: 15px;">Datos Cliente</p></strong>
                                                    </div>
                                                    <div class="form-group form-primary">
                                                        <input type="text" name="user-name" class="form-control"
                                                            required="">
                                                        <span class="form-bar"></span>
                                                        <label class="float-label">Nombres</label>
                                                    </div>
                                                    <div class="form-group form-primary">
                                                        <input type="text" name="user-name" class="form-control"
                                                            required="">
                                                        <span class="form-bar"></span>
                                                        <label class="float-label">Apellidos</label>
                                                    </div>
                                                    <div class="form-group form-primary">
                                                        <input type="text" name="user-name" class="form-control"
                                                            required="">
                                                        <span class="form-bar"></span>
                                                        <label class="float-label">Direccion</label>
                                                    </div>
                                                    <div class="form-group form-primary row">
                                                        <div class="form-group col-sm-6" >
                                                            <input type="text" name="user-name" class="form-control"
                                                                required="">
                                                            <span class="form-bar"></span>
                                                            <label class="float-label" style="margin-left:15px ;">Telefono</label>   
                                                        </div>
                                                        <div class="form-group col-sm-6" >
                                                            <input type="text" name="user-name" class="form-control"
                                                                required="">
                                                            <span class="form-bar"></span>
                                                            <label class="float-label" style="margin-left:15px ;">Telefono Opcional</label>   
                                                        </div>
                                                    </div>
                                                    <div class="form-group form-primary">
                                                        <strong><p class="text-left" style="font-size: 15px;">Datos Electrodomestico</p></strong>
                                                    </div>
                                                    <div class="form-group form-primary row">
                                                        <div class="form-group col-sm-6" >
                                                            <span class="form-bar"></span>
                                                            <select name="typeUser" class="form-control" id="">
                                                                <option value="">Seleccione el tipo</option>
                                                                <option value="Tecnico">1</option>
                                                                <option value="Encargado">2</option>
                                                            </select>
                                                        </div>
                                                        <div class="form-group col-sm-6" >
                                                            <input type="text" name="user-name" class="form-control"
                                                                required="">
                                                            <span class="form-bar"></span>
                                                            <label class="float-label" style="margin-left:15px ;">Nro serie</label>   
                                                        </div>
                                                    </div>
                                                    <div class="form-group form-primary row">
                                                        <div class="form-group col-sm-6" >
                                                            <input type="text" name="user-name" class="form-control"
                                                                required="">
                                                            <span class="form-bar"></span>
                                                            <label class="float-label" style="margin-left:15px ;">Marca</label>   
                                                        </div>
                                                        <div class="form-group col-sm-6" >
                                                            <input type="text" name="user-name" class="form-control"
                                                                required="">
                                                            <span class="form-bar"></span>
                                                            <label class="float-label" style="margin-left:15px ;">Modelo</label>   
                                                        </div>
                                                    </div>
                                                    <div class="form-group form-primary">
                                                        <strong><p class="text-left" style="font-size: 15px;">Datos del Servicio</p></strong>
                                                    </div>
                                                    <div class="form-group form-primary row">
                                                        <div class="form-group col-sm-6" >
                                                            <label class="col-sm-3" style="margin-left:15px ;">Fecha</label> 
                                                            <input type="datetime-local" name="user-name" class="form-control col-sm-6"
                                                                required="">
                                                            <span class="form-bar"></span>
                                                        </div>
                                                        <div class="form-group col-sm-6" >
                                                            <input type="text" name="user-name" class="form-control"
                                                                required="">
                                                            <span class="form-bar"></span>
                                                            <label class="float-label" style="margin-left:15px ;">Monto</label>   
                                                        </div>
                                                    </div>
                                                    <div class="form-group form-primary">
                                                        <textarea type="text" name="user-name" class="form-control"
                                                            required=""></textarea>
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
                                                            <button type="button"
                                                                class="btn btn-primary btn-md btn-block waves-effect text-center m-b-20">Cancelar</button>
                                                        </div><div class="col-md-4">
                                                            <button type="button"
                                                                class="btn btn-success btn-md btn-block waves-effect text-center m-b-20">Guardar</button>
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

                    </div>
                </div>
            </div>
        </div>
    </div>
    
</body>

</html>

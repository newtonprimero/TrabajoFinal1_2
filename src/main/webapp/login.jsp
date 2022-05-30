
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="css/magnific-popup.css" type="text/css">

<link rel="stylesheet" href="css/owl.theme.css" type="text/css">
<link rel="stylesheet" href="css/owl.carousel.css" type="text/css">

<!-- MAIN CSS -->
<link rel="stylesheet" href="css/tooplate-style.css" type="text/css">

<!---------Other CSS------------>
</head>
<body>
    <div class="preloader">
         <div class="spinner">
              <span class="sk-inner-circle"></span>
         </div>
    </div>
    <div class="navbar custom-navbar navbar-fixed-top" role="navigation">
        <div class="container">

             <!-- NAVBAR HEADER -->
             <div class="navbar-header">
                  <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                       <span class="icon icon-bar"></span>
                       <span class="icon icon-bar"></span>
                       <span class="icon icon-bar"></span>
                  </button>
                  <!-- lOGO -->
                  <a href="index.jsp" class="navbar-brand"><p style="font-size: 25px; font-weight: bold; color: white;">Taller <img class="utp_logo" src="logo_utp.jpg" alt="280" width="90"></p></a>
             </div>

             <!-- MENU LINKS -->
             <div class="collapse navbar-collapse">
                  <ul class="nav navbar-nav navbar-right">
                       <li><a href="index.jsp" class="smoothScroll">Inicio</a></li>
                       <li><a href="index.jsp#about" class="smoothScroll">Nosotros</a></li>
                       <li><a href="index.jsp#project" class="smoothScroll">Servicios</a></li>
                       <li><a href="registrarCliente.jsp" class="smoothScroll">Registrarse</a></li>  
                       <li><a href="login.jsp" class="smoothScroll">Login</a></li>
                  </ul>
             </div>

        </div>
    </div>
                   
    <section id="contact" class="parallax-section">
    <div class="container">

        <div class="row">
            <div class="">
                <div class="" style=" margin:auto; width: 40%; height: 60%; ">
                    <form class="md-float-material form-material col-md-11" action="ServletValidar?accion=verificar" method="POST" style="background: #a6a8ab; border-radius: 6px" >
                        <div class="text-center">
                        </div>
                        <div class="auth-box card">
                            <div class="card-block">
                                <div class="row m-b-20">
                                    <div class="col-md-12">
                                        <h3 class="text-center">Iniciar Sesión</h3>
                                    </div>
                                </div>
                                <div class="form-group form-primary">
                                    <input type="email" name="txtemail" class="form-control">
                                    <span class="form-bar"></span>
                                    <label class="float-label">Ingrese Correo</label>
                                </div>
                                <div class="form-group form-primary">
                                    <input type="password" name="txtpassword" class="form-control" >
                                    <span class="form-bar"></span>
                                    <label class="float-label">Contraseña</label>
                                </div>
                                <div class="row m-t-25 text-left">
                                    <div class="col-12">
                                        <div class="checkbox-fade fade-in-primary d-">
                                            <label>
                                                <input type="checkbox" value="">
                                                <span class="cr"><i class=""></i></span>
                                                <span class="text-inverse">Recordarme</span>
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="forgot-phone text-right f-right">
                                            <a href="#" class="text-right f-w-600"> Forgot Password?</a>
                                        </div>
                                <div class="row m-t-30">
                                    <div class="col-md-12">
                                        <input type="submit" name="verificar" value="Ingresar" class="btn btn-primary btn-md btn-block waves-effect waves-light text-center m-b-20">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-10">
                                        <p class="text-inverse text-left m-b-0">Thank you.</p>
                                        <p class="text-inverse text-left"><a href="index.jsp"><b>Back to website</b></a></p>
                                    </div>
                                    <div class="col-md-2">
                                        <img src="assets/images/auth/Logo-small-bottom.png" alt="small-logo.png">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                    
                <!-- end of form -->
                </div>
            </div>
      </div>
    </div>
    </section>
    
    <footer>
         <div class="container">
              <div class="row">

                   <div class="col-md-5 col-sm-6">
                        <h2>Diseñado Por</h2>
                        <p>Santiago Gustavo Zenteno Taco,<br> Tristique vestibulum,<br> Lorem ipsum dolor</p>


                   </div>

                   <div class="col-md-4 col-sm-6">
                        <div class="footer-info">
                            <h2>Informacion</h2>
                             <p><a href="tel:010-090-0780">950800115</a></p>
                             <p><a href="mailto:info@company.com">sant1999_@hotmail.com</a></p>
                             <p><a href="#">Our Location</a></p>
                        </div>
                   </div>

                   <div class="col-md-3 col-sm-12">

                        <h2>Redes</h2>
                        <p></p>
                        <ul class="social-icon">
                             <li><a href="#" class="fa fa-twitter"></a></li>
                             <li><a href="#" class="fa fa-facebook"></a></li>
                             <li><a href="#" class="fa fa-instagram"></a></li>
                             <li><a href="#" class="fa fa-linkedin"></a></li>
                        </ul>

                   </div>

                   <div class="clearfix"></div>

                   <div class="col-md-12 col-sm-12">
                        <div class="copyright-text">
                             <p>Copyright © 2021  

                             | Design: Santiago Zenteno</p>
                        </div>
                   </div>

              </div>
         </div>
    </footer>
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.parallax.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.magnific-popup.min.js"></script>
<script src="js/magnific-popup-options.js"></script>
<script src="js/modernizr.custom.js"></script>
<script src="js/smoothscroll.js"></script>
<script src="js/custom.js"></script>
</body>
</html>
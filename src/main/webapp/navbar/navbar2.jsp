
<nav class="pcoded-navbar">
    <div class="sidebar_toggle"><a href="#"><i class="icon-close icons"></i></a></div>
    <div class="pcoded-inner-navbar main-menu">
        <div class="">
            <div class="main-menu-header">
                <img class="img-80 img-radius" src="assets/images/user.png"
                     alt="User-Profile-Image">
                <div class="user-details">
                    <span id="more-details"> ${usuario.getNombreUsuario()}<i class="fa fa-caret-down"></i></span>
                </div>
            </div>

            <div class="main-menu-content">
                <ul>
                    <li class="more-details">
                        <a href="user-profile.html"><i class="ti-user"></i>View Profile</a>
                        <a href="#!"><i class="ti-settings"></i>Settings</a>
                        <a href="login.jsp" name="cerrar" ><i class="ti-layout-sidebar-left"></i>Logout</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="p-15 p-b-0">
            <form class="form-material">
                <div class="form-group form-primary">
                    <input type="text" name="footer-email" class="form-control" required="">
                    <span class="form-bar"></span>
                    <label class="float-label"><i class="fa fa-search m-r-10"></i>Search
                        Friend</label>
                </div>
            </form>
        </div>
        <div class="pcoded-navigation-label" data-i18n="nav.category.navigation">Home</div>
        <ul class="pcoded-item pcoded-left-item">
            <li class="" id="iluminar">
                <a href="homeEncargado.jsp" class="waves-effect waves-dark">
                    <span class="pcoded-micon"><i class="ti-home"></i><b>D</b></span>
                    <span class="pcoded-mtext" data-i18n="nav.dash.main">Inicio</span>
                    <span class="pcoded-mcaret"></span>
                </a>
            </li>
            <li class="pcoded-hasmenu">
                <a href="javascript:void(0)" class="waves-effect waves-dark">
                    <span class="pcoded-micon"><i class="ti-layout-grid2-alt"></i></span>
                    <span class="pcoded-mtext"
                          data-i18n="nav.basic-components.main">Mantenimiento</span>
                    <span class="pcoded-mcaret"></span>
                </a>
                <ul class="pcoded-submenu">
                    <li class="" id="iluminar">
                        <a href="ServletValidar?accion=listartecnicos" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext"
                                  data-i18n="nav.basic-components.alert">Tecnicos</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                    <li class=" " id="iluminar">
                        <a href="ServletValidar?accion=listarclientes" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext"
                                  data-i18n="nav.basic-components.breadcrumbs">Clientes</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                    <li class=" " id="iluminar">
                        <a href="ServletValidar?accion=listarrepuestos" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext"
                                  data-i18n="nav.basic-components.alert">Repuestos</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                    <li class=" " id="iluminar">
                        <a href="ServletValidar?accion=listarencargados" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext"
                                  data-i18n="nav.basic-components.breadcrumbs">Encargados</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>

                </ul>
            </li>
        </ul>
        <div class="pcoded-navigation-label" data-i18n="nav.category.forms">Asignación &amp; Visualizacion</div>
        <ul class="pcoded-item pcoded-left-item">
            <li id="iluminar">
                <a href="<c:url value="ServletValidar">
                    <c:param name="accion" value="formasignarHorario" />
                    </c:url>" class="waves-effect waves-dark">
                    <span class="pcoded-micon"><i class="ti-layers"></i><b>FC</b></span>
                    <span class="pcoded-mtext" data-i18n="nav.form-components.main">Asignar Horarios</span>
                    <span class="pcoded-mcaret"></span>
                </a>
            </li>
            <li id="iluminar">
                <a href="bs-basic-table.html" class="waves-effect waves-dark">
                    <span class="pcoded-micon"><i class="ti-layers"></i><b>FC</b></span>
                    <span class="pcoded-mtext" data-i18n="nav.form-components.main">Mostrar Horarios</span>
                    <span class="pcoded-mcaret"></span>
                </a>
            </li>
            <li class="pcoded-hasmenu " id="iluminar">
                <a href="javascript:void(0)" class="waves-effect waves-dark">
                    <span class="pcoded-micon"><i class="ti-direction-alt"></i><b>M</b></span>
                    <span class="pcoded-mtext" data-i18n="nav.menu-levels.main">Mostra Servicios</span>
                    <span class="pcoded-mcaret"></span>
                </a>
                <ul class="pcoded-submenu">
                    <li class="">
                        <a href="ServletValidar?accion=listarTodosServicios" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext"
                                  data-i18n="nav.menu-levels.menu-level-21">Mostrar Servicios Taller</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                    <li class="">
                        <a href="ServletValidar?accion=listarServiciosDomicilio" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext"
                                  data-i18n="nav.menu-levels.menu-level-21">Mostrar Servicios Domicilio</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                </ul>
            </li>
        </ul>

        <div class="pcoded-navigation-label" data-i18n="nav.category.forms">Registrar</div>
        <ul class="pcoded-item pcoded-left-item">
            <li id="iluminar">
                <a href="ServletValidar?accion=formRegisTecnico" class="waves-effect waves-dark">
                    <span class="pcoded-micon"><i class="ti-layers"></i><b>FC</b></span>
                    <span class="pcoded-mtext" data-i18n="nav.form-components.main">Técnicos</span>
                    <span class="pcoded-mcaret"></span>
                </a>
            </li>
            <li id="iluminar">
                <a href="ServletValidar?accion=formRegisTecnico" class="waves-effect waves-dark">
                    <span class="pcoded-micon"><i class="ti-layers"></i><b>FC</b></span>
                    <span class="pcoded-mtext" data-i18n="nav.form-components.main">Encargados</span>
                    <span class="pcoded-mcaret"></span>
                </a>
            </li>
            <li id="iluminar">
                <a href="ServletValidar?accion=registrarcliente" class="waves-effect waves-dark">
                    <span class="pcoded-micon"><i class="ti-layers"></i><b>FC</b></span>
                    <span class="pcoded-mtext" data-i18n="nav.form-components.main">Cliente</span>
                    <span class="pcoded-mcaret"></span>
                </a>
            </li>
            <li id="iluminar">
                <a href="ServletValidar?accion=registrarcliente" class="waves-effect waves-dark">
                    <span class="pcoded-micon"><i class="ti-layers"></i><b>FC</b></span>
                    <span class="pcoded-mtext" data-i18n="nav.form-components.main">Repuesto</span>
                    <span class="pcoded-mcaret"></span>
                </a>
            </li>
            <li class="pcoded-hasmenu">
                <a href="javascript:void(0)" class="waves-effect waves-dark">
                    <span class="pcoded-micon"><i class="ti-layout-grid2-alt"></i></span>
                    <span class="pcoded-mtext" data-i18n="nav.basic-components.main">Repuestos</span>
                    <span class="pcoded-mcaret"></span>
                </a>
                <ul class="pcoded-submenu">
                    <li class=" " id="iluminar">
                        <a href="auth-normal-sign-in.html" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext"
                                  data-i18n="nav.basic-components.alert">Ingresar</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                    <li class=" " id="iluminar">
                        <a href="auth-sign-up.html" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext"
                                  data-i18n="nav.basic-components.breadcrumbs">Mantenimiento</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                    <li class=" " id="iluminar">
                        <a href="sample-page.html" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext"
                                  data-i18n="nav.basic-components.breadcrumbs">Mostrar</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                </ul>
            </li>

        </ul>

        <div class="pcoded-navigation-label" data-i18n="nav.category.other">Generar Reportes &amp; Facturas</div>
        <ul class="pcoded-item pcoded-left-item">
            <li class="pcoded-hasmenu " id="iluminar">
                <a href="javascript:void(0)" class="waves-effect waves-dark">
                    <span class="pcoded-micon"><i class="ti-direction-alt"></i><b>M</b></span>
                    <span class="pcoded-mtext" data-i18n="nav.menu-levels.main">Reportes</span>
                    <span class="pcoded-mcaret"></span>
                </a>
                <ul class="pcoded-submenu">
                    <li class="">
                        <a href="javascript:void(0)" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext"
                                  data-i18n="nav.menu-levels.menu-level-21">Clientes</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                    <li class="">
                        <a href="javascript:void(0)" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext"
                                  data-i18n="nav.menu-levels.menu-level-21">Repuestos</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                    <li class="">
                        <a href="javascript:void(0)" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext"
                                  data-i18n="nav.menu-levels.menu-level-22.main">Tecnicos</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                    <li class="">
                        <a href="javascript:void(0)" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext"
                                  data-i18n="nav.menu-levels.menu-level-23">Avanzado</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>

                </ul>
            </li>
            <li>
                <a href="bs-basic-table.html" class="waves-effect waves-dark">
                    <span class="pcoded-micon"><i class="ti-layers"></i><b>FC</b></span>
                    <span class="pcoded-mtext" data-i18n="nav.form-components.main">Factura</span>
                    <span class="pcoded-mcaret"></span>
                </a>
            </li>
        </ul>
    </div>
</nav>
<script>
    function cambiarcolor() {
        document.getElementById("iluminar").classList.toggle("active");
    }
    document.getElementById("iluminar").onclick = function () {
        cambiarcolor();
    };
</script>
<script type="text/javascript" src="./assets/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="./assets/js/jquery-ui/jquery-ui.min.js "></script>
<script type="text/javascript" src="./assets/js/popper.js/popper.min.js"></script>
<script type="text/javascript" src="./assets/js/bootstrap/js/bootstrap.min.js "></script>
<script type="text/javascript" src="./assets/pages/widget/excanvas.js "></script>
<!-- waves js -->
<script src="./assets/pages/waves/js/waves.min.js"></script>
<!-- jquery slimscroll js -->
<script type="text/javascript" src="./assets/js/jquery-slimscroll/jquery.slimscroll.js "></script>
<!-- modernizr js -->
<script type="text/javascript" src="./assets/js/modernizr/modernizr.js "></script>
<!-- slimscroll js -->
<script type="text/javascript" src="./assets/js/SmoothScroll.js"></script>
<script src="./assets/js/jquery.mCustomScrollbar.concat.min.js "></script>
<!-- Chart js -->
<script type="text/javascript" src="./assets/js/chart.js/Chart.js"></script>
<!-- amchart js -->
<script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
<script src="./ssets/pages/widget/amchart/gauge.js"></script>
<script src="./assets/pages/widget/amchart/serial.js"></script>
<script src="./assets/pages/widget/amchart/light.js"></script>
<script src="./assets/pages/widget/amchart/pie.min.js"></script>
<script src="https://www.amcharts.com/lib/3/plugins/export/export.min.js"></script>
<!-- menu js -->
<script src="./assets/js/pcoded.min.js"></script>
<script src="./assets/js/vertical-layout.min.js "></script>
<!-- custom js -->
<script type="text/javascript" src="./assets/pages/dashboard/custom-dashboard.js"></script>
<script type="text/javascript" src="./assets/js/script.js "></script>


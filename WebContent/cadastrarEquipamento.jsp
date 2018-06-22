<%@page import="model.Equipamento"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Colaborador"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-BR">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Inventário Infraestrutura</title>

    <!-- Bootstrap Core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<%
	if(session.getAttribute("usuario") == null || session.getAttribute("senha") == null ){
		response.sendRedirect("login.jsp");
	}
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	response.setHeader("Expires", "0");

	List<Colaborador> colaboradores = (List<Colaborador>) request.getAttribute("colaboradores");
	Equipamento e = (Equipamento) request.getAttribute("e");
%>
    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="abrirHome">Inventário Infraestrutura</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> Perfil</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Configurações</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="fazerLogoff"><i class="fa fa-sign-out fa-fw"></i> Sair</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="abrirHome"><i class="fa fa-dashboard fa-fw"></i> Home</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-table fa-fw"></i> Visualizar<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="listarColaboradores">Colaboradores</a>
                                </li>
                                <li>
                                    <a href="listarMonitores">Monitores</a>
                                </li>
                                <li>
                                    <a href="listarSoftwares">Softwares</a>
                                </li>
                                <li>
                                	<a href="listarEquipamentos">Equipamentos</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-edit fa-fw"></i> Cadastrar<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="abrirCadastrarColaborador">Colaborador</a>
                                </li>
                                <li>
                                    <a href="abrirCadastrarMonitor">Monitor</a>
                                </li>
                                <li>
                                    <a href="abrirCadastrarSoftware">Software</a>
                                </li>
                                <li>
                                    <a href="abrirCadastrarEquipamento">Equipamento</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Cadastrar</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Equipamento
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                
                                    <form role="form" action="salvarEquipamento" method="POST">
                                    <input type="hidden" name="id" value="${e.id}"/>
                                    
                                        <div class="form-group">
                                            <label>Hostname</label>
                                            <input type="text" name="hostname" value="${e.hostname}" class="form-control">
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Patrimônio</label>
                                            <input type="text" name="patrimonio" value="${e.patrimonio}" class="form-control">
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Tipo</label>
                                            <input type="text" name="tipo" value="${e.tipo}" class="form-control">
                                        </div>      
                                        
                                        <div class="form-group">
                                            <label>Modelo</label>
                                            <input type="text" name="modelo" value="${e.modelo}" class="form-control">
                                        </div>                                         
                                        
                                        <div class="form-group">
                                            <label>Processador</label>
                                            <input type="text" name="processador" value="${e.processador}" class="form-control">
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Serial Tag</label>
                                            <input type="text" name="serialTag" value="${e.serialTag}" class="form-control">
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Service Code</label>
                                            <input type="text" name="serviceCode" value="${e.serviceCode}" class="form-control">
                                        </div> 
                                        
                                        <div class="form-group">
                                            <label>Data da Garantia</label>
                                            <input type="text" name="dataGarantia" value="${e.dataGarantia}" class="form-control">
                                        </div> 
                                        
                                        <div class="form-group">
                                            <label>S.O Comprado</label>
                                            <input type="text" name="soComprado" value="${e.soComprado}" class="form-control">
                                        </div> 
                                        
                                        <div class="form-group">
                                            <label>S.O Atual</label>
                                            <input type="text" name="soAtual" value="${e.soAtual}" class="form-control">
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>RAM Original</label>
                                            <input type="text" name="ramOriginal" value="${e.ramOriginal}" class="form-control">
                                        </div> 
                                        
                                        <div class="form-group">
                                            <label>RAM Atual</label>
                                            <input type="text" name="ramAtual" value="${e.ramAtual}" class="form-control">
                                        </div>  
                                        
                                        <div class="form-group">
                                            <label>Colaborador</label>
                                            <select class="form-control" name="colaborador">
                                            	<option value="">Sem Colaborador</option>
                                            	
                                            	<c:forEach var="c" items="${colaboradores}">
                                            		<c:set var="selecao" value=""/>
                                            		<c:if test="${e.colaborador.equals(c)}">
                                            			<c:set var="selecao" value="selected='selected'"/>
                                            		</c:if>
                                            		
                                            		<option ${selecao} value="${c.id}">${c.nome}</option>
                                            	</c:forEach>
                                           	                                           	
                                            </select>
                                        </div>

                                        <button type="submit" class="btn btn-default">Cadastrar</button>
                                    </form>
                                    
                                </div>
                                <!-- /.col-lg-6 (nested) -->
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="dist/js/sb-admin-2.js"></script>

</body>

</html>
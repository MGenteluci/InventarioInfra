<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset=ISO-8859-1">
	<title>Sistema de Invent�rio - INFRA</title>
	
	<link rel="icon" href="img/fav.png" type="image/gif">
	
	<link rel="stylesheet" href="css/login.css"/>
</head>
<body>
	<div id="container">
		<form action="listarEquipamentos" method="POST">
			<div>
				<input type="text" name="usuario" placeholder="Usu�rio"/>
			</div>
			<div>
				<input type="password" name="senha" placeholder="******"/>
			</div>
			<input type="submit" value="Entrar"/>
		</form>
	</div>
</body>
</html>
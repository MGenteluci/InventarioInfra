<%@page import="model.Colaborador"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "header.html" %>
<jsp:useBean id="daomonitor" class="model.dao.DaoMonitor"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- Listar os dados da tabela monitor --%>
<table class="table" id="myTable">
	<thead>
	<tr>
		<th scope="col">Patrimônio</th>
		<th scope="col">Marca</th>
		<th scope="col">Modelo</th>
		<th scope="col">Colaborador</th>
		<th></th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="monitor" items="${daomonitor.pesquisar()}">
		<tr>
			<td style="width: 20%">${monitor.patrimonio}</td>
			<td style="width: 20%">${monitor.marca}</td>
			<td style="width: 20%">${monitor.modelo}</td>
			<td style="width: 20%"><a href="#" title="${daomonitor.consultarUm(monitor.colaborador)}" class="badge badge-warning">${monitor.colaborador}</a></td>
			<td style="width: 20%">
				
				<form action="monitor" method="POST" style="display: none; float: left; margin-right: 1%">
					<input type="hidden" name="monitor" value="remove"></input>
					<input type="hidden" name="id" value="${monitor.id}"></input>
					<button class="btn btn-danger" style="color:white" type="submit">Deletar</button>
				</form>
				
				<button class="btn btn-warning" style="background-color:orange;color:white" type="submit" onClick="mostrar(${monitor.id})">Alterar</button>
							
				<form action="monitor" style="display:none" method="POST" id="${monitor.id}">

					<input type="hidden" class="form-control" name="id" value="${monitor.id}"> 
					<input type="text" class="form-control" name="patrimonio" value="${monitor.patrimonio}">
					<input type="text" class="form-control" name="marca" value="${monitor.marca}">
					<input type="text" class="form-control" name="modelo" value="${monitor.modelo}">
					<select name="colaborador" class="form-control" required>
				    	<%
				    		List<Colaborador> colaboradores = (List<Colaborador>) request.getAttribute("colaboradores");
				    	out.print("<option value=\"\" selected>Selecionar Colaborador</option>");
				    		for(Colaborador c : colaboradores){
				    			out.print("<option value=\"" + c.getId() + "\">" + c.getId() + " - " + c.getNome() + "</option>");
				    		}
				    	%>
				    </select>
					<input type="hidden" name="monitor" value="update"></input>
					
					<button type="submit" class="btn btn-success" style="color: white">Confirmar</button>

				</form>
						
			</td>				
		</tr>
			
	</c:forEach>
	</tbody>
</table>

<%@ include file = "footer.html" %>
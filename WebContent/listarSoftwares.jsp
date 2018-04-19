<%@page import="model.Colaborador"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "header.html" %>
<jsp:useBean id="daosoftware" class="model.dao.DaoSoftware"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% // Listar os dados da tabela software %>
<table class="table" id="myTable">
	<thead>
	<tr>
		<th scope="col">Serial</th>
		<th scope="col">Nome</th>
		<th scope="col">Versão</th>
		<th scope="col">Colaborador</th>
		<th></th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="software" items="${daosoftware.pesquisar()}">
		<tr>
			<td style="width: 20%">${software.serial}</td>
			<td style="width: 20%">${software.nome}</td>
			<td style="width: 20%">${software.versao}</td>
			<td style="width: 20%"><a href="#" title="${daosoftware.consultarUm(software.colaborador)}" class="badge badge-warning">${software.colaborador}</a></td>
			<td style="width: 20%">
				
				<form action="ServletSoftware" method="POST" style="display: none; float: left; margin-right: 1%">
				<input type="hidden" name="software" value="remove"></input>
				<input type="hidden" name="id" value="${software.id}"></input>
				<button class="btn btn-danger" style="color:white" type="submit">Deletar</button>
				</form>
				
				<button class="btn btn-warning" style="background-color:orange;color:white" type="submit" onClick="mostrar(${software.id})">Alterar</button>
							
				<form action="ServletSoftware" style="display:none" method="POST" id="${software.id}">

					<input type="hidden" class="form-control" name="id" value="${software.id}">
					<input type="text" class="form-control" name="serial" value="${software.serial}"> 
					<input type="text" class="form-control" name="nome" value="${software.nome}">
					<input type="text" class="form-control" name="versao" value="${software.versao}">
					<select name="colaborador" class="form-control" required>
				    	<%
				    		List<Colaborador> colaboradores = (List<Colaborador>) request.getAttribute("colaboradores");
				    		out.print("<option value=\"\" selected>Selecionar Colaborador</option>");
				    		for(Colaborador c : colaboradores){
				    			out.print("<option value=\"" + c.getId() + "\">" + c.getId() + " - " + c.getNome() + "</option>");
				    		}
				    	%>
				    </select>
					<input type="hidden" name="software" value="update"></input>
					
					<button type="submit" class="btn btn-success" style="color: white">Confirmar</button>

				</form>
						
			</td>				
		</tr>
	</c:forEach>
	</tbody>
</table>

<%@ include file = "footer.html" %>
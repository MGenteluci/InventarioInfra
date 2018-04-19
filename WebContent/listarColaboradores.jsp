<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "header.html" %>
<jsp:useBean id="daocolaborador" class="model.dao.DaoColaborador"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- Listar os dados da tabela colaborador --%>
<table class="table" id="myTable">
	<thead>
	<tr>
		<th scope="col">Nome</th>
		<th scope="col">Local</th>
		<th scope="col">Usuário</th>
		<th scope="col">Opções</th>
		<th></th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="colaborador" items="${daocolaborador.pesquisar()}">
		<tr>
			<td style="width: 25%">${colaborador.nome}</td>
			<td style="width: 25%">${colaborador.local}</td>
			<td style="width: 25%">${colaborador.usuario}</td>
			<td style="width: 25%">
				
				<form action="ServletColaborador" method="POST" style="display: none; float: left; margin-right: 1%">
					<input type="hidden" name="colaborador" value="remove"></input>
					<input type="hidden" name="id" value="${colaborador.id}"></input>
					<button class="btn btn-danger" style="color:white" type="submit">Deletar</button>
				</form>
				
				<button class="btn btn-warning" style="background-color:orange;color:white" type="submit" onClick="mostrar(${colaborador.id})">Alterar</button>
							
				<form action="ServletColaborador" style="display:none" method="POST" id="${colaborador.id}">			
					<input type="hidden" class="form-control" name="id" value="${colaborador.id}"> 
					<input type="text" class="form-control" name="nome" value="${colaborador.nome}">
					<select name="local" class="form-control">
					    <option value="Infraestrutura - RJ">Infraestrutura - RJ</option>
					    <option value="Marketing - RJ">Marketing - RJ</option>
					    <option value="Marketing - SP">Marketing - SP</option>
					    <option value="Administrativo - RJ">Administrativo - RJ</option>
					    <option value="Administrativo - SP">Administrativo - SP</option>
					    <option value="Fábrica - RJ">Fábrica - RJ</option>
					    <option value="Sulamerica">Sulamerica</option>
					    <option value="Outro" selected>Outro</option>
					    <option value="Indefinido">Indefinido</option>
					</select>
					<input type="text" class="form-control" name="usuario" value="${colaborador.usuario}">
					<input type="hidden" name="colaborador" value="update"></input>
					
					<button type="submit" class="btn btn-success" style="color: white">Confirmar</button>
				</form>
						
			</td>				
		</tr>
			
	</c:forEach>
	</tbody>
</table>

<%@ include file = "footer.html" %>
<%@page import="model.Colaborador"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file = "header.html" %>
<jsp:useBean id="daoequipamento" class="model.dao.DaoEquipamento"/>
<jsp:useBean id="daocolaborador" class="model.dao.DaoColaborador"/>
<jsp:useBean id="daosoftware" class="model.dao.DaoSoftware"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		
		<table class="table" id="myTable">
			<thead>
				<tr>
					<th scope="col">Patrimônio</th>
					<th scope="col">Hostname</th>
					<th scope="col">Situação</th>
					<th scope="col">Tipo</th>
					<th scope="col">Modelo</th>
					<th scope="col">Processador</th>
					<th scope="col">RAM Original</th>
					<th scope="col">RAM Atual</th>
					<th scope="col">Service Tag</th>
					<th scope="col">Express Code</th>
					<th scope="col">Garantia</th>
					<th scope="col">Observação</th>
					<th scope="col">Colaborador</th>
					<th scope="col">Opções</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="equipamento" items="${daoequipamento.pesquisar()}">
				<tr>
					<td style="width: 7%">${equipamento.patrimonio}</td>
					<td style="width: 7%">${equipamento.hostname}</td>
					<td style="width: 7%">${equipamento.situacao}</td>
					<td style="width: 7%">${equipamento.tipo}</td>
					<td style="width: 7%">${equipamento.modelo}</td>
					<td style="width: 7%">${equipamento.processador}</td>
					<td style="width: 7%">${equipamento.ramOriginal}</td>
					<td style="width: 7%">${equipamento.ramAtual}</td>
					<td style="width: 7%">${equipamento.serviceTag}</td>
					<td style="width: 7%">${equipamento.serviceCode}</td>
					<td style="width: 7%">${equipamento.garantia}</td>
					<td style="width: 7%">${equipamento.observacao}</td>
					<td style="width: 7%"><a href="#" title="${daoequipamento.consultarUm(equipamento.colaborador)}" class="badge badge-warning">${equipamento.colaborador}</a></td>
					<td style="width: 7.8%">
						
						<form action="ServletEquipamento" method="POST" style="display: none; float: left; margin-right: 1%">
							<input type="hidden" name="equipamento" value="remove"></input>
							<input type="hidden" name="id" value="${equipamento.id}"></input>
							<button class="btn btn-danger" style="color:white" type="submit">Deletar</button>
						</form>

						<button class="btn btn-warning" style="background-color:orange;color:white" type="submit" onClick="mostrar(${equipamento.id})">Alterar</button>
						
						<form action="ServletEquipamento" style="display:none" method="POST" id="${equipamento.id}">

							<input type="hidden" class="form-control" name="id" value="${equipamento.id}"> 
							<input type="text" class="form-control" name="patrimonio" value="${equipamento.patrimonio}">
							<input type="text" class="form-control" name="hostname" value="${equipamento.hostname}">
							<input type="text" class="form-control" name="situacao" value="${equipamento.situacao}">
							<select name="tipo" class="form-control">
						    	<option value="Notebook" selected>Notebook</option>
						    	<option value="Servidor">Servidor</option>
						    	<option value="Desktop">Desktop</option>
						    	<option value="Access Point">Access Point</option>
    						</select>
							<input type="text" class="form-control" name="modelo" value="${equipamento.modelo}">
							<input type="text" class="form-control" name="processador" value="${equipamento.processador}">
							<input type="text" class="form-control" name="ramOriginal" value="${equipamento.ramOriginal}">
							<input type="text" class="form-control" name="ramAtual" value="${equipamento.ramAtual}">
							<input type="text" class="form-control" name="serviceTag" value="${equipamento.serviceTag}">
							<input type="text" class="form-control" name="serviceCode" value="${equipamento.serviceCode}">
							<input type="text" class="form-control" name="garantia" value="${equipamento.garantia}">
							<input type="text" class="form-control" name="observacao" value="${equipamento.observacao}">
							<select name="colaborador" class="form-control" required>
						    	<%
						    		List<Colaborador> colaboradores = (List<Colaborador>) request.getAttribute("colaboradores");
						    		out.print("<option value=\"\" selected>Selecionar Colaborador</option>");
						    		for(Colaborador c : colaboradores){
						    			out.print("<option value=\"" + c.getId() + "\">" + c.getId() + " - " + c.getNome() + "</option>");
						    		}
						    	%>
						    </select>
							
							<input type="hidden" name="equipamento" value="update"></input>
							
							<button type="submit" class="btn btn-success" style="color: white">Confirmar</button>

						</form>
						
					</td>			
				</tr>
				
			</c:forEach>
			</tbody>
		</table>

<%@ include file = "footer.html" %>
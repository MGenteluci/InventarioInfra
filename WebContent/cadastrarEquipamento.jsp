<%@page import="model.Colaborador"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "header.html" %>

<%
	List<String> erros = (List<String>) request.getAttribute("erros");
	if(erros.size() > 0){
		for(String erro: erros){
			out.print("<ul>");
			out.print("<li>" + erro + "</li>");
			out.print("</ul>");
		}
	}
%>

<form action="ServletEquipamento" method="POST">
	<div class="form-group">
    <label for="patrimonio">Patrimônio</label>
    <input type="text" class="form-control" name="patrimonio" autofocus>
  </div>
  <div class="form-group">
    <label for="hostname">Hostname</label>
    <input type="text" class="form-control" name="hostname">
  </div>
  <div class="form-group">
    <label for="situacao">Situação</label>
    <input type="text" class="form-control" name="situacao">
  </div>
  <div class="form-group">
    <label for="tipo">Tipo</label>
    <select name="tipo" class="form-control">
    	<option value="Notebook" selected>Notebook</option>
    	<option value="Servidor">Servidor</option>
    	<option value="Desktop">Desktop</option>
    	<option value="Access Point">Access Point</option>
    </select>
  </div>
  <div class="form-group">
    <label for="modelo">Modelo</label>
    <input type="text" class="form-control" name="modelo">
  </div>
  <div class="form-group">
    <label for="processador">Processador</label>
    <input type="text" class="form-control" name="processador">
  </div>
  <div class="form-group">
    <label for="ramOriginal">RAM Original</label>
    <input type="text" class="form-control" name="ramOriginal">
  </div>
  <div class="form-group">
    <label for="ramAtual">RAM Atual</label>
    <input type="text" class="form-control" name="ramAtual">
  </div>
  <div class="form-group">
    <label for="serviceTag">Service Tag</label>
    <input type="text" class="form-control" name="serviceTag">
  </div>
  <div class="form-group">
    <label for="serviceCode">Express Code</label>
    <input type="text" class="form-control" name="serviceCode">
  </div>
  <div class="form-group">
    <label for="garantia">Garantia</label>
    <input type="text" class="form-control" name="garantia">
  </div>
  <div class="form-group">
    <label for="observacao">Observação</label>
    <input type="text" class="form-control" name="observacao">
  </div>
  <div class="form-group">
    <label for="colaborador">Colaborador</label>
     <select name="colaborador" class="form-control">
    	<%
    		List<Colaborador> colaboradores = (List<Colaborador>) request.getAttribute("colaboradores");
    		out.print("<option value=\"\" selected>Selecionar Colaborador</option>");
    		for(Colaborador c : colaboradores){
    			out.print("<option value=\"" + c.getId() + "\">" + c.getId() + " - " + c.getNome() + "</option>");
    		}
    	%>
    </select>
  </div>
  <input type="hidden" name="equipamento" value="add"></input>
  <button type="submit" class="btn btn-warning" style="background-color:orange;color:white;">Cadastrar</button>
</form>

<%@ include file="footer.html" %>
<%@page import="model.Colaborador"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "header.html" %>

<%
	List<String> erros = (List<String>) request.getAttribute("erros");
	
	if(erros.size() > 0){
		out.print("<ul>");
			for(String erro: erros){
				out.print("<li>" + erro + "</li>");
			}
		out.print("</ul>");
	}

%>

<form action="monitor" method="POST">
	<div class="form-group">
    <label for="patrimonio">Patrimônio</label>
    <input type="text" class="form-control" name="patrimonio">
  </div>
  <div class="form-group">
    <label for="marca">Marca</label>
    <select name="marca" class="form-control">
    	<option value="Dell" selected>Dell</option>
    	<option value="Samsung">Samsung</option>
    	<option value="Acer">Acer</option>
    	<option value="LG">LG</option>
    	<option value="A definir">À Definir</option>
    </select>
  </div>
  <div class="form-group">
    <label for="modelo">Modelo</label>
    <input type="text" class="form-control" name="modelo">
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
  <input type="hidden" name="monitor" value="add"></input>
  <button type="submit" class="btn btn-warning" style="background-color:orange;color:white;">Cadastrar</button>
</form>

<%@ include file="footer.html" %>
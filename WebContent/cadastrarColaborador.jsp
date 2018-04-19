<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "header.html" %>

<%
	List<String> erros = (List<String>) request.getAttribute("erros");

	if(erros != null || erros.size() > 0){
		out.print("<ul>");
			
			for(String erro: erros){
				out.print("<li>" + erro + "</li>");
			}
		
		out.println("</ul>");
	}
	
%>

<form action="ServletColaborador" method="POST">
  <div class="form-group">
    <label for="nome">Nome</label>
    <input type="text" class="form-control" name="nome">
  </div>
  <div class="form-group">
    <label for="local">Local</label>
    <select name="local" class="form-control">
    	<option value="Infraestrutura - RJ" selected>Infraestrutura - RJ</option>
    	<option value="Marketing - RJ">Marketing - RJ</option>
    	<option value="Marketing - SP">Marketing - SP</option>
    	<option value="Administrativo - RJ">Administrativo - RJ</option>
    	<option value="Administrativo - SP">Administrativo - SP</option>
    	<option value="Fábrica - RJ">Fábrica - RJ</option>
    	<option value="Sulamerica">Sulamerica</option>
    	<option value="Outro">Outro</option>
    	<option value="Indefinido">Indefinido</option>
    </select>
  </div>
  <div class="form-group">
    <label for="usuario">Usuário</label>
    <input type="text" class="form-control" name="usuario">
  </div>
  <input type="hidden" name="colaborador" value="add"></input>
  <button type="submit" class="btn btn-warning" style="background-color:orange;color:white;">Cadastrar</button>
</form>

<%@ include file="footer.html" %>
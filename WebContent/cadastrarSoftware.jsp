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

<form action="ServletSoftware" method="POST">
<div class="form-group">
    <label for="serial">Serial</label>
    <input type="text" class="form-control" name="serial">
  </div>
  <div class="form-group">
    <label for="nome">Nome</label>
    <select name="nome" class="form-control">
    	<optgroup label="Pacote Office">
    		<option value="Microsoft Office">Microsoft Office</option>
    	</optgroup>
    	<optgroup label="Microsoft Windows">
	    	<option value="Windows XP">Windows XP</option>
	    	<option value="Windows 7">Windows 7</option>
	    	<option value="Windows 8.1">Windows 8.1</option>
	    	<option value="Windows 10">Windows 10</option>
    	</optgroup>
    </select>
  </div>
  <div class="form-group">
    <label for="versao">Versão</label>
    <select name="versao" class="form-control">	
    	<optgroup label="Pacote Office">
	    	<option value="Standard 2010 - VLSC">Standard 2010 - VLSC</option>
	    	<option value="Standard 2010 - DEV">Standard 2010 - DEV</option>
	    	<option value="Standard 2013 - VLSC">Standard 2013 - VLSC</option>
	    	<option value="Standard 2016 - VLSC">Standard 2016 - VLSC</option>
	    	<option value="365 Enterprise E3">365 Enterprise E3</option>
    	</optgroup>
    	<optgroup label="Microsoft Windows">
    		<optgroup label="Windows 7, 8, 10">
		    	<option value="Professional">Professional</option>
		    	<option value="Enterprise">Enterprise</option>
		    	<option value="Home & Student">Home & Student</option>
	    	</optgroup>
	    	<optgroup label="Windows XP">
		    	<option value="SP 1">SP 1</option>
		    	<option value="SP 2">SP 2</option>
	    	</optgroup>
    	</optgroup>
    </select>
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
  <input type="hidden" name="software" value="add"></input>
  <button type="submit" class="btn btn-warning" style="background-color:orange;color:white;">Cadastrar</button>
</form>

<%@ include file="footer.html" %>
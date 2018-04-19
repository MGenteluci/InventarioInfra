<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file = "header.html" %>

<form action="ServletLicenca" method="POST">
  <div class="form-group">
    <label for="nome">ID do Equipamento</label>
    <input type="text" class="form-control" name="equipamentoId" autofocus required>
  </div>
  <div class="form-group">
    <label for="nome">ID do Software</label>
    <input type="text" class="form-control" name="softwareId" required>
  </div>
  <div class="form-group">
    <label for="nome">Chave de Licenciamento</label>
    <input type="text" class="form-control" name="codigo" required>
  </div>
  <input type="hidden" name="licenca" value="add"></input>
  <button type="submit" class="btn btn-warning" style="background-color:orange;color:white;" onClick="alertaBotao()">Cadastrar</button>
</form>

<%@ include file = "footer.html" %>
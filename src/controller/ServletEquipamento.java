package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Colaborador;
import model.Equipamento;
import model.dao.DaoColaborador;
import model.dao.DaoEquipamento;

/**
 * Servlet implementation class ServletEquipamento
 */
@WebServlet("/ServletEquipamento")
public class ServletEquipamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEquipamento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> erros = new ArrayList<String>();
		request.setAttribute("erros", erros);
		
		DaoColaborador dc = new DaoColaborador();
		List<Colaborador> colaboradores = dc.pesquisar();
		request.setAttribute("colaboradores", colaboradores);
		
		RequestDispatcher desp = request.getRequestDispatcher("cadastrarEquipamento.jsp");
		desp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoEquipamento de = new DaoEquipamento();
		
		if(request.getParameter("equipamento").equals("add")){
			List<String> erros = new ArrayList<String>();
			
			String patr = request.getParameter("patrimonio");
			String hostname = request.getParameter("hostname");
			String situacao = request.getParameter("situacao");
			String tipo = request.getParameter("tipo");		
			String modelo = request.getParameter("modelo");	
			String processador = request.getParameter("processador");	
			String ramOriginal = request.getParameter("ramOriginal");	
			String ramAtual = request.getParameter("ramAtual");	
			String serviceTag = request.getParameter("serviceTag");	
		    String serviceCode = request.getParameter("serviceCode");	
		    String garantia = request.getParameter("garantia");	 
		    String observacao = request.getParameter("observacao");
		    String colab = request.getParameter("colaborador");
		    
		    ramOriginal = ramOriginal.toUpperCase();
		    ramAtual = ramAtual.toUpperCase();
		    serviceTag = serviceTag.toUpperCase();
		    hostname = hostname.toUpperCase();
		    
		    if(patr == null || patr.length() == 0){
		    	patr = "000";
		    }
		    
		    if(colab == null || colab.length() == 0){
		    	colab = "0";
		    }
		    
		    if(hostname == null || hostname.length() == 0){
		    	erros.add("Campo hostname não pode ser nulo");
		    }
		    
		    if(situacao == null || situacao.length() == 0){
		    	erros.add("Campo situação não pode ser nulo");
		    }
		    
		    if(erros.size() == 0){
		    	int patrimonio = Integer.parseInt(patr);
			    int colaborador = Integer.parseInt(colab);
				
				Equipamento e = new Equipamento(patrimonio, hostname, situacao, tipo, modelo, processador, ramOriginal, ramAtual, serviceTag, serviceCode, garantia, observacao, colaborador);
				de.adicionar(e);
				
				response.sendRedirect("listarEquipamentos");
		    }else{
		    	DaoColaborador dc = new DaoColaborador();
				List<Colaborador> colaboradores = dc.pesquisar();
				
				request.setAttribute("colaboradores", colaboradores);
		    	request.setAttribute("erros", erros);
		    	
		    	RequestDispatcher desp = request.getRequestDispatcher("cadastrarEquipamento.jsp");
		    	desp.forward(request, response);
		    }
		    
		}else if(request.getParameter("equipamento").equals("remove")){
			String identificador = request.getParameter("id");
			int id = Integer.parseInt(identificador);
			
			de.deletar(id);
			
			response.sendRedirect("listarEquipamentos");
		}else if(request.getParameter("equipamento").equals("update")){
			String identificador = request.getParameter("id");
			String patr = request.getParameter("patrimonio");
			String hostname = request.getParameter("hostname");
			String situacao = request.getParameter("situacao");
			String tipo = request.getParameter("tipo");
			String modelo = request.getParameter("modelo");
			String processador = request.getParameter("processador");
			String ramOriginal = request.getParameter("ramOriginal");
			String ramAtual = request.getParameter("ramAtual");
			String serviceTag = request.getParameter("serviceTag");
			String serviceCode = request.getParameter("serviceCode");
			String garantia = request.getParameter("garantia");
			String observacao = request.getParameter("observacao");
			String colab = request.getParameter("colaborador");
			
			ramOriginal = ramOriginal.toUpperCase();
		    ramAtual = ramAtual.toUpperCase();
		    serviceTag = serviceTag.toUpperCase();
		    hostname = hostname.toUpperCase();
			
			int patrimonio = Integer.parseInt(patr);
			int colaborador = Integer.parseInt(colab);
			int id = Integer.parseInt(identificador);
			
			de.alterar(patrimonio, hostname, situacao, tipo, modelo, processador, ramOriginal, ramAtual, serviceTag, serviceCode, garantia, observacao, colaborador, id);
			
			response.sendRedirect("listarEquipamentos");
		}
		
	}

}

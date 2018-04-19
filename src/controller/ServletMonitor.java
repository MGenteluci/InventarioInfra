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
import model.Monitor;
import model.dao.DaoColaborador;
import model.dao.DaoMonitor;

/**
 * Servlet implementation class ServletCadastrarMonitor
 */
@WebServlet("/monitor")
public class ServletMonitor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMonitor() {
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
		
		RequestDispatcher desp = request.getRequestDispatcher("cadastrarMonitor.jsp");
		desp.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DaoMonitor dm = new DaoMonitor();
		
		if(request.getParameter("monitor").equals("add")){
			List<String> erros = new ArrayList<String>();
			String pattern = "[0-9]+";
			
			String marca = request.getParameter("marca");
			String modelo = request.getParameter("modelo");
			String colab = request.getParameter("colaborador");
			String patr = request.getParameter("patrimonio");				
			
			modelo = modelo.toUpperCase();
		
			if(marca == null || marca.length() == 0){
				erros.add("Marca não pode estar em branco.");
			}
			
			if(modelo == null || modelo.length() == 0){
				erros.add("Modelo não pode estar em branco.");
			}
			
			if(colab == null || colab.length() == 0){
				erros.add("Colaborador não pode estar em branco.");
			}
			
			if(patr == null || patr.length() == 0){
				erros.add("Patrimônio não pode estar em branco.");
			}else if(!patr.matches(pattern)){
				erros.add("Patrimônio precisa ser um campo numérico.");
			}
			
			if(erros.size() == 0){
				int patrimonio = Integer.parseInt(patr);
				int colaborador = Integer.parseInt(colab);
				
				Monitor m = new Monitor(patrimonio, marca, modelo, colaborador);
				
				dm.adicionar(m);
				response.sendRedirect("listarMonitores");
				
			}else{
				DaoColaborador dc = new DaoColaborador();
				List<Colaborador> colaboradores = dc.pesquisar();
			
				request.setAttribute("colaboradores", colaboradores);
				request.setAttribute("erros", erros);
				
				RequestDispatcher desp = request.getRequestDispatcher("cadastrarMonitor.jsp");
				desp.forward(request, response);
			}	
			
		}else if(request.getParameter("monitor").equals("remove")){	
			String identificador = request.getParameter("id");
			int id = Integer.parseInt(identificador);
			
			dm.deletar(id);
			
			response.sendRedirect("listarMonitores.jsp");
		}else if(request.getParameter("monitor").equals("update")){	
			String marca = request.getParameter("marca");
			String modelo = request.getParameter("modelo");
			String colab = request.getParameter("colaborador");
			String patr = request.getParameter("patrimonio");
			String identificador = request.getParameter("id");
			
			int colaborador = Integer.parseInt(colab);
			int patrimonio = Integer.parseInt(patr);	
			int id = Integer.parseInt(identificador);
			
			modelo = modelo.toUpperCase();
			
			dm.alterar(patrimonio, marca, modelo, colaborador, id);
			
			response.sendRedirect("listarMonitores");
		}
		
	}

}

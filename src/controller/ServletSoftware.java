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
import model.Software;
import model.dao.DaoColaborador;
import model.dao.DaoSoftware;

/**
 * Servlet implementation class ServletSoftware
 */
@WebServlet("/ServletSoftware")
public class ServletSoftware extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSoftware() {
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
		
		RequestDispatcher desp = request.getRequestDispatcher("cadastrarSoftware.jsp");
		desp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DaoSoftware ds = new DaoSoftware();
		
		if(request.getParameter("software").equals("add")){
			List<String> erros = new ArrayList<String>();
			
			String serial = request.getParameter("serial");
			String nome = request.getParameter("nome");
			String versao = request.getParameter("versao");
			String colab = request.getParameter("colaborador");
			
			if(serial == null || serial.length() == 0){
				erros.add("O campo serial não pode ser nulo");
			}
			
			if(nome == null || nome.length() == 0){
				erros.add("O campo nome não pode ser nulo");
			}
			
			if(versao == null || versao.length() == 0){
				erros.add("O campo versão não pode ser nulo");
			}
			
			if(colab == null || colab.length() == 0){
				erros.add("O campo colaborador não pode ser nulo");
			}
			
			if(erros.size() == 0){
				int colaborador = Integer.parseInt(colab);
				
				
				Software s = new Software(serial, nome, versao, colaborador);
				ds.adicionar(s);
				response.sendRedirect("listarSoftwares");
			}else{
				DaoColaborador dc = new DaoColaborador();
				List<Colaborador> colaboradores = dc.pesquisar();
				
				request.setAttribute("colaboradores", colaboradores);
				request.setAttribute("erros", erros);
				
				RequestDispatcher desp = request.getRequestDispatcher("cadastrarSoftware.jsp");
				desp.forward(request, response);
			}
					
		}else if(request.getParameter("software").equals("remove")){
			String identificador = request.getParameter("id");
			int id = Integer.parseInt(identificador);
			ds.deletar(id);
			
			response.sendRedirect("listarSoftwares.jsp");
		}else if(request.getParameter("software").equals("update")){
			String serial = request.getParameter("serial");
			String nome = request.getParameter("nome");
			String versao = request.getParameter("versao");
			String colab = request.getParameter("colaborador");
			String identificador = request.getParameter("id");
			
			int colaborador = Integer.parseInt(colab);
			int id = Integer.parseInt(identificador);
			
			ds.alterar(serial, nome, versao, colaborador, id);
			
			response.sendRedirect("listarSoftwares");
		}
	}

}

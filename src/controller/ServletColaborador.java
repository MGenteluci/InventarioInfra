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
import model.dao.DaoColaborador;

/**
 * Servlet implementation class ServletColaborador
 */
@WebServlet("/ServletColaborador")
public class ServletColaborador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletColaborador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> erros = new ArrayList<String>();
		request.setAttribute("erros", erros);
		RequestDispatcher desp = request.getRequestDispatcher("cadastrarColaborador.jsp");
		desp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String patternName = "[A-Z¡…Õ”⁄¬ Œ‘€√« ]+";
		if(request.getParameter("colaborador").equals("add")){
			
			List<String> erros = new ArrayList<String>();
			
			String nome = request.getParameter("nome");
			String local = request.getParameter("local");
			String usuario = request.getParameter("usuario");
			
			nome = nome.toUpperCase();
			usuario = usuario.toLowerCase();
			
			if(nome == null || nome.length() == 0){
				erros.add("Campo nome n„o pode estar em branco.");
			}else if(!nome.matches(patternName)){
				erros.add("Campo nome deve ser apenas texto.");
			}else if(nome.length() < 3){
				erros.add("Campo nome deve possuir ao menos 3 letras.");
			}
			
			if(local == null || local.length() == 0){
				erros.add("Campo local n„o pode estar em branco.");
			}
			
			if(usuario == null || usuario.length() == 0){
				erros.add("Campo usu·rio n„o pode estar em branco.");
			}
			
			if(erros.size() == 0){
				Colaborador c = new Colaborador(nome, local, usuario);
				
				DaoColaborador dc = new DaoColaborador();
				dc.adicionar(c);
				
				response.sendRedirect("listarColaboradores.jsp");
			}else{
				request.setAttribute("erros", erros);
				RequestDispatcher desp = request.getRequestDispatcher("cadastrarColaborador.jsp");
				desp.forward(request, response);
			}
			
			
		}else if(request.getParameter("colaborador").equals("remove")){
			String identificador = request.getParameter("id");
			
			int id = Integer.parseInt(identificador);
			
			DaoColaborador dc = new DaoColaborador();
			dc.deletar(id);
			
			response.sendRedirect("listarColaboradores.jsp");
			
		}else if(request.getParameter("colaborador").equals("update")){
			String nome = request.getParameter("nome");
			String local = request.getParameter("local");
			String usuario = request.getParameter("usuario");
			String identificador = request.getParameter("id");
			
			int id = Integer.parseInt(identificador);
			
			nome = nome.toUpperCase();
			usuario = usuario.toLowerCase();
			
			DaoColaborador dc = new DaoColaborador();
			dc.alterar(nome, local, usuario, id);
			
			response.sendRedirect("listarColaboradores.jsp");
		}		
		
	}
	
}

package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Colaborador;
import model.dao.ColaboradorDAO;

/**
 * Servlet implementation class ServletAbrirCadastrarColaborador
 */
@WebServlet("/abrirCadastrarColaborador")
public class ServletAbrirCadastrarColaborador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAbrirCadastrarColaborador() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		
		if(idStr != null) {
			Long id = Long.parseLong(idStr);
			ColaboradorDAO dao = new ColaboradorDAO();
			Colaborador c = dao.obter(id);
			request.setAttribute("c", c);
		}
		
		RequestDispatcher desp = request.getRequestDispatcher("cadastrarColaborador.jsp");
		desp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

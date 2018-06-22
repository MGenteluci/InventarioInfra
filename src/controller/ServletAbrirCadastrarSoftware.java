package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Colaborador;
import model.Software;
import model.dao.ColaboradorDAO;
import model.dao.SoftwareDAO;

/**
 * Servlet implementation class ServletAbrirCadastrarColaborador
 */
@WebServlet("/abrirCadastrarSoftware")
public class ServletAbrirCadastrarSoftware extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAbrirCadastrarSoftware() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		
		if(idStr != null) {
			Long id = Long.parseLong(idStr);
			SoftwareDAO sDAO = new SoftwareDAO();
			Software s = sDAO.obter(id);
			
			request.setAttribute("s", s);
		}
		
		ColaboradorDAO dao = new ColaboradorDAO();
		List<Colaborador> colaboradores = dao.listar();
		
		request.setAttribute("colaboradores", colaboradores);
		
		RequestDispatcher desp = request.getRequestDispatcher("cadastrarSoftware.jsp");
		desp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

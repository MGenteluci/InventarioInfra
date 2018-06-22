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
import model.Monitor;
import model.dao.ColaboradorDAO;
import model.dao.MonitorDAO;

/**
 * Servlet implementation class ServletAbrirCadastrarColaborador
 */
@WebServlet("/abrirCadastrarMonitor")
public class ServletAbrirCadastrarMonitor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAbrirCadastrarMonitor() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		
		if(idStr != null) {
			Long id = Long.parseLong(idStr);
			MonitorDAO mDAO = new MonitorDAO();
			Monitor m = mDAO.obter(id);
			
			request.setAttribute("m", m);
		}
		
		ColaboradorDAO dao = new ColaboradorDAO();
		List<Colaborador> colaboradores = dao.listar();
		
		request.setAttribute("colaboradores", colaboradores);
		
		RequestDispatcher desp = request.getRequestDispatcher("cadastrarMonitor.jsp");
		desp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

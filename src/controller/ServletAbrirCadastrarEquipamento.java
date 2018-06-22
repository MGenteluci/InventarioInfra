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
import model.Equipamento;
import model.dao.ColaboradorDAO;
import model.dao.EquipamentoDAO;

/**
 * Servlet implementation class ServletAbrirCadastrarColaborador
 */
@WebServlet("/abrirCadastrarEquipamento")
public class ServletAbrirCadastrarEquipamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAbrirCadastrarEquipamento() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		
		if(idStr != null) {
			Long id = Long.parseLong(idStr);
			EquipamentoDAO eDAO = new EquipamentoDAO();
			Equipamento e = eDAO.obter(id);
			request.setAttribute("e", e);
		}
		
		ColaboradorDAO dao = new ColaboradorDAO();
		List<Colaborador> colaboradores = dao.listar();
		
		request.setAttribute("colaboradores", colaboradores);
		
		RequestDispatcher desp = request.getRequestDispatcher("cadastrarEquipamento.jsp");
		desp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
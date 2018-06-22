package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Equipamento;
import model.dao.EquipamentoDAO;

/**
 * Servlet implementation class ServletListarColaboradores
 */
@WebServlet("/listarEquipamentos")
public class ServletListarEquipamentos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarEquipamentos() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EquipamentoDAO dao = new EquipamentoDAO();
		List<Equipamento> equipamentos = dao.listar();
		
		request.setAttribute("equipamentos", equipamentos);
		
		RequestDispatcher desp = request.getRequestDispatcher("listarEquipamentos.jsp");
		desp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

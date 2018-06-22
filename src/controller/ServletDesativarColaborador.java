package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Colaborador;
import model.dao.ColaboradorDAO;

/**
 * Servlet implementation class ServletDesativarColaborador
 */
@WebServlet("/desativarColaborador")
public class ServletDesativarColaborador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDesativarColaborador() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		
		Long id = Long.parseLong(idStr);
		ColaboradorDAO dao = new ColaboradorDAO();
		Colaborador c = dao.obter(id);
		
		c.setSituacao("Desligado");
		Date data = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dataDemissao = sdf.format(data);
		c.setDataDemissao(dataDemissao);
		
		dao.salvar(c);
		
		response.sendRedirect("listarColaboradores");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

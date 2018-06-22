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
import model.dao.ColaboradorDAO;
import model.dao.SoftwareDAO;

/**
 * Servlet implementation class ServletSalvarColaborador
 */
@WebServlet("/salvarSoftware")
public class ServletSalvarSoftware extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSalvarSoftware() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String patternId = "[0-9]+";
		
		String idStr = request.getParameter("id");
		String nome = request.getParameter("nome");
		String versao = request.getParameter("versao");
		String serial = request.getParameter("serial");
		String colaboradorStr = request.getParameter("colaborador");
		
		List<String> erros = new ArrayList<String>();
		ColaboradorDAO colabDAO = new ColaboradorDAO();
		SoftwareDAO dao = new SoftwareDAO();
		Software s = new Software();
		
		if(idStr.matches(patternId)) {
			Long id = Long.parseLong(idStr);
			s.setId(id);
		}
		
		if(colaboradorStr != null && !colaboradorStr.equals("")) {
			Long id_colaborador = Long.parseLong(colaboradorStr);
			Colaborador c = colabDAO.obter(id_colaborador);
			s.setColaborador(c);
		}	
		
		s.setNome(nome);
		s.setVersao(versao);
		s.setSerial(serial);	
		
		if(erros.size() == 0) {
			
			dao.salvar(s);
			
			response.sendRedirect("listarSoftwares");
		}else {
			request.setAttribute("erros", erros);
			
			RequestDispatcher desp = request.getRequestDispatcher("abrirCadastrarSoftware");
			desp.forward(request, response);
		}
	}

}
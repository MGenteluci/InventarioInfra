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
import model.dao.ColaboradorDAO;

/**
 * Servlet implementation class ServletSalvarColaborador
 */
@WebServlet("/salvarColaborador")
public class ServletSalvarColaborador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSalvarColaborador() {
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
		String usuario = request.getParameter("usuario");
		String email = request.getParameter("email");
		String local = request.getParameter("local");
		String dataAdmissao = request.getParameter("dataAdmissao");
		
		usuario = usuario.toLowerCase();
		nome = nome.toUpperCase();
		email = email.toLowerCase();
		
		List<String> erros = new ArrayList<String>();
		Colaborador c = new Colaborador();
		
		if(idStr.matches(patternId)) {
			Long id = Long.parseLong(idStr);
			c.setId(id);
		}
		
		c.setNome(nome);
		c.setUsuario(usuario);
		c.setEmail(email);
		c.setLocal(local);
		c.setDataAdmissao(dataAdmissao);
		c.setSituacao("Ativo");
		
		if(erros.size() == 0) {
			ColaboradorDAO dao = new ColaboradorDAO();
			dao.salvar(c);
			
			response.sendRedirect("listarColaboradores");
		}else {
			request.setAttribute("erros", erros);
			
			RequestDispatcher desp = request.getRequestDispatcher("abrirCadastrarColaborador");
			desp.forward(request, response);
		}
	}

}
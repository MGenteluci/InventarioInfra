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
import model.Monitor;
import model.Software;
import model.dao.ColaboradorDAO;
import model.dao.EquipamentoDAO;
import model.dao.MonitorDAO;
import model.dao.SoftwareDAO;

/**
 * Servlet implementation class ServletAbrirHome
 */
@WebServlet("/abrirHome")
public class ServletAbrirHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAbrirHome() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ColaboradorDAO colabDAO = new ColaboradorDAO();
		SoftwareDAO softDAO = new SoftwareDAO();
		EquipamentoDAO eqDAO = new EquipamentoDAO();
		MonitorDAO monDAO = new MonitorDAO();
		
		int qtdColaboradores = 0;
		List<Colaborador> colaboradores = colabDAO.listar();
		for(Colaborador c: colaboradores) {
			qtdColaboradores++;
		}
		
		int qtdSoftwares = 0;
		List<Software> softwares = softDAO.listar();
		for(Software s: softwares) {
			qtdSoftwares++;
		}
		
		int qtdEquipamentos = 0;
		List<Equipamento> equipamentos = eqDAO.listar();
		for(Equipamento e: equipamentos) {
			qtdEquipamentos++;
		}
		
		int qtdMonitores = 0;
		List<Monitor> monitores = monDAO.listar();
		for(Monitor m: monitores) {
			qtdMonitores++;
		}
		
		request.setAttribute("qtdColaboradores", qtdColaboradores);
		request.setAttribute("qtdSoftwares", qtdSoftwares);
		request.setAttribute("qtdEquipamentos", qtdEquipamentos);
		request.setAttribute("qtdMonitores", qtdMonitores);
		
		RequestDispatcher desp = request.getRequestDispatcher("index.jsp");
		desp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

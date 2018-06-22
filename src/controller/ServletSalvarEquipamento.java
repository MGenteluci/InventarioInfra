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
import model.Equipamento;
import model.dao.ColaboradorDAO;
import model.dao.EquipamentoDAO;

/**
 * Servlet implementation class ServletSalvarColaborador
 */
@WebServlet("/salvarEquipamento")
public class ServletSalvarEquipamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSalvarEquipamento() {
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
		String hostname = request.getParameter("hostname");
		String patrimonioStr = request.getParameter("patrimonio");
		String tipo = request.getParameter("tipo");
		String modelo = request.getParameter("modelo");
		String processador = request.getParameter("processador");
		String serialTag = request.getParameter("serialTag");
		String serviceCode = request.getParameter("serviceCode");
		String dataGarantia = request.getParameter("dataGarantia");
		String soComprado = request.getParameter("soComprado");
		String soAtual = request.getParameter("soAtual");
		String ramOriginal = request.getParameter("ramOriginal");
		String ramAtual = request.getParameter("ramAtual");
		String colaboradorStr = request.getParameter("colaborador");
		
		serialTag = serialTag.toUpperCase();
		hostname = hostname.toUpperCase();
		
		List<String> erros = new ArrayList<String>();
		ColaboradorDAO colabDAO = new ColaboradorDAO();
		EquipamentoDAO dao = new EquipamentoDAO();
		Equipamento e = new Equipamento();
		
		if(idStr.matches(patternId)) {
			Long id = Long.parseLong(idStr);
			e.setId(id);
		}
		
		if(colaboradorStr != null && !colaboradorStr.equals("")) {
			Long id_colaborador = Long.parseLong(colaboradorStr);
			Colaborador c = colabDAO.obter(id_colaborador);
			e.setColaborador(c);
		}
		
		if(patrimonioStr.matches(patternId)) {
			int patrimonio = Integer.parseInt(patrimonioStr);
			e.setPatrimonio(patrimonio);
		}	
		
		e.setHostname(hostname);	
		e.setTipo(tipo);
		e.setModelo(modelo);
		e.setProcessador(processador);
		e.setSerialTag(serialTag);
		e.setServiceCode(serviceCode);
		e.setDataGarantia(dataGarantia);
		e.setSoComprado(soComprado);
		e.setSoAtual(soAtual);
		e.setRamAtual(ramAtual);
		e.setRamOriginal(ramOriginal);
		
		if(erros.size() == 0) {
			
			dao.salvar(e);
			
			response.sendRedirect("listarEquipamentos");
		}else {
			request.setAttribute("erros", erros);
			
			RequestDispatcher desp = request.getRequestDispatcher("abrirCadastrarEquipamento");
			desp.forward(request, response);
		}
	}

}
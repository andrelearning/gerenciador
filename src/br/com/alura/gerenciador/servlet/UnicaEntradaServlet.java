package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acoes.ListaEmpresas;
import br.com.alura.gerenciador.acoes.MostraEmpresa;
import br.com.alura.gerenciador.acoes.RemoveEmpresa;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		
		
		if("ListaEmpresas".equalsIgnoreCase(paramAcao)) {
			ListaEmpresas acao = new ListaEmpresas();
			acao.executa(request, response);
		}
		if("RemoveEmpresa".equalsIgnoreCase(paramAcao)) {
			
			RemoveEmpresa acao = new RemoveEmpresa();
			acao.executa(request, response);
		}
		if("MostraEmpresa".equalsIgnoreCase(paramAcao)) {
			MostraEmpresa acao = new MostraEmpresa();
			acao.executa(request, response);
		}
	}

}

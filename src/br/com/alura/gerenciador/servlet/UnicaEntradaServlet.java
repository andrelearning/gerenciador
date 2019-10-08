package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;
import br.com.alura.gerenciador.acao.AlteraEmpresa;
import br.com.alura.gerenciador.acao.ListaEmpresas;
import br.com.alura.gerenciador.acao.MostraEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresaForm;
import br.com.alura.gerenciador.acao.RemoveEmpresa;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String paramAcao = request.getParameter("acao");
		String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;
		String nome;
		try {
			
			Acao acao = (Acao) Class.forName(nomeDaClasse).newInstance();		
			nome = acao.executa(request,response);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new ServletException(e);
		}
		
		String[] forwardOuRedirect = nome.split(":");
		if ("forward".equalsIgnoreCase(forwardOuRedirect[0])) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + forwardOuRedirect[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(forwardOuRedirect[1]);
		}

//		String nome = null;
//		if ("ListaEmpresas".equalsIgnoreCase(paramAcao)) {
//			ListaEmpresas acao = new ListaEmpresas();
//			nome = acao.executa(request, response);
//		} else if ("RemoveEmpresa".equalsIgnoreCase(paramAcao)) {
//			RemoveEmpresa acao = new RemoveEmpresa();
//			nome = acao.executa(request, response);
//		} else if ("MostraEmpresa".equalsIgnoreCase(paramAcao)) {
//			MostraEmpresa acao = new MostraEmpresa();
//			nome = acao.executa(request, response);
//		} else if ("AlteraEmpresa".equalsIgnoreCase(paramAcao)) {
//			AlteraEmpresa acao = new AlteraEmpresa();
//			nome = acao.executa(request, response);
//		} else if ("NovaEmpresa".equalsIgnoreCase(paramAcao)) {
//			NovaEmpresa acao = new NovaEmpresa();
//			nome = acao.executa(request, response);
//		} else if ("NovaEmpresaForm".equalsIgnoreCase(paramAcao)) {
//		NovaEmpresaForm acao = new NovaEmpresaForm();
//		nome = acao.executa(request, response);
//	}

		

	}

}

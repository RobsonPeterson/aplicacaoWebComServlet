package br.com.robson.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.robson.gerenciador.modelo.Banco;

//@WebServlet("/removeEmpresa")
public class RemoveEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String parameId = request.getParameter("id");
		Integer id = Integer.valueOf(parameId);

		Banco banco = new Banco();

		banco.removeEmpresa(id);

		response.sendRedirect("listaEmpresas");
	}

}

package br.com.robson.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.robson.gerenciador.modelo.Banco;
import br.com.robson.gerenciador.modelo.Empresa;

public class MostrarEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String parameId = request.getParameter("id");
		Integer id = Integer.valueOf(parameId);

		Banco banco = new Banco();

		Empresa empresa = banco.buscaEmpresaPeloId(id);

		request.setAttribute("empresa", empresa);

		return "forward:formAlteraEmpresa.jsp";
	}
}

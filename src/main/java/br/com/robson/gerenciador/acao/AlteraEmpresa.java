package br.com.robson.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.robson.gerenciador.modelo.Banco;
import br.com.robson.gerenciador.modelo.Empresa;

public class AlteraEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String parameId = request.getParameter("id");
		Integer id = Integer.valueOf(parameId);

		String nomeEmpresa = request.getParameter("nome");
		String paramDataEmpresa = request.getParameter("data");

		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPeloId(id);
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);

		request.setAttribute("empresa", empresa.getNome());

		return "redirect:entrada?acao=ListaEmpresas";
	}
}

package br.com.robson.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.robson.gerenciador.modelo.Banco;

public class RemoveEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		

		String parameId = request.getParameter("id");
		Integer id = Integer.valueOf(parameId);

		Banco banco = new Banco();

		banco.removeEmpresa(id);

		return "redirect:entrada?acao=ListaEmpresas";
		
	}
	
}

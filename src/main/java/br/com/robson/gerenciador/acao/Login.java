package br.com.robson.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionIdListener;

import br.com.robson.gerenciador.modelo.Banco;
import br.com.robson.gerenciador.modelo.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		Banco banco = new Banco();
		Usuario u = banco.existiUsuario(login, senha);

		if (u != null) {
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", u);
			return "redirect:entrada?acao=ListaEmpresas";
		} else
			return "forward:formLogin.jsp";
	}

}

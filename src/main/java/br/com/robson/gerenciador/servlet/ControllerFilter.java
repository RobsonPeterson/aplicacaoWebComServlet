package br.com.robson.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.robson.gerenciador.acao.Acao;


//@WebFilter("/Entrada")
public class ControllerFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void destroy() {}
    
	public void doFilter(ServletRequest servletRequest, ServletResponse servlerResponse, FilterChain chain) throws IOException, ServletException {
		System.out.println("Entrada");
				
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servlerResponse;
		
		String paramAcao = request.getParameter("acao"); 
    	
        String nomeDaClasse = "br.com.robson.gerenciador.acao." + paramAcao;        
        String nome;
		try {
			@SuppressWarnings("rawtypes")
			Class classe = Class.forName(nomeDaClasse); 
			Acao acao = (Acao) classe.newInstance(); 
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}

        String[] tipoEEndereco = nome.split(":");
        if(tipoEEndereco[0].equals("forward")) {
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
            rd.forward(request, response);
        } else {
            response.sendRedirect(tipoEEndereco[1]);

        }
        

	}

}

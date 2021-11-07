package br.com.robson.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AutorizacaoFilter
 */
//@WebFilter("/entrada")
public class AutorizacaoFilter implements Filter {
	
	@Override
    public void init(FilterConfig filterConfig) throws ServletException {}
	
    @Override
    public void destroy() {}
    
	public void doFilter(ServletRequest servletRequest, ServletResponse servlerResponse, FilterChain chain) throws IOException, ServletException {
		System.out.println("Autorização");
				
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servlerResponse;
		
		String paramAcao = request.getParameter("acao"); 
		
		HttpSession sessao = request.getSession();
    	boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado") == null);
    	boolean acaoProtegina = !(paramAcao.equals("Login") || paramAcao.equals("FormLogin"));
    	if(acaoProtegina && usuarioNaoEstaLogado) {
    		response.sendRedirect("entrada?acao=FormLogin"); 
    		return;
    	}
    	
		chain.doFilter(request, response);
	}

}

package br.com.robson.gerenciador.modelo;

public class Usuario {
	String login;
	String senha;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean ehquals(String login, String senha) {
		if (!this.login.equals(login))
			return false;
		if (!this.senha.equals(senha))
			return false;
		else
			return true;
	}
	
	
}

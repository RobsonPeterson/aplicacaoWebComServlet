package br.com.robson.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> list = new ArrayList<>();
	private static List<Usuario> listUsuarios = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	//private static Integer chaveSequencialusuarios = 1;

	static {
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("Dataprom");
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Alura");
		list.add(empresa);
		list.add(empresa2);
		
		Usuario u = new Usuario();
		u.setLogin("Robson");
		u.setSenha("123");		
		Usuario u2 = new Usuario();
		u2.setLogin("Lolo");
		u2.setSenha("456");
		listUsuarios.add(u);
		listUsuarios.add(u2);
	}

	public void adicionar(Empresa empresa) {
		empresa.setId(chaveSequencial++);
		Banco.list.add(empresa);
	}

	public List<Empresa> getEmpresas() {
		return Banco.list;
	}

	public void removeEmpresa(Integer id) {

		Iterator<Empresa> it = list.iterator();

		while (it.hasNext()) {
			Empresa emp = (Empresa) it.next();
			if (emp.getId() == id) {
				it.remove();
			}
		}

	}

	public Empresa buscaEmpresaPeloId(Integer id) {

		for (Empresa empresa : list) {
			if (empresa.getId() == id) {
				return empresa;
			}

		}
		return null;

	}

	public Usuario existiUsuario(String login, String senha) {
		for (Usuario usuario : listUsuarios) {
			if (usuario.ehquals(login,senha)) {
				return usuario;
			}

		}
		return null;

		
	}
}

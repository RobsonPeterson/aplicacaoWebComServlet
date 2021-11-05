package br.com.robson.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

public class Banco {

	private static List<Empresa> list = new ArrayList<>();
	private static Integer chaveSequancial = 1;

	static {
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequancial++);
		empresa.setNome("Dataprom");
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequancial++);
		empresa2.setNome("Alura");
		list.add(empresa);
		list.add(empresa2);
	}

	public void adicionar(Empresa empresa) {
		empresa.setId(chaveSequancial++);
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
}

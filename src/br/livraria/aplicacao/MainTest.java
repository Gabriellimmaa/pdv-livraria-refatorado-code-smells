package br.livraria.aplicacao;

import br.livraria.factory.TableFactory;

public class MainTest {

	public static void main(String[] args) {
		
		new TableFactory().createTables();
		
	}
}

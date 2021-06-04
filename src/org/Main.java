package org;

import org.interfaces.Login;
import org.interfaces.Tela;

public class Main {
	
	public static void main(String[] args) {
		
		Tela tela = new Tela();
		tela.mostrarTela(new Login().criarJanela());
		
	}
}

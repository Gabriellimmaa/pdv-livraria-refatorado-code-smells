package org;

import java.sql.SQLException;

import org.atores.Funcionario;
import org.controlador.Banco;

public class Main {

	public static void main(String[] args) {
		
		try {
			Banco banco = new Banco();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

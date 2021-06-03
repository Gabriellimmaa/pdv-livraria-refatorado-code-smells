package org;

import java.sql.SQLException;

import org.controlador.Banco;

public class Main {
	
	public static void main(String[] args) {
		
		try {
			Banco bd = new Banco();
			
//			bd.adicionarAdministrador(null);
//			bd.adicionarEditora(null);
//			bd.adicionarFuncionario(null);
//			bd.adicionarItem(null);
//			bd.adicionarLivro(null);
//			bd.adicionarPedido(null);
//			bd.adicionarVenda(null);
//			
//			bd.removerAdministrador(0);
//			bd.removerEditora(0);
//			bd.removerFuncionario(0);
//			bd.removerItem(0);
//			bd.removerLivro(0);
//			bd.removerPedido(0);
//			bd.removerVenda(0);
//			
//			bd.pegarAdministrador(0);
//			bd.pegarEditora(0);
//			bd.pegarFuncionario(0);
//			bd.pegarItem(0);
//			bd.pegarLivro(0);
//			bd.pegarPedido(0);
//			bd.pegarVenda(0);
//			
//			bd.pegarTodasEditoras();
//			bd.pegarTodasVendas();
//			bd.pegarTodosAdministradores();
//			bd.pegarTodosFuncionarios();
//			bd.pegarTodosItensPedidos();
//			bd.pegarTodosLivros();
//			bd.pegarTodosPedidos();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}

package br.livraria.aplicacao;

import java.util.Vector;

import br.livraria.dao.FuncionarioDAO;
import br.livraria.model.Funcionario;
import br.livraria.tela.TelaMenu;

/*
 * Responsavel pelas funcionalidades contidas na telaLogin.java
 */
public class LoginApp {

	/*
	 * Verifica se há um usuário com o id informado
	 * 
	 * Verifica se a senha informado coincide com a informada no banco de dados
	 */
	public boolean entrar(int idUsuario, String senha) {
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		
		Vector<Funcionario> funcionarios = funcionarioDAO.getFuncionarios();
		
		for(int i = 0; i < funcionarios.size(); i++) {
			
			if(funcionarios.get(i).getId() == idUsuario && funcionarios.get(i).getSenha().equals(senha)) {
				
				System.out.println("Logado com sucesso!");
				
				new TelaMenu(funcionarios.get(i));
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
}

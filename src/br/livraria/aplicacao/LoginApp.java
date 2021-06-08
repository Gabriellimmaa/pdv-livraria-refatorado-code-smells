package br.livraria.aplicacao;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
		
		System.out.println("LoginApp : ID Usuario: " + idUsuario);
		System.out.println("LoginApp: Senha: " + senha);
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		
		Vector<Funcionario> funcionarios = funcionarioDAO.getFuncionarios();
		
		for(int i = 0; i < funcionarios.size(); i++) {
			
			if(funcionarios.get(i).getId() == idUsuario && funcionarios.get(i).getSenha().equals(senha)) {
				
				System.out.println("LoginApp : Logado com sucesso!");
				
				new TelaMenu(funcionarios.get(i));
				
				return true;
				
			}
			
		}
		
		System.out.println("LoginApp : Falha na autenticacao.");
		
		JOptionPane.showMessageDialog(new JFrame(), "Falha na autenticacao! ID ou SENHA não coincidem.");
		return false;
		
	}
}

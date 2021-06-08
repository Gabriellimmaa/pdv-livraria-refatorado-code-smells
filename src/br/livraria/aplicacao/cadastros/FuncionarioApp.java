package br.livraria.aplicacao.cadastros;

import java.util.Vector;

import br.livraria.dao.FuncionarioDAO;
import br.livraria.model.Funcionario;

/*
 * Responsavel pelas funcionalidades das telas br.livraria.tela.cadastros.funcionario
 */
public class FuncionarioApp {
	
	// Dado uma String, verifica se há em "nome".
	public Vector<Funcionario> pesquisar(String busca) {
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		
		Vector<Funcionario> funcionarios = funcionarioDAO.getFuncionarios();
		
		Vector<Funcionario> funcionariosSelecionados = new Vector<Funcionario>();
		
		for(int i = 0; i < funcionarios.size(); i++) {
			
			System.out.println("'" + busca + "'");
			if(funcionarios.get(i).getNome().toLowerCase().contains(busca.toLowerCase())) {
				System.out.println("OK " + funcionarios.get(i).getNome());
				funcionariosSelecionados.add(funcionarios.get(i));
			} else {
				System.out.println("NOT " + funcionarios.get(i).getNome());
			}
			
		}
		
		return funcionariosSelecionados;
	}
	
	//Retorna uma matriz de funcionarios
	public Object[][] getFuncionarios(){
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		
		Vector<Funcionario> funcionarios = funcionarioDAO.getFuncionarios();
		
		Object[][] dados = new Object[funcionarios.size()][9];
		
		for(int i = 0; i < funcionarios.size(); i++) {
			dados[i][0] = funcionarios.get(i).getId();
			dados[i][1] = funcionarios.get(i).getNome();
			dados[i][2] = funcionarios.get(i).getCpf();
			dados[i][3] = funcionarios.get(i).getEndereco();
			dados[i][4] = funcionarios.get(i).getCidade();
			dados[i][5] = funcionarios.get(i).getEstado();
			dados[i][6] = funcionarios.get(i).getEmail();
			dados[i][7] = funcionarios.get(i).getTelefone();
			dados[i][8] = funcionarios.get(i).getDataContrato();
			dados[i][9] = funcionarios.get(i).getSenha();
			
			
		}
		
		return dados;
	}
	
	//Retorna uma matriz de funcionarios a partir de um vector estabelecido previamente
	public Object[][] getFuncionarios(Vector<Funcionario> funcionarios){
		
		Object[][] dados = new Object[funcionarios.size()][9];
		
		for(int i = 0; i < funcionarios.size(); i++) {
		
			dados[i][0] = funcionarios.get(i).getId();
			dados[i][1] = funcionarios.get(i).getNome();
			dados[i][2] = funcionarios.get(i).getCpf();
			dados[i][3] = funcionarios.get(i).getEndereco();
			dados[i][4] = funcionarios.get(i).getCidade();
			dados[i][5] = funcionarios.get(i).getEstado();
			dados[i][6] = funcionarios.get(i).getEmail();
			dados[i][7] = funcionarios.get(i).getTelefone();
			dados[i][8] = funcionarios.get(i).getDataContrato();
			dados[i][9] = funcionarios.get(i).getSenha();
		}
		
		return dados;
	}
	
	//Retorna o funcionario com o id especificado
	public Funcionario getFuncionario(int id) {
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		
		Vector<Funcionario> funcionarios = funcionarioDAO.getFuncionarios();
		
		for(int i = 0; i < funcionarios.size(); i++) {
			if(funcionarios.get(i).getId() == id) {
				return funcionarios.get(i);
			}
		}
		
		return null;
	}

}

package br.livraria.aplicacao.cadastros;

import java.util.Vector;

import br.livraria.dao.EditoraDAO;
import br.livraria.model.Editora;

/*
 * Responsável pelas funcionalidades das telas br.livraria.tela.cadastros.editora
 */
public class EditoraApp {

	//Verifica se há no campo "nome" a String informado no campo de pesquisa
	public Vector<Editora> pesquisar(String busca) {
		
		EditoraDAO editoraDAO = new EditoraDAO();
		
		Vector<Editora> editoras = editoraDAO.getEditoras();
		
		Vector<Editora> editorasSelecionadas = new Vector<Editora>();
		
		for(int i = 0; i < editoras.size(); i++) {
			
			System.out.println("'" + busca + "'");
			if(editoras.get(i).getNome().toLowerCase().contains(busca.toLowerCase())) {
				System.out.println("OK " + editoras.get(i).getNome());
				editorasSelecionadas.add(editoras.get(i));
			} else {
				System.out.println("NOT " + editoras.get(i).getNome());
			}
			
		}
		
		return editorasSelecionadas;
	}
	
	// Organiza os dados contidos em banco.db e cria uma matriz de objetos para armazenar os valorers
	public Object[][] getEditoras(){
		
		EditoraDAO editoraDAO = new EditoraDAO();
		
		Vector<Editora> editoras = editoraDAO.getEditoras();
		
		Object[][] dados = new Object[editoras.size()][4];
		
		for(int i = 0; i < editoras.size(); i++) {
			dados[i][0] = editoras.get(i).getId();
			dados[i][1] = editoras.get(i).getNome();
			dados[i][2] = editoras.get(i).getCnpj();
			dados[i][3] = editoras.get(i).getEndereco();
		}
		
		return dados;
	}
	
	// Organiza os dados contidos em banco.db e cria uma matriz de objetos para armazenar os valorers
	// Realiza essa organização a partir de um Vector específico
	public Object[][] getEditoras(Vector<Editora> editoras){
		
		Object[][] dados = new Object[editoras.size()][4];
		
		for(int i = 0; i < editoras.size(); i++) {
			dados[i][0] = editoras.get(i).getId();
			dados[i][1] = editoras.get(i).getNome();
			dados[i][2] = editoras.get(i).getCnpj();
			dados[i][3] = editoras.get(i).getEndereco();
		}
		
		return dados;
	}
	
	// Retorna a editora que possui o id especificado
	public Editora getEditora(int id) {
		
		EditoraDAO editoraDAO = new EditoraDAO();
		
		Vector<Editora> editoras = editoraDAO.getEditoras();
		
		for(int i = 0; i < editoras.size(); i++) {
			if(editoras.get(i).getId() == id) {
				return editoras.get(i);
			}
		}
		
		return null;
	}
	
}

package br.livraria.aplicacao.cadastros;

import java.util.Vector;


import br.livraria.dao.LivroDAO;
import br.livraria.model.Livro;

/*
 * Responsavel pelas funcionalidades das telas br.livraria.tela.cadastros.livro
 */
public class LivroApp {
	
	// Pesquisa se há entre os nomes dos livros alguma instância que coincide com uma string estabelecida
	public Vector<Livro> pesquisar(String busca) {
		
		LivroDAO livroDAO = new LivroDAO();
		
		Vector<Livro> livros = livroDAO.getLivros();
		
		Vector<Livro> livrosSelecionados = new Vector<Livro>();
		
		for(int i = 0; i < livros.size(); i++) {
			
			if(livros.get(i).getTitulo().toLowerCase().contains(busca.toLowerCase())) {
				livrosSelecionados.add(livros.get(i));
			}
			
		}
		
		return livrosSelecionados;
	}
	
	//Retorna uma matriz com dados de livros
	public Object[][] getLivros(){
		
		LivroDAO livroDAO = new LivroDAO();
		
		Vector<Livro> livros = livroDAO.getLivros();
		
		Object[][] dados = new Object[livros.size()][8];
		
		for(int i = 0; i < livros.size(); i++) {
			dados[i][0] = livros.get(i).getId();
			dados[i][1] = livros.get(i).getTitulo();
			dados[i][2] = livros.get(i).getGenero();
			dados[i][3] = livros.get(i).getDataPublicada();
			dados[i][4] = livros.get(i).getAutor();
			dados[i][5] = livros.get(i).getPrecoUnit();
			dados[i][6] = livros.get(i).getQtdEstoque();
			dados[i][7] = livros.get(i).getEditora().getNome();
			
		}
		
		return dados;
	}
	
	
	//Retorna uma matriz de dados de livros a partir de um vector estabelecido
	public Object[][] getLivros(Vector<Livro> livros){
		
		Object[][] dados = new Object[livros.size()][8];
		
		for(int i = 0; i < livros.size(); i++) {
			dados[i][0] = livros.get(i).getId();
			dados[i][1] = livros.get(i).getTitulo();
			dados[i][2] = livros.get(i).getGenero();
			dados[i][3] = livros.get(i).getDataPublicada();
			dados[i][4] = livros.get(i).getAutor();
			dados[i][5] = livros.get(i).getPrecoUnit();
			dados[i][6] = livros.get(i).getQtdEstoque();
			dados[i][7] = livros.get(i).getEditora().getNome();
			
		}
		
		return dados;
	}
	
	//Retorna o livro que possui o id especifico
	public Livro getLivro(int id) {
		
		LivroDAO livroDAO = new LivroDAO();
		
		Vector<Livro> livros = livroDAO.getLivros();
		
		for(int i = 0; i < livros.size(); i++) {
			if(livros.get(i).getId() == id) {
				return livros.get(i);
			}
		}
		
		return null;
	}

}

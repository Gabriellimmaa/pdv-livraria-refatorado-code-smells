package br.livraria.aplicacao.operacional;

import java.util.Vector;

import br.livraria.dao.ItemDAO;
import br.livraria.model.Item;

public class VendaApp {

	public Object[][] getItens(int id){
		
		ItemDAO itemDAO = new ItemDAO();
		
		Vector<Item> itens = itemDAO.getItens(id);
		
		Object[][] dados = new Object[itens.size()][4];
		
		for(int i = 0; i < itens.size(); i++) {
			dados[i][0] = itens.get(i).getLivro().getId();
			dados[i][1] = itens.get(i).getLivro().getTitulo();
			dados[i][2] = itens.get(i).getLivro().getPrecoUnit();
			dados[i][3] = itens.get(i).getQtdVendida();
		}
		
		return dados;
	}
}
